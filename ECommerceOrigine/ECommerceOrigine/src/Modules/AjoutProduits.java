package Modules;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages_Objets.Page_Accueil;

public class AjoutProduits {

	public void AjouterArticleParCategorie(
			WebDriver driver , String vcategorie , String vTaille , String vQuant 
			) throws Exception {

		System.out.println("Call AjouterProduiParCategorie");
		new Page_Accueil().AjouterProduiParCategorie(driver, vcategorie);

		if (vTaille != "" ) {
			System.out.println("Call ModifierTaille " + vTaille);
			new Page_Accueil().ModifierTaille(driver, vTaille);
		}

		if (vQuant != "" ) {
			System.out.println("Call ModifierQuantiteAvecControle : " + vQuant);
			new Page_Accueil().ModifierQuantiteAvecControle(driver, vQuant);
		}

		System.out.println("Call AjouterProduiAuPanier");
		new Page_Accueil().AjouterProduiAuPanier(driver);
	}

	@Test
	public void AjouterArticleAvecModifParMotCle(
			WebDriver driver , String vMotCle , String vTaille , String vQuant 
			) throws Exception {

		System.out.println("Call AjouterProduitParMotcle");
		new Page_Accueil().AjouterProduitParMotcle(driver, vMotCle);

		if (vTaille != "" ) {
			System.out.println("Call ModifierTaille");
			new Page_Accueil().ModifierTaille(driver, vTaille);
		}

		if (vQuant != "" ) {
			System.out.println("Call ModifierQuantiteAvecControle");
			new Page_Accueil().ModifierQuantiteAvecControle(driver, vQuant);
		}

		System.out.println("Call AjouterProduiAuPanier");
		new Page_Accueil().AjouterProduiAuPanier(driver);
	}

}
