package Memberse.AndroidAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import MembersePageObjects.LoginOptionPage;
import MembersePageObjects.RegisterPage;
import MembersePageObjects.WelcomeScreenPage;
import SoFaDog.AndroidAutomation.Base;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class aSmokeTest extends Base {
    
  //Represents as one Test Case
	@Test
	public void aSmokeTestCase() throws InterruptedException {
		//Wait upto for next element to available and will execute immediately once element appear
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		try
		{
			//App update Continue Button
			driver.findElementByXPath("//*[@text='CONTINUE']").click();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		finally
		{
			System.out.println("Wait for application to load, This may take few seconds");
			Thread.sleep(20000);
		}
			
		//Verify UI of the Welcome Screen
		WelcomeScreenPage wsp = new WelcomeScreenPage(driver);
		String imageClass = wsp.WelcomeImage().getAttribute("class");
		System.out.println(imageClass);
		Assert.assertEquals(imageClass, "android.widget.ImageView");
			
		String welcomeText = wsp.WelcomeText().getText();
		Assert.assertEquals(welcomeText, "Welcome to Memberse");
			
		String welcomeDescrp = wsp.WelcomeDescription().getText();
		Assert.assertEquals(welcomeDescrp, "Whether you're a content creator or looking to become a Member of a Community, here you can share and consume great content in video, audio or text");
		
		//Login Button
		wsp.LoginButton().click();
		LoginOptionPage lop = new LoginOptionPage(driver);
		String loginText = lop.LoginText().getText();
		Assert.assertEquals(loginText, "Login");
		lop.signinWithEmail().sendKeys("Smoke Testing is in progress");
		Thread.sleep(1000);
		String termsText = lop.termsConditionsText().getText();
		Assert.assertEquals(termsText, "Agree to  Terms and Conditions");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
			
		//Signup Button
		wsp.SignupButton().click();
		RegisterPage rp = new RegisterPage(driver);
		Thread.sleep(1000);
		String signupText = rp.SignupText().getText();
		Assert.assertEquals(signupText, "Sign up");
		rp.SignupEmail().sendKeys("Smoke Testing is in progress");
		String alreadyMemberText = rp.AlreadyMemberText().getText();
		Assert.assertEquals(alreadyMemberText, "Already a member?");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
			
		Assert.assertEquals(welcomeText, "Welcome to Memberse");
		System.out.println("Application launches fine and GUI is responsive. Smoke Testing is QA Pass");
	}

}
