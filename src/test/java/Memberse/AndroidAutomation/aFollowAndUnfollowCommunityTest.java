package Memberse.AndroidAutomation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import MembersePageObjects.AppMenus;
import MembersePageObjects.CreatorCommunityPage;
import MembersePageObjects.ExplorePage;
import MembersePageObjects.RegisterPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class aFollowAndUnfollowCommunityTest extends Base {
	
	public String email;
	public String password;
	
	@Test(priority=1)
	public void aFollowCommunityTestCase()throws InterruptedException{
		Utilities u = new Utilities(driver);
		u.DirectToRegisterPage();
		
	    String autoText=getSaltString();
	    System.out.println(autoText);
	    String emailDomain = "@yopmail.com";
	    email = autoText+emailDomain;
	    System.out.println(email);
	    password = "123456";
	    System.out.println(password);
	    Thread.sleep(1000);
	     
	    RegisterPage rp = new RegisterPage(driver);
		rp.SignupEmail().sendKeys(email);
		rp.password().sendKeys(password);
		rp.confirmPassword().sendKeys(password);
		Thread.sleep(1000);
		driver.findElementByXPath("//android.view.ViewGroup[6]").click();
		Thread.sleep(1000);
		rp.signupContinue().click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='As a Creator']").click();
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
        cp.followCreator().click(); 
    	Thread.sleep(3000);
        System.out.println("Creator Followed successfully");
        Thread.sleep(5000);
        
        cp.followCreator().click(); 
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]").click();
        System.out.println("Creator UnFollowed successfully");
	 }
	
        public String getSaltString() {
        	String SALTCHARS="Abcdefhijklmn0987654";
        	StringBuilder salt= new StringBuilder();
        	Random rnd =new Random();
        	while(salt.length() < 10) {//length of the random string.
        		int index = (int) (rnd.nextFloat() * SALTCHARS.length());
        		salt.append(SALTCHARS.charAt(index));
        	}
        	String saltStr= salt.toString();
        	return saltStr;
        } 

}
