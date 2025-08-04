package WaseemMavenThree.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;

import AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
		
		WebDriver driver;
		
		public CheckOutPage(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(css=".action__submit")
		WebElement submitcart;
		
		@FindBy(css="[placeholder='Select Country']")
		WebElement country;
		
		@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
		WebElement selectCountry;
		
		By results = By.cssSelector(".ta-results");
		
		public void selectCountry(String countryName) throws InterruptedException
		{
			Actions a = new Actions(driver);
			a.sendKeys(country, countryName).build().perform();
			//waitforElementToAppear(By.cssSelector(".ta-results"));
			Thread.sleep(2000);
			selectCountry.click();
		}
		
		public ConfirmationPage submitOrder()
		{
			submitcart.click();
			return new ConfirmationPage(driver);
		}
}
		
		
		
		



