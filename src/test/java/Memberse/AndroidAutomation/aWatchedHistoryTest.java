package Memberse.AndroidAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import MembersePageObjects.AppMenus;
import MembersePageObjects.LoginOptionPage;
import MembersePageObjects.ProfileMenuPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;
import io.appium.java_client.android.AndroidElement;

public class aWatchedHistoryTest extends Base {
	
	@Test
	public void aWatchedHistoryTestCase() throws InterruptedException {
		Utilities u = new Utilities(driver);
		u.DirectToLoginOptionPage();
		
		String userNumber = "1";
		String emailId = "autouser"+userNumber;
		String emailDomain = "@yopmail.com";
		String email = emailId+emailDomain;
		String password = emailId;
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		Thread.sleep(15000);
		lop.signinWithEmail().sendKeys(email);
		lop.EmailPassword().sendKeys(password);
		lop.RevealPassword().click();
		lop.LoginButton().click();
		Thread.sleep(15000);
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@text='Close']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(2000);
		AppMenus am = new AppMenus(driver);
		am.ProfileMenu().click();
		
		ProfileMenuPage pmp = new ProfileMenuPage(driver);
		pmp.WatchedHistorySubMenu().click();
		Thread.sleep(5000);
		
		String Text = null;
		
		try
		{
			Text = driver.findElementByXPath("//*[@text='No Results']").getText();
			System.out.println(Text);
		    Assert.assertEquals(Text,"No Results");
		}
		catch (Exception e) 
		{
			
		}
		finally 
		{
			Thread.sleep(3000);
			List<AndroidElement> verifyResult2 = driver.findElementsByXPath("(//android.view.ViewGroup[@index='0'])[9]/android.view.ViewGroup");
	        int testresult2 = verifyResult2.size();
	        System.out.println(verifyResult2.size());
	         if(testresult2 <= 1)
	         {
	        	System.out.println(Text);
	     	
	         }
	         else
	         {
	        	 System.out.println("Got Results from the Search field");
	        	 System.out.println(verifyResult2.size());
	         }
		}
	}
	
}
