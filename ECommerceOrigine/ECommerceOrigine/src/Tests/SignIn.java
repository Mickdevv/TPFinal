package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Commun.ToolsString;
import Donnees.LireDataFromXL;
import Modules.Authentification;
import Pages_Objets.Page_Sign_in;

public class SignIn {
	private String vemail; 
	private String vgender ; 
	private String vFirstName; 
	private String vLastName;
	private String vPwd;
	private String vLigneadresse;
	private String vCity;
	private String vState;
	private String vZipCode;
	private String vPhoneNumber;

	@Test
	public void SignInCreateAcountWithoutControle(WebDriver driver , String NomfichierExcel , StringBuilder NewEmail , StringBuilder NewPwd 
) throws Exception {
		
		// ******************************************************
		// Création d'un compte avec des données valides avec la 1ère ligne du fichier Excel 
		// ******************************************************
		try {
			//Open an excel file as input stream
			File datafile=new File(NomfichierExcel);        	
			FileInputStream inputStream = new FileInputStream(datafile);

			//Get the workbook instance for XLS file
			XSSFWorkbook MyWorkbook = new XSSFWorkbook(inputStream);

			// Lire la Feuille des produits
			XSSFSheet Mysheet = MyWorkbook.getSheet("AccountValide");

			// Identifier un compte valide 
			int rowCount = Mysheet.getLastRowNum()- Mysheet.getFirstRowNum();
			System.out.println("Nombre de lignes a traiter : " + rowCount);

			// On commence à la ligne 2
			for (int i = 1; i < rowCount+1 ; i++) {

				System.out.println("Traitement de la ligne : " + i);

				vemail = LireDataFromXL.getCell(Mysheet, i, 0);
				vPwd = LireDataFromXL.getCell(Mysheet, i, 1);
				vFirstName = LireDataFromXL.getCell(Mysheet, i, 2);
				vLastName = LireDataFromXL.getCell(Mysheet, i, 3);
				vgender= LireDataFromXL.getCell(Mysheet, i, 4);
				vLigneadresse = LireDataFromXL.getCell(Mysheet, i, 5);
				vCity = LireDataFromXL.getCell(Mysheet, i, 6);
				vState = LireDataFromXL.getCell(Mysheet, i, 7);
				vZipCode = LireDataFromXL.getCell(Mysheet, i, 8);
				vPhoneNumber = LireDataFromXL.getCell(Mysheet, i, 9);
				
				String StartEmail = ToolsString.RecupCurrentDateHeure();
				NewEmail.append(StartEmail + vemail);
				NewPwd.append(vPwd);
				
				System.out.println("Mail utilisé pour la création de compte : " + NewEmail);
				System.out.println("Call createAcount");
				
				System.out.println("Compte trouvé ==> Call CreateAcountWithoutControle");
				new Authentification().CreateAcountWithoutControle(driver, StartEmail + vemail, vgender, vFirstName, vLastName, vPwd, vLigneadresse, vCity, vState, vZipCode, vPhoneNumber);
				
				// On prend que la 1ère ligne alors on sort de la boucle
				break;

			} // for

			MyWorkbook.close();
			inputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("problème...");
		}		
	}
	

	@Test
	public void SignInCreateAcountWithControle(WebDriver driver , String NomfichierExcel , String NewEmail  
			) throws Exception {

		//Todo
	}

	@Test
	public void SignInWithValideAcount(WebDriver driver , String vmail , String vpwd2 ) throws Exception {

		System.out.println("Call SignInWithValideAccount");
		new Page_Sign_in().SignInWithValideAccount(driver, vmail, vpwd2);
	}

	@Test
	public void SignInWithInValideAcount(WebDriver driver , 
			String vemail , String vPwd ) throws Exception {

		System.out.println("Call SignInWithInvalideAccount");
		new Page_Sign_in().SignInWithInvalideAccount(driver, vemail, vPwd);

	}

}
