package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BasicUtilities.JustWait;
import BasicUtilities.ScreenShotss;
import BasicUtilities.logger;

public class DetailsPage {
	WebDriver dr;
	JustWait wt; logger log; ScreenShotss ss; 
	
	public DetailsPage(WebDriver dr)
	{
		this.dr = dr;
		wt = new JustWait(dr);
		log = new logger(dr);
		ss = new ScreenShotss(dr);
	}
	//to check the thankyou message
	public String ThankyouMsg()
	{
		By by_ele = By.xpath("//p[@class='woocommerce-thankyou-order-received']");
		WebElement we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		return we.getText();
	}
}
