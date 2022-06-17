package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ChannelPage {
	
	public ChannelPage(AppiumDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//About Tab
			@AndroidFindBy(xpath="//*[@text='About']") 
			private WebElement AboutTab;
			
			public WebElement AboutTab(){    
				return AboutTab;
			}

}
