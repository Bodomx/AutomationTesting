package RunTest;

import org.testng.annotations.Test;

import Pages.Controler;

public class SignUp extends Controler {
	@Test(priority = 0)
	public void test_SignUp() throws InterruptedException {
		
		login.OpenApp(AppUrl);
		login.getSignInTitle();
		login.ClickSignIn();
		login.EnterUserName("Tahir");
		login.EnterEmailAddress("xuz@gmail.com");
		login.clickAccountButton();
		} 
	@Test(priority = 1)
	public void test_SignUp2() throws InterruptedException {
		
		login.fillupformSignIn(AppUrl, "Tahir", "xuz@gmail.com");
		} 
/*	@Test(priority = 2, invocationCount = 2)
	public void test_SignUp_FillForm() throws InterruptedException {
		
		form.("22", "January", "Tanvir");
		} 
*/
	
}
