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
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WidgetSwipeTest wst = new WidgetSwipeTest();
		wst.WidgetSwipeTestCase();
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.signinWithEmail().click();
		
		//Change these Credentials according to the User to be Login 
		String userName = "AutoUser40";
		String emailId = "autouser40";
		String emailDomain = "@yopmail.com";
		String email = emailId+emailDomain;
		String password = emailId;
		
		driver.findElementByXPath("//android.widget.EditText[@text='john.doe@email.com']").sendKeys(email);
		driver.findElementByXPath("(//android.widget.EditText)[2]").sendKeys(password);
		
		LoginPage lp = new LoginPage(driver);
		lp.loginButton().click();
		Thread.sleep(25000);
		
		//Verify User Name display on screen
		String uName = driver.findElementByXPath("//android.widget.TextView").getText();
		System.out.println(uName);
		Assert.assertEquals(userName, uName);
	}

}
