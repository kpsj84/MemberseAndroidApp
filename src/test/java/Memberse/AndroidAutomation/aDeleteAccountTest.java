package Memberse.AndroidAutomation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import MembersePageObjects.AppMenus;
import MembersePageObjects.LoginOptionPage;
import MembersePageObjects.ProfileMenuPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;
import SoFaDog.AndroidAutomation.Utilities.Direction;

public class aDeleteAccountTest extends Base {
	
	@Test
	public void aDeleteAccountTestCase() throws InterruptedException {
		Utilities u = new Utilities(driver);
		u.DirectToLoginOptionPage();
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.Register().click();
		
		String autoString = getSaltString();
		String emailDomain = "@yopmail.com";
		String email = autoString+emailDomain;
		String password = "12345";
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.EditText[@text='Email']").sendKeys(email);
		driver.findElementByXPath("//android.widget.EditText[@text='Password']").sendKeys(password);
		driver.findElementByXPath("//android.widget.EditText[@text='Confirm Password']").sendKeys(password);
		driver.findElementByXPath("//android.widget.TextView[@text='Continue']").click();
		driver.manage().timeouts().implicitlyWait(23, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//android.widget.TextView[@text='As a Creator']").click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Close']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AppMenus am = new AppMenus(driver);
		am.ProfileMenu().click();
		Thread.sleep(3000);
		
		u.swipeScreen(Direction.UP);
		ProfileMenuPage pp = new ProfileMenuPage(driver);
		pp.DeleteAccount().click();
		driver.findElementByXPath("(//*[@text='Delete Account'])[2]").click();
		driver.findElementByXPath("//android.widget.Button[@text='YES']").click();
		Thread.sleep(3000);
		System.out.println(email + " Account Deleted Successfully");	
	}
	
	public String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

}
