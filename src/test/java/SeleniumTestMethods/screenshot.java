package SeleniumTestMethods;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Central.Controller;

public class screenshot extends Controller  {
	public final String DRIVER_PATH = "Drivers/chromedriver";
    public final String DRIVER_TYPE = "webdriver.chrome.driver";
   // public WebDriver driver;
    public final String BASE_URL = "https://www.bbc.com/";
    public final String FILE_PATH = "C:\\Users\\jzo_0\\Pictures\\Saved Pictures\\screenshot1.png";
    public final String IMAGE_PATH = "//*[@id=\"page\"]/section[3]/div/ul/li[1]/div/div[2]/h3/a";

   

    @Test (priority = 0)
    public void TakeScreenShot() throws Exception {

	    driver.navigate().to("https://automationexercise.com/");
	    // Navigate to the report URL and refresh
	    driver.navigate().refresh();
	    
	    // Take screenshot and save
	    Robot robot = new Robot();
        BufferedImage screenshot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        Thread.sleep(3000);
        // Save the screenshot to a folder
        String folderName = "screenshots";
        File folder = new File(folderName);
        if (!folder.exists()) {
            folder.mkdir();
        }
        String screenshotName = "screenshot-" + System.currentTimeMillis() + ".png";
        File screenshotFile = new File(folderName + "\\" + screenshotName);
        ImageIO.write(screenshot, "png", screenshotFile);

        System.out.println("Screenshot saved to: " + screenshotFile.getAbsolutePath());
    }

    

}
