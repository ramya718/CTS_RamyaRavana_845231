package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BasicUtilities.JustWait;
import BasicUtilities.ScreenShotss;
import BasicUtilities.logger;

public class MyAccountPage {
	
	WebDriver dr;
	JustWait wt; logger log; ScreenShotss ss; 
	
	public MyAccountPage(WebDriver dr)
	{
		this.dr = dr;
		wt = new JustWait(dr);
		log = new logger(dr);
		ss = new ScreenShotss(dr);
	}
// to verify the login
	public String VerifyLogin()
	{
		By by_ele = By.xpath("//p[contains(text(),'Hello')]//Strong");
		WebElement we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		return we.getText();
	}
	// to click the shop icon
	public void ClickShopLink()
	{
		By by_ele = By.xpath("//li[@id='menu-item-40']//a");
		WebElement we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		we.click();
	}

}
