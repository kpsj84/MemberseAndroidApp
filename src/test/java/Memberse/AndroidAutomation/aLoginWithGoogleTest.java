package Memberse.AndroidAutomation;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import MembersePageObjects.LoginOptionPage;
import MembersePageObjects.WidgetScreenPage;
import SoFaDog.AndroidAutomation.Base;

public class aLoginWithGoogleTest extends Base {
	
	@Test
	public void aLoginWithGoogleTestCase() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementByXPath("//*[@text='CONTINUE']").click();
		System.out.println("Wait for application to load");
		Thread.sleep(10000);
		
		WidgetScreenPage wsp = new WidgetScreenPage(driver);
		wsp.SkipButton().click();
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.SigninwithGoogle().click();
		
		Thread.sleep(3000);
		System.out.println("As if this message print in server logs that means Login with Google Button is clickable and further testing is not possible as Real Google Id is not able to configure on cloud Service");
	}

}
