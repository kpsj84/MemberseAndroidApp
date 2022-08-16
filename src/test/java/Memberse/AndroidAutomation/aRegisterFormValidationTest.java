package Memberse.AndroidAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import MembersePageObjects.LoginOptionPage;
import MembersePageObjects.WidgetScreenPage;
import SoFaDog.AndroidAutomation.Base;

public class aRegisterFormValidationTest extends Base {
	
	@Test
	public void aRegisterFormValidationTestCase() throws InterruptedException {
		driver.findElementByXPath("//*[@text='CONTINUE']").click();
		System.out.println("Wait for application to load");
		Thread.sleep(5000);
		
		WidgetScreenPage wsp = new WidgetScreenPage(driver);
		wsp.SkipButton().click();
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.Register().click();
		
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
	}

}
