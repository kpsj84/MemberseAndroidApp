package Memberse.AndroidAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import MembersePageObjects.AppMenus;
import MembersePageObjects.LoginOptionPage;
import MembersePageObjects.ProfileMenuPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;
import io.appium.java_client.android.AndroidElement;

public class aCommunityPriceTest extends Base {
	
	@Test
	public void aCommunityPriceTestCase() throws InterruptedException {
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
	Thread.sleep(1000);
	driver.findElementByXPath("//android.widget.TextView[@text='Close']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	AppMenus am = new AppMenus(driver);
	am.ProfileMenu().click();
	
	ProfileMenuPage pmp = new ProfileMenuPage(driver);
	pmp.manageMyCommunitySubMenu().click();
	Thread.sleep(5000);
	
	driver.findElementByXPath("//*[@text='Pricing']").click();
	Thread.sleep(2000);
	
	AndroidElement Price = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.widget.TextView");
	String ChkPrice = Price.getText();
	System.out.println(ChkPrice);
	Assert.assertEquals(ChkPrice,"Monthly Membership Price");
	Thread.sleep(2000);
	
	WebElement Text1 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.TextView");
	String text2 = Text1.getText();
	System.out.println(text2);
	Assert.assertEquals(text2,"Stripe connected");
	}

}
