package SeleniumTestMethods;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

//import org.openqa.selenium.By;
//import org.testng.annotations.Test;


import Pages.Controler;

public class uploadfile extends Controler {
	@Test
	public void upload() throws InterruptedException {
		driver.get("http://demo.guru99.com/test/upload/");
		String filocation = "C:\\Users\\larry\\Tools\\PracticeApp\\AutomationTest\\screenshots\\screenshot-1707792199112.png";
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#uploadfile_0")).sendKeys(filocation);
	
}
}
