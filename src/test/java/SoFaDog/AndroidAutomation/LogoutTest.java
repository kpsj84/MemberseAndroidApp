package SoFaDog.AndroidAutomation;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.ProfilePage;

public class LogoutTest extends Base {
	
	@Test
	public void LogoutTestCase() throws InterruptedException, IOException {
		LoginTest lt = new LoginTest();
		lt.LoginTestCase();
		
		ProfilePage pp = new ProfilePage(driver);
		pp.profileButton().click();
		Thread.sleep(3000);
	
		Utilities u = new Utilities(driver);
		u.swipeScreen(Utilities.Direction.UP);
		Thread.sleep(3000);
	
		pp.Logout().click();
		Thread.sleep(3000);
		//Click on Yes for Popup message
		driver.findElementByXPath("//*[@resource-id='android:id/button2']").click();
	}
	
}
