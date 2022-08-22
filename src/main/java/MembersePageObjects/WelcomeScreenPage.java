package MembersePageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WelcomeScreenPage {
	
	//Method for Page Factory should have same name as of class. "this" bind all the variable of this class to its class name which access in other class by making object of this class. 
	public WelcomeScreenPage(AndroidDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.ImageView")
	private WebElement WelcomeImage ;
	
	//for best practice, make the variable private and access the same in other class with public method
	public WebElement WelcomeImage(){    
		return WelcomeImage;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Welcome to Memberse']")
	private WebElement WelcomeText ;
	
	//for best practice, make the variable private and access the same in other class with public method
	public WebElement WelcomeText(){    
		return WelcomeText;
	}
	
	@AndroidFindBy(xpath="(//android.widget.TextView)[2]")
	private WebElement WelcomeDescription ;
	
	//for best practice, make the variable private and access the same in other class with public method
	public WebElement WelcomeDescription(){    
		return WelcomeDescription;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Log in']")
	private WebElement LoginButton ;
	
	//for best practice, make the variable private and access the same in other class with public method
	public WebElement LoginButton(){    
		return LoginButton;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Sign up']")
	private WebElement SignupButton ;
	
	//for best practice, make the variable private and access the same in other class with public method
	public WebElement SignupButton(){    
		return SignupButton;
	}
}
