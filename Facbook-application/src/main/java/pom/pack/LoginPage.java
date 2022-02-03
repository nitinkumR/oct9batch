package pom.pack;



	

	import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import Utilis.Utility;

	public class LoginPage {
		private WebDriver driver;
		@FindBy (xpath="//input[@type='text']")
		private WebElement userName;
		@FindBy (xpath="//input[@type='password']")
		private WebElement password;
		@FindBy (xpath="//button[@value='1']")
		private WebElement login;
		
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			this.driver=driver;
		}
		
		//actions on WebElements
		 
		public void sendUserName() throws EncryptedDocumentException, IOException
		{
			
			//String data=Utility.getDataFromDataSheet(1, 0);
				userName.sendKeys("7757917535");
			
		}
		public void sendPassword()
		{
			if(password.isDisplayed())
			{
				password.sendKeys("2015bel@014");
			}
		}
		public void clickOnLoginButton()
		{
			if(login.isDisplayed())
			{
				login.click();
			}
		}
		
	}
		
		
		
		
		
		
		
		
		
		
		

	

	


