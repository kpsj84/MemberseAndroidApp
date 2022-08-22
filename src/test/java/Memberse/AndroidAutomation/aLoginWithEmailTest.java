package Memberse.AndroidAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import MembersePageObjects.AppMenus;
import MembersePageObjects.LoginOptionPage;
import MembersePageObjects.ProfileMenuPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;

public class aLoginWithEmailTest extends Base{
	
	@Test
	public void LoginTestCasewithEmail() throws InterruptedException {	
		Utilities u = new Utilities(driver);
		u.DirectToLoginOptionPage();
		
		String userNumber = "aA40";
		String userName = "AutoUser"+userNumber;
		String emailId = "autouser"+userNumber;
		String emailDomain = "@yopmail.com";
		String email = emailId+emailDomain;
		String password = emailId;
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.signinWithEmail().sendKeys(email);
		lop.EmailPassword().sendKeys(password);
		lop.LoginButton().click();
		Thread.sleep(7000);
		
		AppMenus am = new AppMenus(driver);
		am.ProfileMenu().click();
		
		ProfileMenuPage pmp = new ProfileMenuPage(driver);
		pmp.MemberInfo().click();
		
		String VerifyEmail = driver.findElementByXPath("//android.widget.EditText[@text='"+email+"']").getText();
		Assert.assertEquals(email, VerifyEmail);
		System.out.println("Expected Vs Actual is: "+ email + " Vs " + VerifyEmail);
		System.out.println(userName + " Login Test Passed");
	}

}
