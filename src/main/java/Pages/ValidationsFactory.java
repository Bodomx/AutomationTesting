package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ValidationsFactory extends Controler {
	 SignUp Page;
	    
		public ValidationsFactory(WebDriver driver, SignUp Page) {     //, By enterEmail)         
	    	this.driver = driver;
	    	this.Page = Page;
	    	PageFactory.initElements(driver, Page);
			// adding Commnets
	    }
		
		
	    public void assertTitle(String expectedTitle) {
			String actualTitle = driver.getTitle().trim();
			Assert.assertEquals(actualTitle, expectedTitle, "Actual title '" + actualTitle + "' does not match expected title '" + expectedTitle + "'");
		}
	    
	    
	    public void assertXpath1(WebElement element, String expectedText) {
	        try {
	            Thread.sleep(3000); // Wait for 3 second to allow the input field to be updated
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        //xpath = driver.findElement(xpath));
	        String actualText = element.getAttribute("value").trim();
	        Assert.assertEquals(actualText, expectedText, "Actual text '" + actualText + "' does not match expected text '" + expectedText + "' for XPath expression: " + element.toString());
	    }
	    public void assertDropdownSelected2(WebElement dropdown, String expectedOption) {
	    	Select select = new Select(dropdown);
	    	String actualOption = select.getFirstSelectedOption().getText().trim();
	    	Assert.assertEquals(actualOption, expectedOption, "Actual dropdown selection '" + actualOption + "' does not match expected selection '" + expectedOption + "'");
	    }

		public SignUp getPage() {
			return Page;
		}


}
