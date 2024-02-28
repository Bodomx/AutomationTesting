package SeleniumTestMethods;

import org.openqa.selenium.interactions.Action; // Importing Action class from Selenium
import org.openqa.selenium.interactions.Actions; // Importing Actions class from Selenium
import org.openqa.selenium.support.ui.ExpectedConditions; // Importing ExpectedConditions class from Selenium
import org.openqa.selenium.support.ui.Wait; // Importing Wait class from Selenium
import org.openqa.selenium.support.ui.WebDriverWait; // Importing WebDriverWait class from Selenium

import java.time.Duration; // Importing Duration class from Java

import org.openqa.selenium.By; // Importing By class from Selenium
import org.openqa.selenium.Keys; // Importing Keys class from Selenium
import org.openqa.selenium.WebDriver; // Importing WebDriver class from Selenium
import org.openqa.selenium.WebElement; // Importing WebElement class from Selenium
import org.testng.Assert; // Importing Assert class from TestNG
import org.testng.annotations.BeforeMethod; // Importing BeforeMethod annotation from TestNG
import org.testng.annotations.Test; // Importing Test annotation from TestNG

import Pages.Controler; // Importing Controler class from Pages package

public class Actionsmethods extends Controler { // Class Actionsmethods extending Controler class
    private WebDriverWait wait; // Declaring private WebDriverWait variable
    private Actions action; // Declaring private Actions variable

    @Test(priority = 0) // Test annotation with priority 0
    public void actionset1() { // Method actionset1
     driver.manage().window().maximize(); // Maximizing the window
        driver.manage().deleteAllCookies(); // Deleting all cookies
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Setting implicit wait of 2 seconds
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));; // Initializing WebDriverWait
        action = new Actions(driver); // Initializing Actions
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); // Navigating to the URL
        driver.navigate().refresh(); // Refreshing the page

        WebElement addup1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("hrefIncAdt"))); // Waiting for the element to be present
        Action seriesOfActions1 = action.moveToElement(addup1).click().build(); // Building a series of actions

        for(int i=1;i<10;i++) { // Loop to perform the actions 10 times
            seriesOfActions1.perform(); // Performing the actions
        }

        int j=1; // Initializing counter
        while(j<10){ // Loop to click the element 10 times
            driver.findElement(By.id("hrefIncChd")).click(); // Clicking the element
            j++; // Incrementing the counter
        }
    }

    @Test(priority = 1) // Test annotation with priority 1
    public void actionset2() { // Method actionset2
        WebElement substract = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("hrefDecAdt"))); // Waiting for the element to be present
        Action seriesOfActions = action.moveToElement(substract).click().build(); // Building a series of actions

        for(int i=1;i<5;i++) { // Loop to perform the actions 5 times
            seriesOfActions.perform(); // Performing the actions
        }

        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult", "Expected 5 Adults but found different value"); // Asserting the result

        WebElement search = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("autosuggest"))); // Waiting for the element to be present
        Action seriesOfActions2 = action.moveToElement(search).click().sendKeys("Bang").sendKeys(Keys.ARROW_DOWN).build(); // Building a series of actions
        seriesOfActions2.perform(); // Performing the actions
    }

    @Test(priority = 3) // Test annotation with priority 3
    public void actionbuilder() { // Method actionbuilder
        String baseUrl = "http://www.facebook.com/"; // Base URL
        driver.get(baseUrl); // Navigating to the URL
        WebElement txtUsername = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))); // Waiting for the element to be present

        Action seriesOfActions = action // Building a series of actions
            .moveToElement(txtUsername) // Moving to the element
            .click() // Clicking the element
            .keyDown(txtUsername, Keys.SHIFT) // Pressing the SHIFT key
            .sendKeys(txtUsername, "hello") // Sending keys to the element
            .keyUp(txtUsername, Keys.SHIFT) // Releasing the SHIFT key
            .doubleClick(txtUsername) // Double clicking the element
            .contextClick() // Right clicking the element
            .build(); // Building the actions

        for(int i=1;i<5;i++) { // Loop to perform the actions 5 times
            seriesOfActions.perform(); // Performing the actions
        }
    }
}