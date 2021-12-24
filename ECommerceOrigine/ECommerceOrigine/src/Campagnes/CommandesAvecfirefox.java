package Campagnes;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import Donnees.*;
import Pages_Objets.Page_Commune;
import Tests.AjoutProduitsDansPanier;
import Tests.ContactUs;
import Tests.Footer;
import Tests.SignIn;
import Tests.TunelDeCommande;

public class CommandesAvecfirefox {

	private WebDriver driver;

	private String FirefoxWebDriverFile; 
	private String NomfichierExcel;
	private String baseUrl ;

	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {

		// Load properties file
		String PathPropertiesFile = System.getProperty("user.dir") +"\\Ecommerce.properties";
		ReadProperty objProperties = new ReadProperty(PathPropertiesFile);

		FirefoxWebDriverFile = objProperties.getProperty("PathFirefoxDriver");
		baseUrl = objProperties.getProperty("BaseUrl");
		
		// Le fichier Data est placé dans le package Donnees
		NomfichierExcel = System.getProperty("user.dir")+  
				objProperties.getProperty("DataFile");

		System.setProperty("webdriver.gecko.driver", FirefoxWebDriverFile);
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Dimension d = new Dimension(800,600);
     	//Resize current window to the set dimension
     	driver.manage().window().setSize(d);
		
		driver.get(baseUrl);		

	}

	@Test
	public void CommandesAvecCreationCompte() throws Exception {
		
		//System.out.println("Verification du Contact us");
		new ContactUs().contactUs(driver);
		
		//System.out.println("Verification du footer");
		new Footer().VerifierFooter(driver);
		
		// Déclaration pour récupérer les valeurs de mail et Pwd créé
		StringBuilder vmail = new StringBuilder();
		StringBuilder vpwd = new StringBuilder();

		// ******************************************************
		// Remplir le panier 
		// ******************************************************
		new AjoutProduitsDansPanier().AjouterToutsLesProduits(driver, NomfichierExcel);

		// ******************************************************
		// Création d'un compte avec des données valides 
		// ******************************************************
		new SignIn().SignInCreateAcountWithoutControle(driver, NomfichierExcel, vmail, vpwd);

		System.out.println("Mail et pwd créé : " + vmail + "/" + vpwd);
		System.out.println("Mail et pwd créé (ToString: " + vmail.toString() + "/" + vpwd.toString());

		// ******************************************************
		// Passer commande  
		// ******************************************************
		new Page_Commune().AccesPanier(driver);
		new TunelDeCommande().CommandeLivraisonParDefautPaiementBank(driver);
		new Page_Commune().SignOut(driver);
		
		// ******************************************************
		// Remplir le panier avec 1 article 
		// ******************************************************
		new AjoutProduitsDansPanier().AjouterUnProduit(driver, NomfichierExcel);

		// ******************************************************
		// S'authentifier avec un compte valide 
		// ******************************************************
		new SignIn().SignInWithValideAcount(driver, vmail.toString(), vpwd.toString());

		// ******************************************************
		// Passer commande  
		// ******************************************************
		new Page_Commune().AccesPanier(driver);
		new TunelDeCommande().CommandeLivraisonParDefautPaiementCheck(driver);
		new Page_Commune().SignOut(driver);
		
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}

}
