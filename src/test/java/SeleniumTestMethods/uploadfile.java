package SeleniumTestMethods;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Central.Controller;

public class uploadfile extends Controller {
	@Test
	public void upload() throws InterruptedException {
		driver.get("http://demo.guru99.com/test/upload/");
		String filocation = "C:\\Tools\\P_O_M_FrameWork\\src\\main\\java\\seleniumTestMethods\\UploadFile.java";
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#uploadfile_0")).sendKeys(filocation);
	
}
}
