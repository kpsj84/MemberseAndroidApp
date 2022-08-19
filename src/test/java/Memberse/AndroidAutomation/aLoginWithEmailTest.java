package Memberse.AndroidAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import MembersePageObjects.TutorialScreenPage;
import MembersePageObjects.AppMenus;
import MembersePageObjects.LoginOptionPage;
import MembersePageObjects.ProfileMenuPage;
import SoFaDog.AndroidAutomation.Base;

public class aLoginWithEmailTest extends Base{
	@Test
	public void LoginTestCasewithEmail() throws InterruptedException {
		
		//App update Continue Button
		driver.findElementByXPath("//*[@text='CONTINUE']").click();
		System.out.println("Wait for application to load");
		Thread.sleep(5000);
		
		TutorialScreenPage wsp = new TutorialScreenPage(driver);
		wsp.SkipButton().click();
		
		String userNumber = "40";
		String userName = "AutoUser"+userNumber;
		String emailId = "autouser"+userNumber;
		String emailDomain = "@yopmail.com";
		String email = emailId+emailDomain;
		String password = emailId;
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.signinWithEmail().sendKeys(email);
		lop.EmailPassword().sendKeys(password);
		lop.LoginButton().click();
		Thread.sleep(5000);
		
		AppMenus am = new AppMenus(driver);
		am.ProfileMenu().click();
		
		ProfileMenuPage pmp = new ProfileMenuPage(driver);
		pmp.UserInfo().click();
		
		String VerifyEmail = driver.findElementByXPath("//android.widget.EditText[@text='"+email+"']").getText();
		Assert.assertEquals(email, VerifyEmail);
		System.out.println("Expected Vs Actual is: "+ email + " Vs " + VerifyEmail);
		System.out.println(userName + " Login Test Passed");
	}

}
