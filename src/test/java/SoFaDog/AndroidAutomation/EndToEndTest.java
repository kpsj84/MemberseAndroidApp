package SoFaDog.AndroidAutomation;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

import PageObjects.ChannelPage;
import PageObjects.ExplorePage;
import PageObjects.LoginOptionPage;
import PageObjects.LoginPage;
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

//Step1 Just only fill Register Form
			String userNumber = "999";
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
			Thread.sleep(1000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.pressKey(new KeyEvent(AndroidKey.BACK));	
					
//Step2 Login User
			LoginUser lt = new LoginUser();
			lt.LoginUserCase();
			
//Step3 Explore the list of new channels on Explore Page
			//Menu Item - Explore Page
			driver.findElementByXPath("//*[@content-desc=', tab, 2 out of 5']").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ExplorePage ep = new ExplorePage(driver);
			ep.NewChannelsViewall().click();
			Utilities u = new Utilities(driver);
			u.swipeScreen(Utilities.Direction.UP);
			driver.findElementByXPath("(//android.widget.TextView)[5]").click();
			ChannelPage cp = new ChannelPage(driver);
			cp.AboutTab().click();
			Thread.sleep(1000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			
//Step4 Watching Video content from Popular Section of Explore Page
			Thread.sleep(1000);
			u.swipeScreen(Utilities.Direction.UP);
			TouchAction t2 = new TouchAction(driver);
			Dimension dim = driver.manage().window().getSize();
			int startX = dim.width-10;
			System.out.println(startX);
			int endX = dim.width*2/100;
			System.out.println(endX);
			int startY = dim.height*80/100;
			System.out.println(startY);
			int endY = dim.height*80/100;
			System.out.println(endY);
			
			//t2.press(PointOption.point(1400, 2203)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).moveTo(PointOption.point(10, 2203)).release().perform();	
			t2.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).moveTo(PointOption.point(endX, endY)).release().perform();	
			driver.findElementByXPath("//android.widget.TextView[@text='Party time']").click();
			Thread.sleep(25000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));	
			Thread.sleep(1000);
			
//Step5 Chat via DM
			driver.findElementByXPath("//*[@content-desc=', tab, 4 out of 5']").click();
			
			
//Step6 Signout from App
			driver.findElementByXPath("//*[@content-desc=', tab, 5 out of 5']").click();
			LogoutUser lgtu = new LogoutUser();
			lgtu.LogoutUserCase();
		}

}
