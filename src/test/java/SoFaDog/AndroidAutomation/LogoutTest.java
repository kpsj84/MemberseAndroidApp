package SoFaDog.AndroidAutomation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import PageObjects.ProfilePage;

public class LogoutTest extends Base {
	
	@Test
	public void LogoutTestCase() throws InterruptedException, IOException {
		LoginTest lt = new LoginTest();
		lt.LoginTestCase();
		
		ProfilePage pp = new ProfilePage(driver);
		pp.profileButton().click();
		Thread.sleep(1000);
	
		Utilities u = new Utilities(driver);
		u.swipeScreen(Utilities.Direction.UP);
	
		pp.Logout().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Click on Yes for Popup message
		driver.findElementByXPath("//*[@resource-id='android:id/button2']").click();
		Thread.sleep(5000);
	}
	
}
