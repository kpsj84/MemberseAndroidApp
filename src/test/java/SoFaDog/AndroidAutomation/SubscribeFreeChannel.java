package SoFaDog.AndroidAutomation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import PageObjects.ChannelPage;
import PageObjects.LoginOptionPage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import PageObjects.SearchPage;

public class SubscribeFreeChannel extends Base {
	
	@Test
	public void SubscribeFreeChannelTestCase() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WidgetSwipeTest wst = new WidgetSwipeTest();
		wst.WidgetSwipeTestCase();
				
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.signinWithEmail().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.createAccount().click();
		
		//Change the User Number every time while running this test to fill new detail in Register Form or Delete that user at the end of Test
		String userNumber = UsersDetail.SubscribeFreeChannelTestNumber;
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
		
		//Step2 Subscribe a Free Channel
		//Click on Explore Channels Button
		driver.findElementByXPath("//*[@content-desc=', tab, 2 out of 4']").click();
		Thread.sleep(1000);
		
		//Click in Search at some tag
		driver.findElementByXPath("//*[@text='tag1']").click();
		SearchPage sp = new SearchPage(driver);
		sp.Channels().click();
		sp.SearchField().sendKeys("kqacd2");
		driver.findElementByXPath("//android.widget.TextView[@text='kqacd2 Test Channel']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		ChannelPage cp = new ChannelPage(driver);
		cp.SubscribeFreeButton().click();
		driver.findElementById("android:id/button2").click();
		Thread.sleep(10000);
	}

}
