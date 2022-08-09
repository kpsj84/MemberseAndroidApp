package Memberse.AndroidAutomation;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;

public class aWidgetSwipeTest extends Base {
    
  //Represents as one Test Case
	@Test
	public void aWidgetSwipeTestCase() throws InterruptedException {
			//Wait upto for next element to available and will execute immediately once element appear
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//App update Continue Button
			driver.findElementByXPath("//*[@text='CONTINUE']").click();
			System.out.println("Wait for application to load");
			Thread.sleep(8000);
			
			//Create object of Utilities class for Swipe Action
			Utilities u = new Utilities(driver);
			u.swipeScreen(Utilities.Direction.LEFT);
			System.out.println("1st Widget Swipe Executed");
			Thread.sleep(2000);
			u.swipeScreen(Utilities.Direction.LEFT);
			System.out.println("2nd Widget Swipe Executed");
			Thread.sleep(2000);
			
			//Next Button clicked on Widget Screen
			driver.findElementByXPath("(//android.view.ViewGroup)[23]").click();
			System.out.println("Last Swipe Executed");
			Thread.sleep(2000);
			
			System.out.println("Landing on Login Options Screen");
			String Text = driver.findElementByXPath("//android.widget.TextView[@text='Login']").getText();
			System.out.println(Text);
			
			//Verify the Text available on Login Option Page
			Assert.assertEquals(Text, "Login");
			System.out.println("Swipe Action and Click Action functionality on Widgets screen are working as Expected");
			System.out.println("This refers to Smoke Testing as well and its QA Pass");
		}

}
