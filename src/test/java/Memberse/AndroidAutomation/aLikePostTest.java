package Memberse.AndroidAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import MembersePageObjects.AppMenus;
import MembersePageObjects.HomePage;
import MembersePageObjects.LoginOptionPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class aLikePostTest extends Base {
	
	@Test
	public void aLikePostTestCase()throws InterruptedException{
		Utilities u = new Utilities(driver);
		u.DirectToLoginOptionPage();
     
		String userNumber = "c4";
		String emailId = "kqatest"+userNumber;
		String emailDomain = "@yopmail.com";
		String email = emailId+emailDomain;
		String password = emailId;
	
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.signinWithEmail().sendKeys(email);
		lop.EmailPassword().sendKeys(password);
		lop.RevealPassword().click();
		lop.LoginButton().click();
		Thread.sleep(10000);
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//android.widget.TextView[@text='Close']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		AppMenus am = new AppMenus(driver);
		driver.pressKey(new KeyEvent(AndroidKey.BACK)); 
		am.HomeMenu().click();
		Thread.sleep(2000);
		
		HomePage hp= new HomePage(driver);
		String likeCount = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[6]/android.view.ViewGroup[1]/android.widget.TextView")).getText();
		System.out.println(likeCount);
		Thread.sleep(3000);
	
		WebDriverWait w = new WebDriverWait(driver,60);
        w.until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[6]/android.view.ViewGroup[1]/android.view.ViewGroup")));
        hp.likePost().click();
		Thread.sleep(5000);
		String newLikeCount = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[6]/android.view.ViewGroup[1]/android.widget.TextView")).getText();
		System.out.println(newLikeCount);
		Thread.sleep(2000);
		Assert.assertNotEquals(likeCount, newLikeCount);
		System.out.println("Like Post Test Case Completed");
	}


}
