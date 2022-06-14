package SoFaDog.AndroidAutomation;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
/*			
//Step2 Subscribe a Free Channel
			//Click on Explore Channels Button
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			driver.findElementByXPath("//*[@content-desc=', tab, 2 out of 4']").click();
			
			//Click in Search at some tag
			Thread.sleep(12000);
			driver.findElementByXPath("//*[@text='tag1']").click();
			Thread.sleep(3000);
			driver.findElementByXPath("//android.widget.TextView[@text='Channels']").click();
			Thread.sleep(3000);
			driver.findElementByXPath("//android.widget.EditText[@text='Search...']").sendKeys("kqacd2");
			Thread.sleep(3000);
			driver.findElementByXPath("//android.widget.TextView[@text='kqacd2 Test Channel']").click();
			Thread.sleep(3000);
			driver.findElementByXPath("//android.widget.TextView[@text='Subscribe for FREE                                  }']").click();
			driver.findElementById("android:id/button2").click();
			Thread.sleep(15000);
			
//Step3 Watch a Video			
			driver.findElementByXPath("//android.widget.TextView[@text='Test video 3']").click();
			driver.findElementByXPath("//android.widget.TextView[@text='Play']").click();
			Thread.sleep(5000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(1000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(1000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(1000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(1000); // come back on explore page
*/
		
//Step4 Search for Other Creator Channel & Subscribe a Paid Channel			
			//Click on View All Button for New Channels on Explore Page
			driver.findElementByXPath("//*[@content-desc=', tab, 2 out of 4']").click();
			driver.findElementByXPath("(//android.widget.TextView[@text='View All'])[2]").click();
			
			//Scroll List
			Thread.sleep(5000);
			Utilities u = new Utilities(driver);
			u.swipeScreen(Utilities.Direction.UP);
			Thread.sleep(10000);
			driver.findElementByXPath("//android.widget.TextView[@text='kqatest11_Channel']").click();
			Thread.sleep(10000);
			
			//Subscribe Button
			driver.findElementByXPath("//android.widget.TextView[@text='Subscribe for € 2 p/m']").click();
			Thread.sleep(15000);
			
		//Stripe Form
			Thread.sleep(30000);
			System.out.println("wait for context");
			
			Set<String> contexts = driver.getContextHandles();
			for(String contextName : contexts)
            {
                    System.out.println(contextName);
            }   
			System.out.println("Printed context Name");
			Thread.sleep(15000);
			
			driver.context("WEBVIEW_dog.fa.so.app"); //this let the code know which view it has to consider by taking the detail from package attribute, add WEBVIEW_ before the package name
			Thread.sleep(15000);
			System.out.println(driver.getContext());
			
			// Some Issue Here
			driver.findElement(By.name("email")).sendKeys(email);
			driver.findElement(By.id("cardNumber")).sendKeys("4242424242424242");
			driver.findElement(By.name("cardExpiry")).sendKeys("12/26");
			driver.findElement(By.id("cardCvc")).sendKeys("123");
			driver.findElement(By.name("billingName")).sendKeys(userName);
			u.ScrollToText("Subscribe");
			
			//click subscribe
			Thread.sleep(2000);
			driver.findElement(By.className("SubmitButton-IconContainer")).click();
			Thread.sleep(15000);
			driver.context("NATIVE_APP");
			System.out.println("Shifting context from WEBVIEW to NATIVE APP");
		
			
//Step5 Watching Video content in Popular Section of Explore Page
			Thread.sleep(3000);	
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
