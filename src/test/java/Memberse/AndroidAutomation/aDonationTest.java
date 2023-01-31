package Memberse.AndroidAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import MembersePageObjects.AppMenus;
import MembersePageObjects.CreatePostPage;
import MembersePageObjects.CreatorCommunityPage;
import MembersePageObjects.ExplorePage;
import MembersePageObjects.HomePage;
import MembersePageObjects.LoginOptionPage;
import MembersePageObjects.ThankyouPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class aDonationTest extends Base {
	
	@Test
	public void aDonationTestCase()throws InterruptedException{
		Utilities u = new Utilities(driver);
		u.DirectToLoginOptionPage();
	     
		String userNumber = "c4";
		String emailId = "kqatest"+userNumber;
		String emailDomain = "@yopmail.com";
		String email = emailId+emailDomain;
		String password = emailId;
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.signinWithEmail().sendKeys(email);
		lop.EmailPassword().sendKeys(password);
		lop.RevealPassword().click();
		lop.LoginButton().click();
		Thread.sleep(10000);
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//android.widget.TextView[@text='Close']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AppMenus am = new AppMenus(driver);
		driver.pressKey(new KeyEvent(AndroidKey.BACK)); 
		am.ExploreMenu().click();
		Thread.sleep(2000);
		
	    ExplorePage ep = new ExplorePage(driver);
        ep.SearchField().sendKeys("kqatestc3");
        Thread.sleep(10000);
        ep.clickCreator().click();
        Thread.sleep(5000);
        
        CreatorCommunityPage cp = new CreatorCommunityPage(driver);
        cp.donateButton().click();
        Thread.sleep(3000);
        
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.TextView").click();
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView").click();
        Thread.sleep(8000);
        driver.findElementByXPath("//*[@text='Pay']").click();
        Thread.sleep(8000);
        
        ThankyouPage tp= new ThankyouPage(driver);
	    String Text = driver.findElement(By.xpath("//*[@text='Thank you for your support']")).getText();
		System.out.println(Text);
		Assert.assertEquals(Text, "Thank you for your support");
		tp.back2Community().click();
	    Thread.sleep(3000);
        
	}

}
