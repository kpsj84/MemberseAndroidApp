package MembersePageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RoleSelectionPage {
	
	public RoleSelectionPage(AndroidDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='As a Creator']")
	private WebElement asACreator ;
	
	public WebElement asACreator(){    
		return asACreator;
	}

	@AndroidFindBy(xpath="abc")
	private WebElement asAMember;
	
	public WebElement asAMember(){    
		return asAMember;
	}
}
