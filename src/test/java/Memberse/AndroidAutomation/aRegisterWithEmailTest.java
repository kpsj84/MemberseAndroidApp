package Memberse.AndroidAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import MembersePageObjects.AppMenus;
import MembersePageObjects.LoginOptionPage;
import MembersePageObjects.ProfileMenuPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.UsersDetail;
import SoFaDog.AndroidAutomation.Utilities;

public class aRegisterWithEmailTest extends Base{
	
	@Test
	public void aRegisterWithEmailTestCase() throws InterruptedException {
		Utilities u = new Utilities(driver);
		u.DirectToLoginOptionPage();
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.Register().click();
		
		String userNumber = UsersDetail.RegisterTestNumber;
		String firstName = "AutoUser"+userNumber;
		String lastName = "QATest"+userNumber;
		String emailId = "autouser"+userNumber;
		String emailDomain = "@yopmail.com";
		String email = emailId+emailDomain;
		String password = emailId;
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.EditText[@text='Email']").sendKeys(email);
		driver.findElementByXPath("//android.widget.EditText[@text='Password']").sendKeys(password);
		driver.findElementByXPath("//android.widget.EditText[@text='Confirm Password']").sendKeys(password);
		driver.findElementByXPath("//android.widget.TextView[@text='Continue']").click();
		Thread.sleep(7000);
		
		driver.findElementByXPath("//android.widget.TextView[@text='As a creator']").click();
		Thread.sleep(3000);
		
		AppMenus am = new AppMenus(driver);
		am.ProfileMenu().click();
		Thread.sleep(2000);
		
		ProfileMenuPage pmp = new ProfileMenuPage(driver);
		pmp.MemberInfo().click();
		
		String VerifyEmail = driver.findElementByXPath("//android.widget.EditText[@text='"+email+"']").getText();
		Assert.assertEquals(email, VerifyEmail);
		System.out.println("Expected Vs Actual is: "+ email + " Vs " + VerifyEmail);
		System.out.println(firstName + lastName + " Register Test Passed");
	}

}
