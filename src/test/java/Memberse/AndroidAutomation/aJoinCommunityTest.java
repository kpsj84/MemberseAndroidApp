package Memberse.AndroidAutomation;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import MembersePageObjects.AppMenus;
import MembersePageObjects.CreatorCommunityPage;
import MembersePageObjects.ExplorePage;
import MembersePageObjects.ThankyouPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class aJoinCommunityTest extends Base {
	
	@Test
	public void aJoinCommunityTestCase() throws InterruptedException {
		Utilities u = new Utilities(driver);
		u.DirectToRegisterPage();
		
		String autoText = getRandomString();
	    System.out.println(autoText);
	    String emailDomain = "@yopmail.com";
	    String email = autoText + emailDomain;
	    System.out.println(email);
	    String password="123456";
	    System.out.println(password);
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	    driver.findElementByXPath("//android.widget.EditText[@text='Email']").sendKeys(email);
		driver.findElementByXPath("//android.widget.EditText[@text='Password']").sendKeys(password);
		driver.findElementByXPath("//android.widget.EditText[@text='Confirm Password']").sendKeys(password);
		driver.findElementByXPath("//android.view.ViewGroup[6]").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Continue']").click();
		
		driver.findElementByXPath("//android.widget.TextView[@text='As a Creator']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Close']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AppMenus am = new AppMenus(driver);
		driver.pressKey(new KeyEvent(AndroidKey.BACK)); 
		am.ExploreMenu().click();
		Thread.sleep(2000);
		
	    ExplorePage ep = new ExplorePage(driver);
        ep.SearchField().sendKeys("kqatestc3");
        Thread.sleep(10000);
        ep.clickCreator().click();
        Thread.sleep(5000);
        
        CreatorCommunityPage cp = new CreatorCommunityPage(driver);
        cp.joinCommunity().click();
        Thread.sleep(5000);
	    
	  //Stripe Form
	  		System.out.println("wait for context");
	  		
	  		Set<String> contexts = driver.getContextHandles();
	  		for(String contextName : contexts)
	          {
	                  System.out.println(contextName);
	          }   
	  		System.out.println("Printed context Name");
	  		
	  		//driver.context("WEBVIEW_dog.fa.so.app"); //this let the code know which view it has to consider by taking the detail from package attribute, add WEBVIEW_ before the package name
	  		Thread.sleep(3000);
	  		System.out.println(driver.getContext());
	  		
	  		driver.findElementByXPath("//android.widget.EditText").sendKeys(email);
	  		driver.findElementByXPath("(//android.widget.EditText)[2]").sendKeys("4242424242424242");
	  		driver.findElementByXPath("(//android.widget.EditText)[3]").sendKeys("1226");
	  		driver.findElementByXPath("(//android.widget.EditText)[4]").sendKeys("123");
	  		driver.findElementByXPath("(//android.widget.EditText)[5]").sendKeys(autoText);
	  		u.swipeScreen(Utilities.Direction.UP);
	  		driver.findElementByXPath("(//android.view.View)[33]").click();
	  		Thread.sleep(1000);
	  		//Clicked on Zimbabwe who have no zip code
	  		driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_1));
	  		driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_2));
	  		driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_3));
	  		driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_4));
	  		driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_5)); 
	  		driver.hideKeyboard();
	  		driver.findElementByXPath("//android.widget.Button[@text='Subscribe']").click();
	  		Thread.sleep(15000);
	  		
	  		ThankyouPage tp= new ThankyouPage(driver);
		    String Text = driver.findElement(By.xpath("//*[@text='Thank you for your support']")).getText();
			System.out.println(Text);
			Assert.assertEquals(Text, "Thank you for your support");
			tp.back2Community().click();
		    Thread.sleep(3000);
	}
	
	public String getRandomString() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";   //Characters from string to build
        StringBuilder builder = new StringBuilder();
        Random rnd = new Random();
        while (builder.length() < 10) { 							  //decide length of the random string.
            int index = (int) (rnd.nextFloat() * characters.length());//nextFloat() returns random number from 0.0 to 1.0
            builder.append(characters.charAt(index));				  //Add up characters into builder at that index
        }
        String autoString = builder.toString();						  //String Builder object value converts to String. 
        return autoString;
	}

}
