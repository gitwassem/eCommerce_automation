package Java.TestComponents;

import java.time.Duration;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import WaseemMavenThree.pageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	
	public WebDriver initialiseDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("edge"))
		{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();	
		
		
		}
		
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			//firefox
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
	}
	
	public LandingPage launchApplication() throws IOException
	{
		driver = initialiseDriver();
		LandingPage landing = new LandingPage(driver);
		landing.goTo();
		return landing;
	}

}
