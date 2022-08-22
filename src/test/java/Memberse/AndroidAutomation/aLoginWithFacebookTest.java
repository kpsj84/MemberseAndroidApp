package Memberse.AndroidAutomation;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import MembersePageObjects.AppMenus;
import MembersePageObjects.LoginOptionPage;
import MembersePageObjects.ProfileMenuPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;

public class aLoginWithFacebookTest extends Base {
	
	@Test
	public void iLoginWithFacebookTestCase() throws InterruptedException {
		Utilities u = new Utilities(driver);
		u.DirectToLoginOptionPage();
		
		String email = "qatesting9999@gmail.com";
		String password = "Softqa1313";
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.SigninwithFacebook().click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		try
		{
		driver.findElementByXPath("//android.widget.Button[@text='Only allow essential cookies']").click();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		finally
		{
			System.out.println("Execute finally Block");
		}
		
		driver.findElementByXPath("//android.widget.EditText[@resource-id='m_login_email']").sendKeys(email);
		driver.findElementByXPath("//android.widget.EditText[@resource-id='m_login_password']").sendKeys(password);
		Thread.sleep(1000);
		driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
		driver.findElementByXPath("//android.widget.Button[@text='Continue']").click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		AppMenus am = new AppMenus(driver);
		am.ProfileMenu().click();
		
		ProfileMenuPage pmp = new ProfileMenuPage(driver);
		pmp.MemberInfo().click();
		
		String GetHandle = driver.findElementByXPath("//android.widget.EditText").getText();
		System.out.println(GetHandle + " is the Logged In User Handle Name, Login with Facebook Test is Passed");
		}

}
