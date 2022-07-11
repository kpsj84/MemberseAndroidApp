package SoFaDog.AndroidAutomation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AppMenus;
import PageObjects.ChannelPage;
import PageObjects.CreatorPage;
import PageObjects.CreatorServicesPage;
import PageObjects.LoginOptionPage;
import PageObjects.LoginPage;
import PageObjects.ProfilePage;
import PageObjects.SearchPage;
import PageObjects.StripeFormPage;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class PaidServiceStatusTest extends Base {
	
	@Test
	public void PaidServiceStatusTestCase() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		LoginTest lt = new LoginTest();
		lt.LoginTestCase();
		
		AppMenus am = new AppMenus(driver);
		am.ExploreMenu().click();
		
		driver.findElementByXPath("//*[@text='tag1']").click();
		SearchPage sp = new SearchPage(driver);
		sp.Channels().click();
		sp.SearchField().sendKeys("kqacd");
		driver.findElementByXPath("//android.widget.TextView[@text='kqacd Test Channel']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		ChannelPage cp = new ChannelPage(driver);
		cp.ServicesTab().click();
		driver.findElementByXPath("//android.widget.TextView[@text='4']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Buy service € 4']").click();
		Thread.sleep(7000);
		StripeFormPage sfp = new StripeFormPage(driver);
		sfp.DonationPayButton().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementById("android:id/button2").click();
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		am.ProfileMenu().click();
		Thread.sleep(2000);
		
		//Verify "ONGOING" Status
		ProfilePage pp = new ProfilePage(driver);
		pp.ServicesSubMenu().click();
		String msg1 = driver.findElementByXPath("//android.widget.TextView[@text='kqacd Test Channel']").getText();
		String msg2 = driver.findElementByXPath("//android.widget.TextView[@text='ONGOING']").getText();
		Assert.assertEquals(msg1, "kqacd Test Channel");
		Assert.assertEquals(msg2, "ONGOING");
		
		//Verify "Dispute" Status at Fan end
		driver.findElementByXPath("//android.widget.TextView[@text='kqacd Test Channel']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Dispute']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String msg3 = driver.findElementByXPath("//android.widget.TextView[@text='DISPUTED']").getText();
		Assert.assertEquals(msg3, "DISPUTED");
		
		//Verify "Dispute" Status at Creator end
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Utilities u = new Utilities(driver);
		u.swipeScreen(Utilities.Direction.UP);
		
		LogoutUser lu = new LogoutUser();
		lu.LogoutUserCase();
		
		WidgetSwipeTest wst = new WidgetSwipeTest();
		wst.WidgetSwipeTestCase();
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.signinWithEmail().click();
		
		driver.findElementByXPath("//android.widget.EditText[@text='john.doe@email.com']").sendKeys("kqacd@yopmail.com");
		driver.findElementByXPath("(//android.widget.EditText)[2]").sendKeys("kqacd");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginButton().click();
		Thread.sleep(15000);
		
		am.CreatorMenu().click();
		
		CreatorPage crp = new CreatorPage(driver);
		crp.ServicesSubMenu().click();
		
		CreatorServicesPage csp = new CreatorServicesPage(driver);
		csp.ActiveServicesTab().click();
		u.swipeScreen(Utilities.Direction.UP);
		String msg4 = driver.findElementByXPath("//*[@text='DISPUTED']").getText();
		Assert.assertEquals(msg4, "DISPUTED");
		
		//Verify "Complete" Status at Creator end
		lu.LogoutUserCase();
		
		lt.LoginTestCase();
		
		am.ProfileMenu().click();
		
		pp.ServicesSubMenu().click();
		
		driver.findElementByXPath("//*[@text='DISPUTED']").click();
		driver.findElementByXPath("//*[@text='Withdraw Dispute']").click();
		Thread.sleep(8000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(1000);
		lu.LogoutUserCase();
		
		wst.WidgetSwipeTestCase();
		
		lop.signinWithEmail().click();
		
		driver.findElementByXPath("//android.widget.EditText[@text='john.doe@email.com']").sendKeys("kqacd@yopmail.com");
		driver.findElementByXPath("(//android.widget.EditText)[2]").sendKeys("kqacd");
		
		lp.loginButton().click();
		Thread.sleep(15000);
		
		am.CreatorMenu().click();
		crp.ServicesSubMenu().click();
		csp.ActiveServicesTab().click();
		u.swipeScreen(Utilities.Direction.UP);
		driver.findElementByXPath("//*[@text='ONGOING']").click();
		driver.findElementByXPath("//*[@text='Complete']").click();
		Thread.sleep(7000);
		
		lu.LogoutUserCase();
		
		lt.LoginTestCase();
		
		am.ProfileMenu().click();
		
		pp.ServicesSubMenu().click();
		
		driver.findElementByXPath("//*[@text='COMPLETED']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//*[@text='Remove']").click();
		Thread.sleep(7000);
		System.out.println("Test Passed");
	}

}
