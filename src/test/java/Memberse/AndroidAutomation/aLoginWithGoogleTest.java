package Memberse.AndroidAutomation;

import org.testng.annotations.Test;

import MembersePageObjects.LoginOptionPage;
import MembersePageObjects.TutorialScreenPage;
import SoFaDog.AndroidAutomation.Base;

public class aLoginWithGoogleTest extends Base {
	
	@Test
	public void aLoginWithGoogleTestCase() throws InterruptedException {
		
		driver.findElementByXPath("//*[@text='CONTINUE']").click();
		System.out.println("Wait for application to load");
		Thread.sleep(5000);
		
		TutorialScreenPage wsp = new TutorialScreenPage(driver);
		wsp.SkipButton().click();
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.SigninwithGoogle().click();
		
		driver.findElementByXPath("//android.widget.Button[@text='Next']").click();
		driver.findElementByXPath("//android.widget.EditText").sendKeys("qatesting9999@gmail.com");
		driver.findElementByXPath("//android.widget.Button[@text='Next']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//android.widget.Button[@text='Next']").click();
		driver.findElementByXPath("//android.widget.EditText").sendKeys("Softqa@1313");
		driver.findElementByXPath("//android.widget.Button[@text='Next']").click();
		
		System.out.println("As if this message print in server logs that means Login with Google Button is clickable and Webview UI is Responsive");
	}

}
