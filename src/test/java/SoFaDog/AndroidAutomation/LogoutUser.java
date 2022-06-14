package SoFaDog.AndroidAutomation;

import java.util.concurrent.TimeUnit;

import PageObjects.ProfilePage;

public class LogoutUser extends Base {
	
	public void LogoutUserCase() throws InterruptedException  {

		ProfilePage pp = new ProfilePage(driver);
		pp.profileButton().click();
		Thread.sleep(2000);
	
		Utilities u = new Utilities(driver);
		u.swipeScreen(Utilities.Direction.UP);
	
		pp.Logout().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Click on Yes for Popup message
		driver.findElementByXPath("//*[@resource-id='android:id/button2']").click();
		Thread.sleep(5000);
		}

}
