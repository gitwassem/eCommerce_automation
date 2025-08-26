package WaseemMavenThree.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
		
		public WebDriver driver;
		
		public LandingPage(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="userEmail")
		WebElement Email;
		
		@FindBy(id="userPassword")
		WebElement Password;
		
		@FindBy(id="login")
		WebElement submit;
		
		@FindBy(className="text-reset")
		WebElement RegisterHere;
		
		public void loginApplication(String userid, String passwordone)
		{
			Email.sendKeys(userid);
			Password.sendKeys(passwordone);
			submit.click();
		}
		
		public void registerApplication()
		{
			RegisterHere.click();
		}
		
		public void goTo()
		{
			driver.get("https://rahulshettyacademy.com/client/");
			
		}
		}



