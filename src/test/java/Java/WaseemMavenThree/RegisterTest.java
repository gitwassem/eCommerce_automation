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
import WaseemMavenThree.pageObjects.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class RegisterTest extends BaseTest{

	@Test
	
	public void RegisterUser() throws IOException, InterruptedException
	{
	
		LandingPage landing = launchApplication();
		landing.goTo();
		landing.registerApplication();
		RegisterPage register = new RegisterPage(driver);
		register.fillForm("Test", "Three", "testuser@three.com", "9890960001", "Test@123", "Test@123", "Student");
		
		Thread.sleep(2000);
		driver.quit();
		
		
		
	}

}
