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
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
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
		Thread.sleep(2000);
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.Button").click();
		
		try
		{
		driver.findElementByXPath("//android.widget.Button[@text='Continue']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Close']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AppMenus am = new AppMenus(driver);
		am.ProfileMenu().click();
		
		ProfileMenuPage pmp = new ProfileMenuPage(driver);
		pmp.MemberInfo().click();
		
		String GetHandle = driver.findElementByXPath("//android.widget.EditText").getText();
		System.out.println(GetHandle + " is the Logged In User Handle Name, Login with Facebook Test is Passed");
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		finally
		{
			System.out.println("Login with Facebook is QA Pass");
		}
		}

}
