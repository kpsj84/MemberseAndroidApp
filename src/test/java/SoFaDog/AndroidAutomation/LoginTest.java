package SoFaDog.AndroidAutomation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginOptionPage;
import PageObjects.LoginPage;

public class LoginTest extends Base {
	
	@Test
	public void LoginTestCase() throws IOException, InterruptedException {	
		WidgetSwipeTest wst = new WidgetSwipeTest();
		wst.WidgetSwipeTestCase();
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.signinWithEmail().click();
		
		//Change these Credentials according to the User to be Login 
		String userNumber = "40";
		String userName = "AutoUser"+userNumber;
		String emailId = "autouser"+userNumber;
		String emailDomain = "@yopmail.com";
		String email = emailId+emailDomain;
		String password = emailId;
		
		driver.findElementByXPath("//android.widget.EditText[@text='john.doe@email.com']").sendKeys(email);
		driver.findElementByXPath("(//android.widget.EditText)[2]").sendKeys(password);
		
		LoginPage lp = new LoginPage(driver);
		lp.loginButton().click();
		Thread.sleep(15000);
		
		//Verify User Name display on screen
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String uName = driver.findElementByXPath("//android.widget.TextView").getText();
		System.out.println(uName);
		System.out.println(userName);
		Assert.assertEquals(uName, userName);
	}

}
