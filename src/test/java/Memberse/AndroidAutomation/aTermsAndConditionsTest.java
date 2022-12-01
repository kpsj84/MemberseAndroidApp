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

public class aTermsAndConditionsTest extends Base {
	
	@Test
	public void aTermsAndConditionsTestCase() throws InterruptedException {
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
		u.swipeScreen(Direction.UP);
		
		ProfileMenuPage pmp = new ProfileMenuPage(driver);
		pmp.TermsAndConditions().click();
		Thread.sleep(10000);
		
		Set<String> contexts = driver.getContextHandles();
        for(String contextName : contexts)
        {
                System.out.println(contextName);
        }        
        driver.context("WEBVIEW_chrome");
        String changedContextName = driver.getContext();
        System.out.println(changedContextName);
        
		String verifyText = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div/div/div/h1")).getText();
		System.out.println(verifyText);
		Assert.assertEquals(verifyText, "Terms and Conditions");
	}

}
