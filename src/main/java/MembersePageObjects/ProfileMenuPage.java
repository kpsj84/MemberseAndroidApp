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
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Memberships']")
	private WebElement MembershipsSubMenu;
	
	public WebElement MembershipsSubMenu() {
		return MembershipsSubMenu;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Watch History']")
	private WebElement WatchedHistorySubMenu;
	
	public WebElement WatchedHistorySubMenu() {
		return WatchedHistorySubMenu;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Language']")
	private WebElement LanguageMenu;
	
	public WebElement LanguageMenu() {
		return LanguageMenu;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Privacy Policy']")
	private WebElement PrivacyPolicy;
	
	public WebElement PrivacyPolicy() {
		return PrivacyPolicy;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Terms & Conditions']")
	private WebElement TermsAndConditions;
	
	public WebElement TermsAndConditions() {
		return TermsAndConditions;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Community Guidelines']")
	private WebElement CommunityGuidelines;
	
	public WebElement CommunityGuidelines() {
		return CommunityGuidelines;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Become a Creator']")
	private WebElement BecomeACreatorMenu;
	
	public WebElement BecomeACreatorMenu() {
		return BecomeACreatorMenu;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Log out']")
	private WebElement Logout;
	
	public WebElement Logout() {
		return Logout;
	}
	
	@AndroidFindBy(xpath="//*[@text='Delete Account']")
	private WebElement DeleteAccount;
	
	public WebElement DeleteAccount() {
		return DeleteAccount;
	}

}
