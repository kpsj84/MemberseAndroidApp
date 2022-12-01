package Memberse.AndroidAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import MembersePageObjects.AppMenus;
import MembersePageObjects.ExplorePage;
import MembersePageObjects.LoginOptionPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class aSearchCreatorTest extends Base {
	
	@Test
	public void aSearchCreatorTestCase() throws InterruptedException {
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
		am.ExploreMenu().click();
		
		ExplorePage ep = new ExplorePage(driver);
		ep.SearchField().click();
		ep.SearchField().sendKeys("kqatest");
		Thread.sleep(1000);
		driver.getKeyboard();
		driver.pressKey(new KeyEvent(AndroidKey.SEARCH));
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Thread.sleep(10000);  
		
		List<AndroidElement> searchResult = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup");
		System.out.println(searchResult.size());
		int verifyResult = searchResult.size();
		 if(verifyResult == 0)
	        {
	        	String noResult = driver.findElement(By.xpath("//*[@text='No results... .did you type correctly?']")).getText();
	        	System.out.println(noResult);
	        	Assert.assertEquals(noResult, "No results... .did you type correctly?");
	        }
	        else
	        {
	        	System.out.println("Got Results from the Search field = " + verifyResult);
	        }
	}

}
