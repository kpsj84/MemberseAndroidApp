package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CreatorServicesPage {
		
		public CreatorServicesPage(AppiumDriver<AndroidElement>driver)
		{
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
		
		@AndroidFindBy(xpath="//*[@text='CREATE']")
		private WebElement CreateService;
		
		public WebElement CreateService() {
			return CreateService;
		}
		
		@AndroidFindBy(xpath="//android.widget.TextView[@text='SAVE']")
		private WebElement CreateServiceSaveButton;
		
		public WebElement CreateServiceSaveButton() {
			return CreateServiceSaveButton;
		}
	
		@AndroidFindBy(xpath="//android.widget.TextView[@text='Active Services']")
		private WebElement ActiveServicesTab;
		
		public WebElement ActiveServicesTab() {
			return ActiveServicesTab;
		}
}
