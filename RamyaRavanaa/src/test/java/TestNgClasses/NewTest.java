package TestNgClasses;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BasicUtilities.Browsers;
import BasicUtilities.ScreenShotss;
import ExcelDataUtils.ReadExcel;
import POM.*;

import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebDriver;

public class NewTest {
	WebDriver dr;
	//declare the objects for all page classes
	Browsers br;Home hm; LoginAndRegister lg; ReadExcel re;
	MyAccountPage ma; ShopPage sp;BasketPage bp;CheckOutPage cop;DetailsPage dp;ScreenShotss ss;
	//test case for invalid login
  @Test(dataProvider = "InvalidData")
  public void InvalidLogin(String username, String password, String Exp_res) {
	  br = new Browsers();
	  dr = br.launchBrowser(br.Chrome,"http://practice.automationtesting.in/");
	  ss= new ScreenShotss(dr);
	  ss.ScreenShott("BrowserLaunched.png");
	  hm = new Home(dr);
	  hm.ClickOnMyAccount();
	  lg = new LoginAndRegister(dr);
	  lg.DoLogin(username, password);
	  String err =lg.InvalidEmailError();
	  ss.ScreenShott("ErrorMsgFor"+username+".png");
	 
	  SoftAssert sa = new SoftAssert();
	  sa.assertEquals(err, Exp_res);
	  sa.assertAll();
	  dr.quit();
  }
  @DataProvider
  public String[][] InvalidData() {
	  re = new ReadExcel();
	  re.get_data("Login Invalid Credentials",2,3);
	  return re.testdata;
  }
  //test case for valid login
  @Test(dataProvider = "validData")
  public void validLogin(String username, String password, String Exp_res) {
	  br = new Browsers();
	  dr = br.launchBrowser(br.Chrome,"http://practice.automationtesting.in/");
	  hm = new Home(dr);
	  hm.ClickOnMyAccount();
	  lg = new LoginAndRegister(dr);
	  lg.DoLogin(username, password);
	  ss= new ScreenShotss(dr);
	  ss.ScreenShott("successful login"+username+".png");
	  ma= new MyAccountPage(dr);
	  String uname =ma.VerifyLogin();
	  SoftAssert sa = new SoftAssert();
	  sa.assertEquals(uname, Exp_res);
	  sa.assertAll();
	  dr.quit();
  }
  @DataProvider
  public String[][] validData() {
	  re = new ReadExcel();
	  re.get_data("Valid Credentials",2,3);
	  return re.testdata;
  }
 //test case for checking name and price of item which is added
  @Test(dataProvider = "LoginData")
  public void AddToCart(String username, String password) {
	  br = new Browsers();
	  dr = br.launchBrowser(br.Chrome,"http://practice.automationtesting.in/");
	  hm = new Home(dr);
	  hm.ClickOnMyAccount();
	  lg = new LoginAndRegister(dr);
	  lg.DoLogin(username, password);
	  ma= new MyAccountPage(dr);
	  ma.ClickShopLink();
	  sp = new ShopPage(dr);
	  sp.AddtoCart(2);
	  ss= new ScreenShotss(dr);
	  ss.ScreenShott("added to cart.png");
	  String ExpName  =sp.ItemName(2);
	  float ExpPrice = sp.Price(2);
	  sp.ViewBasket(2);
	  bp=new BasketPage(dr);
	  String actName=bp.ItemName(1);
	  float actPrice = bp.Price(1);
	  SoftAssert sa = new SoftAssert();
	  sa.assertEquals(actPrice,ExpPrice );
	  sa.assertEquals(actName, ExpName);
	  sa.assertAll();
	  dr.quit();
  }
  @DataProvider
  public String[][] LoginData() {
	  re = new ReadExcel();
	  re.get_data("Valid Credentials",1,2);
	  return re.testdata;
  }
 //test case for check out message
  @Test(dataProvider = "LoginAndCheckout")
  public void Checkout(String username, String password,String FirstName, String LastName, String Phone, String Address, String City, String PostalCode, String exp) {
	  br = new Browsers();
	  dr = br.launchBrowser(br.Chrome,"http://practice.automationtesting.in/");
	  hm = new Home(dr);
	  hm.ClickOnMyAccount();
	  lg = new LoginAndRegister(dr);
	  lg.DoLogin(username, password);
	  ma= new MyAccountPage(dr);
	  ma.ClickShopLink();
	  sp = new ShopPage(dr);
	  sp.AddtoCart(2);
	  sp.AddtoCart(3);
	  ss= new ScreenShotss(dr);
	  ss.ScreenShott("Added to cart2.png");
	  sp.ViewBasket(2);
	  bp=new BasketPage(dr);
	  bp.Checkout();
	  cop= new CheckOutPage(dr);
	  cop.BillingDetails(FirstName, LastName, Phone, Address, City, PostalCode);  
	  dp = new DetailsPage(dr);
	  String actText=dp.ThankyouMsg();
	  SoftAssert sa = new SoftAssert();
	  sa.assertEquals(actText, exp);
	  sa.assertAll();
	  dr.quit();
  }
  @DataProvider
  public String[][] LoginAndCheckout() {
	  re = new ReadExcel();
	  re.get_data("CheckoutDetails",1,9);
	  return re.testdata;
  }
  

  
  
 

}
