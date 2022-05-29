package SoFaDog.AndroidAutomation;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import PageObjects.SamplePage;

import io.appium.java_client.TouchAction;

public class SampleTest extends Base {
	
	//Represents as one Test Case
	@SuppressWarnings("rawtypes")
	@Test
	public void FirstTest() throws IOException, InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Create object for Application Page
		SamplePage sp = new SamplePage(driver);
		sp.getNameField().sendKeys("Hello");
		driver.hideKeyboard();
		sp.femaleOption.click();
		sp.countrySelection.click();
		
		//Create Object of Utilities class for Scrolling
		Utilities u = new Utilities(driver);
		u.ScrollToText("Argentina");
		
		driver.findElementByXPath("//*[@text='Argentina']").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();		//as text changed to ADDED TO CART for first Item
		
		//This is Cart Button click
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		Thread.sleep(4000);
		
		int count = driver.findElementsById("com.androidsample.generalstore:id/productPrice").size();
		double sum = 0;
		SamplePage cp = new SamplePage(driver);
		for(int i=0; i<count; i++)
		{
			String amount = cp.productsList.get(i).getText();
			double amtvalue=getAmount(amount);
			sum = sum+amtvalue;
		}
		String ttlamt = cp.totalAmount.getText();
		double ttlamtvalue = getAmount(ttlamt);
		System.out.println(ttlamtvalue);
		Assert.assertEquals(sum, ttlamtvalue);
		
		WebElement checkbox = driver.findElementByClassName("android.widget.CheckBox");
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(checkbox))).perform();
		
		WebElement tc = driver.findElementByXPath("//*[@text='Please read our terms of conditions']");
		t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();
		driver.findElementById("android:id/button1").click();
		Thread.sleep(4000);
		driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
	}
	
	public static double getAmount(String value) {
		value = value.substring(1);
		double amtvalue = Double.parseDouble(value);
		return amtvalue;
	}

}
