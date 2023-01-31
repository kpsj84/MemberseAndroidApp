package Memberse.AndroidAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import MembersePageObjects.AppMenus;
import MembersePageObjects.CreatorCommunityPage;
import MembersePageObjects.ExplorePage;
import MembersePageObjects.LoginOptionPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class aCommunityTabsTest extends Base {
	
	@Test
	public void aCommunityTabsTestCase() throws InterruptedException {
		Utilities u = new Utilities(driver);
		u.DirectToLoginOptionPage();
		
		String userNumber = "c5";
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
		am.ExploreMenu().click();
		Thread.sleep(2000);
		
		ExplorePage ep = new ExplorePage(driver);
		ep.SearchField().sendKeys("kqatestc3");
		Thread.sleep(7000);
		ep.clickCreator().click();
		
		CreatorCommunityPage cp = new CreatorCommunityPage(driver);
	    cp.playlistTab().click();
	    Thread.sleep(7000);        
        List<AndroidElement> verifyResult2 = driver.findElementsByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup");
        System.out.println(verifyResult2.size());
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(5000);
        
        cp.aboutTab().click();
        Thread.sleep(4000);
        String Text = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView")).getText();
		System.out.println(Text);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(4000);
       
		cp.fansTab().click();
        Thread.sleep(8000);
        List<AndroidElement> verifyResult1 = driver.findElements(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup"));
        System.out.println(verifyResult1.size());
        Thread.sleep(4000);
	}

}
