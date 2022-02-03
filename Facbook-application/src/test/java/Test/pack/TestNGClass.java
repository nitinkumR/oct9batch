package Test.pack;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Base.Base;
import Utilis.Utility;
import pom.pack.HomePage;
import pom.pack.LoginPage;


public class TestNGClass extends Base {
	

	private WebDriver driver;
	private HomePage homepage;
    private LoginPage loginpage;
   private SoftAssert softassert;
   private int testID;
   static ExtentTest test;
   static ExtentHtmlReporter reporter;
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser)
	{
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"ExtendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		if(browser.equals("chrome"))
		{
			driver=openChromeBrowser();
		}
		if(browser.equals("firefox"))
		{
			driver= openFireFoxBrowser();
		}
	}
	@BeforeClass
	public void initializePomClasses()
	{
		loginpage=new LoginPage(driver);
		homepage =new HomePage(driver);
	}
	@BeforeMethod
	public void logInToFB() throws EncryptedDocumentException, IOException 
	{
        try {
			driver.get("https://www.facebook.com/login/");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driver.navigate().refresh();
		 
         
		loginpage.sendUserName();
		loginpage.sendPassword();
		loginpage.clickOnLoginButton();
		 
		 softassert=new SoftAssert();
	}
	
	@Test
	public void toVarifyMessangerTab()
	{testID=101;
		homepage.clickOnMessangertab();
		
	}
	
	@Test
	public void toVarifyMarketTab() throws InterruptedException
	{testID=102;
		
		homepage.clickOnMarketPlace();
		Thread.sleep(2000);
		String url=driver.getCurrentUrl();
	Assert.assertEquals(url, "https://www.facebook.com/marketplace/?ref=app_tab");
        String str=homepage.clickOnCreateStory();
        softassert.assertEquals(str,"Create story");
        softassert.assertAll();
	}
	
	@Test(enabled=false)
	public void toVarifyWatchTab() throws InterruptedException
	{
		
		homepage.clickOnWatchButton();
	}
	
	@AfterMethod
	public void logOutFromFacebook() throws InterruptedException, IOException
	{    Thread.sleep(2000);
	     Utility.saveScrenshot(driver, testID);
	
		homepage.clickOnAccount();
     	homepage.clickOnLogOut();
	}
	
	@AfterClass
	public void clearObjects() throws InterruptedException
	{
		loginpage=null;
		homepage=null;
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
		driver=null;
		System.gc();
	}
	
	
	

}
