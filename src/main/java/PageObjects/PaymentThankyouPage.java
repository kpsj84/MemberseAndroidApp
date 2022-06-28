package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PaymentThankyouPage {
	
	public PaymentThankyouPage(AppiumDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Subscribe for Free Button
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Back to channel']")
	private WebElement BackToChannel;
	
	public WebElement BackToChannel(){    
		return BackToChannel;
	}

}
