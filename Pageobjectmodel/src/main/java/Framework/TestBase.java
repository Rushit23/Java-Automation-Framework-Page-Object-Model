package Framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase
	{
			
		
		public static WebDriver driver=null;
		

		public void setup() throws IOException
		{
			
			Properties p=new Properties();
			
			FileInputStream fi=new FileInputStream("C:\\Apps\\Pageobjectmodel\\src\\main\\java\\Framework\\global.properties");
			p.load(fi);
			
			// System.out.println(p.getProperty("browser"));
			
			if(p.getProperty("browser").contains("firefox"))
			{
				driver=new FirefoxDriver();
			}
			
			else if (p.getProperty("browser").contains("chrome"))
			{
				// System.setProperty("webdriver.chrome.driver", value);
				// System.setProperty("webdriver.chrome.driver","D:/Selenium-Drivers/ChromeDriver/chromedriver.exe");
				driver=new ChromeDriver();
			}
			
			else
			{
				// System.setProperty("webdriver.chrome.driver","D:/Selenium-Drivers/ChromeDriver/chromedriver.exe");
				driver=new ChromeDriver();
			}
			
			 driver.manage().window().maximize();
			driver.get(p.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}
		
		
		
		
		
		
	}
