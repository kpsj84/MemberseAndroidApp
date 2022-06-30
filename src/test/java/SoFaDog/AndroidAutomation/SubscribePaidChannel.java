package SoFaDog.AndroidAutomation;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginOptionPage;
import PageObjects.LoginPage;
import PageObjects.PaymentThankyouPage;
import PageObjects.RegisterPage;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class SubscribePaidChannel extends Base {
	
	@Test
	public void SubscribePaidChannelTestCase() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WidgetSwipeTest wst = new WidgetSwipeTest();
		wst.WidgetSwipeTestCase();
				
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.signinWithEmail().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.createAccount().click();
		
		//Change the User Number every time while running this test to fill new detail in Register Form or Delete that user at the end of Test
		String userNumber = UsersDetail.SubscribePaidChannelTestNumber;
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
			
		//Click on View All Button for New Channels on Explore Page
		driver.findElementByXPath("//*[@content-desc=', tab, 2 out of 4']").click();
		driver.findElementByXPath("(//android.widget.TextView[@text='View All'])[2]").click();
		
		//Scroll List
		Thread.sleep(2000);
		Utilities u = new Utilities(driver);
		u.swipeScreen(Utilities.Direction.UP);
		u.swipeScreen(Utilities.Direction.UP);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='kqatest11_Channel']").click();
		Thread.sleep(7000);
		
		//Subscribe Button
		driver.findElementByXPath("//android.widget.TextView[@text='Subscribe for € 2 p/m']").click();
		Thread.sleep(20000);
		
		//Stripe Form
		System.out.println("wait for context");
		
		Set<String> contexts = driver.getContextHandles();
		for(String contextName : contexts)
        {
                System.out.println(contextName);
        }   
		System.out.println("Printed context Name");
		
		//driver.context("WEBVIEW_dog.fa.so.app"); //this let the code know which view it has to consider by taking the detail from package attribute, add WEBVIEW_ before the package name
		Thread.sleep(3000);
		System.out.println(driver.getContext());
		
		driver.findElementByXPath("//android.widget.EditText").sendKeys(email);
		driver.findElementByXPath("(//android.widget.EditText)[2]").sendKeys("4242424242424242");
		driver.findElementByXPath("(//android.widget.EditText)[3]").sendKeys("1226");
		driver.findElementByXPath("(//android.widget.EditText)[4]").sendKeys("123");
		driver.findElementByXPath("(//android.widget.EditText)[5]").sendKeys(userName);
		u.swipeScreen(Utilities.Direction.UP);
		driver.findElementByXPath("(//android.view.View)[33]").click();
		Thread.sleep(1000);
		//Clicked on Zimbabwe who have no zip code
		driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_1));
		driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_2));
		driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_3));
		driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_4));
		driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_5)); 
		driver.hideKeyboard();
		driver.findElementByXPath("//android.widget.Button[@text='Subscribe']").click();
		Thread.sleep(15000);
		
		PaymentThankyouPage ptp = new PaymentThankyouPage(driver);
		Thread.sleep(2000);
		ptp.ContinueToChannel().click();
		Thread.sleep(2000);
		String msg = driver.findElementByXPath("//android.widget.TextView[@text='Donate']").getText();
		Assert.assertEquals(msg, "Donate");
	}
}
