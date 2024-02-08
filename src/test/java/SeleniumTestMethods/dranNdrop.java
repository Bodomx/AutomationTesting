package SeleniumTestMethods;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Central.Controller;

public class dranNdrop extends Controller {

	
	@Test(priority =0)
	public void draganddrop() throws InterruptedException {
	  String URL = "https://demoqa.com/droppable/";
	  driver.get(URL);
	
	
	
	//Actions class method to drag and drop 
	
	Actions builder = new Actions(driver);
	WebElement from = driver.findElement(By.id("draggable"));//source
	WebElement to = driver.findElement(By.id("droppable")); //target
	
	
	
	//Perform drag and drop
	builder.dragAndDrop(from, to).build().perform();
	
	Thread.sleep(2000);
	//verify text changed in to 'Drop here' box 
	
	 
	String textTo = to.getText();
	
	if(textTo.equals("Dropped!")) {
	System.out.println("PASS: File is dropped to target as expected");
	}else {
	System.out.println("FAIL: File couldn't be dropped to target as expected");
	}
	
	
	//driver.close();
	
}
}
