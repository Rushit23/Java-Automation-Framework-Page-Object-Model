package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginpage
	{
				
		
		WebDriver driver;
		  
		  
		  
		  	// Define All  The Objects Belonging to This Page Only
		    By username = By.id("email");
		    By password= By.id("pass");
		    By signin= By.id("loginbutton");
		 
		    
		    
		            

		   // Basic Constructor That You Will Need To Write For All Your Page Object Classes
		    
		     public loginpage(WebDriver driver)
		    	 {
		 
		    		 this.driver = driver;
		 
		    	 }
		     
		     
		     
		     	public void setUserid(String userid)
		         {
		        	driver.findElement(username).sendKeys(userid);
		         }
		         
		     
		         public void setPassword(String passwords)
		         {
		        	driver.findElement(password).sendKeys(passwords);
		         }
		         
		         
		         public void signin()
		         {
		        	driver.findElement(signin).click();
		         }
		         
		     
		     
		     
		     
		     
		     
		     
	}
