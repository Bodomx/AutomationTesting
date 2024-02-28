package SeleniumTestMethods;

import static org.testng.Assert.fail; // Importing fail method from TestNG

import org.openqa.selenium.By; // Importing By class from Selenium
import org.openqa.selenium.JavascriptExecutor; // Importing JavascriptExecutor class from Selenium
import org.openqa.selenium.Keys; // Importing Keys class from Selenium
import org.testng.annotations.Test; // Importing Test annotation from TestNG

import Pages.Controler; // Importing Controler class from Pages package

public class autosuggest extends Controler { // Class autosuggest extending Controler class

 @Test // Test annotation
 public void autosuggest3() throws Exception { // Method autosuggest3 which throws Exception

  autosuggest auto = new autosuggest(); // Creating an instance of autosuggest class

 auto.suggestions(); // Calling suggestions method
 }
 public void suggestions() throws Exception { // Method suggestions which throws Exception
  driver.get("http://www.etsy.com/"); // Navigating to the URL
  Thread.sleep(2000); // Pausing the execution for 2 seconds
  driver.findElement(By.xpath("//*[@id='global-enhancements-search-query']")).sendKeys("Drill"); // Sending keys "Drill" to the element
  driver.findElement(By.xpath("//*[@id='gnav-search']/div/div[1]/button[2]")).sendKeys(Keys.DOWN); // Sending DOWN key to the element
  String text = driver.findElement(By.xpath("//*[@id='global-enhancements-search-query']")).getText(); // Getting the text of the element

  System.out.println("Text is"+text); // Printing the text
  Thread.sleep(2000); // Pausing the execution for 2 seconds

  String str = "return document.getElementById(\"search\").value;"; // JavaScript to get the value of the element with id "search"
  String item = (String) js.executeScript(str); // Executing the JavaScript
  System.out.println(item); // Printing the item
  int i=0; // Initializing counter
  while(!item.contains("drill holder")){ // Loop until item contains "drill holder"
    i++; // Incrementing the counter
    driver.findElement(By.xpath("//*[@id='global-enhancements-search-query']")).sendKeys(Keys.DOWN); // Sending DOWN key to the element
    Thread.sleep(1000); // Pausing the execution for 1 second
    item = (String) js.executeScript(str); // Executing the JavaScript
    System.out.println(item); // Printing the item
    if(i>15){ // If counter is more than 15
    break; // Break the loop
    }
    }
    if(i>15){ // If counter is more than 15
    System.out.println("Item not found."); // Print "Item not found."
    fail ("Desired item not found."); // Fail the test with message "Desired item not found."
    }else{
    System.out.println("Desire item found."); // Print "Desire item found."
    }
    driver.findElement(By.xpath("//*[@id='global-enhancements-search-query']")).sendKeys(Keys.TAB); // Sending TAB key to the element
    driver.findElement(By.xpath("//*[@id='gnav-search']/div/div[1]/button[2]")).click(); // Clicking on the element
 }

}