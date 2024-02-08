package SeleniumTestMethods;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Controler;

public class Actionsmethods extends Controler {
    private WebDriverWait wait;
    private Actions action;

    @BeforeMethod
    public void setup() {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);
        action = new Actions(driver);
    }

    @Test(priority = 0)
    public void actionset1() {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.navigate().refresh();

        WebElement addup1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("hrefIncAdt")));
        Action seriesOfActions1 = action.moveToElement(addup1).click().build();

        for(int i=1;i<10;i++) {
            seriesOfActions1.perform();
        }

        int j=1;
        while(j<10){
            driver.findElement(By.id("hrefIncChd")).click();
            j++;
        }
    }

    @Test(priority = 1)
    public void actionset2() {
        WebElement substract = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("hrefDecAdt")));
        Action seriesOfActions = action.moveToElement(substract).click().build();

        for(int i=1;i<5;i++) {
            seriesOfActions.perform();
        }

        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult", "Expected 5 Adults but found different value");

        WebElement search = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("autosuggest")));
        Action seriesOfActions2 = action.moveToElement(search).click().sendKeys("Bang").sendKeys(Keys.ARROW_DOWN).build();
        seriesOfActions2.perform();
    }

    @Test(priority = 3)
    public void actionbuilder() {
        String baseUrl = "http://www.facebook.com/";
        driver.get(baseUrl);
        WebElement txtUsername = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));

        Action seriesOfActions = action
            .moveToElement(txtUsername)
            .click()
            .keyDown(txtUsername, Keys.SHIFT)
            .sendKeys(txtUsername, "hello")
            .keyUp(txtUsername, Keys.SHIFT)
            .doubleClick(txtUsername)
            .contextClick()
            .build();

        for(int i=1;i<5;i++) {
            seriesOfActions.perform();
        }
    }
}