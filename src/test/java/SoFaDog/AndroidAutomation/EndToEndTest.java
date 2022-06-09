package SoFaDog.AndroidAutomation;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

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

/*
//Step1 Register a User
			RegisterTest rt = new RegisterTest();
			rt.registerUser();
			Thread.sleep(10000);
*/		
			
//Step Login User directly to Bypass Register Process
			LoginTest lt = new LoginTest();
			lt.LoginTestCase();
			
//Step2 Subscribe a Free Channel
			//Click on Explore Channels Button
			driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
			driver.findElementByXPath("//*[@content-desc=', tab, 2 out of 5']").click();
			
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
			//driver.findElementByXPath("//android.widget.TextView[@text='Subscribe for FREE                                  }']").click();
			//driver.findElementById("android:id/button2").click();
			//Thread.sleep(20000);
			
//Step3 Watch a Video			
			driver.findElementByXPath("//android.widget.TextView[@text='VR Glasses']").click();
			Thread.sleep(3000);
			driver.findElementByXPath("//android.widget.TextView[@text='Play']").click();
			Thread.sleep(30000);
			TouchAction t = new TouchAction(driver);
			t.tap(PointOption.point(1280,2000)).perform();
			Thread.sleep(6000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(6000);
			t.tap(PointOption.point(98,196)).perform();
			Thread.sleep(6000);
			t.tap(PointOption.point(1307,231)).perform();
			Thread.sleep(6000);

/*			
//Step4 Search for Other Creator Channel & Subscribe a Paid Channel			
			//Click on View All Button for New Channels on Explore Page
			Thread.sleep(5000);
			driver.findElementByXPath("//*[@content-desc=', tab, 2 out of 4']").click();
			driver.findElementByXPath("(//android.widget.TextView[@text='View All'])[2]").click();
			
			//Scroll List
			Thread.sleep(5000);
			Utilities u = new Utilities(driver);
			u.swipeScreen(Utilities.Direction.UP);
			u.swipeScreen(Utilities.Direction.UP);
/*			Thread.sleep(25000);
			driver.findElementByXPath("//*[@text='Suri's Stripe Demo']").click();
			Thread.sleep(10000);
			
			//Subscribe Button
			driver.findElementByXPath("//android.widget.TextView[@text='Subscribe for € 3 p/m']").click();
			Thread.sleep(25000);
			
/*			//Stripe Form
			Thread.sleep(15000);
			driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
			System.out.println("wait for context");
			
			Set<String> contexts = driver.getContextHandles();
			for(String contextName : contexts)
            {
                    System.out.println(contextName);
            }   
			System.out.println("Printed context Name");
			Thread.sleep(15000);
			
			driver.context("WEBVIEW_dog.fa.so.app"); //this let the code know which view it has to consider by taking the detail from package attribute, add WEBVIEW_ before the package name
			Thread.sleep(12000);
			System.out.println(driver.getContext());
			
			// Some Issue Here
			driver.findElement(By.name("email")).sendKeys("autouser2@yopmail.com");
			driver.findElementByAccessibilityId("cardNumber']").sendKeys("4242424242424242");
			driver.findElementByXPath("//android.widget.EditText[@resource-id='cardExpiry']").sendKeys("12/26");
			driver.findElementByXPath("//android.widget.EditText[@resource-id='cardCvc']").sendKeys("123");
			driver.findElementByXPath("//android.widget.EditText[@resource-id='billingName']").sendKeys("autouser2@yopmail.com");
			//Utilities u = new Utilities(driver);
			u.ScrollToText("Subscribe");
			
			//click subscribe
			Thread.sleep(2000);
			driver.findElementByXPath("//android.widget.Button[@text=Subscribe]");
			driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
			driver.context("NATIVE_APP");
			System.out.println("Shifting context from WEBVIEW to NATIVE APP");
*/			

//Step5 Search for audio content on other Channel
			driver.findElementByXPath("//android.widget.EditText[@text='kqacd2']").sendKeys("MakFreeChannel");
			Thread.sleep(6000);
			driver.findElementByXPath("//android.widget.TextView[@text='MakFreeChannel']").click();
			Thread.sleep(6000);
			driver.findElementByXPath("//android.widget.TextView[@text='test']").click();
			driver.findElementByXPath("//android.widget.TextView[@text='Play']").click();
			Thread.sleep(21000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			
//Step6 Watching Video content in Popular Section of Explore Page
			Thread.sleep(3000);
			Utilities u = new Utilities(driver);	
			u.swipeScreen(Utilities.Direction.UP);
			Thread.sleep(3000);
			TouchAction t2 = new TouchAction(driver);
			t2.press(PointOption.point(1400, 2203)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).moveTo(PointOption.point(10, 2203)).release().perform();	
			//t2.press(PointOption.point(1400, 2203)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).moveTo(PointOption.point(10, 2203)).release().perform();	
			driver.findElementByXPath("//android.widget.TextView[@text='Party time']").click();
			Thread.sleep(28000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));	
			Thread.sleep(3000);

/*
//Step7 Become a Creator
			driver.findElementByXPath("//*[@content-desc=', tab, 4 out of 4']").click();
			Thread.sleep(5000);
			driver.findElementByXPath("(//android.widget.Switch)[1]").click();
			Thread.sleep(5000);
			driver.findElementByXPath("//android.widget.Button").click();
			Thread.sleep(20000);
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
*/	
			
/*
//Step8 Upload a Video
			driver.findElementByXPath("//android.widget.TextView[@text='My Posts']").click();
			Thread.sleep(4000);
			driver.findElementByXPath("//android.widget.TextView[@text='UPLOAD']").click();
			Thread.sleep(3000);
			driver.findElementByXPath("//android.widget.TextView[@text='Select a file to upload']").click();
			Thread.sleep(3000);
			//driver.findElementByXPath("//android.widget.TextView[@text='Upload Audio']").click();
			//Thread.sleep(2000);
			//driver.findElementByXPath("//android.widget.ImageButton").click();
			//Thread.sleep(3000);
			//driver.findElementByXPath("//android.widget.TextView[@text='Downloads']").click();
			//Thread.sleep(4000);
			//driver.findElementByXPath("//*[@text='file_example_MP3_700KB.mp3']").click();
			//Thread.sleep(2000);
			
			//Take Video Button
			driver.findElementByXPath("//android.widget.TextView[@text='Take Video']").click();
			Thread.sleep(3000);
			driver.findElementByXPath("//android.widget.ImageView[@resource-id='com.android.camera2:id/shutter_button']").click();
			Thread.sleep(5000);
			driver.findElementByXPath("//android.widget.ImageView[@resource-id='com.android.camera2:id/shutter_button']").click();
			Thread.sleep(3000);
			driver.findElementByXPath("//android.widget.ImageButton[@resource-id='com.android.camera2:id/done_button']").click();
			Thread.sleep(3000);
			
			//driver.findElementByXPath("//android.widget.TextView[@text='Select a thumbnail image']").click();
			//Thread.sleep(2000);
			//driver.findElementByXPath("//android.widget.ImageView[@resource-id='com.android.camera2:id/shutter_button']").click();
			//Thread.sleep(1000);
			//driver.findElementByXPath("//android.widget.ImageButton[@resource-id='com.android.camera2:id/done_button']").click();
			Thread.sleep(3000);
			driver.findElementByXPath("//android.widget.EditText").sendKeys("Auto Test Audio");
			Thread.sleep(3000);
			driver.findElementByXPath("(//android.widget.EditText)[2]").sendKeys("Auto Test Description");
			Thread.sleep(3000);
			u.swipeScreen(Utilities.Direction.UP);
			Thread.sleep(3000);
			driver.findElementByXPath("//android.widget.Switch").click();
			Thread.sleep(3000);
			driver.findElementByXPath("//android.widget.TextView[@text='SAVE']").click();
			Thread.sleep(60000);
			//driver.findElementByXPath("//*[@resource-id='android:id/button1']").click();
			//driver.pressKey(new KeyEvent(AndroidKey.BACK));	
			Thread.sleep(5000);
*/
			
/*			
//Step9 Checks the uploaded content on Own Channel	
			driver.findElementByXPath("//*[@content-desc=', tab, 1 out of 5']").click();
			Thread.sleep(2000);
			driver.findElementByXPath("//android.widget.TextView[@text='AutoUser2']").click();
			Thread.sleep(2000);
			driver.findElementByXPath("//android.widget.TextView[@text='Auto Test Audio']").click();
			Thread.sleep(2000);
			driver.findElementByXPath("//android.widget.TextView[@text='Play']").click();
			Thread.sleep(25000);
			System.out.println("Yeppee uploaded content availabe for public");
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(2000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));	
			Thread.sleep(2000);
*/
	
//Step10 Signout from App
			driver.findElementByXPath("//*[@content-desc=', tab, 5 out of 5']").click();
			LogoutUser lgtu = new LogoutUser();
			lgtu.LogoutUserCase();
		}

}
