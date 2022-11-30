package Memberse.AndroidAutomation;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
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
		driver.findElementByXPath("(//android.view.ViewGroup[@index='0'])[10]").click();
		lop.SigninwithGoogle().click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		try
		{
		driver.findElementByXPath("//android.widget.Button[@text='Next']").click();
		driver.findElementByXPath("//android.widget.EditText").sendKeys("testsingh998@gmail.com");
		driver.findElementByXPath("//android.widget.Button[@text='Next']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//android.widget.Button[@text='Next']").click();
		driver.findElementByXPath("//android.widget.EditText").sendKeys("test@123#");
		driver.findElementByXPath("//android.widget.Button[@text='Next']").click();
		Thread.sleep(5000);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		finally
		{
			System.out.println("Execute Finally block");
			String verifyPage = driver.findElementByXPath("//*[@text='Verify it’s you']").getText();
			Assert.assertEquals(verifyPage,"Verify it’s you");
		}
		
		System.out.println("As if this message print in server logs that means Login with Google Button is clickable and Webview UI is Responsive");
	}

}
