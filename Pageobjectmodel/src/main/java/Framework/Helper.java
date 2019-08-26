package Framework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class Helper
	{
		
		
		//  This Class Contains the Helper Methods
		
		
		
		public static void highLightElement(WebDriver driver, WebElement element)
			{
			JavascriptExecutor js=(JavascriptExecutor)driver; 
			 
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
			 
			try 
			{
			Thread.sleep(5000);
			} 
			catch (InterruptedException e) {
			 
			System.out.println(e.getMessage());
			} 
			 
			js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
			 
			}
		
		
		
		
		public static void captureScreenShot(WebDriver driver)
			{
				try 
					{
						TakesScreenshot ts = (TakesScreenshot)driver;
			
						File src= ts.getScreenshotAs(OutputType.FILE);
				
			
						 FileHandler.copy(src, new File("D:/Test/error.png"));
				
						
						System.out.println(" SceenShot Taken ");
					
					}
				 
				catch (IOException e)
				 {
					 System.out.println(e.getMessage());
				 
				 }
				
			 }
		
		
		
		// Screen Shot With Path
		
		public static String  captureScreenShotWF (WebDriver driver,String screenshotName)
		{
			try 
			{
				TakesScreenshot ts = (TakesScreenshot)driver;
				
				File source =ts.getScreenshotAs(OutputType.FILE);
				
				String dest ="D:\\Test\\"+screenshotName+".png";
				
				File destination = new File(dest);
				
				FileHandler.copy(source, destination);
				
				System.out.println(" SceenShot Taken ");
				
				return dest;
			}
			
			catch (IOException e)
				 {
					 System.out.println(e.getMessage());
					 return e.getMessage();
				 }
			
			
		}
		
		
		
		
		// Screenshot  with Destination
		
		
		
		public static String takeScreenshot(WebDriver driver, String fileName) throws IOException {
			fileName = fileName + ".png";
			String directory = "D:\\ScreenSHoots\\";
			File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 FileHandler.copy(sourceFile, new File(directory + fileName));
			String destination = directory + fileName;
			return destination;
		}
		
		
		
		
		
		
		// Random Number generator
		
		

		public static double getRandomNumber()
			{
				double x = Math.random();
					return x;
			}
		
		
		
		public static double getRandomNumber1()
			{
				double num=0;
				 for(int i=0; i < 5 ; i++)
				
					 
					num = (i+1) + (int)(Math.random()*100);
					return num;
					
			}
		
		
	}
