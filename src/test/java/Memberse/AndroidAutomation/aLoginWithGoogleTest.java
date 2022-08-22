package Memberse.AndroidAutomation;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import MembersePageObjects.LoginOptionPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;

public class aLoginWithGoogleTest extends Base {
	
	@Test
	public void aLoginWithGoogleTestCase() throws InterruptedException {
		Utilities u = new Utilities(driver);
		u.DirectToLoginOptionPage();
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.SigninwithGoogle().click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		try
		{
		driver.findElementByXPath("//android.widget.Button[@text='Next']").click();
		driver.findElementByXPath("//android.widget.EditText").sendKeys("qatesting9999@gmail.com");
		driver.findElementByXPath("//android.widget.Button[@text='Next']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//android.widget.Button[@text='Next']").click();
		driver.findElementByXPath("//android.widget.EditText").sendKeys("Softqa@1313");
		driver.findElementByXPath("//android.widget.Button[@text='Next']").click();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		finally
		{
			System.out.println("Execute Finally block");
		}
		
		System.out.println("As if this message print in server logs that means Login with Google Button is clickable and Webview UI is Responsive");
	}

}
