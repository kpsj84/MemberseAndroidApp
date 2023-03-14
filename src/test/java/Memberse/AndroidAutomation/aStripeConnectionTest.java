package Memberse.AndroidAutomation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import MembersePageObjects.AppMenus;
import MembersePageObjects.ProfileMenuPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;
import SoFaDog.AndroidAutomation.Utilities.Direction;


public class aStripeConnectionTest extends Base {
	
	@Test
	public void aStripeConnectionTestCase() throws InterruptedException {
		Utilities u = new Utilities(driver);
		u.DirectToRegisterPage();
		
		String autoString = getSaltString();
		String emailDomain = "@yopmail.com";
		String email = autoString+emailDomain;
		String password = "12345";
		Thread.sleep(1000);
		driver.findElementByXPath("//android.widget.EditText[@text='Email']").sendKeys(email);
		driver.findElementByXPath("//android.widget.EditText[@text='Password']").sendKeys(password);
		driver.findElementByXPath("//android.widget.EditText[@text='Confirm Password']").sendKeys(password);
		driver.findElementByXPath("//android.view.ViewGroup[6]").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Continue']").click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//android.widget.TextView[@text='As a Creator']").click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Close']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AppMenus am = new AppMenus(driver);
		am.ProfileMenu().click();
		Thread.sleep(1000);
		
		ProfileMenuPage pmp = new ProfileMenuPage(driver);
		pmp.manageMyCommunitySubMenu().click();
		Thread.sleep(3000);
		
		driver.findElementByXPath("//*[@text='Pricing']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@text='Connect with Stripe']").click();
		Thread.sleep(10000);
		
		//Stripe Form
			/*
				System.out.println("wait for context");
				
				Set<String> contexts = driver.getContextHandles();
				for(String contextName : contexts)
		        {
		                System.out.println(contextName);
		        }   
				System.out.println("Printed context Name");
				
				driver.context("WEBVIEW_dog.fa.so.app.stage"); //this let the code know which view it has to consider by taking the detail from package attribute, add WEBVIEW_ before the package name
				Thread.sleep(3000);
				System.out.println(driver.getContext());
				
				driver.findElement(By.xpath("//*[@id=\"hv-root\"]/div/div/main/div[2]/div/div[2]/form/span/div[1]/div/div/div[2]/div[2]/div/div/div/div/div/div[2]/div/div/div/div/div[2]/div/div/span/span[2]/button/div/div[2]/span")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[text()='Continue']")).click();
				Thread.sleep(7000);
				driver.findElement(By.xpath("//*[@id=\"hv-root\"]/div/div/main/div[2]/div/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[2]/div[2]/div/div[1]/button/div/div[2]/span/span")).click();
				Thread.sleep(7000);
				driver.findElement(By.xpath("//*[text()='Continue']")).click();
				Thread.sleep(7000);
				driver.findElement(By.xpath("//*[@id=\"first_name\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"last_name\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"business_profile[url]\"]")).click();
				driver.findElement(By.xpath("//*[text()='Continue']")).click();
				Thread.sleep(7000);
				driver.findElement(By.xpath("//*[@id=\"hv-root\"]/div/div/main/div[2]/div/div[3]/div[2]/form/div[1]/div/div/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div[2]/div/div[1]/button/div/div[2]/span")).click();
				Thread.sleep(7000);
				driver.findElement(By.xpath("//*[text()='Submit']")).click();
				Thread.sleep(7000);
			*/
		
		driver.findElementByXPath("//android.widget.Button[@text='the test phone number']").click();
		driver.findElementByXPath("//*[@text='Email']").click();
		driver.findElementByXPath("//*[@text='Continue']").click();
		Thread.sleep(7000);
		driver.findElementByXPath("//*[@text='Use test code']").click();
		Thread.sleep(7000);
		u.swipeScreen(Direction.UP);
		driver.findElementByXPath("//*[@text='Continue']").click();
		Thread.sleep(7000);
		driver.findElementByXPath("//android.widget.EditText[@resource-id='first_name']").sendKeys(email);
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.EditText[@resource-id='last_name']").sendKeys(autoString);
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.EditText[@resource-id='business_profile[url]']").sendKeys("www" + autoString + ".com");
		u.swipeScreen(Direction.UP);
		driver.hideKeyboard();
		Thread.sleep(4000);
		
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[5]/android.view.View/android.view.View/android.widget.Button").click();
		Thread.sleep(10000);
		u.swipeScreen(Direction.DOWN);
		driver.findElementByXPath("//*[@text='Select an account for payouts']").click();
		driver.findElementByXPath("//*[@text='Use test account']").click();
		Thread.sleep(7000);
		u.swipeScreen(Direction.UP);
		Thread.sleep(2000);
		driver.findElementByXPath("//*[@text='PAYOUT ACCOUNTS']").click();
		Thread.sleep(3000);
		
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[4]/android.view.View/android.widget.Button").click();
		Thread.sleep(10000);
		
		/*
		u.swipeScreen(Direction.UP);
		Thread.sleep(2000);
		driver.findElementByXPath("//*[@text='Payment methods']").click();
		String verifyStrpe = driver.findElementByXPath("//*[@text='Stripe connected']").getText();
		Assert.assertEquals(verifyStrpe, "Stripe connected");
		*/
	}
	
	public String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

}
