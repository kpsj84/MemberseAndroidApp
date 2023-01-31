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
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class aShareCommunityTest extends Base {

	@Test
	public void aShareCommunityTestCase()throws InterruptedException{
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
        cp.threeDotsMenu().click();
        Thread.sleep(3000);
        
        cp.shareCommunity().click();
        Thread.sleep(3000);
        //driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.TextView").click();
        driver.findElementByXPath("//*[@text='Copy to clipboard']").click();
        Thread.sleep(2000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(4000);
        am.ProfileMenu().click();
        am.HomeMenu().click();
        
        HomePage hp = new HomePage(driver);
		hp.createPost().click();
		Thread.sleep(2000);
		
		CreatePostPage cpp = new CreatePostPage(driver);
  		cpp.postTitle().click();
  		String ct = driver.getClipboardText();
  		System.out.println(ct);
  		String ss = ct.substring(37,58);
  		System.out.println(ss);
  		cpp.postTitle().sendKeys(ss);
        cpp.postDescription().sendKeys("This is an Auto-QA Post Description");
        Thread.sleep(2000);
        
        String text= cpp.postTitle().getText();
 		System.out.println(text);
 		Assert.assertEquals(text,"https://memberse.page");
      }
}
