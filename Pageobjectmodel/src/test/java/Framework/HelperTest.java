package Framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HelperTest
	{
		WebDriver driver;
		
		
		  public void InitializeDriver(String browser)
			    {
			        switch (browser)
			        {
			            case "Chrome":
			                driver = new ChromeDriver();
			                    break;
			            case "edge":
			                driver = new EdgeDriver();
			                break;
			            case "Firefox":
			                driver = new FirefoxDriver();
			                break;
			            case "IE":
			                driver = new InternetExplorerDriver();
			                break;
			            default:
			                driver = new ChromeDriver();
			                break;
			        }
			    }
		
		
		  
		  
			@BeforeTest
			public void setup()
			{
				 	InitializeDriver("Chrome");
				 	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
					driver.manage().window().maximize();
					driver.get("https://www.facebook.com/");
			}
			
			
			@AfterTest
			public void Cleanup()
				{
					driver.quit();
				}
			
			
			
			
			
			@Test
			public void highlighttest() throws InterruptedException
			{
				 WebElement username= driver.findElement(By.id("email"));  
			 	  
			 	Helper.highLightElement(driver,username);
				
				Thread.sleep(3000);			 
			}
			
			
			
			
	}
