package Memberse.AndroidAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import MembersePageObjects.RegisterPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;

public class aRegisterFormValidationTest extends Base {
	
	@Test
	public void aRegisterFormValidationTestCase() throws InterruptedException {
		Utilities u = new Utilities(driver);
		u.DirectToRegisterPage();
		
		driver.findElementByXPath("//android.view.ViewGroup[6]").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Continue']").click();
		
		String ValidateEmail = driver.findElementByXPath("//android.widget.TextView[@text='Email is required']").getText();
		System.out.println(ValidateEmail);
		
		String ValidatePassword = driver.findElementByXPath("//android.widget.TextView[@text='Password is required']").getText();
		System.out.println(ValidatePassword);
		
		String ValidateConfirmPassword = driver.findElementByXPath("//android.widget.TextView[@index='12']").getText();
		System.out.println(ValidateConfirmPassword);
		
		Assert.assertEquals(ValidateEmail, "Email is required");
		Assert.assertEquals(ValidatePassword, "Password is required");
		Assert.assertEquals(ValidateConfirmPassword, "Password is required");
		Thread.sleep(1000);
		
		driver.findElementByXPath("//android.widget.EditText[@text='Email']").sendKeys("abc@abc");
		String ValidateWrongEmail = driver.findElementByXPath("//android.widget.TextView[@text='Must be formatted: user@domain.com']").getText();
		Assert.assertEquals(ValidateWrongEmail, "Must be formatted: user@domain.com");
		
		driver.findElementByXPath("//android.widget.EditText[@text='Password']").sendKeys("abc");
		String ValidateWrongPassword = driver.findElementByXPath("//android.widget.TextView[@text='Password must be at least 5 characters']").getText();
		Assert.assertEquals(ValidateWrongPassword, "Password must be at least 5 characters");
		
		driver.findElementByXPath("//android.widget.EditText[@text='Confirm Password']").sendKeys("123");
		String ValidateWrongConfirmPassword = driver.findElementByXPath("//android.widget.TextView[@text='Passwords must match']").getText();
		Assert.assertEquals(ValidateWrongConfirmPassword, "Passwords must match");
		
		RegisterPage rp = new RegisterPage(driver);
		rp.RevealPassword().click();
		Thread.sleep(1000);
		rp.RevealConfirmPassword().click();
		System.out.println("Validation QA Passed");
	}

}
