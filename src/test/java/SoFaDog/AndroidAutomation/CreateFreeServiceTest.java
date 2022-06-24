package SoFaDog.AndroidAutomation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AppMenus;
import PageObjects.CreatorPage;
import PageObjects.CreatorServicesPage;

public class CreateFreeServiceTest extends Base {
	
	@Test
	public void CreateFreeServiceTestCase() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		LoginTest lt = new LoginTest();
		lt.LoginTestCase();
		
		AppMenus am = new AppMenus(driver);
		am.CreatorMenu().click();
		
		CreatorPage cp = new CreatorPage(driver);
		cp.ServicesSubMenu().click();
		Thread.sleep(3000);
		
		CreatorServicesPage csp = new CreatorServicesPage(driver);
		csp.CreateService().click();
		
		driver.findElementByXPath("(//android.widget.EditText)[1]").sendKeys("AutoTest Free Service");
		driver.findElementByXPath("(//android.widget.EditText)[2]").sendKeys("AutoTest Free Service Description");
		csp.CreateServiceSaveButton().click();
		Thread.sleep(3000);
		driver.findElementById("android:id/button2").click();
		String msg = driver.findElementByXPath("//android.widget.TextView[@text='Created Successfully']").getText();
		Assert.assertEquals(msg, "Created Successfully");
		Thread.sleep(1000);
		driver.findElementById("android:id/button1").click();
		Thread.sleep(3000);
		
		Utilities u = new Utilities(driver);
		u.swipeScreen(Utilities.Direction.UP);
		u.swipeScreen(Utilities.Direction.UP);
		Thread.sleep(1000);
		driver.findElementByXPath("//*[@text='AutoTest Free Service']").click();
	}

}
