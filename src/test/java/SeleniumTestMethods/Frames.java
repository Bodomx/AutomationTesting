package SeleniumTestMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Central.Controller;

public class Frames extends Controller {
	public void frames1() throws InterruptedException {
		// TODO Auto-generated method stub
		//WebDriver driver;		   
		   
	    // driver = new ChromeDriver();
	       
		// System.setProperty("webdriver.chrome.driver", "chromedriver-windows.exe");

		 
		 
		 String url1 = "file:///C:/Tools/Frames/framenested2.htm";	
		 
		 driver.get(url1);Thread.sleep(2000);
		 
		// driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		 
		 //driver.switchTo().frame(0); // By Index number ---- Rule 1
		 
		 
		 driver.switchTo().frame("iframe3"); // By name or Id Attribute value..----- Rule 2
		 Thread.sleep(2000);
		
		 
		 //driver.switchTo().frame("iframe1"); // By WebElement first we switch to frame --- Rule 2 + Rule 3 --- this is the child frame --index 0
		 
		 //driver.switchTo().frame("iframe2"); //index 1
		 
		// driver.switchTo().frame("iframe3");// index 2
		 
		// ArrayList <String> frames = new ArrayList <String>();
		// frames.add("driver.switchTo().frame(\"iframe2\")");
		  // then we write the xpath---Rule 3
		// System.out.printf(frames.get(0));
		 
		 
		 driver.findElement(By.name("userName")).sendKeys("javid");Thread.sleep(2000);
		 
		 driver.findElement(By.name("usePwd")).sendKeys("javid");
		 
		 //driver.switchTo().defaultContent();      // ---- this is rule  2
		 
		 driver.switchTo().parentFrame();  //---- this is the parent frame -- rule 1 ---
		 //driver.switchTo().parentFrame(); // --- this going back to iframe1
		 Thread.sleep(2000);
		 
		 WebElement Login = driver.findElement(By.xpath("//button[@name='Login']"));
		 
		 Login.click();Thread.sleep(2000);
		 
		 Login.isDisplayed();Thread.sleep(2000);  // will give us true or false answer
		 
		 System.out.println(driver.getCurrentUrl());
		 
	}

}
