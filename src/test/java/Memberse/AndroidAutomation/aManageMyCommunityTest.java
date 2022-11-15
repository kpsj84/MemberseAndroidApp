package Memberse.AndroidAutomation;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import MembersePageObjects.AppMenus;
import MembersePageObjects.LoginOptionPage;
import MembersePageObjects.ManageMyCommunityPage;
import MembersePageObjects.ProfileMenuPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;
import SoFaDog.AndroidAutomation.Utilities.Direction;
import io.appium.java_client.android.AndroidElement;

public class aManageMyCommunityTest extends Base {
	
	@Test
	public void aManageMyCommunityTestCase() throws InterruptedException {
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
		pmp.manageMyCommunitySubMenu().click();
		Thread.sleep(5000);
		
		ManageMyCommunityPage mmcp = new ManageMyCommunityPage(driver);
		AndroidElement CommunityName = driver.findElementByXPath("//android.widget.EditText[@index='1']");
	    String chkName = CommunityName.getText();
	    System.out.println(chkName);
		Assert.assertEquals(chkName,"kqatestc3's Channel");
		
		mmcp.CommunityDescription().clear();
		mmcp.CommunityDescription().sendKeys("This is my QA Test Channel and this text post during Automation test :- 123566");
		mmcp.CommunitySaveButton().click();
		Thread.sleep(5000);
		driver.findElementById("android:id/button1").click();
		
		Thread.sleep(3000);
		pmp.manageMyCommunitySubMenu().click();
		Thread.sleep(5000);
		
		u.swipeScreen(Direction.UP);
		AndroidElement CommunityPrice = driver.findElementByXPath("//android.widget.EditText[@index='2']");
	    System.out.println(CommunityPrice.getText());
	    
	    Thread.sleep(2000);
	    AndroidElement stripeStatus = driver.findElementByXPath("//android.widget.TextView[@index='1'][1]");
	    System.out.println(stripeStatus.getText());
	}

}
