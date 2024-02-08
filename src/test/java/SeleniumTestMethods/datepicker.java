package SeleniumTestMethods;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import Central.Controller;

public class datepicker extends Controller{
	@Test(priority = 0)

    public void testDAtePicker() throws Exception{

        //DAte and Time to be set in textbox

        String dateTime ="02/01/2023 11:15 PM";

        //WebDriver driver = new FirefoxDriver();
        
       // System.setProperty("webdriver.gecko.driver","geckodriver.exe");

       //driver.manage().window().maximize();
        
        driver.get("https://demos.telerik.com/kendo-ui/datetimepicker/index");
        
       //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        //button to open calendar
        
        WebElement selectDate = driver.findElement(By.xpath("//*[@id='demo-runner']/div/div/span/button[2]"));
        
        Ex.until(ExpectedConditions.visibilityOf(selectDate));
        
    selectDate.click();

    //button to move next in calendar

    WebElement nextLink = driver.findElement(By.xpath("//*[@id='f273464f-b82e-470c-989b-ffd6c8e3b70f']/div[1]/a[3]"));

    //button to click in center of calendar header

    Ex.until(ExpectedConditions.visibilityOf(nextLink));
    
    WebElement midLink = driver.findElement(By.xpath("//*[@id='d14c0b2d-d500-4e48-af83-073fca0a8d11']"));

    //button to move previous month in calendar
    Ex.until(ExpectedConditions.visibilityOf(nextLink));

    WebElement previousLink = driver.findElement(By.xpath("//*[@id='f273464f-b82e-470c-989b-ffd6c8e3b70f']/div[1]/a[1]")); 

    Ex.until(ExpectedConditions.visibilityOf(nextLink));
        //Split the date time to get only the date part

        String date_dd_MM_yyyy[] = (dateTime.split(" ")[0]).split("/");

        //get the year difference between current year and year to set in calander

        int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2])- Calendar.getInstance().get(Calendar.YEAR);

        midLink.click();

        if(yearDiff!=0){

            //if you have to move next year

            if(yearDiff>0){

                for(int i=0;i< yearDiff;i++){

                    System.out.println("Year Diff->"+i);

                    nextLink.click();

                }

            }

            //if you have to move previous year

            else if(yearDiff<0){

                for(int i=0;i< (yearDiff*(-1));i++){

                    System.out.println("Year Diff->"+i);

                    previousLink.click();

                }

            }

        }
        
        Thread.sleep(1000);

        //Get all months from calendar to select correct one

        List<WebElement> list_AllMonthToBook = driver.findElements(By.xpath("//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]"));
        
        list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[1])-1).click();
        
        Thread.sleep(1000);

        //get all dates from calendar to select correct one

        List<WebElement> list_AllDateToBook = driver.findElements(By.xpath("//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]"));
        
        list_AllDateToBook.get(Integer.parseInt(date_dd_MM_yyyy[0])-1).click();
        
        ///FOR TIME

        WebElement selectTime = driver.findElement(By.xpath("//span[@aria-controls='datetimepicker_timeview']"));

        //click time picker button

        selectTime.click();

        //get list of times

        List<WebElement> allTime = driver.findElements(By.xpath("//div[@data-role='popup'][contains(@style,'display: block')]//ul//li[@role='option']"));
      
        dateTime = dateTime.split(" ")[1]+" "+dateTime.split(" ")[2];

     //select correct time

        for (WebElement webElement : allTime) {

            if(webElement.getText().equalsIgnoreCase(dateTime))

            {

                webElement.click();

            }

        }

    }
	@Test(priority = 1)
	public void dateTimePicker() throws InterruptedException{

        //System.setProperty("webdriver.chrome.driver", "chromedriver-windows.exe");

        //WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://demo.guru99.com/test/");

        //Find the date time picker control

        WebElement dateBox = driver.findElement(By.xpath("//form//input[@name='bdaytime']"));

        Ex.until(ExpectedConditions.visibilityOf(dateBox));
        
        //Fill date as mm/dd/yyyy as 09/25/2013

        dateBox.sendKeys("03252023");
        
        Thread.sleep(2000);

        //Press tab to shift focus to time field

        dateBox.sendKeys(Keys.TAB);

        //Fill time as 02:45 PM

        dateBox.sendKeys("0245PM");

    }
}
