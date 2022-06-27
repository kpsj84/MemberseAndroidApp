package SoFaDog.AndroidAutomation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AppMenus;
import PageObjects.CreatorPage;
import PageObjects.CreatorServicesPage;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class EditServiceTest extends Base {
	
	@Test
	public void EditServiceTestCase() throws IOException, InterruptedException {
		
		WidgetSwipeTest wst = new WidgetSwipeTest();
		wst.WidgetSwipeTestCase();
		
		LoginUser lt = new LoginUser();
		lt.LoginUserCase();
		
		AppMenus am = new AppMenus(driver);
		am.CreatorMenu().click();
		
		CreatorPage cp = new CreatorPage(driver);
		cp.ServicesSubMenu().click();
		Thread.sleep(7000);
		
		driver.findElementByXPath("(//android.view.ViewGroup)[20]").click();
		driver.findElementByXPath("//android.widget.EditText").click();
		driver.pressKey(new KeyEvent(AndroidKey.CLEAR));
		driver.findElementByXPath("//android.widget.EditText").sendKeys(" Service 1 Auto Edited");
		Thread.sleep(2000);
		
		CreatorServicesPage csp = new CreatorServicesPage(driver);
		csp.CreateServiceSaveButton().click();
		
		String msg = driver.findElementById("android:id/alertTitle").getText();
		Assert.assertEquals(msg, "Edit Successful");
		driver.findElementById("android:id/alertTitle").click();
		Thread.sleep(7000);
	}

}
