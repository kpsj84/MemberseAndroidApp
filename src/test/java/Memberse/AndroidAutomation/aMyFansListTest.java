package Memberse.AndroidAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import MembersePageObjects.AppMenus;
import MembersePageObjects.LoginOptionPage;
import MembersePageObjects.ProfileMenuPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;
import io.appium.java_client.android.AndroidElement;

public class aMyFansListTest extends Base {
	
	@Test
	public void aMyFansListTestCase() throws InterruptedException {
		Utilities u = new Utilities(driver);
		u.DirectToLoginOptionPage();
		
		String userNumber = "c3";
		String emailId = "kqatest"+userNumber;
		String emailDomain = "@yopmail.com";
		String email = emailId+emailDomain;
		String password = emailId;
		
		LoginOptionPage lop = new LoginOptionPage(driver);
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
		
		AppMenus am = new AppMenus(driver);
		am.ProfileMenu().click();
		
		ProfileMenuPage pmp = new ProfileMenuPage(driver);
		pmp.myFansSubMenu().click();
		Thread.sleep(3000);
		List<AndroidElement> verifyResult2 = driver.findElementsByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup");
	    int testresult3 = verifyResult2.size()-1;
        System.out.println(testresult3);
	}

}
