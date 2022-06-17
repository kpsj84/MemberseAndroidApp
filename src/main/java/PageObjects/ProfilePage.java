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
	
	@AndroidFindBy(xpath="//*[@content-desc=', tab, 5 out of 5']") 
	private WebElement profileButton;
	
	public WebElement profileButton(){    
		return profileButton;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Log out of your current session']") 
	private WebElement Logout;
	
	public WebElement Logout(){    
		return Logout;
	}
	
	@AndroidFindBy(xpath="//*[@text='Delete Account']") 
	private WebElement DeleteAccount;
	
	public WebElement DeleteAccount(){    
		return DeleteAccount;
	}

}
