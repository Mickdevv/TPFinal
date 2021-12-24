package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages_Objets.Page_Accueil;

public class ContactUs {//Call ContactWebMaster and ContactCustomerService
	@Test
	public void contactUs (WebDriver driver) throws Exception {
		//System.out.println("Contact us, Webmaster");
		new Page_Accueil().ContactUsWebMaster(driver);
		
		//System.out.println("Contact us, Customer service");
		new Page_Accueil().ContactUsCustomerService(driver);
		
		System.out.println("Contact us finished");
	}
}
