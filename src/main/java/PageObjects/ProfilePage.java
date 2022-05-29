package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProfilePage {
	
	public ProfilePage(AppiumDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//*[@content-desc=', tab, 4 out of 4']") 
	private WebElement profileButton;
	
	public WebElement profileButton(){    
		return profileButton;
	}
	
	@AndroidFindBy(xpath="(//android.widget.TextView[@text='Logout']") 
	private WebElement Logout;
	
	public WebElement Logout(){    
		return Logout;
	}

}
