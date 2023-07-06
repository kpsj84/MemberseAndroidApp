package MembersePageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DMPage {
	
	public DMPage(AppiumDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='DMs on Web']")
	private WebElement DMonWebText;
	
	public WebElement DMonWebText() {
		return DMonWebText;
	}
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
	private WebElement DMonWebButton;
	
	public WebElement DMonWebButton() {
		return DMonWebButton;
	}
	
	@AndroidFindBy(xpath="(//android.view.View[@content-desc=\"Login\"])[1]/android.widget.TextView")
	private WebElement mBrowserLogin;
	
	public WebElement mBrowserLogin() {
		return mBrowserLogin;
	}
	
	@AndroidFindBy(xpath="(//android.view.View[@text='Email address'])")
	private WebElement mBrowserEmail;
	
	public WebElement mBrowserEmail() {
		return mBrowserEmail;
	}


}
