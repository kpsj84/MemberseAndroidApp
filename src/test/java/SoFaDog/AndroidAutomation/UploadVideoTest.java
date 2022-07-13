package SoFaDog.AndroidAutomation;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import PageObjects.CreatorMyPostsPage;
import PageObjects.LoginOptionPage;
import PageObjects.LoginPage;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class UploadVideoTest extends Base {
	
	@Test
	public void UploadVideoTestCase() throws InterruptedException, IOException {
		WidgetSwipeTest wst = new WidgetSwipeTest();
		wst.WidgetSwipeTestCase();
				
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.signinWithEmail().click();		

		//Change these Credentials according to the User to be Login 
		String userNumber = "39";
		String userName = "AutoUser"+userNumber;
		String emailId = "autouser"+userNumber;
		String emailDomain = "@yopmail.com";
		String email = emailId+emailDomain;
		String password = emailId;
		
		driver.findElementByXPath("//android.widget.EditText[@text='john.doe@email.com']").sendKeys(email);
		driver.findElementByXPath("(//android.widget.EditText)[2]").sendKeys(password);
		
		LoginPage lp = new LoginPage(driver);
		lp.loginButton().click();
		Thread.sleep(15000);
		
		//Verify User Name display on screen
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String uName = driver.findElementByXPath("//android.widget.TextView").getText();
		System.out.println(uName);
		System.out.println(userName);
		
		//Upload Process
		driver.findElementByXPath("//*[@content-desc=', tab, 3 out of 5']").click();
		CreatorMyPostsPage cmpp = new CreatorMyPostsPage(driver);
		cmpp.MyPostsSubMenu().click();
		Thread.sleep(3000);
		cmpp.Upload().click();
		cmpp.SelectFileToUpload().click();
		
		//Push a file
		driver.pushFile("/sdcard/Download/SampleVideo_100MB.mp4", new File(System.getProperty("user.dir")+"/src/uploadfiles/SampleVideo_100MB.mp4"));
		Thread.sleep(5000);

		//Pull file
		//byte[] fileBase64 = (driver.pullFile("/sdcard/Download/SampleVideo_2MB.mp4"));
		
		cmpp.UploadVideo().click();
		driver.findElementByXPath("//*[@text='Download']").click();
		Thread.sleep(5000);
		//Very first video selected
		driver.findElementByXPath("//android.view.ViewGroup[2]").click();
		Thread.sleep(500000000);
		driver.findElementByXPath("//android.widget.EditText").sendKeys("Automation Test Video");
		driver.findElementByXPath("(//android.widget.EditText)[2]").sendKeys("Automation Test Description");
		
		Utilities u = new Utilities(driver);
		u.swipeScreen(Utilities.Direction.UP);
		Thread.sleep(1000);
		
		cmpp.PublicToggleSwitch().click();
		Thread.sleep(1000);
		cmpp.PostUploadSaveButton().click();
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
		cmpp.UploadConfirmation().click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));	
		Thread.sleep(2000);
	}

}
