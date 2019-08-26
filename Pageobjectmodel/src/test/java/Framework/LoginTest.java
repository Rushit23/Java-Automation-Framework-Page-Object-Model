package Framework;

import static org.testng.Assert.assertEquals;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




/*													MUST MUST MUST
 * 
 * Before Running Any Test You MUST MUST  Add  The TestNG Library (To The Project) and testng.annotations to the Class
 * 
 * Required For Running The Test
 * 
 * 
 * */





public class LoginTest
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
			
			
			
			
			
			
			
			@Test
			public void LoginApp() throws InterruptedException
			{
				// Create Object Of The Class  (Methods You want to access) here We  Need object of LoginPage 
				// Creating Object Means Invoking the Constructor of that class
				
				
				 loginpage lp = new loginpage(driver);
				 String title=driver.getTitle();
				 System.out.println(title);
				 
				lp.setUserid("hkjgkjgkjg");
				lp.setPassword("hhfhftf");
				lp.signin();
				//Thread.sleep(2000);
				
		
				 
				assertEquals(title,"Facebook - Log In or Signhgjhgjhg Up");
				
				
			// Thread.sleep(2000);
				
			//	Reporter.log("This Is Report log Example", true);
		
				 
			}
			
			
			
		
			
			
			

		@AfterTest
			public void Cleanup()
				{
					driver.quit();
				}
			
			
			
			
			
			
												/****** Helper Methods ******/
			
	}
