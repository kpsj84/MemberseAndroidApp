package SoFaDog.AndroidAutomation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ListenAudioTest extends Base {
	@Test
	public void ListenaudioTestCase() throws IOException, InterruptedException {
		LoginTest lt = new LoginTest();
		lt.LoginTestCase();
		
		driver.findElementByXPath("//*[@content-desc=', tab, 2 out of 5']").click();
		//Click in Search at some tag
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//*[@text='tag1']").click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Channels']").click();
		driver.findElementByXPath("//android.widget.EditText[@text='Search...']").sendKeys("MakFreeChannel");
		Thread.sleep(5000);
		driver.findElementByXPath("//android.widget.TextView[@text='MakFreeChannel']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//android.widget.TextView[@text='test']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Play']").click();
		Thread.sleep(10000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		System.out.println("Audio Test Completed");
	}

}
