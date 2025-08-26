package WaseemMavenThree.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AbstractComponents.AbstractComponent;

public class RegisterPage extends AbstractComponent {
		
		public WebDriver driver;
		
		public RegisterPage(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="firstName")
		WebElement FirstUserName;
		
		@FindBy(id="lastName")
		WebElement LastUserName;
		
		@FindBy(id="userEmail")
		WebElement UserID;
		
		@FindBy(id="userMobile")
		WebElement Mobile;
		
		@FindBy(id="userPassword")
		WebElement MyPassword;
		
		@FindBy(id="confirmPassword")
		WebElement MyConfirmPassword;
		
		//@FindBy(xpath="//select[@class='custom-select ng-valid ng-touched ng-dirty']")
		//WebElement Occupation;
		
		@FindBy(xpath="//input[@value='Male']")
		WebElement Gender;
		
		@FindBy(xpath="//input[@type='checkbox']")
		WebElement Confirm;
		
		@FindBy(xpath="//input[@value='Register']")
		WebElement RegisterButton;
		
		By toastMessage = By.cssSelector("#toast-container");
		
		
		public void fillForm(String registername, String registersurname, String registerid, String cellno, String passwordone, String passwordtwo, String value) 
		{
			FirstUserName.sendKeys(registername);
			LastUserName.sendKeys(registersurname);
			UserID.sendKeys(registerid);
			Mobile.sendKeys(cellno);
			MyPassword.sendKeys(passwordone);
			MyConfirmPassword.sendKeys(passwordtwo);
			//Select dropdown = new Select(Occupation);
		    //dropdown.selectByVisibleText(value);
		    Gender.click();
		    Confirm.click();
		    RegisterButton.click();
		    waitforElementToAppear(toastMessage);
						
		}
		
		
		public void goTo()
		{
			driver.get("https://rahulshettyacademy.com/client/");
			
		}
		}



