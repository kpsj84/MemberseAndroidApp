package Memberse.AndroidAutomation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import MembersePageObjects.AppMenus;
import MembersePageObjects.LoginOptionPage;
import MembersePageObjects.PostsHistoryPage;
import MembersePageObjects.ProfileMenuPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;

public class aPostHistoryPostEditTest extends Base {
	
	@Test
	public void aPostHistoryPostEditTestCase() throws InterruptedException {
		Utilities u = new Utilities(driver);
		u.DirectToLoginOptionPage();
		
		String userNumber = "c3";
		String emailId = "kqatest"+userNumber;
		String emailDomain = "@yopmail.com";
		String email = emailId+emailDomain;
		String password = emailId;
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		Thread.sleep(15000);
		lop.signinWithEmail().sendKeys(email);
		lop.EmailPassword().sendKeys(password);
		lop.RevealPassword().click();
		lop.LoginButton().click();
		Thread.sleep(15000);
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@text='Close']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(2000);
		AppMenus am = new AppMenus(driver);
		am.ProfileMenu().click();
		
		ProfileMenuPage pmp = new ProfileMenuPage(driver);
		pmp.postsHistorySubMenu().click();
		Thread.sleep(5000);
		
		PostsHistoryPage php = new PostsHistoryPage(driver);
		Thread.sleep(5000);
		driver.findElementsByXPath("//android.view.ViewGroup[@index='0']").get(14).click();
		php.postDescription().clear();
		String autotext = getSaltString();
		php.postDescription().sendKeys("This is automated test description - " + autotext);
		php.editPostSave().click();
		Thread.sleep(5000);
		String verifyMsg1 = driver.findElementByXPath("//android.widget.TextView[@text='Edit Successful']").getText();
		Assert.assertEquals(verifyMsg1, "Edit Successful");
		driver.findElementByXPath("//android.widget.Button[@text='OK']").click();
		Thread.sleep(5000);
	}
	
	public String getSaltString() {
		  String SALTCHARS="1234567890";
		  StringBuilder salt= new StringBuilder();
		  Random rnd =new Random();
		  while(salt.length() < 5) {//length of the random string.
		  int index = (int) (rnd.nextFloat() * SALTCHARS.length());
		  salt.append(SALTCHARS.charAt(index));
		  }
		  	String saltStr= salt.toString();
		    return saltStr;
	 }

}
