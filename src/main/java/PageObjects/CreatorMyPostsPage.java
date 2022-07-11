package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CreatorMyPostsPage {
	
	public CreatorMyPostsPage(AppiumDriver<AndroidElement>driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='My Posts']")
	private WebElement MyPostsSubMenu;
	
	public WebElement MyPostsSubMenu() {
		return MyPostsSubMenu;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='UPLOAD']")
	private WebElement Upload;
	
	public WebElement Upload() {
		return Upload;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='SAVE']")
	private WebElement PostUploadSaveButton;
	
	public WebElement PostUploadSaveButton() {
		return PostUploadSaveButton;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Select a file to upload']")
	private WebElement SelectFileToUpload;
	
	public WebElement SelectFileToUpload() {
		return SelectFileToUpload;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Upload Audio']")
	private WebElement UploadAudio;
	
	public WebElement UploadAudio() {
		return UploadAudio;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Upload Video']")
	private WebElement UploadVideo;
	
	public WebElement UploadVideo() {
		return UploadVideo;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Camera']")
	private WebElement CameraFolder;
	
	public WebElement CameraFolder() {
		return CameraFolder;
	}
	
	@AndroidFindBy(xpath="//android.widget.Switch")
	private WebElement PublicToggleSwitch;
	
	public WebElement PublicToggleSwitch() {
		return PublicToggleSwitch;
	}
	
	@AndroidFindBy(xpath="//*[@resource-id='android:id/button1']")
	private WebElement UploadConfirmation;
	
	public WebElement UploadConfirmation() {
		return UploadConfirmation;
	}

}
