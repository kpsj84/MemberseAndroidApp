package SoFaDog.AndroidAutomation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AppMenus;
import PageObjects.ChannelPage;
import PageObjects.ExplorePage;
import PageObjects.PaymentThankyouPage;
import PageObjects.SearchPage;
import PageObjects.StripeFormPage;

public class DonationPaidTest extends Base {
	
	@Test
	public void DonationPaidTestCase() throws IOException, InterruptedException {
		WidgetSwipeTest wst = new WidgetSwipeTest();
		wst.WidgetSwipeTestCase();
		
		LoginUser lt = new LoginUser();
		lt.LoginUserCase();
		
		AppMenus am = new AppMenus(driver);
		am.ExploreMenu().click();
		
		ExplorePage ep = new ExplorePage(driver);
		ep.Searchtag1().click();
		
		SearchPage sp = new SearchPage(driver);
		sp.Channels().click();
		sp.SearchField().sendKeys("kqacd");
		Thread.sleep(4000);
		driver.findElementByXPath("//*[@text='kqacd Test Channel']").click();
		Thread.sleep(3000);
		
		ChannelPage cp = new ChannelPage(driver);
		cp.DonateButton().click();
		cp.DonatePrice().click();
		cp.FinalDonateButton().click();
		
		StripeFormPage sfp = new StripeFormPage(driver);
		Thread.sleep(7000);
		sfp.DonationPayButton().click();
		Thread.sleep(7000);
		
		PaymentThankyouPage ptp = new PaymentThankyouPage(driver);
		ptp.BackToChannel().click();
		Thread.sleep(2000);
		String UN = driver.findElementByXPath("//android.widget.TextView[@text='kqacd Test Channel']").getText();
		Assert.assertEquals(UN, "kqacd Test Channel");
	}

}
