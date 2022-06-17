package SoFaDog.AndroidAutomation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import PageObjects.ExplorePage;
import PageObjects.SearchPage;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ListenAudioTest extends Base {
	@Test
	public void ListenaudioTestCase() throws IOException, InterruptedException {
		LoginTest lt = new LoginTest();
		lt.LoginTestCase();
		
		//Menu Item - Explore Page
		driver.findElementByXPath("//*[@content-desc=', tab, 2 out of 5']").click();
		
		//Click in Search at some tag
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ExplorePage ep = new ExplorePage(driver);
		ep.Searchtag1().click();
				
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SearchPage sp = new SearchPage(driver);
		sp.Channels().click();
		sp.SearchField().sendKeys("MakFreeChannel");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='MakFreeChannel']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='test']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Play']").click();
		Thread.sleep(10000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(1000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(1000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(1000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		System.out.println("Audio Test Completed");
	}

}
