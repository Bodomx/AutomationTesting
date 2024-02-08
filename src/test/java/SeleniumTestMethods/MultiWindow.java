package SeleniumTestMethods;

import java.util.ArrayList;

import org.testng.annotations.Test;

import Central.Controller;

public class MultiWindow extends Controller{
	@Test(priority = 0)
	public void multiwindow() throws InterruptedException {
			
		//WebDriver driver;
		        
				//driver = new ChromeDriver();
			              
					 //System.setProperty("webdriver.chrome.driver", "C:\\Users\\jzo_0\\eclipse-workspace\\HandleWindows\\chromedriver-windows.exe");
	
					 //Execution of the Command  				//Location of the file\\
					 

						//JavascriptExecutor js = (JavascriptExecutor) driver;

						driver.get("https://www.rahulshettyacademy.com/AutomationPractice/"); Thread.sleep(1000L);// index number 0
						js.executeScript("window.open('http://www.practiceselenium.com/')"); Thread.sleep(1000L);//  7
						js.executeScript("window.open('http://spicejet.com/')"); Thread.sleep(1000L);//  6         
					    js.executeScript("window.open('https://rahulshettyacademy.com/dropdownsPractise/')");Thread.sleep(1000L); // 5
						js.executeScript("window.open('https://demoqa.com/sortable')");Thread.sleep(1000L); // 4
						js.executeScript("window.open('http://www.way2automation.com/demo.html')");Thread.sleep(1000L); // 3
						js.executeScript("window.open('https://phptravels.com/demo/')");Thread.sleep(1000L); // 2
						js.executeScript("window.open('https://jqueryui.com/demos/')");Thread.sleep(1000L); // 1 
						
					//ARRAY LISTS OF TABS 
							ArrayList<String> tabs1	= 	new ArrayList<String>(driver.getWindowHandles()); 
							driver.switchTo().window(tabs1.get(0));Thread.sleep(20000);		
							driver.switchTo().window(tabs1.get(7));Thread.sleep(10000);
							driver.switchTo().window(tabs1.get(6));Thread.sleep(10000);
							driver.switchTo().window(tabs1.get(5));Thread.sleep(10000);
							driver.switchTo().window(tabs1.get(4));Thread.sleep(10000);
							driver.switchTo().window(tabs1.get(3));Thread.sleep(10000);
							driver.switchTo().window(tabs1.get(2));Thread.sleep(10000);
							driver.switchTo().window(tabs1.get(1));Thread.sleep(10000);
					 System.out.println(tabs1);
	}

}
