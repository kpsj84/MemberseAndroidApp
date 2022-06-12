package SoFaDog.AndroidAutomation;

import PageObjects.ProfilePage;

public class LogoutUser extends Base {
	
	public void LogoutUserCase() throws InterruptedException  {

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
