package Memberse.AndroidAutomation;

import org.testng.annotations.Test;

import MembersePageObjects.AppMenus;
import MembersePageObjects.LoginOptionPage;
import MembersePageObjects.ProfileMenuPage;
import MembersePageObjects.WidgetScreenPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;
import SoFaDog.AndroidAutomation.Utilities.Direction;

public class aLogoutTest extends Base {
	
	@Test
	public void aLogoutTestCase() throws InterruptedException {
		//App update Continue Button
				driver.findElementByXPath("//*[@text='CONTINUE']").click();
				System.out.println("Wait for application to load");
				Thread.sleep(5000);
				
				WidgetScreenPage wsp = new WidgetScreenPage(driver);
				wsp.SkipButton().click();
				
				String userNumber = "40";
				String userName = "AutoUser"+userNumber;
				String emailId = "autouser"+userNumber;
				String emailDomain = "@yopmail.com";
				String email = emailId+emailDomain;
				String password = emailId;
				
				LoginOptionPage lop = new LoginOptionPage(driver);
				lop.signinWithEmail().sendKeys(email);
				lop.EmailPassword().sendKeys(password);
				lop.LoginButton().click();
				Thread.sleep(6000);
				
				AppMenus am = new AppMenus(driver);
				am.ProfileMenu().click();
				Thread.sleep(3000);
				
				Utilities u = new Utilities(driver);
				u.swipeScreen(Direction.UP);
				
				ProfileMenuPage pmp = new ProfileMenuPage(driver);
				pmp.Logout().click();
				
				driver.findElementByXPath("//android.widget.Button[@text='YES']").click();
				Thread.sleep(6000);
				System.out.println(userName + "Logout Test Case Pass");		
	}

}
