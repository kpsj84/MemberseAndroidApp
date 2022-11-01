package Memberse.AndroidAutomation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import MembersePageObjects.AppMenus;
import MembersePageObjects.ProfileMenuPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;

public class aBecomeCreatorTest extends Base {
	
	@Test
	public void aRegisterWithEmailTestCase() throws InterruptedException {
		Utilities u = new Utilities(driver);
		u.DirectToRegisterPage();
		
		String autoString = getSaltString();
		String emailDomain = "@yopmail.com";
		String email = autoString+emailDomain;
		String password = "12345";
		Thread.sleep(2000);
		System.out.println(email);
		driver.findElementByXPath("//android.widget.EditText[@text='Email']").sendKeys(email);
		driver.findElementByXPath("//android.widget.EditText[@text='Password']").sendKeys(password);
		driver.findElementByXPath("//android.widget.EditText[@text='Confirm Password']").sendKeys(password);
		driver.findElementByXPath("//android.view.ViewGroup[6]").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Continue']").click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//android.widget.TextView[@text='As a Member']").click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Close']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AppMenus am = new AppMenus(driver);
		am.ProfileMenu().click();
		Thread.sleep(3000);
		
		ProfileMenuPage pmp = new ProfileMenuPage(driver);
		pmp.BecomeACreatorMenu().click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.view.ViewGroup[@index='5']").click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementByXPath("//*[@text='CONFIRM']").click();
		Thread.sleep(7000);
		driver.findElementByXPath("//android.widget.ImageButton[@index='0']").click();
		Thread.sleep(3000);
		
		String VerifyText = driver.findElementByXPath("//android.widget.TextView[@text='Manage my Community']").getText();
		Assert.assertEquals(VerifyText, "Manage my Community");
		System.out.println("Member Becomes Creator Now");
	}
	
	public String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

}
