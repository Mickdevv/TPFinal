package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages_Objets.Page_Accueil;

public class Footer {// Calls all footer methods from Page_accueil
	
	@Test
	public void VerifierFooter (WebDriver driver) throws Exception {
		new Page_Accueil().VerifierFooterInformation(driver);
		new Page_Accueil().VerifierFooterMoreInformation(driver);
		new Page_Accueil().VerifierFooterMyAccount(driver);
	}
}
