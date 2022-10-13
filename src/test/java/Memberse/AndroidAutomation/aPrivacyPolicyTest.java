package Memberse.AndroidAutomation;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import MembersePageObjects.AppMenus;
import MembersePageObjects.LoginOptionPage;
import MembersePageObjects.ProfileMenuPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;
import SoFaDog.AndroidAutomation.Utilities.Direction;

public class aPrivacyPolicyTest extends Base {
	
	@Test
	public void aPrivacyPolicyTestCase() throws InterruptedException {
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
		u.swipeScreen(Direction.UP);
		
		ProfileMenuPage pmp = new ProfileMenuPage(driver);
		pmp.PrivacyPolicy().click();
		Thread.sleep(7000);
		
		Set<String> contexts = driver.getContextHandles();
        for(String contextName : contexts)
        {
                System.out.println(contextName);
        }        
        driver.context("WEBVIEW_chrome");
        String changedContextName = driver.getContext();
        System.out.println(changedContextName);
        Thread.sleep(5000);
        
		String verifyText = driver.findElement(By.xpath("/html/body/div/section[2]/div/div/div/div/div/h1")).getText();
		System.out.println(verifyText);
		Assert.assertEquals(verifyText, "Privacy Policy");
	}

}
