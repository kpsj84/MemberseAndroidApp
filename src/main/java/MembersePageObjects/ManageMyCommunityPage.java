package MembersePageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ManageMyCommunityPage {
	
	public ManageMyCommunityPage (AppiumDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.EditText[@index='1']")
	private WebElement CommunityName;
	
	public WebElement CommunityName() {
		return CommunityName;
	}
	
	@AndroidFindBy(xpath="//android.widget.EditText[2]")
	private WebElement CommunityDescription;
	
	public WebElement CommunityDescription() {
		return CommunityDescription;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Save']")
	private WebElement CommunitySaveButton;
	
	public WebElement CommunitySaveButton() {
		return CommunitySaveButton;
	}

}
	