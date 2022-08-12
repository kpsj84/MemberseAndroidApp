package Memberse.AndroidAutomation;

import org.testng.annotations.Test;

import MembersePageObjects.AppMenus;
import MembersePageObjects.LoginOptionPage;
import MembersePageObjects.ProfileMenuPage;
import MembersePageObjects.WidgetScreenPage;
import SoFaDog.AndroidAutomation.Base;

public class aLoginWithFacebookTest extends Base {
	
	@Test
	public void iLoginWithFacebookTestCase() throws InterruptedException {
		
		driver.findElementByXPath("//*[@text='CONTINUE']").click();
		System.out.println("Wait for application to load");
		Thread.sleep(5000);
		
		WidgetScreenPage wsp = new WidgetScreenPage(driver);
		wsp.SkipButton().click();
		
		String email = "qatesting9999@gmail.com";
		String password = "Softqa1313";
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.SigninwithFacebook().click();
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.Button[@text='Only allow essential cookies']").click();
		driver.findElementByXPath("//android.widget.EditText[@resource-id='m_login_email']").sendKeys(email);
		driver.findElementByXPath("//android.widget.EditText[@resource-id='m_login_password']").sendKeys(password);
		driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
		driver.findElementByXPath("//android.widget.Button[@text='Continue']").click();
		Thread.sleep(3000);
		
		AppMenus am = new AppMenus(driver);
		am.ProfileMenu().click();
		
		ProfileMenuPage pmp = new ProfileMenuPage(driver);
		pmp.UserInfo().click();
		
		String GetHandle = driver.findElementByXPath("//android.widget.EditText").getText();
		System.out.println(GetHandle + " is the Logged In User Handle Name, Login with Facebook Test is Passed");
		}

}
