package MembersePageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppMenus {
	
	public AppMenus(AppiumDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//*[@content-desc=', tab, 1 out of 4']")
	private WebElement HomeMenu;
	
	public WebElement HomeMenu() {
		return HomeMenu;
	}
	
	@AndroidFindBy(xpath="//*[@content-desc=', tab, 2 out of 4']")
	private WebElement ExploreMenu;
	
	public WebElement ExploreMenu() {
		return ExploreMenu;
	}
	
	@AndroidFindBy(xpath="//*[@content-desc=', tab, 3 out of 4']")
	private WebElement MessagesMenu;
	
	public WebElement MessagesMenu() {
		return MessagesMenu;
	}
	
	@AndroidFindBy(xpath="//*[@content-desc=', tab, 4 out of 4']")
	private WebElement ProfileMenu;
	
	public WebElement ProfileMenu() {
		return ProfileMenu;
	}

}
