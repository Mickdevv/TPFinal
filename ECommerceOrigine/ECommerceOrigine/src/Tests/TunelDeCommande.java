package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages_Objets.Page_Adress;
import Pages_Objets.Page_Payment;
import Pages_Objets.Page_Shipping;
import Pages_Objets.Page_Summary;

public class TunelDeCommande {

	@Test
	public void CommandeLivraisonParDefautPaiementBank(WebDriver driver) throws Exception {
		new Page_Summary().EtapeSummaryControleSimple(driver);
		new Page_Adress().EtapeAdresseControleSimple(driver, "Hello World");
		new Page_Shipping().EtapeSippingControleSimlpe(driver);
		new Page_Payment().PaymentByBankWire(driver);
	}
	
	@Test
	public void CommandeLivraisonParDefautPaiementCheck(WebDriver driver) throws Exception {
		new Page_Summary().EtapeSummaryControleSimple(driver);
		new Page_Adress().EtapeAdresseControleSimple(driver, "Hello World");
		new Page_Shipping().EtapeSippingControleSimlpe(driver);
		new Page_Payment().PaymentByCheck(driver);
		
	}
	
	
}
