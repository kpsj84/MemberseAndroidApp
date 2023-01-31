package MembersePageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RegisterPage {
	
	public RegisterPage(AndroidDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Sign up']")
	private WebElement SignupText ;
	
	public WebElement SignupText(){    
		return SignupText;
	}
	
	@AndroidFindBy(xpath="//*[@text='Email']")
	private WebElement SignupEmail ;
	
	public WebElement SignupEmail(){    
		return SignupEmail;
	}
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Password']")
	private WebElement password ;
	
	public WebElement password(){    
		return password;
	}
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@index='7']")
	private WebElement RevealPassword ;
	
	public WebElement RevealPassword(){    
		return RevealPassword;
	}
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Confirm Password']")
	private WebElement confirmPassword ;
	
	public WebElement confirmPassword(){    
		return confirmPassword;
	}
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@index='11']")
	private WebElement RevealConfirmPassword ;
	
	public WebElement RevealConfirmPassword(){    
		return RevealConfirmPassword;
	}
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[6]")
	private WebElement signupTerms ;
	
	public WebElement signupTerms(){    
		return signupTerms;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Continue']")
	private WebElement signupContinue ;
	
	public WebElement signupContinue(){    
		return signupContinue;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Already a member?']")
	private WebElement AlreadyMemberText ;
	
	public WebElement AlreadyMemberText(){    
		return AlreadyMemberText;
	}

}
