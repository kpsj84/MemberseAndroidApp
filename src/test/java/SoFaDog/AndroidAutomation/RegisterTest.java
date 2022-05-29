package SoFaDog.AndroidAutomation;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import PageObjects.LoginOptionPage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;

public class RegisterTest extends Base {
	
	@Test
	public void registerUser() throws InterruptedException {
	
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
		
		LoginPage lp = new LoginPage(driver);
		lp.createAccount().click();
		
		//Change the user credentials every time while running this test to fill fresh detail in Register Form or Delete the user at the end of Test to keep this detail same
		String firstName = "AutoUser23";
		String lastName = "QATest23";
		String emailId = "autouser23";
		
		String userName = firstName;
		String emailDomain = "@yopmail.com";
		String email = emailId+emailDomain;
		String password = emailId;
		driver.findElementByXPath("//android.widget.EditText[@text='John']").sendKeys(firstName);
		driver.findElementByXPath("//android.widget.EditText[@text='Doe']").sendKeys(lastName);
		driver.findElementByXPath("//android.widget.EditText[@text='johndoe']").sendKeys(userName);
		driver.findElementByXPath("//android.widget.EditText[@text='john.doe@email.com']").sendKeys(email);
		driver.findElementsByXPath("//android.widget.EditText").get(4).sendKeys(password);
		Thread.sleep(1000);
		driver.findElementsByXPath("//android.widget.EditText").get(5).sendKeys(password);
		
		RegisterPage rp = new RegisterPage(driver);
		rp.createAccountButton2().click();
		Thread.sleep(15000);		
	}
	
}
