package MembersePageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PostsHistoryPage {
	
	public PostsHistoryPage (AppiumDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]")
	private WebElement postContent;
	
	public WebElement postContent() {
		return postContent;
	}
	
	@AndroidFindBy(xpath="abc")
	private WebElement postEdit;
	
	public WebElement postEdit() {
		return postEdit;
	}
	
	@AndroidFindBy(xpath="//android.widget.EditText[@index='6']")
	private WebElement postDescription;
	
	public WebElement postDescription() {
		return postDescription;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Save']")
	private WebElement editPostSave;
	
	public WebElement editPostSave() {
		return editPostSave;
	}

}
