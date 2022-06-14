package SoFaDog.AndroidAutomation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import PageObjects.LoginOptionPage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;

public class BecomeCreatorTest extends Base {
	
	@Test
	public void BecomeCreatorTestCase() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WidgetSwipeTest wst = new WidgetSwipeTest();
		wst.WidgetSwipeTestCase();
				
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.signinWithEmail().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.createAccount().click();
		
		//Change the User Number every time while running this test to fill new detail in Register Form or Delete that user at the end of Test
		String userNumber = "204";
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
		Thread.sleep(20000);
		
		driver.findElementByXPath("//*[@content-desc=', tab, 4 out of 4']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("(//android.widget.Switch)[1]").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//android.widget.Button").click();
		Thread.sleep(10000);
		driver.findElementByXPath("//android.widget.Button").click();
		Thread.sleep(10000);
		driver.findElementByXPath("//*[@text='Pricing']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.EditText").sendKeys("100");
		driver.hideKeyboard();
		driver.findElementByXPath("//*[@text='Set']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//*[@text='SAVE']").click();
		Thread.sleep(10000);
		driver.findElementById("android:id/button1").click();
		Thread.sleep(5000);	
		System.out.println("Content Creater created Successfully and set the channel price");
	}

}
