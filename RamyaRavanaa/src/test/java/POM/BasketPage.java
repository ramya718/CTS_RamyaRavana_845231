package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BasicUtilities.JustWait;
import BasicUtilities.ScreenShotss;
import BasicUtilities.logger;

public class BasketPage {
	WebDriver dr;
	JustWait wt; logger log; ScreenShotss ss ;MyAccountPage Ap; 
	
	public BasketPage(WebDriver dr)
	{
		this.dr = dr;
		wt = new JustWait(dr);
		log = new logger(dr);
		ss = new ScreenShotss(dr);
	}
	//to get the name from the item which is added
	public String ItemName(int i)
	{
		By by_ele = By.xpath("//table[@class='shop_table shop_table_responsive cart']//tbody//tr["+i+"]//td[3]");
		WebElement we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		return we.getText();
	}
	//to get the price from the item which is added
	public float Price(int i)
	{
		By by_ele = By.xpath("//table[@class='shop_table shop_table_responsive cart']//tbody//tr["+i+"]//td[4]");
		WebElement we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		String s=we.getText();
		String s1 = s.substring(1);
		float price = Float.parseFloat(s1);
		return price;
	}
	//to checkout
	public void Checkout()
	{
		By by_ele = By.xpath("//a[@class='checkout-button button alt wc-forward']");
		WebElement we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		we.click();
		log.Update_log("clicked on Proceed to checkout");
	}

}
