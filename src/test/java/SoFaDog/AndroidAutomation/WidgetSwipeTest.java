package SoFaDog.AndroidAutomation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginOptionPage;

public class WidgetSwipeTest extends Base {
	
	//Represents as one Test Case
		@Test
		public void WidgetSwipeTestCase() throws IOException, InterruptedException {	
			//Wait upto for next element to available and will execute immediately once element appear
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//Create object of Utilities class for Swipe Action
			Utilities u = new Utilities(driver);
			System.out.println("Wait for application to load");
			Thread.sleep(20000);
			u.swipeScreen(Utilities.Direction.LEFT);
			System.out.println("1st Widget Swipe Executed");
			Thread.sleep(5000);
			u.swipeScreen(Utilities.Direction.LEFT);
			System.out.println("2nd Widget Swipe Executed");
			Thread.sleep(5000);
			u.swipeScreen(Utilities.Direction.LEFT);
			System.out.println("3rd Widget Swipe Executed");
			Thread.sleep(5000);
			u.swipeScreen(Utilities.Direction.LEFT);
			System.out.println("Last Swipe Executed");
			Thread.sleep(5000);
			
			LoginOptionPage lop = new LoginOptionPage(driver);
			String A = lop.maybeLater().getText();
			
			//Verify the Maybe later available on Login Option Page
			Assert.assertEquals(A, "Maybe later");
		}

}
