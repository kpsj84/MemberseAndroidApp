package MembersePageObjects;

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
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Login']") 
	private WebElement LoginText;
		
	public WebElement LoginText(){    
		return LoginText;
	}
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Email']") 
	private WebElement signinWithEmail;
		
	public WebElement signinWithEmail(){    
		return signinWithEmail;
	}
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Password']") 
	private WebElement EmailPassword;
		
	public WebElement EmailPassword(){    
		return EmailPassword;
	}
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@index='6']") 
	private WebElement RevealPassword;
		
	public WebElement RevealPassword(){    
		return RevealPassword;
	}
	
	@AndroidFindBy(xpath="(//*[@text='Login'])[2]") 
	private WebElement LoginButton;
		
	public WebElement LoginButton(){    
		return LoginButton;
	}
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@index='11']") 
	private WebElement SigninwithGoogle;
		
	public WebElement SigninwithGoogle(){    
		return SigninwithGoogle;
	}
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@index='12']") 
	private WebElement SigninwithFacebook;
		
	public WebElement SigninwithFacebook(){    
		return SigninwithFacebook;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Sign up']") 
	private WebElement Register;
		
	public WebElement Register(){    
		return Register;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='New to Memberse?']") 
	private WebElement NewMemberseText;
		
	public WebElement NewMemberseText(){    
		return NewMemberseText;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Agree to  Terms and Conditions']") 
	private WebElement termsConditionsText;
		
	public WebElement termsConditionsText(){    
		return termsConditionsText;
	}
}
