package SoFaDog.AndroidAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.ExplorePage;
import PageObjects.HomePage;
import PageObjects.LoginOptionPage;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SmokeTest extends Base {

	//Represents as one Test Case
	@Test
	public void SmokeTestCase() throws IOException, InterruptedException {
		WidgetSwipeTest wst = new WidgetSwipeTest();
		wst.WidgetSwipeTestCase();
		
		//Click on Maybe later Button by calling Web Element thru LoginOptionPage Object
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.SigninwithGoogle().click();
		Thread.sleep(15000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementById("android:id/button1").click();
		lop.SigninwithFacebook().click();
		Thread.sleep(10000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
		lop.signinWithEmail().click();
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		lop.maybeLater().click();
		
		//Verify Text from Explore Page
		System.out.println("Waiting for UI to load");
		Thread.sleep(13000);
		ExplorePage ep = new ExplorePage(driver);
		String suggestedChannels = ep.SuggestedChannels().getText();
		Assert.assertEquals(suggestedChannels, "Suggested Channels");
		System.out.println("Checked, Mobile Elements are available on Screen");		
		
		//Swipe Action performed on screen
		Utilities u = new Utilities(driver);
		u.swipeScreen(Utilities.Direction.UP);
		Thread.sleep(3000);
		
		//Click on Home Button
		HomePage hp = new HomePage(driver);
		hp.homeButton().click();
		Thread.sleep(3000);
		
		//Click on Sign up Button
		hp.signup().click();
		Thread.sleep(3000);
		System.out.println("I am in SoFaDog App at Sign-In Options Page. This Build is Responsive");
	}
	
}
