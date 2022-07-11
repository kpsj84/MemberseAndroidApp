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
	
	//Subscribe for Free Button
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Subscribe for FREE                                  }']") 
	private WebElement SubscribeFreeButton;
	
	public WebElement SubscribeFreeButton(){    
		return SubscribeFreeButton;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Donate']") 
	private WebElement DonateButton;
	
	public WebElement DonateButton(){    
		return DonateButton;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='€2']") 
	private WebElement DonatePrice;
	
	public WebElement DonatePrice(){    
		return DonatePrice;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Donate €2']") 
	private WebElement FinalDonateButton;
	
	public WebElement FinalDonateButton(){    
		return FinalDonateButton;
	}

	//About Tab
		@AndroidFindBy(xpath="//*[@text='Services']") 
		private WebElement ServicesTab;
				
		public WebElement ServicesTab(){    
			return ServicesTab;
		}
	
	//About Tab
	@AndroidFindBy(xpath="//*[@text='About']") 
	private WebElement AboutTab;
			
	public WebElement AboutTab(){    
		return AboutTab;
	}

}
