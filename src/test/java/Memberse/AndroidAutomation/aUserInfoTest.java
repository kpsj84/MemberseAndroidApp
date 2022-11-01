package Memberse.AndroidAutomation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import MembersePageObjects.AppMenus;
import MembersePageObjects.LoginOptionPage;
import MembersePageObjects.ProfileMenuPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;
import SoFaDog.AndroidAutomation.Utilities.Direction;
import io.appium.java_client.android.AndroidElement;

public class aUserInfoTest extends Base {
	
	@Test
	public void aUserInfoTestCase() throws InterruptedException {	
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
		
		ProfileMenuPage pmp = new ProfileMenuPage(driver);
		pmp.MemberInfo().click();
		Thread.sleep(2000);
		
		AndroidElement verifyName = driver.findElementByXPath("//android.widget.EditText[@text='kqatestc3']");
		String chk1 = verifyName.getText();
		System.out.println(chk1);
		Assert.assertEquals(chk1, "kqatestc3");
		
		WebElement verifyUserName = driver.findElementByXPath("//android.widget.EditText[@text='kqatestc3'][1]");
		String chk2 = verifyUserName.getText();
		System.out.println(chk2);
		Assert.assertEquals(chk2, "kqatestc3");
		
		WebElement verifyEmail = driver.findElementByXPath("//android.widget.EditText[@text='kqatestc3@yopmail.com']");
		String chk3 = verifyEmail.getText();
		System.out.println(chk3);
		Assert.assertEquals(chk3, "kqatestc3@yopmail.com");
		
		String randomNumber = getSaltString();
		System.out.println(randomNumber);
		driver.findElementByXPath("(//android.widget.EditText[@index='0'])[5]").clear();
		Thread.sleep(2000);
		driver.findElementByXPath("(//android.widget.EditText[@index='0'])[5]").sendKeys(randomNumber);
		Thread.sleep(2000);
		u.swipeScreen(Direction.UP);
		driver.findElementByXPath("//*[@text='Save']").click();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		Assert.assertEquals(driver.findElementById("android:id/alertTitle").getText(), "Success");
		System.out.println("Edit functionality at User Info Page is working fine");
	}
	
	public String getSaltString() {
        String SALTCHARS = "1234567890";
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
