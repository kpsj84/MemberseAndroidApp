package SoFaDog.AndroidAutomation;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.LoginOptionPage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class UploadVideoTest extends Base {
	
	@Test
	public void UploadVideoTestCase() throws InterruptedException, IOException {
		WidgetSwipeTest wst = new WidgetSwipeTest();
		wst.WidgetSwipeTestCase();
				
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.signinWithEmail().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.createAccount().click();
		
		//Change the User Number every time while running this test to fill new detail in Register Form or Delete that user at the end of Test
		String userNumber = "403";
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
		
		RegisterPage rp = new RegisterPage(driver);
		rp.createAccountButton2().click();
		Thread.sleep(20000);
		
		driver.findElementByXPath("//*[@content-desc=', tab, 4 out of 4']").click();
		Thread.sleep(2000);
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
		System.out.println("Content Creater created Successfully and set the channel price");

		//Upload Process
		driver.findElementByXPath("//android.widget.TextView[@text='My Posts']").click();
		Thread.sleep(4000);
		driver.findElementByXPath("//android.widget.TextView[@text='UPLOAD']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.TextView[@text='Select a file to upload']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.TextView[@text='Upload Video']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@text='Camera']").click();
		Thread.sleep(4000);
		driver.findElementByXPath("//android.view.View").click();
		Thread.sleep(4000);		
/*		
		//Take Video Button
		driver.findElementByXPath("//android.widget.TextView[@text='Take Video']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.ImageView[@resource-id='com.android.camera2:id/shutter_button']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//android.widget.ImageView[@resource-id='com.android.camera2:id/shutter_button']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.ImageButton[@resource-id='com.android.camera2:id/done_button']").click();
		Thread.sleep(3000);
*/
		driver.findElementByXPath("//android.widget.TextView[@text='Select a thumbnail image(optional)']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@text='Pick from Library']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//android.widget.TextView[@text='Camera']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("(//android.view.ViewGroup)[2]").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//android.widget.EditText").sendKeys("Auto Test Audio");
		Thread.sleep(3000);
		driver.findElementByXPath("(//android.widget.EditText)[2]").sendKeys("Auto Test Description");
		Thread.sleep(3000);
		Utilities u = new Utilities(driver);
		u.swipeScreen(Utilities.Direction.UP);
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.Switch").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.TextView[@text='SAVE']").click();
		Thread.sleep(85000);
		driver.findElementByXPath("//*[@resource-id='android:id/button1']").click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));	
		Thread.sleep(5000);
	}

}
