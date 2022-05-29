package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginOptionPage {
	
	//This is PageFactory Code and name of this method should be same as of class
	public LoginOptionPage(AppiumDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); //this here means local
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Sign in with Email']") 
	private WebElement signinWithEmail;
		
	public WebElement signinWithEmail(){    
		return signinWithEmail;
	}
	
	//AndroidFindBy & similar is IOSFindBy used for xpath, id etc
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Maybe later']") 
	private WebElement maybeLater;		//Above xpath assigned to this private variable
	
	//Public method access the private variable with in same class and return variable value
	public WebElement maybeLater(){    
		return maybeLater;
	}

}
