package Memberse.AndroidAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import MembersePageObjects.AppMenus;
import MembersePageObjects.LoginOptionPage;
import MembersePageObjects.ProfileMenuPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;
import io.appium.java_client.android.AndroidElement;

public class aMembershipsTest extends Base {
	
	@Test
	public void aMembershipsTestCase() throws InterruptedException {
		Utilities u = new Utilities(driver);
		u.DirectToLoginOptionPage();
		
		String userNumber = "c3";
		String emailId = "kqatest"+userNumber;
		String emailDomain = "@yopmail.com";
		String email = emailId+emailDomain;
		String password = emailId;
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.signinWithEmail().sendKeys(email);
		lop.EmailPassword().sendKeys(password);
		lop.RevealPassword().click();
		lop.LoginButton().click();
		Thread.sleep(15000);
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//android.widget.TextView[@text='Close']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AppMenus am = new AppMenus(driver);
		am.ProfileMenu().click();
		
		ProfileMenuPage pmp = new ProfileMenuPage(driver);
		pmp.MembershipsSubMenu().click();
		Thread.sleep(3000);
		
		String verifyText1 = null;
		try
		{
			verifyText1 = driver.findElement(By.xpath("//android.widget.TextView[@text='You have no Memberships yet']")).getText();
			System.out.println(verifyText1);
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			List<AndroidElement> verifyActive = driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup"));
			int msglog = verifyActive.size()-1;
			System.out.println(msglog);
			if(msglog < 1)
			{
				System.out.println("Memberships List is Empty");
			}
			else
			{
				System.out.println("Memberships List Count is : " + msglog);
			}
		}
		
		if(verifyText1 == "You have no Memberships yet")
		{
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@text='Find Communities']")).click();
			Thread.sleep(1000);
			String text2 = driver.findElement(By.xpath("//*[@text='Find your Content Creator']")).getText();
			System.out.println(text2);
			Assert.assertEquals(text2, "Find your Content Creator");
			driver.navigate().back();
			Thread.sleep(1000);
		}
		
		try
		{
			System.out.println("Checking for Cancelled Memberships Data");
			
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			List<AndroidElement> verifyCancelled = driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup[2]/android.view.ViewGroup"));
			int msglog = verifyCancelled.size()-1;
			if(msglog < 1)
			{
				System.out.println("Second Section for Memberships have no data");
			}
			else
			{
				System.out.println("Cancelled Memberships List Count is : " + msglog);
			}
		}
	}

}
