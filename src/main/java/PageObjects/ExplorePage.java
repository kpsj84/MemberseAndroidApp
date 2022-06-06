package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ExplorePage {
	
		public ExplorePage(AppiumDriver<AndroidElement> driver) 
		{
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
		
		@AndroidFindBy(xpath="//android.widget.TextView[@text='Suggested Channels']") 
		private WebElement SuggestedChannels;
		
		public WebElement SuggestedChannels(){    
			return SuggestedChannels;
		}
		
		@AndroidFindBy(xpath="(//android.view.ViewGroup[17]") 
		private WebElement PopularSection;
		
		public WebElement PopularSection(){    
			return PopularSection;
		}


}
