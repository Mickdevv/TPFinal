package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Donnees.LireDataFromXL;
import Modules.AjoutProduits;

public class AjoutProduitsDansPanier {

	private String vcategorieProduit ; 
	private String vMotCleProduit ; 
	private String vTaille;
	private String vQuant;

	@Test
	public void AjouterToutsLesProduits(
			WebDriver driver , String NomfichierExcel 			 
			) throws Exception {

		// ******************************************************
		// Ajouter tous les produits à partir du fichier Excel
		// ******************************************************
		try {
			//Open an excel file as input stream
			File datafile=new File(NomfichierExcel);        	
			FileInputStream inputStream = new FileInputStream(datafile);

			//Get the workbook instance for XLS file
			XSSFWorkbook MyWorkbook = new XSSFWorkbook(inputStream);

			// Lire la Feuille des produits
			XSSFSheet Mysheet = MyWorkbook.getSheet("Produits");

			// Boucler sur les lignes des produits 
			int rowCount = Mysheet.getLastRowNum()- Mysheet.getFirstRowNum();
			System.out.println("Nombre de lignes a traiter : " + rowCount);

			// On commence à la ligne 2
			for (int i = 1; i < rowCount+1; i++) {

				System.out.println("Traitement de la ligne : " + i);
				vcategorieProduit = LireDataFromXL.getCell(Mysheet, i, 0); 
				vMotCleProduit = LireDataFromXL.getCell(Mysheet, i, 1);
				vTaille= LireDataFromXL.getCell(Mysheet, i, 2);
				vQuant = LireDataFromXL.getCell(Mysheet, i, 3);

				// Remplir le panier
				if (vcategorieProduit != "") {
					new AjoutProduits().AjouterArticleParCategorie(driver, vcategorieProduit, vTaille, vQuant);
				}

				if (vMotCleProduit != "") {
					new AjoutProduits().AjouterArticleAvecModifParMotCle(driver, vMotCleProduit, vTaille, vQuant);
				}

			} // for

			MyWorkbook.close();
			inputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("problème...");
		}		

	}	

	
	@Test
	public void AjouterUnProduit(
			WebDriver driver , String NomfichierExcel			 
			) throws Exception {

		// ******************************************************
		// Ajouter tous les produits à partir du fichier Excel
		// ******************************************************
		try {
			//Open an excel file as input stream
			File datafile=new File(NomfichierExcel);        	
			FileInputStream inputStream = new FileInputStream(datafile);

			//Get the workbook instance for XLS file
			XSSFWorkbook MyWorkbook = new XSSFWorkbook(inputStream);

			// Lire la Feuille des produits
			XSSFSheet Mysheet = MyWorkbook.getSheet("Produits");

			// Boucler sur les lignes des produits 
			int rowCount = Mysheet.getLastRowNum()- Mysheet.getFirstRowNum();
			System.out.println("Nombre de lignes a traiter : " + rowCount);

			// On commence à la ligne 2
			for (int i = 1; i < rowCount+1; i++) {

				System.out.println("Traitement de la ligne : " + i);
				vcategorieProduit = LireDataFromXL.getCell(Mysheet, i, 0); 
				vMotCleProduit = LireDataFromXL.getCell(Mysheet, i, 1);
				vTaille= LireDataFromXL.getCell(Mysheet, i, 2);
				vQuant = LireDataFromXL.getCell(Mysheet, i, 3);

				// Remplir le panier
				if (vcategorieProduit != "") {
					new AjoutProduits().AjouterArticleParCategorie(driver, vcategorieProduit, vTaille, vQuant);
				}

				if (vMotCleProduit != "") {
					new AjoutProduits().AjouterArticleAvecModifParMotCle(driver, vMotCleProduit, vTaille, vQuant);
				}
				
				// On prend que la 1ère ligne
				break;

			} // for

			MyWorkbook.close();
			inputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("problème...");
		}		

	}	
	
	
}
