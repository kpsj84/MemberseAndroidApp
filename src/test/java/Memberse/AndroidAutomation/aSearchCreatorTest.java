package Memberse.AndroidAutomation;

import java.util.List;

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
		
		Thread.sleep(5000);
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
		Thread.sleep(3000);
		
		AppMenus am = new AppMenus(driver);
		am.ExploreMenu().click();
		Thread.sleep(3000);
		
		ExplorePage ep = new ExplorePage(driver);
		ep.SearchField().click();
		ep.SearchField().sendKeys("kqatest");
		Thread.sleep(2000);
		driver.getKeyboard();
		driver.pressKey(new KeyEvent(AndroidKey.SEARCH));
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Thread.sleep(10000);    
		List<AndroidElement> searchResult = driver.findElementsByXPath("//android.view.ViewGroup[@index='0']");
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
	        	System.out.println("Got Results from the Search field");
	        }
	}

}
