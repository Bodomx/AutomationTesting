package RunTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LaunchBrowser {
	public static WebDriver driver;
   @Test 
	public static void Launch() throws InterruptedException {

        // Set the path to the chromedriver executable
    	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\larry\\Tools\\Automation_Batch_2023_April\\workspace1\\Aut_Practice_April_2023\\src\\SeleniumTestMethods\\chromedriver.exe");

        // Initialize browser
    	driver = new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        // Open website
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //Thread.sleep(2000);
        
     // Create new WebDriverWait
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
 
        // Wait for the Google Search button to be clickable
        WebElement radioButton = wait.until(
            ExpectedConditions.elementToBeClickable(By.name("radioButton"))
        );
        
        //Find the element & click
        driver.findElement(By.name("radioButton")).click();
        
        wait.until(
                ExpectedConditions.elementSelectionStateToBe(radioButton, true)
                );
        
        driver.findElement(By.xpath("//*[@id='radio-btn-example']/fieldset/label[2]/input")).click();
        Thread.sleep(2000);
        // Close browser
        
        
        driver.findElement(By.xpath("//*[@id='autocomplete']")).sendKeys("Larry");
        
        wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='autocomplete']"))
                );
        Thread.sleep(2000);
        WebElement DropDownbutton = driver.findElement(By.xpath("//*[@id='dropdown-class-example']"));
        DropDownbutton.click();
        Select sinput = new Select(DropDownbutton);
        Thread.sleep(2000);
        sinput.selectByIndex(3);
        Thread.sleep(2000);
        sinput.selectByValue("option2");
        Thread.sleep(2000);
        sinput.selectByVisibleText("Option1");
      //  driver.close();

    }

}

