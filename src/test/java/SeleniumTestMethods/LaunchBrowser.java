import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

    public static void main(String[] args) {

        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Initialize browser
        WebDriver driver = new ChromeDriver();

        // Open website
        driver.get("http://www.google.com");

        // Close browser
        driver.close();

    }

}