package MembersePageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProfileMenuPage {
	
	public ProfileMenuPage(AppiumDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Member Info']")
	private WebElement MemberInfo;
	
	public WebElement MemberInfo() {
		return MemberInfo;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Log out']")
	private WebElement Logout;
	
	public WebElement Logout() {
		return Logout;
	}

}
