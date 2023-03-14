package Memberse.AndroidAutomation;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;

import MembersePageObjects.AppMenus;
import MembersePageObjects.LoginOptionPage;
import MembersePageObjects.PlaylistPage;
import MembersePageObjects.ProfileMenuPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;
import SoFaDog.AndroidAutomation.Utilities.Direction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class aAddMediaAndPlayPlaylistTest extends Base {
	
	@Test
	public void aAddMediaAndPlayPlaylistTestCase() throws InterruptedException, IOException {
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
		Thread.sleep(8000);
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@text='Close']").click();
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AppMenus am = new AppMenus(driver);
		am.ProfileMenu().click();
		
		ProfileMenuPage pmp = new ProfileMenuPage(driver);
		pmp.playlistSubMenu().click();
		Thread.sleep(2000);
		
		PlaylistPage plp = new PlaylistPage(driver);
        plp.createPlayList().click();
        Thread.sleep(2000);
        String autotext = getSaltString();
		System.out.println(autotext);
		String title = "Autolist - " + autotext;
        plp.PlayListTitleTextbox().sendKeys(title);
        plp.DescriptionTextbox().sendKeys("This is an Automated QA Description :- " + autotext);
        plp.UploadImageButton().click();
        Thread.sleep(5000);
        
        driver.findElementByXPath("//android.widget.TextView[@text='Pick from Library']").click(); 
        driver.pushFile("/sdcard/Download/Pic22.jpg", new File(System.getProperty("user.dir") + "/src/Pic22.jpg"));
        Thread.sleep(2000);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        Thread.sleep(1000);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        Thread.sleep(3000);
        driver.findElementByXPath("//android.view.ViewGroup[@index='1']").click(); 
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.TextView[@text='Save']").click();
        Thread.sleep(5000);
        driver.findElementByXPath("//android.widget.Button[@text='OK']").click();
        Thread.sleep(5000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(1000);
        
        pmp.postsHistorySubMenu().click();
		Thread.sleep(4000);
		
		//Thread.sleep(999999999);
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.ImageView").click();
		Thread.sleep(4000);
		Dimension dims = driver.manage().window().getSize();
		@SuppressWarnings("rawtypes")
		TouchAction ta = new TouchAction(driver);
		ta.press(PointOption.point(dims.width/2,(int) (dims.height*0.70))).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).moveTo(PointOption.point(dims.width/2,(int) (dims.height*0.30))).release().perform();
		u.swipeScreen(Direction.UP);
		u.swipeScreen(Direction.UP);
		Thread.sleep(3000);
		List<AndroidElement> playlistTotalNos = driver.findElementsByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup");
		int playlistNumber = playlistTotalNos.size()-7;
		System.out.println(playlistNumber);
		driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup["+playlistNumber+"]/android.widget.Switch").click();
		Thread.sleep(4000);
		
		@SuppressWarnings("rawtypes")
		TouchAction ta1 = new TouchAction(driver);
		ta1.press(PointOption.point(dims.width/2,(int) (dims.height*.15))).release().perform();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		pmp.playlistSubMenu().click();
		Thread.sleep(3000);
		u.swipeScreen(Direction.UP);
		u.swipeScreen(Direction.UP);
		u.ScrollToText(title);
		driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup").click();
		Thread.sleep(5000);
		String channelName = driver.findElementByXPath("//android.widget.TextView[@index='1']").getText();
		Assert.assertEquals(channelName, "kqatestc3's Community");
		
	}
	
	public String getSaltString() {
		String SALTCHARS="369852147";
		StringBuilder salt= new StringBuilder();
		   Random rnd =new Random();
		   while(salt.length() < 4) {//length of the random string.
			   int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			   salt.append(SALTCHARS.charAt(index));
		   }
		   String saltStr= salt.toString();
		    return saltStr;  
	} 

}
