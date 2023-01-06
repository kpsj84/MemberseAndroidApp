package Memberse.AndroidAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.testng.annotations.Test;

import MembersePageObjects.LoginOptionPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class aFeedsVerifyTest extends Base {
	
	@Test
	public void aFeedsVerifyTestCase() throws Exception {
		Utilities u = new Utilities(driver);
		u.DirectToLoginOptionPage();
		
		String userName = "kqatestc3";
		String emailDomain = "@yopmail.com";
		String email = userName+emailDomain;
		String password = userName;
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.signinWithEmail().sendKeys(email);
		lop.EmailPassword().sendKeys(password);
		lop.RevealPassword().click();
		Thread.sleep(1000);
		lop.LoginButton().click();
		Thread.sleep(10000);
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//android.widget.TextView[@text='Close']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(1000);
		
		int verifyResult = 0;
		try
		{
			List<AndroidElement> feedsNos = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup");
			verifyResult = feedsNos.size();
	        System.out.println(verifyResult);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
        if(verifyResult >= 1)
        {
        	System.out.println("Feeds are available on Home Screen");
        }
        else
        {
        	Assert.fail();	
        }
	}

}
