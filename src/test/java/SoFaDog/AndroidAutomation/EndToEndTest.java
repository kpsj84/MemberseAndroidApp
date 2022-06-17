package SoFaDog.AndroidAutomation;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import PageObjects.LoginOptionPage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class EndToEndTest extends Base {
	
		@SuppressWarnings("rawtypes")
		@Test
		public void EndToEndTestCase() throws IOException, InterruptedException {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			WidgetSwipeTest wst = new WidgetSwipeTest();
			wst.WidgetSwipeTestCase();
					
			LoginOptionPage lop = new LoginOptionPage(driver);
			lop.signinWithEmail().click();
			
			LoginPage lp = new LoginPage(driver);
			lp.createAccount().click();

//Step1 Register a User
			String userNumber = "305";
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
			
/*			
//Step Login User to Bypass Register Process
			LoginTest lt = new LoginTest();
			lt.LoginTestCase();
*/
			
//Step5 Watching Video content in Popular Section of Explore Page
			Thread.sleep(3000);	
			Utilities u = new Utilities(driver);
			u.swipeScreen(Utilities.Direction.UP);
			Thread.sleep(3000);
			TouchAction t2 = new TouchAction(driver);
			t2.press(PointOption.point(1400, 2203)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).moveTo(PointOption.point(10, 2203)).release().perform();	
			driver.findElementByXPath("//android.widget.TextView[@text='Party time']").click();
			Thread.sleep(28000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));	
			Thread.sleep(3000);
			
//Step6 Signout from App
			driver.findElementByXPath("//*[@content-desc=', tab, 5 out of 5']").click();
			LogoutUser lgtu = new LogoutUser();
			lgtu.LogoutUserCase();
		}

}
