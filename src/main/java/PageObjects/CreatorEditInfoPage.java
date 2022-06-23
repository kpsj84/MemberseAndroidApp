package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CreatorEditInfoPage {
	
	public CreatorEditInfoPage(AppiumDriver<AndroidElement>driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//*[@text='SAVE']")
	private WebElement EditInfoSaveButton;
	
	public WebElement EditInfoSaveButton() {
		return EditInfoSaveButton;
	}
	
	@AndroidFindBy(xpath="//*[@text='Pricing']")
	private WebElement PricingTab;
	
	public WebElement PricingTab() {
		return PricingTab;
	}
	
	@AndroidFindBy(xpath="//android.widget.EditText")
	private WebElement PriceInput;
	
	public WebElement PriceInput() {
		return PriceInput;
	}
	
	@AndroidFindBy(xpath="//*[@text='Set']")
	private WebElement PriceSet;
	
	public WebElement PriceSet() {
		return PriceSet;
	}

}
