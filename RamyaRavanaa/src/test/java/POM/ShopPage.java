package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BasicUtilities.JustWait;
import BasicUtilities.ScreenShotss;
import BasicUtilities.logger;

public class ShopPage {
	
	WebDriver dr;
	JustWait wt; logger log; ScreenShotss ss ;MyAccountPage Ap; 
	
	public ShopPage(WebDriver dr)
	{
		this.dr = dr;
		wt = new JustWait(dr);
		log = new logger(dr);
		ss = new ScreenShotss(dr);
	}
	//to add the item to cart
	public void AddtoCart(int i)
	{
		wt.Sleep(2000);
		By by_ele = By.xpath("//div[@id='content']//ul//li["+i+"]//a[2]");
		WebElement we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		we.click();
		log.Update_log("Item added to cart");
	}
	//to get the name of item which we added
	public String ItemName(int i)
	{
		By by_ele = By.xpath("//div[@id='content']//ul//li["+i+"]//h3");
		WebElement we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		return we.getText();
	}
	//to get the price of the item which is added
	public float Price(int i)
	{
		By by_ele = By.xpath("//div[@id='content']//ul//li["+i+"]//span[@class='price']");
		WebElement we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		String s=we.getText();
		String s1 = s.substring(1);
		float price = Float.parseFloat(s1);
		return price;
	}
	//to click the view basket icon
	public void ViewBasket(int i)
	{
		By by_ele = By.xpath("//div[@id='content']//ul//li["+i+"]//a[3]");
		WebElement we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		we.click();
	}
}
