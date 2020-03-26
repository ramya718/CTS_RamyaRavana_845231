package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BasicUtilities.JustWait;
import BasicUtilities.ScreenShotss;
import BasicUtilities.logger;

public class CheckOutPage {
	WebDriver dr;
	JustWait wt; logger log; ScreenShotss ss ;MyAccountPage Ap; 
	
	public CheckOutPage(WebDriver dr)
	{
		this.dr = dr;
		wt = new JustWait(dr);
		log = new logger(dr);
		ss = new ScreenShotss(dr);
	}
	//to fill the details of customer
	public void BillingDetails(String FirstName, String LastName, String Phone, String Address, String City, String PostalCode )
	{
		By by_ele = By.xpath("//h3[text()='Billing Details']//parent::div//p[1]//input");
		WebElement we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		we.clear();
		we.sendKeys(FirstName);
		
		by_ele = By.xpath("//h3[text()='Billing Details']//parent::div//p[2]//input");
		we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		we.clear();
		we.sendKeys(LastName);
		
		by_ele = By.xpath("//h3[text()='Billing Details']//parent::div//p[5]//input");
		we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		we.clear();
		we.sendKeys(Phone);
		
		by_ele = By.xpath("//h3[text()='Billing Details']//parent::div//p[5]//input");
		we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		we.clear();
		String phoneno = Phone.substring(1,Phone.length()-1);
		we.sendKeys(phoneno);
		
		by_ele = By.xpath("//h3[text()='Billing Details']//parent::div//p[7]//input");
		we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		we.clear();
		we.sendKeys(Address);
		
		by_ele = By.xpath("//h3[text()='Billing Details']//parent::div//p[9]//input");
		we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		we.clear();
		we.sendKeys(City);
		
		by_ele = By.xpath("//h3[text()='Billing Details']//parent::div//p[11]//input");
		we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		we.clear();
		we.sendKeys(PostalCode);

		by_ele = By.xpath("//input[@id='place_order']");
		we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		we.click();
	
	}
}
