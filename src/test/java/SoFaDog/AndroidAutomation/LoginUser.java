package SoFaDog.AndroidAutomation;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.LoginOptionPage;
import PageObjects.LoginPage;

public class LoginUser extends Base {
		
		@Test
		public void LoginUserCase() throws IOException, InterruptedException {	
			LoginOptionPage lop = new LoginOptionPage(driver);
			lop.signinWithEmail().click();
			
			//Change these Credentials according to the User to be Login 
			String userNumber = "40";
			String emailId = "autouser"+userNumber;
			String emailDomain = "@yopmail.com";
			String email = emailId+emailDomain;
			String password = emailId;
			
			driver.findElementByXPath("//android.widget.EditText[@text='john.doe@email.com']").sendKeys(email);
			driver.findElementByXPath("(//android.widget.EditText)[2]").sendKeys(password);
			
			LoginPage lp = new LoginPage(driver);
			lp.loginButton().click();
			Thread.sleep(15000);
		}

}
