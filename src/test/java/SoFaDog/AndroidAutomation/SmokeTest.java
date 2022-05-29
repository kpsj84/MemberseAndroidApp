package SoFaDog.AndroidAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.ExplorePage;
import PageObjects.HomePage;
import PageObjects.LoginOptionPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SmokeTest extends Base {

	//Represents as one Test Case
	@Test
	public void SmokeTestCase() throws IOException, InterruptedException {
		
		//Wait for next element to available and will execute immediately once it appear
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Create object of Utilities class for Swipe Action
		Utilities u = new Utilities(driver);
		System.out.println("Wait for application to load");
		Thread.sleep(20000);
		u.swipeScreen(Utilities.Direction.LEFT);
		System.out.println("1st Widget Swipe Executed");
		Thread.sleep(3500);
		u.swipeScreen(Utilities.Direction.LEFT);
		System.out.println("2nd Widget Swipe Executed");
		Thread.sleep(3500);
		u.swipeScreen(Utilities.Direction.LEFT);
		System.out.println("3rd Widget Swipe Executed");
		Thread.sleep(3500);
		u.swipeScreen(Utilities.Direction.LEFT);
		System.out.println("Last Swipe Executed");
		Thread.sleep(1000);
		
		//Click on Maybe later Button by calling Web Element thru LoginOptionPage Object
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.maybeLater().click();
		
		//Verify Text from Explore Page
		System.out.println("Waiting for UI to load");
		Thread.sleep(13000);
		ExplorePage ep = new ExplorePage(driver);
		String suggestedChannels = ep.SuggestedChannels().getText();
		Assert.assertEquals(suggestedChannels, "Suggested Channels");
		System.out.println("Checked, Mobile Elements are available on Screen");		
		u.swipeScreen(Utilities.Direction.UP);
		Thread.sleep(3000);
		
		//Click on Home Button
		HomePage hp = new HomePage(driver);
		hp.homeButton().click();
		Thread.sleep(2000);
		
		//Click on Sign up Button
		hp.signup().click();
		Thread.sleep(2000);
		System.out.println("I am in SoFaDog App at Sign-In Options Page. This Build is Responsive");
	}
	
}
