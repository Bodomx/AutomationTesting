package SeleniumTestMethods;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import Central.Controller;

public class autosuggest extends Controller {

	@Test
	public void autosuggest3() throws Exception {

		autosuggest auto = new autosuggest();
			
	auto.suggestions();
	//auto.closeBrowser();
	}
	public void suggestions() throws Exception {
	//System.setProperty("webdriver.chrome.driver","C:\\Users\\jzo_0\\eclipse-workspace\\Dropdowns\\chromedriver-windows.exe");
		// driver = new ChromeDriver();
		//driver.get("https://global.shopbakerhughes.com/");
		driver.get("http://www.etsy.com/");
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='global-enhancements-search-query']")).sendKeys("Drill");
		 driver.findElement(By.xpath("//*[@id='gnav-search']/div/div[1]/button[2]")).sendKeys(Keys.DOWN);
		 String text = driver.findElement(By.xpath("//*[@id='global-enhancements-search-query']")).getText();

			
			System.out.println("Text is"+text);
				Thread.sleep(2000);

				//JavascriptExecutor js = (JavascriptExecutor)driver;
			
				String str = "return document.getElementById(\"search\").value;";
				String item = (String) js.executeScript(str);
				System.out.println(item);
			int i=0;
		while(!item.contains("drill holder")){
				i++;
				driver.findElement(By.xpath("//*[@id='global-enhancements-search-query']")).sendKeys(Keys.DOWN);
				Thread.sleep(1000);
				item = (String) js.executeScript(str);
			System.out.println(item);
				if(i>15){
				break;
				}
				}
				if(i>15){
				System.out.println("Item not found.");
				fail ("Desired item not found.");
				}else{
				System.out.println("Desire item found.");
				}
				driver.findElement(By.xpath("//*[@id='global-enhancements-search-query']")).sendKeys(Keys.TAB);
				driver.findElement(By.xpath("//*[@id='gnav-search']/div/div[1]/button[2]")).click();
	}
	
}
