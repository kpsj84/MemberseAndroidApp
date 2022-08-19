package MembersePageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TutorialScreenPage {
	
	//Method for Page Factory should have same name as of class. "this" bind all the variable of this class to its class name which access in other class by making object of this class. 
	public TutorialScreenPage(AndroidDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Skip']")
	private WebElement SkipButton;
	
	//for best practice, make the variable private and access the same in other class with public method
	public WebElement SkipButton(){    
		return SkipButton;
	}
	
}
