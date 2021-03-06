package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import BasicUtilities.*;

public class Home {
	WebDriver dr;
	JustWait wt; logger log; ScreenShotss ss; 
	
	public Home(WebDriver dr)
	{
		this.dr = dr;
		wt = new JustWait(dr);
		log = new logger(dr);
		ss = new ScreenShotss(dr);
	}
	//function to click on myaccount
	public void ClickOnMyAccount()
	{
		By by_ele = By.xpath("//a[text()='My Account']");
		WebElement we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		we.click();
		log.Update_log("clicked on My Account");
	}
}
