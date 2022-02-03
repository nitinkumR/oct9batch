package pom.pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	@FindBy (xpath="(//div[@aria-label='Messenger'])[1]")
	private WebElement messanger;
	@FindBy (xpath="//input[@type='search']")
	private WebElement search;
	
	@FindBy (xpath="//a[@aria-label='Watch']")
	private WebElement watchvideo;
	@FindBy (xpath="//a[@aria-label='Marketplace']")
	private WebElement marketplace;
	@FindBy (xpath="//a[@aria-label='Groups, 3 notifications']")
	private WebElement notification;
	@FindBy (xpath="//a[@aria-label='More']")
	private WebElement moreoptions;
	
	@FindBy (xpath="(//div[@aria-label='Account'])[1]")
	private WebElement account;
	@FindBy (xpath="//span[text()='Log Out']")
	private WebElement logout;
	
	@FindBy (xpath="//a[@aria-label='Create story']")
	private WebElement createstory;
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void clickOnMessangertab() 
	{
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 messanger.click();
	}
	public void clickOnSearchTab()
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		search.click();
	}
	

	public void clickOnWatchButton() throws InterruptedException
	{    Thread.sleep(4000);
		watchvideo.click();
	}
	public String clickOnCreateStory()
	{
		String string=createstory.getAttribute("aria-label");
		return string;
	}
	public void clickOnMarketPlace()
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		marketplace.click();
	}
	
	public void clickOnNotification()
	{ 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		notification.click();
	}
	
	public void clickOnMoreOptions()
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		moreoptions.click();
	}
	
	public void clickOnAccount() throws InterruptedException 
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//Thread.sleep(3000);
		account.click();
	}
	
	public void clickOnLogOut() throws InterruptedException 
	{
		Thread.sleep(3000);
		
		logout.click();
	}
	

	

}
