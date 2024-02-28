package SeleniumTestMethods;

import org.openqa.selenium.By; // Importing By class from Selenium
import org.testng.annotations.Test; // Importing Test annotation from TestNG

import Pages.Controler; // Importing Controler class from Pages package

public class Alerts extends Controler { // Class Alerts extending Controler class

 @Test(priority = 0) // Test annotation with priority 0
 public void alerts() throws InterruptedException { // Method alerts which throws InterruptedException

  driver.get("https://rahulshettyacademy.com/AutomationPractice/"); // Navigating to the URL

  driver.findElement(By.id("name")).click(); // Clicking on the element with id "name"

  driver.findElement(By.id("name")).sendKeys("Ra"); // Sending keys "Ra" to the element with id "name"

  driver.findElement(By.cssSelector("[id='alertbtn']")).click(); // Clicking on the element with id "alertbtn"

  Thread.sleep(3000); // Pausing the execution for 3 seconds

  System.out.println(driver.switchTo().alert().getText()); // Printing the text of the alert

  driver.switchTo().alert().accept(); // Accepting the alert

  driver.findElement(By.id("confirmbtn")).click(); // Clicking on the element with id "confirmbtn"

  System.out.println(driver.switchTo().alert().getText()); // Printing the text of the alert

  driver.switchTo().alert().accept(); // Accepting the alert
 }


 @Test(priority = 1) // Test annotation with priority 1
 public void alerts2() throws InterruptedException{ // Method alerts2 which throws InterruptedException

  driver.get("C:\\Tools\\workspace1\\Aut_Practice_April_2023\\Frames\\Alert.html"); // Navigating to the local file
  Thread.sleep(2000); // Pausing the execution for 2 seconds
  driver.findElement(By.xpath("/html/body/button[1]")).click(); // Clicking on the first button in the body
  Thread.sleep(2000); // Pausing the execution for 2 seconds
  driver.switchTo().alert().accept(); // Accepting the alert
 }
}