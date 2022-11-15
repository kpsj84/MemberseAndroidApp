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

public class aPostHistoryPlayTest extends Base {
	
	@Test
	public void aPostHistoryPlayTestCase() throws InterruptedException {
		Utilities u = new Utilities(driver);
		u.DirectToLoginOptionPage();
		
		String userNumber = "c3";
		String emailId = "kqatest"+userNumber;
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
		pmp.postsHistorySubMenu().click();
		Thread.sleep(5000);
		
		String noPosts = null;
		try
		{
			noPosts = driver.findElementByXPath("//android.widget.TextView[@text='No post available']").getText();
			Assert.assertEquals(noPosts, "No post available");
		}
		catch(Exception e)
		{
			
		}
		
		if(noPosts == "No post available")
		{
			System.out.println("There are no Posts in Post History List");
		}
		else
		{
			List<AndroidElement> postCount = (List<AndroidElement>) driver.findElementsByXPath("(//android.view.ViewGroup[@index='0'])[9]");
			int postCountVerify = postCount.size();
			System.out.println("Total Posts count visible on screen :- " + postCountVerify);
		}
	}

}
