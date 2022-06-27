package SoFaDog.AndroidAutomation;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.AppMenus;
import PageObjects.CreatorPage;

public class DeleteServiceTest extends Base {
	
	@Test
	public void DeleteServiceTestCase() throws IOException, InterruptedException {
		
		WidgetSwipeTest wst = new WidgetSwipeTest();
		wst.WidgetSwipeTestCase();
		
		LoginUser lt = new LoginUser();
		lt.LoginUserCase();
		
		AppMenus am = new AppMenus(driver);
		am.CreatorMenu().click();
		
		CreatorPage cp = new CreatorPage(driver);
		cp.ServicesSubMenu().click();
		Thread.sleep(7000);
		
		driver.findElementByXPath("(//android.view.ViewGroup)[25]").click();
		driver.findElementById("android:id/button2").click();
		Thread.sleep(5000);
	}

}
