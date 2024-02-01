package Pages;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class TestData extends Controler {

	      
		
		
		@DataProvider(name = "login-data")
	      public Object[][] getLoginData(){
	    	  return new Object[][] {
	    		  { "Tanvirr", "xyx@gmail1.com" },
	              { "John", "john@gmail.com" },
	              { "Mary", "mary@gmail.com" }
	    	  };
	    	  
	      }
}
