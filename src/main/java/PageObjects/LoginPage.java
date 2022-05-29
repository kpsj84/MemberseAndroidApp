package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	
	public LoginPage(AppiumDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); 
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Create Account']") 
	private WebElement createAccount;
		
	public WebElement createAccount(){    
		return createAccount;
	}
	
	@AndroidFindBy(xpath="(//android.widget.TextView)[5]") 
	private WebElement loginButton;
		
	public WebElement loginButton(){    
		return loginButton;
	}

}
