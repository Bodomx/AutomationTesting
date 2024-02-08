package SeleniumTestMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import Central.Controller;

public class ToolTip extends Controller {
@Test(priority = 0)
	public void tooltip1() throws InterruptedException {
	
		
		//http://demo.guru99.com/test/tooltip.html
		//https://demoqa.com/automation-practice-form
		//http://webdriveruniversity.com/index.html
		//https://www.phptravels.net/
		
	
		
		
		driver.get("https://jqueryui.com/tooltip/");
		
		//WebElement iframe1 = driver.findElement(By.xpath("//iframe[@src='/resources/demos/tooltip/default.html']"));
		//iframe1.click();
		driver.switchTo().frame(0); 
		
		WebElement company = driver.findElement(By.xpath("//*[@id='age']"));
		
		Actions perform = new Actions(driver);
		
		WebElement contact = driver.findElement(By.xpath(".//a[@href='https://www.phptravels.net/about-us']"));
		Thread.sleep(2000);
		
		
		perform.moveToElement(company).build().perform();
		
		Ex.until(ExpectedConditions.visibilityOf(company));
		perform.moveToElement(company).click().build().perform();
		
		
        String expectedTooltip = "We ask for your age only for statistical purposes.";	
        		
        

         //get the value of the "title" attribute of the contact icon		
        String actualTooltip = company.getAttribute("title");	
        
        //Assert the tooltip's value is as expected 		
       System.out.println("Actual Title of Tool Tip"+actualTooltip);							
       if(actualTooltip.equals(expectedTooltip)) {							
            System.out.println("Test Case Passed");					
        }		
        //driver.close();	
	}
}
