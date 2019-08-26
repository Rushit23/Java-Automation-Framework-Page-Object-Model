import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;








  
			//     *********************** CONTAINS THE HELPER METHODS ***************************   //
 
 

public class Helper
	{
		
		
		
		
												// HightLight The Element
		
		
		
		public static void highLightElement(WebDriver driver, WebElement element)
			{
				
				JavascriptExecutor js=(JavascriptExecutor)driver; 
				 
				js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
				 
				try 
				{
					
				Thread.sleep(5000);
				
				} 
				catch (InterruptedException e) 
				{
				 
				System.out.println(e.getMessage());
				
				} 
				 
				js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
				 
			}
		
		
		
		
										// Automate The Barcode 
		
		
		// String barCodeURL = driver.findElement(By.tagName("img")).getAttribute("src");
				// AutomateBarcode(driver,barCodeURL);
		
		
		public static String AutomateBarcode(WebDriver driver,String barcodeurl)
				throws MalformedURLException, IOException, NotFoundException
			{

				
				 
				 System.out.println(barcodeurl);
				 
				 URL url = new URL(barcodeurl);
				 
				 BufferedImage bufferedImage = ImageIO.read(url);
				 
				 LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
				 BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
				 
				 Result result = new MultiFormatReader().decode(binaryBitmap);
				 
				 return result.getText();
			}
		
		
		
		//  Select Data BY JS 
		
		public static void selectDateByJS(WebDriver driver, WebElement element, String dateVal){
	    	JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
			
		}
        
		
		
		
		
		
		
		
		
		//  Get frame Number And Switch
		
		// int m = gotoframe(driver, By.xpath(".//*[@id='recaptcha-anchor']"));

		// 	driver.switchTo().frame(m);

		public static int gotoframe(WebDriver driver1, By by)

			{

				driver1.switchTo().defaultContent();

				int i;

				int num = -1;

				int a = driver1.findElements(By.tagName("iframe")).size();

				for (i = 0; i < a; i++)

					{

						driver1.switchTo().defaultContent();

						driver1.switchTo().frame(i);

						int b = driver1.findElements(by).size();

						if (b > 0)

							{

								num = i;

								break;

							}

					}

				driver1.switchTo().defaultContent();

				return num;

			}
		
		
		
		
		
		
		
		
		
		// Browser Information Version And Type
		
				public static void Browserinformation(WebDriver driver)
					{

						Capabilities caps = ((RemoteWebDriver)driver).getCapabilities();
					 	
					 	String browserName = caps.getBrowserName();
					 	String browserVersion = caps.getVersion();
					 	
					 	System.out.println(browserName +  " "+ browserVersion);
					 	
					}
		
		
				
				
				
				
				
				
				
				
				// Verify Active Link
				
				public static void verifyLinkActive(String linkUrl)
					{
					        try 
					        {
					           URL url = new URL(linkUrl);
					           
					           HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
					           
					           httpURLConnect.setConnectTimeout(3000);
					           
					           httpURLConnect.connect();
					           
					           if(httpURLConnect.getResponseCode()==200)
					           {
					        	   
					               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
					               
					            }
					           
					          if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
					           {
					        	   
					               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
					               
					            }
					          
					        }
					        
					        catch (Exception e)
					        {
					           
					        }
				    } 
					
				
				
				
				
				
				
				
				// Get DOmain Name
				
				public static String GetDomainName(WebDriver driver) throws URISyntaxException
					{

						URI uri = new URI(driver.getCurrentUrl());
					 	String domain= uri.getHost();
					 	return domain;
					}

				
				
				
				
				
				
				
			//	DropDown BootStrap

			//	List<WebElement> dd_menu=driver.findElements(By.xpath(""));
			 //	DropDownBootSTP(driver,dd_menu,"JavaScript");
				
				
				public static void DropDownBootSTP(WebDriver driver, List<WebElement> element2,String Opton)
					{

					 	 for(WebElement element:element2)
					 	 {

					 		 String innerhtml=element.getAttribute("innerHTML");

					 	 
					 	 
					 	 
					 		 	if(innerhtml.contentEquals(Opton))
					 			 {
					 		 
					 				 element.click();
					 				 break;
					 	 
							 	 }

					 		 	System.out.println(" Values from dropdown is ==== " + innerhtml);
					 		 	
					 		 
					 	 
					 	 }
					 	 
					// 	return Opton;
					 	 
					}
				
				
				
				
				
				
				// Verify File Exists
				
				public static boolean VerifyFileExists(String path)
					{
						boolean existss;
						File f = new File(path);
						if(f.exists())
							{
								 existss = true;
								
								return existss;
							}
						
						else
							{
								
								existss = false;
								return existss;
							}
					}
				
				
				
				
				
				// Reading Data From Excel File
				
				//	path = "D:\\Test.xlsx";
				public static String ExcelDataRead(String path) throws FileNotFoundException, IOException
					{

						FileInputStream files = new FileInputStream(new File(path));
					   
					 	
						XSSFWorkbook workbook = new XSSFWorkbook(files);		 	
					 	
						XSSFSheet	sheet =	workbook.getSheetAt(0);
						
						String h1 = sheet.getRow(0).getCell(0).getStringCellValue();
						return h1;
					}
				
				
				
				
				
				
				//  Get Row Count Of Table
				
				public static int GetRowCountofTable(List<WebElement> elem)
					{

						int RoWCOunt = elem.size();
						return RoWCOunt;
					}
				
				
				
				// ************************** CSS VALUES ********************************** //
				
				
				
				public static String GetCSSValuee(WebElement element, String CSSvALUE)
					{

						String CssVlu =element.getCssValue(CSSvALUE);
						return CssVlu;
					}
				
				
				public static String GetfontSizeCSS(WebElement element)
					{

						String fontSize =element.getCssValue("font-size");
						return fontSize;
					}
				
				
				
				
				// ************************** Dropdown List********************************** //
				
				
				 //	WebElement dropdownelement1 =driver.findElement(By.id("myList"));
				 //	DropDownbyIIndex(driver,dropdownelement1,2);
				
				
				
					public static void DropDownbyIIndex(WebDriver driver,WebElement dropdownelement,int indx)
						{

							Select dropdown = new Select(dropdownelement);
							
							dropdown.selectByIndex(indx);
						}
					
				
					
					
					
					
					public static void DropDownbyText(WebDriver driver,WebElement dropdownelement,String TXT)
						{

							Select dropdown = new Select(dropdownelement);
							
							dropdown.selectByVisibleText(TXT);
						}
					
					
					
					
					
					
					
					public static void DeselectDropDownbyIIndex(WebDriver driver,WebElement dropdownelement,int indx)
						{

							Select dropdown = new Select(dropdownelement);
							
							dropdown.deselectByIndex(indx);
						}
					
				
					
					
					
					
					
					
					public static void DeselectByText(WebDriver driver,WebElement dropdownelement,String TXT)
						{

							Select dropdown = new Select(dropdownelement);
							
							dropdown.deselectByVisibleText(TXT);
						}
					
					
					
					
					
					
					
					public static void DeselectALl(WebDriver driver,WebElement dropdownelement)
						{

							Select dropdown = new Select(dropdownelement);
							
							dropdown.deselectAll();
						}
					
					
					
					
					
					
					public static int GetSizeOfDropDown(WebDriver driver,WebElement dropdownelement)
						{

							Select dropdown = new Select(dropdownelement);
							
							List<WebElement> elements=dropdown.getOptions();
							return elements.size();
						}	
					
					
					
					
					
					public static boolean VerifyIsMultiSelecet(WebDriver driver,WebElement dropdownelement)
						{

							Select dropdown = new Select(dropdownelement);
							boolean ismultiple=dropdown.isMultiple();
							return ismultiple;
						
						}
					
					
					
					public static void GeteDropDownElements(WebDriver driver,WebElement dropdownelement)
						{

							Select dropdown = new Select(dropdownelement);
							
							List<WebElement> elements=dropdown.getOptions();
							
							for(WebElement ele:elements)
								
							 ele.getText();
						}	
					
					
					
					
					
					
					
					public static String GeteSelectedDropDownElement(WebDriver driver,WebElement dropdownelement)
						{

							Select dropdown = new Select(dropdownelement);
							
							WebElement element=dropdown.getFirstSelectedOption();
							
							
							return element.getText();
						}	
					
					
					
					
					
					
					
					
					
					
					
					
					// SendKeys
					
					
					// WebElement element =driver.findElement(By.id("myList"));
					public static void Sendkeeys(WebDriver driver ,WebElement element,String mytext)
						{

									 
						 	element.sendKeys(mytext);
						}
				
					
					
					
					// Verify ELement is Enabled 
					
					public static boolean VerifyElementisEnabled(WebDriver driver,WebElement ele)
						{

							boolean enabled = ele.isEnabled();
							return enabled;
						}
					
					
					
					
					
					// Verify Element is Displayed
					
					public static boolean VerifyElementisDisplayed(WebDriver driver,WebElement ele)
						{

							boolean display = ele.isDisplayed();
							return display;
						}
					
					
					
					
					
					// Verify Element is Selected
					
					public static boolean VerifyElementisSelected(WebDriver driver,WebElement ele)
						{

							boolean select = ele.isSelected();
							return select;
						}
					
					
					
					

					// Get Size Of The element
					
					public static Dimension GetSizeOfTheElement(WebDriver driver,WebElement ele)
						{

							Dimension sz = ele.getSize();
							return sz;
						}
					
					
					
					
						// Get Tag NAme
					
					public static String GetTagNAme(WebDriver driver,WebElement ele)
						{

							String tName = ele.getTagName();
							return tName;
						}
					
					


					// Get Text Of Element
				
				public static String GetText(WebDriver driver,WebElement ele)
					{

						String tex = ele.getText();
						return tex;
					}
					
					
				
				
					// Submit
					
					// Submit Is uSed  When Button type Attribute is Submit
				
				public static void submit(WebDriver driver,WebElement ele)
					{

						 ele.submit();
					
					}
					
				
				
				
				
				
				
				
				
				// Locators 
				
					public static void FindById(WebDriver driver,String loctr)
						{

							WebElement element =driver.findElement(By.id(loctr));
						}

					
					

					public static void FindByCSS(WebDriver driver,String loctr)
						{

							WebElement element =driver.findElement(By.cssSelector(loctr));
						}
					
					
					
					

					public static void FindByXpath(WebDriver driver,String loctr)
						{

							WebElement element =driver.findElement(By.xpath(loctr));
						}
					
					
					
					
					
					public static void FindByName(WebDriver driver,String loctr)
						{

							WebElement element =driver.findElement(By.name(loctr));
						}
				
					
					
					
					public static void FindByLink(WebDriver driver,String loctr)
						{

							WebElement element =driver.findElement(By.linkText(loctr));
						}
				
				
					
					
					
				
					// Click ON Elements 
					
					public static void ClickById(WebDriver driver,String loctr)
						{

							WebElement element =driver.findElement(By.id(loctr));
							element.click();
						}

					
					

					public static void ClickByCSS(WebDriver driver,String loctr)
						{

							WebElement element =driver.findElement(By.cssSelector(loctr));
							element.click();
						}
					
					
					
					

					public static void ClickXpath(WebDriver driver,String loctr)
						{

							WebElement element =driver.findElement(By.xpath(loctr));
							element.click();
						}
					
					
					
					
					
					public static void ClickName(WebDriver driver,String loctr)
						{

							WebElement element =driver.findElement(By.name(loctr));
							element.click();
						}
				
					
					
					
					public static void ClickLink(WebDriver driver,String loctr)
						{

							WebElement element =driver.findElement(By.linkText(loctr));
							element.click();
						}
				
				
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					// Navigation
					
					public static void Navigatebaack(WebDriver driver)
						{

						driver.navigate().back();
						}
					
					
					
					
					public static void NavigateFoorward(WebDriver driver)
						{

						driver.navigate().forward();
						}
					
					
					
					
					public static void Refreesh(WebDriver driver)
						{

						driver.navigate().refresh();
						}
					
					
					
					
					//****************** Get Height And Width Of An Element ******************//
					
					public static int GetHightOfElement(WebDriver driver,WebElement ele)
						{

							Dimension dimension = ele.getSize();
							
							
							return dimension.getHeight();
						}

				
					public static int GetWidthOfElement(WebDriver driver,WebElement ele)
						{

							Dimension dimension = ele.getSize();
							
							
							return dimension.getWidth();
						}
					
					
					
					
					
					// Cookies Name And Value
					
				
					
					public static void CookiesNameAndVAlue(WebDriver driver)
						{

							Set<Cookie> cookies = driver.manage().getCookies();
						 	int sizeeofCookie =  cookies.size();
						 	System.out.println(sizeeofCookie);
						 	
						 	for (Cookie cookie:cookies)
						 		{
						 			System.out.println(cookie.getName()+" : " + cookie.getValue());
						 		
						 			
						 		}
						}

					
					
					
					
					
					// Cookies Size
					
					public static int CookiesSIZEE(WebDriver driver)
						{

							Set<Cookie> cookies = driver.manage().getCookies();
						 	int sizeeofCookie =  cookies.size();
						 	return sizeeofCookie;
						}
					
					
					
					
					
					
					
					
					
					
					// Get Title
					

					public static String GetTTitle(WebDriver driver)
						{
						 	String title =  driver.getTitle();
						 	return title;
						}
					
					
					
					
					
					
					
					
						// Get CurrentURL
					

					public static String GetTURL(WebDriver driver)
						{
						 	String URL =  driver.getCurrentUrl();
						 	return URL;
						}
					
				
				
					
					
					
					
					
					
					
					
					
				// RadioButton and CheckBox Dynamic
				
				
				
			//	    List<WebElement> radio = driver.findElements(By.xpath("//input[@name='lang' and @type='radio']"));
			 // 	Helper.RadioBDynamic(driver,radio,"RUBY");
				
				
				public static void RadioBDynamic(WebDriver driver, List<WebElement> RB,String Opton)
					{

							 
						 for (int i= 0; i < RB.size(); i++)
						 {
						    WebElement local_rodio = RB.get(i);
						     String value = local_rodio.getAttribute("value");
						     System.out.println("Values from radio buttons are.----->»»" + value);

						     if (value.equalsIgnoreCase(Opton))
						 	{ 
						        local_rodio.click();
						     }
						 }
					}
				
				
				
				
				
				
				
				
				
				
			//	 CheckBox Dynamic
				
				
					//   List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
				 // 	Helper.RadioBDynamic(driver,checkbox,"RUBY");
					
					
					public static void CheckBDynamic(WebDriver driver, List<WebElement> CB,String Opton)
						{

								 
							 for (int i= 0; i < CB.size(); i++)
							 {
							    WebElement local_check = CB.get(i);
							    
							     String id = local_check.getAttribute("id");
							    

							     if (id.equalsIgnoreCase(Opton))
							 	{ 
							 		local_check.click();
							 		break;
							     }
							 }
						}
					
				
					
					
					
					
					
					
					
				
				//  Count Checked Check Boxes
					
					public static int CountCheckedCheckBoxes(WebDriver driver)
						{

							List<WebElement> elements = driver.findElements(By.xpath("//input[@type='checkbox']"));
							
							
							int checkedcount =0;
							 int UNcheckedcount =0;
							  
							 for (int i= 0; i < elements.size(); i++)
								 {
								 
									 if(elements.get(i).isSelected()==true)
										 {
											 checkedcount++;
										 }
									 
									 else
										 {
											 UNcheckedcount++;
										 }
									 
									 
								 }
							 
							 return checkedcount ;
							 
						}
				
					
					
					//  JAVASCRPT METHODS
					
					public static void flash(WebElement element, WebDriver driver) {
				        JavascriptExecutor js = ((JavascriptExecutor) driver);
				        String bgcolor  = element.getCssValue("backgroundColor");
				        for (int i = 0; i <  10; i++) {
				            changeColor("rgb(0,200,0)", element,driver);//1
				            changeColor(bgcolor, element,driver);//2
				        }
				    }
				    public static void changeColor(String color, WebElement element, WebDriver driver) {
				    	JavascriptExecutor js = ((JavascriptExecutor) driver);
				        js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",  element);

				        try {
				            Thread.sleep(20);
				        }  catch (InterruptedException e) {
				        }
				     }
					
					
				    public static void drawBorder(WebElement element, WebDriver driver){
				    	JavascriptExecutor js = ((JavascriptExecutor) driver);
				    	js.executeScript("arguments[0].style.border='3px solid red'", element);
				    }
				    
				    public static void generateAlert(WebDriver driver, String message){
				    	JavascriptExecutor js = ((JavascriptExecutor) driver);
				    	js.executeScript("alert('"+message+"')");

				    }
				    
				    public static void clickElementByJS(WebElement element, WebDriver driver){
				    	JavascriptExecutor js = ((JavascriptExecutor) driver);
				    	js.executeScript("arguments[0].click();", element);
				    	
				    }
					
				    public static void refreshBrowserByJS(WebDriver driver){
				    	JavascriptExecutor js = ((JavascriptExecutor) driver);
				    	js.executeScript("history.go(0)");
				    }
				    
				    public static String getTitleByJS(WebDriver driver){
				    	JavascriptExecutor js = ((JavascriptExecutor) driver);
				    	String title = js.executeScript("return document.title;").toString();
				    	return title;
				    }
				    
				    public static String getPageInnerText(WebDriver driver){
				    	JavascriptExecutor js = ((JavascriptExecutor) driver);
				    	String pageText = js.executeScript("return document.documentElement.innerText;").toString();
				    	return pageText;
				    }
				    
				    public static void scrollPageDown(WebDriver driver){
				    	JavascriptExecutor js = ((JavascriptExecutor) driver);
				    	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				    }
				    
				    public static void scrollIntoView(WebElement element, WebDriver driver){
				    	JavascriptExecutor js = ((JavascriptExecutor) driver);
				    	js.executeScript("arguments[0].scrollIntoView(true);", element);
				    }
				    
					
					
					
					
					//  Count UnChecked Check Boxes
					
					public static int CountUnCheckedCheckBoxes(WebDriver driver)
						{

							List<WebElement> elements = driver.findElements(By.xpath("//input[@type='checkbox']"));
							
							
							int checkedcount =0;
							 int UNcheckedcount =0;
							  
							 for (int i= 0; i < elements.size(); i++)
								 {
								 
									 if(elements.get(i).isSelected()==true)
										 {
											 checkedcount++;
										 }
									 
									 else
										 {
											 UNcheckedcount++;
										 }
									 
									 
								 }
							 
							 return UNcheckedcount ;
							 
						}
				
				
				
					
					
					//  Actions Class
					
					
					
					public static void RightClick() throws AWTException
						{

							Robot r = new Robot();
						 	r.mousePress(InputEvent.BUTTON3_MASK);
						 	r.mouseRelease(InputEvent.BUTTON3_MASK);
						}
					
					
					
				
							// Assert true Method
							
							public static void AssrtTruue(String Title)
								{
					
									Assert.assertTrue(Title.contains("Google"));
								}
							
							
							
							
							
							
							
							
							// Get Title
							
							public static String GeetTiitle(WebDriver driver)
								{
					
									String Title=driver.getTitle();
									return Title;
								}
							
		
		
							
							
								// Clear
							//     WebElement element = driver.findElement(By.id(loctr));
							
							
							public static void  GeetTiitle(WebDriver driver,WebElement element)
								{
					
								
									element.clear();
								}
		
		
		
							public static String getScreenshot(WebDriver driver)
								{
									TakesScreenshot ts=(TakesScreenshot) driver;
									
									File src=ts.getScreenshotAs(OutputType.FILE);
									
									String path=System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";
									
									File destination=new File(path);
									
									try 
									{
										 FileHandler.copy(src, destination);
									} catch (IOException e) 
									{
										System.out.println("Capture Failed "+e.getMessage());
									}
									
									return path;
								}
							
							
							
							
							// Screenshot  with Destination
							
							
							
							public static String takeScreenshot(WebDriver driver, String fileName) throws IOException {
								fileName = fileName + ".png";
								String directory = "D:\\ScreenSHoots";
								File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
								 FileHandler.copy(sourceFile, new File(directory + fileName));
								String destination = directory + fileName;
								return destination;
							}
							
							
							// Screenshot ONLY		
							
							public static void captureScreenShot(WebDriver driver)
								{
									try 
										{
											TakesScreenshot ts = (TakesScreenshot)driver;
								
											File src= ts.getScreenshotAs(OutputType.FILE);
									
								
											 FileHandler.copy(src, new File("C:/selenium/error.png"));
									
											
											System.out.println(" SceenShot Taken ");
										
										}
									 
									catch (IOException e)
									 {
										 System.out.println(e.getMessage());
									 
									 }
									
								 }
							
		
		
							// screenShot Of Specific element
							
							// "test.jpeg"
							
							
							public static void ScreenshotOfElement(WebDriver driver,WebElement ele,String Namee) throws IOException
								{

									
								 	 File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
								 	 
								 	 BufferedImage fullImage = ImageIO.read(screenshot);
								 	 
								 	 Point point =ele.getLocation();
								 	 
								 	 int eleWid =ele.getSize().getWidth();
								 	 int eleHight =ele.getSize().getHeight();
								 	
								 	BufferedImage eleScreenshot =fullImage.getSubimage(point.getX(), point.getY(),eleWid, eleHight);
								 	
								 	ImageIO.write(eleScreenshot, "Png", screenshot);
								 	
								 	FileHandler.copy(screenshot,new File(Namee));
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
		
		
					
					// Page Source
					
					
					
					public static String GetPageSource(WebDriver driver)
						{
			
							String pagesource = driver.getPageSource();
							return pagesource;
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
					
					
					// Page Source In Text File
					// String filee = "D://pagesource.txt";
					
					
					public static void GetPageSourceINTextFile(WebDriver driver,String filee)
						{
			
							String pagesource = driver.getPageSource();
							
							try
								{
									
									File newtextfFile = new File(filee);
									FileWriter fw = new FileWriter(newtextfFile);
									
									fw.write(pagesource);
									fw.close();
								}
							
							catch(Exception e)
								{
									System.out.println(e);
								}
						}
					
					
					
					
					// Get  All Elements
					
					public static void GetAllElements(WebDriver driver)
						{

							List<WebElement> elements = driver.findElements(By.xpath("//*"));
						 	System.out.println(" No Of elements " + elements.size());
						 	System.out.println("-------------------------------------------------");
						 	for(WebElement el:elements)
						 		{
						 							
						 			System.out.println(el.getTagName() + " : " + el.getText());
						 				
						 		}
						}
					
					
					
					
					//  All Images Link
					
					
					
					public static void ImagesAllLinks(WebDriver driver)
						{

							List<WebElement> listImages = driver.findElements(By.tagName("img"));
						 	System.out.println(" No Of Images " + listImages.size());
						 	
						 	for(int i=0;i<listImages.size();i++)
						 		{
						 			
						 				if(!(listImages.get(i).getAttribute("src").equals(""))&& !(listImages.get(i).getAttribute("src")== null))
						 						{
						 							
						 							System.out.println(listImages.get(i).getAttribute("src"));
						 							
						 							
						 						}
						 			
						 		}
						}
					
					
					
					
					
					
					
					//  All Images Link IN Text File
					// String filee = "D://ImagesLinks.txt";
					
					public static void GetAllIMAGESLinksInTextFile(WebDriver driver, String filee) throws IOException
						{

							List<String> Hyperlinks = new ArrayList<String>();
							List<WebElement> listImages = driver.findElements(By.tagName("img"));
						
							for(WebElement ele:listImages)
								{
									if(!(ele.getAttribute("src").equals(""))&& !(ele.getAttribute("src")== null))
										{
											String link =ele.getAttribute("src");
											Hyperlinks.add(link);
										}
								}
							

							File newtextfFile = new File(filee);
							FileWriter fw = new FileWriter(newtextfFile);
							
							
							if(Files.exists(Paths.get(filee))) 
							{ 
							      
								  fw.write( "\r\n" + " Total Number Of Images Links Found : "+ Hyperlinks.size());
								  fw.write( "\r\n" + "-------------------------------------------------");
							      for(String link:Hyperlinks)
							    	  {
							    		  
							    		  fw.write( "\r\n" + link);
							    	  }
							      
							  	fw.close();
							}
						}
					
					
					

					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					// Get  All Links 
					// String filee = "D://links.txt"
					
					
					
					public static void GetAllLinks(WebDriver driver)
						{

							List<WebElement> links = driver.findElements(By.tagName("a"));
							for(WebElement ele:links)
							System.out.println(ele.getAttribute("href"));
						
						}
					
					
					
					
					
					
					
					// Get All Links in Text File

					// String filee = "D://linkss.txt";
					// Change the File Name Each time
					
					public static void GetALLLinks(WebDriver driver, String filee) throws IOException
						{

							List<String> Hyperlinks = new ArrayList<String>();
						 	
						 	
							for(WebElement ele:driver.findElements(By.tagName("a")))
								{
									
									String link =ele.getAttribute("href");
									Hyperlinks.add(link);
									
								}
							

							File newtextfFile = new File(filee);
							FileWriter fw = new FileWriter(newtextfFile);
							
							
							if(Files.exists(Paths.get(filee))) 
							{ 
							      
								  fw.write( "\r\n" + " Total Number Of Links Found : "+ Hyperlinks.size());
								  fw.write( "\r\n" + "-------------------------------------------------");
							      for(String link:Hyperlinks)
							    	  {
							    		  
							    		  fw.write( "\r\n" + link);
							    	  }
							      
							  	fw.close();
							}
						}
					
					
					
					
					
					
					
					
					//  Get All Buttons
					

					public static void GetAllButtons(WebDriver driver)
						{
							

							List<WebElement> listButton = driver.findElements(By.xpath("//Button"));
						//	List<WebElement> listButton = driver.findElements(By.tagName("button"));
							
							
						 	System.out.println(" No Of Buttons " + listButton.size());
						 	
						 	for(WebElement ele:listButton)
						 		{
						 							
						 		System.out.println(ele.getText() +" : " + ele.getAttribute("type"));
						 		
						 		}
						}
					
					
					
					
					//  Get All Radio Buttons
					
					public static void GetTotalRadioButtons(WebDriver driver)
						{
							

							List<WebElement> listButton = driver.findElements(By.xpath("//input[@type='radio']"));
					
							
							
						 	System.out.println(" No Of Radio Buttons " + listButton.size());
						 	
						 	for(WebElement ele:listButton)
						 		{
						 							
						 		System.out.println(ele.getText() +" : " + ele.getAttribute("type"));
						 		
						 		}
						}
					
					
					
				
					
					
					
					
					//  Get All Text Boxes
					
					
					
					public static void GetALLTextBoxes(WebDriver driver)
						{
							

							List<WebElement> listButton = driver.findElements(By.xpath("//input[@type='text']"));
					
							
							
						 	System.out.println(" No Of TextBoxes " + listButton.size());
						 	
						 	for(WebElement ele:listButton)
						 		{
						 							
						 		System.out.println(ele.getText() +" : " + ele.getAttribute("type"));
						 		
						 		}
						}
					
					
					
					
					
					
					
					
					//  Get All Text CheckBoxes
					
					public static void GetALLCheckBoxes(WebDriver driver)
						{
							

							List<WebElement> listButton = driver.findElements(By.xpath("//input[@type='checkbox']"));
					
							
							
						 	System.out.println(" No Of checkboxes " + listButton.size());
						 	
						 	for(WebElement ele:listButton)
						 		{
						 							
						 		System.out.println(ele.getText() +" : " + ele.getAttribute("type"));
						 		
						 		}
						}
					
					
					
					
					
					
					// Select All check Boxes
					
					public static void SelectAllCheckBoxes(WebDriver driver)
						{

							List<WebElement> listcheck = driver.findElements(By.xpath("//input[@type='checkbox']"));
							
							for(WebElement ele:listcheck)
								{
									
									ele.click();
									
								}
						}

					
					
					
					
					
					//  Get All iframe
					
					public static void GetTotalIFRAME(WebDriver driver)
						{
							

							List<WebElement> iframe = driver.findElements(By.tagName("iframe"));
						
							
							
						 	System.out.println(" No Of IFRAME " + iframe.size());
						 	
						 	for(WebElement ele:iframe)
						 		{
						 							
						 		System.out.println(ele.getText() +" : " + ele.getAttribute("type"));
						 		
						 		}
						}
					
					
					
					
					
					
					
					// Switch to Main Frame
					
					public static void SwitchToMainnFrame(WebDriver driver)
						{

							driver.switchTo().defaultContent();
						}
					
					
					
					
					
					
					
					//  Get All DropDown
					
					public static void GetAllDropDown(WebDriver driver)
						{
							

							List<WebElement> iframe = driver.findElements(By.tagName("select"));
						
							
							
						 	System.out.println(" No Of Dropdown " + iframe.size());
						 	
						 	for(WebElement ele:iframe)
						 		{
						 							
						 		System.out.println(ele.getText() +" : " + ele.getAttribute("type"));
						 		
						 		}
						}
					
					
					
					
					
					// String filee = "D://links.txt";
					// Change the File Name Each time
					
					public static void GetAllLinksInTextFile(WebDriver driver, String filee)
						{

							
							List<WebElement> links = driver.findElements(By.tagName("a"));
							
							try
								{
									
									File newtextfFile = new File(filee);
									FileWriter fw = new FileWriter(newtextfFile);
									
									for(WebElement ele:links)
									
									fw.write(ele.getAttribute("href"));
									fw.close();
								}
							
							catch(Exception e)
								{
									System.out.println(e);
								}
							
							
							
						}
					
					
					
					
					
					
					
					
					
					// Verify Text present In Page
					
					 //	boolean result1 = VerifytextPresentInPagee(driver,text);
					 //	Assert.assertTrue(result1, "Page Contains The Text ");
					 	
						public static boolean VerifytextPresentInPagee(WebDriver driver,String text)
							{

								boolean	result2;
							 	
							 	if (driver.getPageSource().contains(text))
							 		{
							 			result2 =true;
							 			return result2;
							 		}
							 	
							 	else
							 		{ result2 = false;
							 		
							 		return result2;
							 		}
							}

					
			
						
						
						// Verify Page Is Ready Or Not
					
						public static String PagereadyOrNOt(WebDriver driver)
							{

								JavascriptExecutor js = (JavascriptExecutor)driver;
								String ready = (String)js.executeScript("return document.readyState");
								return ready;
							}

					
						public static String LastModifyDateOfWebPage(WebDriver driver)
							{

								JavascriptExecutor js = (JavascriptExecutor)driver;
								String state = (String)js.executeScript("return document.lastModified");
								return state;
							}
					
					
					// Maximize Window
					
					
					
					public static void MaximizeWindow(WebDriver driver)
						{
			
							driver.manage().window().maximize();
						}
					
					
					
					
					// Full Screen
					
					public static void FullScreeenWindow(WebDriver driver)
						{
			
							driver.manage().window().fullscreen();
						}
					
					
					
					
					
						// Scroll to Bottom
					
						public static void ScrollToBottom(WebDriver driver)
						{
			
							JavascriptExecutor js = (JavascriptExecutor)driver;
							js.executeScript("scrollBy(0,2500)");
						}
					
					
					
						
							// Get Window Size
						
							public static Dimension GetWindowSiZZE(WebDriver driver)
							{
				
								Dimension WSize = driver.manage().window().getSize();
								return WSize;
							}
					
					
					
						
					
							// Set Window Size
						
							public static void SettWindowwSize(WebDriver driver,int x, int y)
								{
			
									
									driver.manage().window().setSize(new Dimension(x,y));
								}
			
							
							
							
							// Get Window Position
							
							public static Point GetWindowwPosition(WebDriver driver)
								{
			
								
									Point point =driver.manage().window().getPosition();
									
									return point;
								}
							
							
							
							
							
							// Set Window Position
							
							public static void SettWindowwPosition(WebDriver driver,int x, int y)
								{
			
								
									driver.manage().window().setPosition(new Point(x,y));
								}
							
							
							
					
							
							
							
							
							//***********************  Window Handles ****************************//
							
							
							
							/*
								ArrayList<String> newWin = new ArrayList<String>(driver.getWindowHandles());
			 					driver.switchTo().window(newWin.get(1));
			 					driver.switchTo().window(newWin.get(0));
							
							
							*/
							
							
							
							public static int NumberOfWindowsOpen(WebDriver driver)
								{

									return driver.getWindowHandles().size();
								}


							public static void GetWindowHandles(WebDriver driver)
								{

									for(String window:driver.getWindowHandles())
										{
											System.out.println(window);
											
										}
								}
							
							
							
							
							
							
							
							
							
							
							
							// Explicit Wait
							
							public static void ExpliWait(WebDriver driver,int secc)
								{
			
									WebDriverWait wait=new WebDriverWait(driver,secc);
					 
								 		// Wait till the element is not visible
					 
								 	WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("ur xpath here")));
								}
							
							
							
							public static void ExplicitWait2(WebDriver driver,int sec, String Title)
								{

									WebDriverWait wait = new WebDriverWait(driver,10);
									
									wait.until(ExpectedConditions.titleContains(Title));
								}
							
							
							
							
							
							
							
							
							// IMplicit Wait
							
							public static void ImpliWait(WebDriver driver,int secc)
								{
									driver.manage().timeouts().implicitlyWait(secc, TimeUnit.SECONDS);
									
									
								}
							
			
			
							
							// Alert  Accept, Dismiss, GetText
							
							public static void AcceeptAlert(WebDriver driver)
								{

									Alert alt = driver.switchTo().alert();
								 	alt.accept();
								}

							
							public static void DismiiissAlert(WebDriver driver)
								{

									Alert alt = driver.switchTo().alert();
								 	alt.dismiss();
								}


							public static String AlertTexxt(WebDriver driver)
								{

									Alert alt = driver.switchTo().alert();
								 	String txt =alt.getText();
								 	return txt;
								}

							
							public static void AlertSendKeeys(WebDriver driver,String MSG)
								{

									driver.switchTo().alert().sendKeys(MSG);
								}

							
							
							//  Verify Alert Is Present
							
							public static boolean isAlertPresentt(WebDriver driver)
							{
								try
									{
										 driver.switchTo().alert();

											return true;
									}
								
								catch(NoAlertPresentException ex)
								{
									
									 return false ;
								}
								
								
								
							}
							
							
							
					
							
							
							
							// Scroll To Element
							
							
							
							 //	WebElement element1 = driver.findElement(By.xpath(".//*[@id='mCSB_3_container']/p[3]"));
						 	
							 //	ScrollToElement(driver, element1);
								
								public static void ScrollToElement(WebDriver driver, WebElement element)
									{
			
										JavascriptExecutor je = (JavascriptExecutor) driver;
									 	 
									 	
							
									 	je.executeScript("arguments[0].scrollIntoView(true);",element);
									}
							
							
							
								
								
								
								
								
							
							// Scroll By Pixel
								
								public static void ScrollByPixel(WebDriver driver)
									{
			
										JavascriptExecutor js = (JavascriptExecutor)driver;
									 	js.executeScript("scrollBy(0,2500)");
									}
			
						
								
								
								
								
								
								
							//  File Upload
								
								
								// String filepath ="D:\\Test\\Fileupload.exe";
								
								public static void fileuppload(String filepath) throws IOException, Exception
									{

										Runtime.getRuntime().exec(filepath);
									 	Thread.sleep(6000);
									}
					
					
								
								
								
					
					
					//  Hover And Click
								
								public static void HoverandCLick(WebDriver driver,WebElement ele,WebElement ele2)
									{

										Actions act = new Actions(driver);

									 	act.moveToElement(ele).build().perform();
									 	
									 	act.moveToElement(ele2).click().perform();
									}
					
								
								
								
								
								
								
						//  Drag AND Drop
								
								public static void DragandDrop(WebDriver driver,WebElement ele,WebElement ele2)
									{

										Actions act = new Actions(driver);

									 	act.dragAndDrop(ele, ele2).build().perform();
									 	
									 
									}
								
								
								
								
								
									//  Drag AND Drop BY OFF Set
								
								public static void DragandDrop(WebDriver driver,WebElement ele,int x, int y)
									{

										Actions act = new Actions(driver);

									 	act.dragAndDropBy(ele, x, y).build().perform();
									 	
									 
									}
								
								
								
								
						//  Click BY OFF SEt
								
								public static void ClickByOffSEt(WebDriver driver,int x,int y)
									{

										Actions act = new Actions(driver);

									 	act.moveByOffset(x,y).contextClick().build().perform();
									 	
									 
									}
						
								
								
								
								
								
								
								
								// Click Hold AND Release
								
								
								public static void ClickHoldANDRelease(WebDriver driver,WebElement ele,WebElement ele2)
									{

										Actions act = new Actions(driver);

									 	act.moveToElement(ele).clickAndHold().moveToElement(ele2).release().build().perform();
									 	
									 
									}
								
								
								
								
								
								
								
								
					// Hover Over Element
					
					
								public static void HoverOvEr(WebDriver driver,WebElement ele)
									{

										Actions act = new Actions(driver);

									 	act.moveToElement(ele).build().perform();
									 	
									
									}
								
								
								
								
								
								
								
								// Element is not ClicKable			
								
								public static void NotCLickableElement(WebDriver driver,WebElement ele)
									{

										Actions act = new Actions(driver);

									 	act.moveToElement(ele).click().build().perform();
									 	
									 	
									}
								
								
								
								
								
								
								// 	double Click On ELement
								
								public static void DoubleClick(WebDriver driver, WebElement ele)
								{


									Actions act = new Actions(driver);

								 	act.moveToElement(ele).doubleClick().perform();
												 	
								}		
								
								
								
								
								
								
								
								
				// 	Get X  Coordinates
								
					public static int getXCoordinate(WebDriver driver,WebElement ele)
					{

						int x = ele.getLocation().getX();
						return x;
									 	
									 	
					}			
								
						
					
					
					
					// New Tab
					
					 public static void NewTab(WebDriver driver)
						{

							((JavascriptExecutor)driver).executeScript("window.open()");
						}
					
					
					
					 
					  // Page Load Time OUT
						
						// Amount of time Want To Wait  Before Loading The Web Page
						
						public static void PageLoTIOUT(WebDriver driver,int secc)
							{

								driver.manage().timeouts().pageLoadTimeout(secc, TimeUnit.SECONDS);
							}
					 
					 
					 
					
					
					
					// 	Get Y Coordinates
					
					public static int getYCoordinate(WebDriver driver, WebElement ele)
					{

						int y = ele.getLocation().getY();
						return y;
									 	
									 	
					}			
					
					
					
					
					
					// Get Date and Time
					
					public static String GetDateTime()
						{

							DateFormat df = new SimpleDateFormat("yyyy_MMM_dd HH_MM_SS");
						 	Date d = new Date();
						 	
						 	String time = df.format(d);
						 	return time;
						}

					
					
					
					
					
					
					
					// Get Page Load Time
					
					public static double GetPageLoadTime(WebDriver driver,String URL)
						{

							double start = System.currentTimeMillis();
						 	driver.get(URL);
						 	
						 	double finish = System.currentTimeMillis();
						 	
						 	double totalTime = (finish-start)/1000;  //  To get the time In Seconds / 1000
						 	return totalTime;
						 	
						}
					
					
						
					
					
					
		
	}
