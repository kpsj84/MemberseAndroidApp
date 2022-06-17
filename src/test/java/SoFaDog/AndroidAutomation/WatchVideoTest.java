package SoFaDog.AndroidAutomation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

import PageObjects.ExplorePage;
import PageObjects.SearchPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;

public class WatchVideoTest extends Base {
	
	@SuppressWarnings("rawtypes")
	@Test
	public void WatchVideoTestCase() throws IOException, InterruptedException {
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
		sp.SearchField().sendKeys("kqacd2");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='kqacd2 Test Channel']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='VR Glasses']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Play']").click();
		Thread.sleep(15000);
		
		Dimension dim1 = driver.manage().window().getSize();
		TouchAction t = new TouchAction(driver);
		//t.tap(PointOption.point(1280,2000)).perform();
		t.tap(PointOption.point(dim1.width/2,dim1.height/2)).perform();
		Thread.sleep(2000);
		t.tap(PointOption.point(dim1.width/2,dim1.height/2)).perform();
		Thread.sleep(1000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(1000);
		//t.tap(PointOption.point(98,196)).perform();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(1000);
		//t.tap(PointOption.point(1307,231)).perform();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(1000);
		System.out.println("Video Test ends");
	}

}
