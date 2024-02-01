package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUp extends Controler {
	
ValidationsFactory validate;
//WebDriverWait Ex1;


    @FindBy(css="#id_gender1")
	WebElement Mr;
	
	@FindBy(css="input[id='id_gender2']")
	WebElement Mrs;
	
	@FindBy(css="select[name*='days']")
	WebElement Days;
	
	
    @FindBy(css="input[id='optin'][value='1']")
	WebElement CheckBox1;
    
    @FindBy(css="input[id^='first']")
	WebElement FirstName;

public SignUp(WebDriver driver) {
	super();
	this.driver=driver;
	//this.Ex = new WebDriverWait(driver, 30);;
	validate = new ValidationsFactory(driver, this);
	PageFactory.initElements(driver, this);
	
}

public void selectMr() {
	Mr.click();
	//validate.assertElementSelected2(Mr);
	
}

public void selectMrs() {
	Mrs.click();
	//validate.assertElementEnabled2(Mrs);
}

public void selectDays(String inputdays) throws InterruptedException {
	//Days.click();
	Thread.sleep(2000);
	
	// String inputdaysStr = Double.toString(inputdays);
	Select sinput = new Select(Days);
	Thread.sleep(2000);
	
	sinput.selectByValue(inputdays);
	Thread.sleep(2000);
	validate.assertDropdownSelected2(Days, inputdays);
} 



public void selectCheckBox1() {
	CheckBox1.click();
	
	//SignUp.assertCheckboxSelected2(CheckBox1);
}
public void selectFirstName(String name) {
	//Ex.until(ExpectedConditions.elementToBeClickable(FirstName));
	js.executeScript("arguments[0].scrollIntoView(true);", FirstName);
	//Ex.until(ExpectedConditions.visibilityOf(FirstName));
	FirstName.click();
	FirstName.sendKeys(name);
	validate.assertXpath1(FirstName, name);
}

public void fillform(String inputdays, String name) throws InterruptedException {

	this.selectMr();
	this.selectMrs();
	this.selectDays(inputdays);
	this.selectCheckBox1();
	this.selectFirstName(name);
	
	

}
}