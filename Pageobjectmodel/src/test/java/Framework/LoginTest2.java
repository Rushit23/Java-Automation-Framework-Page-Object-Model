package Framework;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import java.io.IOException;
import Framework.loginpage;
import Framework.TestBase;


/*					
 *   							LOGIN TEST USING GLOBAL ENVIRONMENT VARIABLE
 * 
 * 
 * 
 * 
 * 								MUST MUST MUST
 * 
 * 		Before Running Any Test You MUST MUST  Add  The TestNG Library (To The Project) and testng.annotations 
 * 		to the Class
 * 
 * 		Required For Running The Test
 * 
 * 		import Framework.loginpage;  Provide References Where  Required 
	 	Framework.TestBase;

 * 
 * 
 * */





		public class LoginTest2 extends TestBase
		{
			
			@AfterTest
			public void Cleanup()
				{
					driver.quit();
				}
			

			@Test(description="This TC will perform valid login")
			public void LoginApp() throws InterruptedException, IOException
			{
				// Create Object Of The Class  (Methods You want to access) here We  Need object of LoginPage 
				// Creating Object Means Invoking the Constructor of that class
				
				// Will Initialize Driver & browser 
					setup();
				
				 loginpage lp = new loginpage(driver);
				 String title=driver.getTitle();
				 System.out.println(title);
				 
				lp.setUserid("UserName");
				lp.setPassword("Password");
				lp.signin();
				Thread.sleep(2000);
				
		
				 
				assertEquals(title,"Facebook - Log In or Sign Up");
				Thread.sleep(2000);	
				 
			}
			
			
			
		/*	
			
			@Test(retryAnalyzer = Analyzer.RetryAnalyzer.class)
			public void Test1()
			{
			    

			}
			
			
		*/	
			
			
			
			
			
			
			
			
												/****** Helper Methods ******/
			
	}
