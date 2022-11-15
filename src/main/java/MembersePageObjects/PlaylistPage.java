package MembersePageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PlaylistPage {
	
	public PlaylistPage(AppiumDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='CREATE']")
	private WebElement createPlayList;
	
	public WebElement createPlayList() {
		return createPlayList;
	}
	
	@AndroidFindBy(xpath="//android.widget.EditText[@index='2']")
	private WebElement PlayListTitleTextbox;
	
	public WebElement PlayListTitleTextbox() {
		return PlayListTitleTextbox;
	}
	
	@AndroidFindBy(xpath="//android.widget.EditText[@index='4']")
	private WebElement DescriptionTextbox;
	
	public WebElement DescriptionTextbox() {
		return DescriptionTextbox;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Add thumbnail']")
	private WebElement UploadImageButton;
	
	public WebElement UploadImageButton() {
		return UploadImageButton;
	}

}
