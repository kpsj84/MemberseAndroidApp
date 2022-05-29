package SoFaDog.AndroidAutomation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import PageObjects.LoginOptionPage;
import PageObjects.LoginPage;

public class LoginTest extends Base {
	
	@Test
	public void LoginTestCase() throws IOException, InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Utilities u = new Utilities(driver);
		System.out.println("Wait for application to load");
		Thread.sleep(20000);
		u.swipeScreen(Utilities.Direction.LEFT);
		System.out.println("1st Widget Swipe Executed");
		Thread.sleep(3500);
		u.swipeScreen(Utilities.Direction.LEFT);
		System.out.println("2nd Widget Swipe Executed");
		Thread.sleep(3500);
		u.swipeScreen(Utilities.Direction.LEFT);
		System.out.println("3rd Widget Swipe Executed");
		Thread.sleep(3500);
		u.swipeScreen(Utilities.Direction.LEFT);
		System.out.println("Last Swipe Executed");
		Thread.sleep(1000);
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.signinWithEmail().click();
		
		//Change these Credentials according to the User to be Login 
		String emailId = "autouser4";
		String emailDomain = "@yopmail.com";
		String email = emailId+emailDomain;
		String password = emailId;
		
		driver.findElementByXPath("//android.widget.EditText[@text='john.doe@email.com']").sendKeys(email);
		driver.findElementByXPath("(//android.widget.EditText)[2]").sendKeys(password);
		
		LoginPage lp = new LoginPage(driver);
		lp.loginButton().click();
		Thread.sleep(10000);
	}

}
