package SeleniumTestMethods;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Central.Controller;

public class Alerts extends Controller {

	
	@Test(priority = 0)
	public void alerts() throws InterruptedException {
		// TODO Auto-generated method stub
		

		//WebDriver driver = new ChromeDriver();

		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\jzo_0\\eclipse-workspace\\alertPractice\\chromedriver-windows.exe");
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("name")).click();

		driver.findElement(By.id("name")).sendKeys("Ra");

		driver.findElement(By.cssSelector("[id='alertbtn']")).click();
		
		Thread.sleep(3000);

		System.out.println(driver.switchTo().alert().getText());

		driver.switchTo().alert().accept();

		driver.findElement(By.id("confirmbtn")).click();

		System.out.println(driver.switchTo().alert().getText());
		
		driver.switchTo().alert().accept();
	}
	
	
	@Test(priority = 1)
	
	public void alerts2() throws InterruptedException{
		
		driver.get("C:\\Tools\\workspace1\\Aut_Practice_April_2023\\Frames\\Alert.html");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/button[1]")).click();
	    Thread.sleep(2000);
	    driver.switchTo().alert().accept();
	}
}
