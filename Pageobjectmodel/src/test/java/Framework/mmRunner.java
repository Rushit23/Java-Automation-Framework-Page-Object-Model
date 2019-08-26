package Framework;



import org.testng.TestNG;

public class mmRunner
	{
		public static TestNG testNg;
		
		
		public static void main(String[] args)
			{
				testNg = new TestNG();

				testNg.setTestClasses(new Class[] {LoginTest.class});
				testNg.run();

			}

	}
