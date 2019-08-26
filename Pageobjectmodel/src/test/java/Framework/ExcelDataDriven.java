package Framework;
import java.io.BufferedInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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





public class ExcelDataDriven
	{
	
		WebDriver driver;
		
		
		
															//  Must  craete  """"Screenshots"""""  Inside The project  
			@AfterMethod
				public void tearDown(ITestResult result) throws IOException, InterruptedException
				{
				 
			
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
		
		
		
		
		
		
		
		@Test(description=" This Is Example Of Redaing Data From Config file")
		public void ReadDataaFromConfig() throws IOException
		{
			 
			
			
			
				System.setProperty("webdriver.chrome.driver","D:\\Selenium-Drivers\\Rj\\chromedriver.exe\\");
				
				File src=new File("C:\\Apps\\Pageobjectmodel\\TestData\\Object_Repo.properties");
				 

				FileInputStream fis=new FileInputStream(src);
		
				Properties pro=new Properties();
				 
	
				pro.load(fis);
				 
				System.out.println("Property class loaded");
				 
				 
				
				
				 WebDriver driver = new ChromeDriver ();
				 driver.manage().window().maximize();
				String title= driver.getTitle();
				 
			
				driver.get("http://www.facebook.com");
				 
				
				
				
				driver.findElement(By.xpath(pro.getProperty("facebook.login.username.xpath"))).
				sendKeys("Selenium@gmail.com");
				 
			
				driver.findElement(By.xpath(pro.getProperty("facebook.login.password.xpath"))).
				sendKeys("adsadasdas");
				 
				
				driver.findElement(By.xpath(pro.getProperty("facebook.login.Signup.xpath"))).click();
				Assert.assertTrue(title.contains("Google")); 
			
		}
		
		
		
		
		
		
		
		
		@Test(dataProvider="Rushit")
		public void TestFB(String uname,String password)
		{
		 
			 System.setProperty("webdriver.chrome.driver","D:\\Selenium-Drivers\\Rj\\chromedriver.exe\\"); 
			 driver = new ChromeDriver ();
			 driver.manage().window().maximize();
		 
	
		driver.get("http://www.facebook.com");
		String title= driver.getTitle();
		 
	
		 
		driver.findElement(By.id("email")).clear();
		 
		 
	
		driver.findElement(By.id("email")).sendKeys(uname);
		 
		 
		 

		driver.findElement(By.id("pass")).clear();
		 
		 
		 

		driver.findElement(By.id("pass")).sendKeys(password);
		Assert.assertTrue(title.contains("Google")); 
		}
		 
		
		
		
		
		
		
		
		
		
		
		
		
			
			
			
		
		
		
		
		
		
		
		@DataProvider(name="Rushit")
		public Object[][] TestDataFeed() throws InterruptedException 
			{
		 
				ExcelDataConfig config = new ExcelDataConfig("C:\\Apps\\Pageobjectmodel\\TestData\\fbtes.xlsx");
	
						
						int rows =config.getRowCount(0);
						
					Object [][] datasss=new Object[rows][2];
					for(int i =0;i<rows;i++)
						{
							datasss[i][0]=config.getData(0, i, 0);
							datasss[i][1]=config.getData(0, i, 1);
						}
		 
	
		return datasss;
		}

		
		
		
		
		
		
		
		
	}











