package SoFaDog.AndroidAutomation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import PageObjects.CreatorEditInfoPage;
import PageObjects.CreatorPage;
import PageObjects.LoginOptionPage;
import PageObjects.LoginPage;
import PageObjects.ProfilePage;
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
		String userNumber = UsersDetail.BecomeCreatorTestNumber;
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
		Thread.sleep(15000);
		
		driver.findElementByXPath("//*[@content-desc=', tab, 4 out of 4']").click();
		Thread.sleep(1000);
		ProfilePage pp = new ProfilePage(driver);
		pp.BecomeCreatorSwitch().click();
		Thread.sleep(5000);
		pp.BecomeCreatorConfirmation().click();
		Thread.sleep(10000);
		
		CreatorPage cp = new CreatorPage(driver);
		cp.CreatorWelcomeMessage().click();
		Thread.sleep(10000);
		
		CreatorEditInfoPage ceip = new CreatorEditInfoPage(driver);
		ceip.PricingTab().click();
		Thread.sleep(3000);
		ceip.PriceInput().sendKeys("100");
		driver.hideKeyboard();
		ceip.PriceSet().click();
		Thread.sleep(5000);
		ceip.EditInfoSaveButton().click();
		driver.findElementById("android:id/button1").click();
		Thread.sleep(5000);	
		
		System.out.println("Content Creater created Successfully and set the channel price");
	}

}
