package Memberse.AndroidAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import MembersePageObjects.AppMenus;
import MembersePageObjects.DMPage;
import MembersePageObjects.LoginOptionPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;

public class aDMMenuTest extends Base {
	
	@Test
	public void aDMMenuTestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		Utilities u = new Utilities(driver);
		u.DirectToLoginOptionPage();
		
		String userNumber = "mem";
		String emailId = "test"+userNumber;
		String emailDomain = "@yopmail.com";
		String email = emailId+emailDomain;
		String password = emailId;
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(lop.signinWithEmail())).sendKeys(email);
		ewait.until(ExpectedConditions.elementToBeClickable(lop.EmailPassword())).sendKeys(password);
		ewait.until(ExpectedConditions.elementToBeClickable(lop.RevealPassword())).click();
		ewait.until(ExpectedConditions.elementToBeClickable(lop.LoginButton())).click();
		u.apiDelay();
		
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		//driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//android.widget.TextView[@text='Close']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AppMenus am = new AppMenus(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(am.MessagesMenu())).click();
		
		DMPage dmp=new DMPage(driver);
		WebElement aele = ewait.until(ExpectedConditions.elementToBeClickable(dmp.DMonWebText()));
		Assert.assertEquals(aele.getText(), "DMs on Web");
		
		ewait.until(ExpectedConditions.elementToBeClickable(dmp.DMonWebButton())).click();
		
		ewait.until(ExpectedConditions.elementToBeClickable(dmp.mBrowserLogin())).click();
		WebElement aele2 = ewait.until(ExpectedConditions.elementToBeClickable(dmp.mBrowserEmail()));
		Assert.assertEquals(aele2.getText(), "Email address");
	}

}
