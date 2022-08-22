package Memberse.AndroidAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import MembersePageObjects.LoginOptionPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;

public class aEmailFormValidationTest extends Base {
	
	@Test
	public void aEmailFormValidationTestCase() throws InterruptedException {
		
		Utilities u = new Utilities(driver);
		u.DirectToLoginOptionPage();
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.LoginButton().click();
		
		String ValidateEmail = driver.findElementByXPath("//android.widget.TextView[@text='Email is required']").getText();
		System.out.println(ValidateEmail);
		String ValidatePassword = driver.findElementByXPath("//android.widget.TextView[@text='Password is required']").getText();
		System.out.println(ValidatePassword);
		Assert.assertEquals(ValidateEmail, "Email is required");
		Assert.assertEquals(ValidatePassword, "Password is required");
		Thread.sleep(1000);
		
		driver.findElementByXPath("//android.widget.EditText[@text='Email']").sendKeys("abc@abc");
		String ValidateWrongEmail = driver.findElementByXPath("//android.widget.TextView[@text='Must be formatted: user@domain.com']").getText();
		Assert.assertEquals(ValidateWrongEmail, "Must be formatted: user@domain.com");
	}
	
}
