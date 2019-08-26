package Framework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

		//ITestListener interface which implements TestNg listeners

	public class Listeners implements ITestListener 

	{
		
		WebDriver driver;

	@Override
	public void onTestStart(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		System.out.println(result.getName() + " : Have passed  ");
	}

	
	
	
	
	@Override
	public void onTestFailure(ITestResult result) 
		
		{
		// TODO Auto-generated method stub
		//screenshot code 
		//response if API is failed
		
			System.out.println(" TheName Of The Failed Test Case is :  " + result.getName());	
			
			/*
			try
				{
					Helper.takeScreenshot(driver,result.getName()+Helper.getRandomNumber1());
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
		}

	
	
	
	
	@Override
	public void onTestSkipped(ITestResult result) 
		{
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
		{
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	@Override
	public void onStart(ITestContext context) 
		{
		// TODO Auto-generated method stub
		
	}
	
	
	
	

	@Override
	public void onFinish(ITestContext context)
		{
		// TODO Auto-generated method stub
		
	}

	
	
	
}