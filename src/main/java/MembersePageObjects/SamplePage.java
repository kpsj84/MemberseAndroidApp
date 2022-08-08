package MembersePageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SamplePage {
	
	//Method for Page Factory should have same name as of class. "this" bind all the variable of this class to its class name which access in other class by making object of this class. 
	public SamplePage(AndroidDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField") 
	private WebElement nameField;
	
	@AndroidFindBy(xpath="//*[@text='Female']") 
	public WebElement femaleOption;
	
	@AndroidFindBy(id="android:id/text1") 
	public WebElement countrySelection;
	
	//for best practice, make the variable private and access the same in other class with public method
	public WebElement getNameField(){    
		return nameField;
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice") 
	public List<WebElement> productsList;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl") 
	public WebElement totalAmount;

}
