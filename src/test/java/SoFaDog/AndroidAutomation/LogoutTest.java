package SoFaDog.AndroidAutomation;

import PageObjects.ProfilePage;

public class LogoutTest extends Base {
	
	public void LogoutTestCase() {
		
	ProfilePage pp = new ProfilePage(driver);
	pp.profileButton().click();
	
	Utilities u = new Utilities(driver);
	u.swipeScreen(Utilities.Direction.UP);
	
	//Click on Yes for Popup message
	driver.findElementById("android:id/button2").click();
	}
	
}
