package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchPage {
	
	public SearchPage(AppiumDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
		//Channels Tab
		@AndroidFindBy(xpath="//android.widget.TextView[@text='Channels']") 
		private WebElement Channels;
			
		public WebElement Channels(){    
		return Channels;
		}
	
		//Search Field
		@AndroidFindBy(xpath="//android.widget.EditText[@text='Search...']") 
		private WebElement SearchField;
				
		public WebElement SearchField(){    
			return SearchField;
		}

}
