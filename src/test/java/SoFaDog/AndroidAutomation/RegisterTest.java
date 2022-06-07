package SoFaDog.AndroidAutomation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginOptionPage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;

public class RegisterTest extends Base {
	
	@Test
	public void registerUser() throws InterruptedException, IOException {
	
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WidgetSwipeTest wst = new WidgetSwipeTest();
		wst.WidgetSwipeTestCase();
				
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.signinWithEmail().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.createAccount().click();
		
		//Change the user credentials every time while running this test to fill fresh detail in Register Form or Delete the user at the end of Test to keep this detail same
		String userNumber = "48";
		String firstName = "AutoUser"+userNumber;
		String lastName = "QATest"+userNumber;
		String emailId = "autouser"+userNumber;
		
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
		Thread.sleep(30000);
		
		//Verify User Name display on screen
		String uName = driver.findElementByXPath("//android.widget.TextView").getText();
		System.out.println(uName);
		Assert.assertEquals(uName, firstName);
	}
	
}
