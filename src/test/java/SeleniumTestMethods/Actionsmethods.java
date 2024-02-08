package SeleniumTestMethods;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import Central.Controller;

public class Actionsmethods extends Controller {
	
	@Test(priority = 0)
	public void actionset1() throws InterruptedException {
		
	   driver.get("https://rahulshettyacademy.com/dropdownsPractise/");Thread.sleep(1000);
		
		//driver.get("http://spicejet.com");
		
		driver.navigate().refresh(); Thread.sleep(1000); // refresh page

		driver.manage().window().maximize(); Thread.sleep(1000); // maximize window

		driver.manage().deleteAllCookies(); Thread.sleep(1000); // delete all cookies

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); // page load timeout

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // implicit wait

		Ex = new WebDriverWait(driver, 30); // explicit wait
		
		driver.findElement(By.id("divpaxinfo")).click(); Thread.sleep(1000);
		
		WebElement addup1 = driver.findElement(By.id("hrefIncAdt")); // the plus buton for adults
		
		 Actions action1 = new Actions(driver);
		 
		 Action seriesOfActions1 = action1.moveToElement(addup1).click().build();// 
		
		addup1 = Ex.until(ExpectedConditions.presenceOfElementLocated(By.id("hrefIncAdt")));
		 
		for(int i=1;i<10;i++)   // Execute Line for 9 times
			   {
			   seriesOfActions1.perform(); Thread.sleep(1000);
			   } 
		  
		int j=1;
		while(j<10){
			
		driver.findElement(By.id("hrefIncChd")).click(); Thread.sleep(1000); // using xpath or findElement scripting click 8 times
		j++;
		}
	}
			 	 
			 
	
	@Test(priority = 1)
	public void actionset2() throws InterruptedException {
	
	            //driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		 
		 //driver.findElement(By.id("divpaxinfo")).click();
		 
		 System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		 
		 Thread.sleep(1000);
		 
		 WebElement substract = driver.findElement(By.id("hrefDecAdt")); // the plus buton for adults
		 
		 Actions action = new Actions(driver);
		 
		 Action seriesOfActions = action.moveToElement(substract).click().build();// 
			
		//seriesOfActions.perform();
		 
			for(int i=1;i<5;i++)

			{

			
				seriesOfActions.perform();// Using mouse actions 

			}
		          driver.findElement(By.id("btnclosepaxoption"));

			AssertJUnit.assertEquals(driver.findElement(By.id("divpaxinfo")).getText() ,"5 Adult");

			System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
			
			WebElement search = driver.findElement(By.id("autosuggest"));
			
			Action seriesOfActions2 = action.moveToElement(search).click().sendKeys("Bang").sendKeys(Keys.ARROW_DOWN).build();
			
			seriesOfActions2.perform();
			
	}
	@Test(priority = 3)
	  public void actionbuilder() {
		  String baseUrl = "http://www.facebook.com/";
		  

		  driver.get(baseUrl);
		  WebElement txtUsername = driver.findElement(By.id("email"));

		  Actions builder = new Actions(driver);
		  Action seriesOfActions = builder
		  .moveToElement(txtUsername)
		  .click()
		  .keyDown(txtUsername, Keys.SHIFT)
		  .sendKeys(txtUsername, "hello")
		  .keyUp(txtUsername, Keys.SHIFT)
		  .doubleClick(txtUsername)
		  .contextClick()
		  .build();
		  for(int i=1;i<5;i++)

			{

			
			  seriesOfActions.perform() ;// Using mouse actions 

			}
		  
		  }
}
