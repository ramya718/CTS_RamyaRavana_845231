package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import BasicUtilities.JustWait;
import BasicUtilities.ScreenShotss;
import BasicUtilities.logger;

public class LoginAndRegister {
	WebDriver dr;
	JustWait wt; logger log; ScreenShotss ss ;MyAccountPage Ap; 
	
	public LoginAndRegister(WebDriver dr)
	{
		this.dr = dr;
		wt = new JustWait(dr);
		log = new logger(dr);
		ss = new ScreenShotss(dr);
	}
	//to enter the username
	public void EnterUserName(String username)
	{
		By by_ele = By.xpath("//h2[text()='Login']//parent::div//input[@id='username']");
		WebElement we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		we.sendKeys(username);
	}
	//function for to enter the password
	public void EnterPassword(String password)
	{
		By by_ele = By.xpath("//h2[text()='Login']//parent::div//input[@id='password']");
		WebElement we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		we.sendKeys(password);
	}
	//to click the login button
	public void ClickLoginBTn()
	{
		By by_ele = By.xpath("//h2[text()='Login']//parent::div//input[@type='submit'] ");
		WebElement we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		we.click();
	}
	//error message checking for invalidemial
	public String InvalidEmailError()
	{
		By by_ele = By.xpath("//strong[contains(text(),'E')]//parent::li");
		WebElement we = wt.WaitForElement(by_ele, 10);
		we = wt.elementToBeClickable(by_ele, 10);
		return we.getText();
	}
	
	
	//function to login
	public void DoLogin(String userName, String Password)
	{
		String s = null;
		this.EnterUserName(userName);
		this.EnterPassword(Password);
		ss.ScreenShott("Login Data.png");
		this.ClickLoginBTn();	
		log.Update_log("Login tried with data"+userName+" "+Password);
	}
}
