package Framework;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




public class FaceBokTest
	{
	
		WebDriver driver;
		
		@Test(dataProvider="testdata")
		public void TestFireFox(String uname,String password){
		 
			 System.setProperty("webdriver.chrome.driver","D:\\Selenium-Drivers\\Rj\\chromedriver.exe\\"); 
			 driver = new ChromeDriver ();
			 driver.manage().window().maximize();
		 
		// Load application
		driver.get("http://www.facebook.com");
		String title= driver.getTitle();
		 
		// clear email field
		 
		driver.findElement(By.id("email")).clear();
		 
		 
		// Enter usename
		driver.findElement(By.id("email")).sendKeys(uname);
		 
		 
		 
		// Clear password field
		driver.findElement(By.id("pass")).clear();
		 
		 
		 
		// Enter password
		driver.findElement(By.id("pass")).sendKeys(password);
		Assert.assertTrue(title.contains("Google")); 
		}
		 
		
		
			//  Must  craete  """"Screenshots"""""  Inside The project  
		@AfterMethod
			public void tearDown(ITestResult result) throws IOException, InterruptedException
			{
			 
			// Here will compare if test is failing then only it will enter into if condition
			if(ITestResult.FAILURE==result.getStatus())
			{
				
				
				TakesScreenshot ts=(TakesScreenshot)driver;
				File source=ts.getScreenshotAs(OutputType.FILE);		 
				FileHandler.copy(source, new File("./Screenshots/"+result.getName()+Helper.getRandomNumber1()+".png"));
				 
				System.out.println("Screenshot taken");
				Thread.sleep(2000);
				
				
				
				/*
				Helper.takeScreenshot(driver,result.getName()+Helper.getRandomNumber1());
				Thread.sleep(2000);
				*/
			}
			
			driver.quit();
			}
			
			
		
		
		
		
		
		
		// this is DataProvider which actually feed data to our test cases here I have taken 2 D //array with 2 rows and 2 column it means. It will run our test case two times because we //have taken 2 rows. While first iteration this will pass username and password to test //case and in second iteration perform the same for second rows
		@DataProvider(name="testdata")
		public Object[][] TestDataFeed(){
		 
		 
		// Create object array with 2 rows and 2 column- first parameter is row and second is //column
		Object [][] facebookdata=new Object[2][2];
		 
		 
		 
		// Enter data to row 0 column 0
		facebookdata[0][0]="Selenium1@gmail.com";
		 
		 
		 
		// Enter data to row 0 column 1
		facebookdata[0][1]="Password1";
		 
		 
		 
		// Enter data to row 1 column 0
		facebookdata[1][0]="Selenium2@gmail.com";
		 
		// Enter data to row 1 column 0
		facebookdata[1][1]="Password2";
		 
		// return arrayobject to testscript
		return facebookdata;
		}

		
	}










