package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	
	public HomePage(AppiumDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//*[@content-desc=', tab, 1 out of 4']") 
	private WebElement homeButton;
	
	public WebElement homeButton(){    
		return homeButton;
	}
		
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Sign Up']") 
	private WebElement signup;
		
	public WebElement signup(){    
		return signup;	
	}

}
