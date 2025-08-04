package Java.WaseemMavenThree;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Java.TestComponents.BaseTest;
import WaseemMavenThree.pageObjects.CartPage;
import WaseemMavenThree.pageObjects.CheckOutPage;
import WaseemMavenThree.pageObjects.LandingPage;
import WaseemMavenThree.pageObjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest extends BaseTest{

	@Test
	
	public void StandAlone() throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
		String productName = "ZARA COAT 3";		
		LandingPage landing = launchApplication();
		landing.goTo();
		landing.loginApplication("test74@one.com", "Test@123");
		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.addProductToCart(productName);
		productcatalogue.goToCartPage();
		CartPage cartPage = new CartPage(driver);
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		cartPage.goToCheckOut();
		CheckOutPage checkoutPage = new CheckOutPage(driver);
		checkoutPage.selectCountry("india");
		checkoutPage.submitOrder();
		
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertEquals(confirmMessage, "THANKYOU FOR THE ORDER.");
		Thread.sleep(2000);
		driver.quit();
		
		
		
	}

}
