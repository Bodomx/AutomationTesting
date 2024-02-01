package Pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Controler {

	public WebDriver driver; 
	public static String AppUrl;
		public static JavascriptExecutor js1;
			public static WebDriverWait Ex;
				public static ChromeOptions options;
					public static SignIn login;
						public SignUp form;
						  public Actions act;
						  	public static JavascriptExecutor js;
						  	   //private String originalWindowHandle;
//public static ExtentReports extentReports;
//   public static ExtentTest extentTest;
//WebElement UserName;

@BeforeSuite()
public void config() {
//	 ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/Reports/ExtentReport.html"));
 //       extentReports = new ExtentReports();
        //extentReports.attachReporter(htmlReporter);

//System.setProperty("webdriver.chrome.driver","chromedriver-windows.exe");
	//WebDriverManager.chromedriver().setup();
	
AppUrl = "https://automationexercise.com/";
options = new ChromeOptions();
options.addArguments("--headless=new");

//Ex = new WebDriverWait(driver,15);
driver = new ChromeDriver(options);
js = (JavascriptExecutor) driver;
js1 = (JavascriptExecutor) driver;
}
@BeforeTest()
public void setup() {
	//WebDriverManager.chromedriver().setup();
	
//driver = new ChromeDriver();
driver.manage().window().maximize();

//originalWindowHandle = driver.getWindowHandle();
login = new SignIn(driver);
form = new SignUp(driver);
}

@BeforeClass
 public void Synchronize() {
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	act = new Actions(driver);
}

@BeforeMethod() 
public void BrowserConfig() {
	 //We maximize or change browser based on our preference.
	
	
}

@AfterMethod()
public void validations(){
	System.out.println("Validations succesfully");// We validate our code executions.
	System.out.println("Method executed succesfully");
	//Ex = new WebDriverWait(driver, 10);
}
@AfterTest()
public void BrowserClosing() throws InterruptedException, IOException, AWTException {
	
    //String testNgReportPath = "test-output\\index.html"; // Replace with the path to your TestNG report

    //File reportFile = new File(testNgReportPath);
    //if (!reportFile.exists()) {
    //    System.out.println("Report file not found: " + testNgReportPath);
    //    return;
   // }

    //js1.executeScript("window.open('https://www.google.com/')");

    // Switch to the new window
    /*Set<String> windowHandles = driver.getWindowHandles();
    String newWindowHandle = windowHandles.toArray()[windowHandles.size()-1].toString();
    driver.switchTo().window(newWindowHandle);*/
   // File file = new File("test-output/index.html");
    //String htmlFilePath = "file:///" + htmlFile.getAbsolutePath();
   // driver.navigate().to(file.getAbsolutePath());
    // Navigate to the report URL and refresh
    //driver.navigate().to("C:\\Tools\\workspace1\\AutomationClass2023\\test-output\\index.html");
    //driver.navigate().to(X);
   // driver.navigate().refresh();
   // Thread.sleep(3000);
    // Take screenshot and save
    //Robot robot = new Robot();
   // BufferedImage screenshot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

    // Save the screenshot to a folder
   // String folderName = "screenshots";
   // File folder = new File(folderName);
   // if (!folder.exists()) {
     //   folder.mkdir();
   // }
   // String screenshotName = "screenshot-" + System.currentTimeMillis() + ".png";
   // File screenshotFile = new File(folderName + "\\" + screenshotName);
   // ImageIO.write(screenshot, "png", screenshotFile);

   // System.out.println("Screenshot saved to: " + screenshotFile.getAbsolutePath());

    // Wait 30 seconds
    Thread.sleep(3000);

    // Close the window and switch back to the original window
    driver.close();
    //driver.switchTo().window(originalWindowHandle);
}
	
@AfterSuite
public void terminate() {
	driver.quit(); // We close the instance and terminate the session. It will erase all the cache memory and make our next execution better.
}

}
