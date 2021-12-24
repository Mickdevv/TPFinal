package Pages_Objets;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Page_Accueil {
	
	StringBuffer verificationErrors = new StringBuffer();
	
	@Test
	public void AjouterProduiParCategorie(WebDriver driver , String vCategorie) throws Exception {
	    System.out.println("Click sur le lien Catégorie puis le 1er article ");
		
	    driver.findElement(By.linkText(vCategorie)).click();
	    driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")).click();
	    
	    TimeUnit.SECONDS.sleep(2);
	    }

	@Test
	public void AjouterProduitParMotcle (WebDriver driver , String vMotCle ) throws Exception {
		
	    System.out.println("Saisir le mot clé puis Click sur Recherche");
		driver.findElement(By.id("search_query_top")).click();
		driver.findElement(By.id("search_query_top")).clear();
		driver.findElement(By.id("search_query_top")).sendKeys(vMotCle);
		driver.findElement(By.name("submit_search")).click();
		
	    System.out.println("Click sur 1er produit");
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")).click();
	}

	@Test
	public void AjouterProduiAuPanier(WebDriver driver ) throws Exception {
		
	    System.out.println("Click sur Add to Cart");
	    
	    TimeUnit.SECONDS.sleep(2);
	    
		driver.findElement(By.xpath("//p[@id='add_to_cart']/button/span")).click();		
		
	    System.out.println("Après Click sur Add to Cart");
		
		TimeUnit.SECONDS.sleep(5);
		
	    System.out.println("Click sur continuer mes courses");
		driver.findElement(By.xpath("//div[@id='layer_cart']/div/div[2]/div[4]/span/span")).click();
	}
	
	@Test
	public void ModifierTaille(WebDriver driver , String vTaille ) throws Exception {
		
	    System.out.println("Modifier la taille dans la liste");
	    driver.findElement(By.id("group_1")).click();
	    TimeUnit.SECONDS.sleep(1);
		new Select(driver.findElement(By.id("group_1"))).selectByVisibleText(vTaille);
	    
	}
	
	@Test
	public void ModifierQuantiteAvecControle(WebDriver driver , String vQuantite) throws Exception {
		
		String NewQuantite ;  
		
	    System.out.println("Modifier la quantité par saisie dans le champ quantité");
		// Saisir la quantifié dans le champ Quantité
		driver.findElement(By.id("quantity_wanted")).click();
	    driver.findElement(By.id("quantity_wanted")).click();
	    driver.findElement(By.id("quantity_wanted")).clear();
	    driver.findElement(By.id("quantity_wanted")).sendKeys(vQuantite);
		
	    // Vérifier la valeur saisie 
		try {
			assertEquals(vQuantite , driver.findElement(By.id("quantity_wanted")).getAttribute("value"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		
	    System.out.println("Click sur bouton - de la quantité ");
		// Vérifier le bouton "-"
	    driver.findElement(By.xpath("//p[@id='quantity_wanted_p']/a/span")).click();
		NewQuantite = String.valueOf(Integer.parseInt(vQuantite) - 1) ; 
		try {
			assertEquals(vQuantite , driver.findElement(By.id("quantity_wanted")).getAttribute("value"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}

		System.out.println("Click sur bouton + de la quantité ");
		// Vérifier le bouton "+"
	    driver.findElement(By.xpath("//p[@id='quantity_wanted_p']/a[2]/span")).click();
		try {
			NewQuantite = String.valueOf(Integer.parseInt(vQuantite) + 1) ; 
			assertEquals(NewQuantite , driver.findElement(By.id("quantity_wanted")).getAttribute("value"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	    
	}
	
	@Test
	public void VerifierFooterInformation(WebDriver driver) throws Exception {
		System.out.println("VerifierFooterInformation");
		// Test name: VerifyInformationFooter
	    // 3 | click | css=.bottom-footer > div | 
	    driver.findElement(By.cssSelector(".bottom-footer > div")).click();
	    // 4 | click | id=footer | 
	    driver.findElement(By.id("footer")).click();
	    // 5 | click | css=.bullet > li:nth-child(3) | 
	    driver.findElement(By.cssSelector(".bullet > li:nth-child(3)")).click();
	    try {
			// 6 | verifyText | linkText=Specials | Specials
			assertEquals(driver.findElement(By.linkText("Specials")).getText(), "Specials");
			// 7 | verifyText | linkText=New products | New products
			assertEquals(driver.findElement(By.linkText("New products")).getText(), "New products");
			// 8 | verifyText | linkText=Best sellers | Best sellers
			assertEquals(driver.findElement(By.linkText("Best sellers")).getText(), "Best sellers");
			// 9 | verifyText | linkText=Our stores | Our stores
			assertEquals(driver.findElement(By.linkText("Our stores")).getText(), "Our stores");
			// 10 | verifyText | css=.item:nth-child(5) > a | Contact us
			assertEquals(driver.findElement(By.cssSelector(".item:nth-child(5) > a")).getText(), "Contact us");
			// 11 | verifyText | linkText=Terms and conditions of use | Terms and conditions of use
			assertEquals(driver.findElement(By.linkText("Terms and conditions of use")).getText(), "Terms and conditions of use");
			// 12 | verifyText | linkText=About us | About us
			assertEquals(driver.findElement(By.linkText("About us")).getText(), "About us");
			// 13 | verifyText | linkText=Sitemap | Sitemap
			assertEquals(driver.findElement(By.linkText("Sitemap")).getText(), "Sitemap");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR: VerifierFooterInformation");
			e.printStackTrace();
		}
	}
	@Test
	public void VerifierFooterMyAccount(WebDriver driver) throws Exception {
		System.out.println("VerifierFooterMyAccount");
	    try {
			// 3 | verifyText | linkText=My account | My account
			assertEquals(driver.findElement(By.linkText("My account")).getText(), "My account");
			// 4 | verifyText | linkText=My orders | My orders
			assertEquals(driver.findElement(By.linkText("My orders")).getText(), "My orders");
			// 5 | verifyText | linkText=My credit slips | My credit slips
			assertEquals(driver.findElement(By.linkText("My credit slips")).getText(), "My credit slips");
			// 6 | verifyText | linkText=My addresses | My addresses
			assertEquals(driver.findElement(By.linkText("My addresses")).getText(), "My addresses");
			// 7 | verifyText | linkText=My personal info | My personal info
			assertEquals(driver.findElement(By.linkText("My personal info")).getText(), "My personal info");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void VerifierFooterMoreInformation(WebDriver driver) throws Exception {
		System.out.println("VerifierFooterMoreInformation");
	    try {
			// 3 | verifyText | css=#block_contact_infos h4 | Store information
			assertEquals(driver.findElement(By.cssSelector("#block_contact_infos h4")).getText(), "Store information");
			// 4 | verifyText | css=div > .toggle-footer > li:nth-child(1) | Selenium Framework, Research Triangle Park, North Carolina, USA
			assertEquals(driver.findElement(By.cssSelector("div > .toggle-footer > li:nth-child(1)")).getText(), "Selenium Framework, Research Triangle Park, North Carolina, USA");
			// 5 | verifyText | css=div > .toggle-footer > li:nth-child(2) | Call us now: (347) 466-7432
			assertEquals(driver.findElement(By.cssSelector("div > .toggle-footer > li:nth-child(2)")).getText(), "Call us now: (347) 466-7432");
			// 6 | verifyText | css=li:nth-child(2) > span:nth-child(2) | (347) 466-7432
			assertEquals(driver.findElement(By.cssSelector("li:nth-child(2) > span:nth-child(2)")).getText(), "(347) 466-7432");
			// 7 | verifyText | css=div > .toggle-footer > li:nth-child(3) | Email: support@seleniumframework.com
			assertEquals(driver.findElement(By.cssSelector("div > .toggle-footer > li:nth-child(3)")).getText(), "Email: support@seleniumframework.com");
			// 8 | verifyText | linkText=support@seleniumframework.com | support@seleniumframework.com
			assertEquals(driver.findElement(By.linkText("support@seleniumframework.com")).getText(), "support@seleniumframework.com");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void ContactUsWebMaster(WebDriver driver) throws Exception {
		System.out.println("ContactUs");
		
	    // 3 | click | linkText=Contact us | 
	    driver.findElement(By.linkText("Contact us")).click();
	    // 4 | click | id=id_contact | 
	    driver.findElement(By.id("id_contact")).click();
	    // 5 | select | id=id_contact | label=Webmaster
	    {
	    	WebElement dropdown = driver.findElement(By.id("id_contact"));
	    
	    	dropdown.findElement(By.xpath("//option[. = 'WebMaster']")).click();
	    }
	    // 6 | click | css=option:nth-child(3) | 
	    driver.findElement(By.cssSelector("option:nth-child(3)")).click();
	    
	    {
	    	// 7 | verifyText | id=desc_contact1 | If a technical problem occurs on this website
	    	assertEquals(driver.findElement(By.id("desc_contact1")).getText(), "If a technical problem occurs on this website");
	    }



	    // 8 | click | id=email | 
	    driver.findElement(By.id("email")).click();
	    // 9 | type | id=email | testeurfou@gmail.com
	    driver.findElement(By.id("email")).sendKeys("testeurfou@gmail.com");
	    // 10 | click | id=id_order | 
	    driver.findElement(By.id("id_order")).click();
	    // 11 | type | id=id_order | 1234
	    driver.findElement(By.id("id_order")).sendKeys("1234");
	    // 12 | click | id=message | 
	    driver.findElement(By.id("message")).click();
	    // 13 | type | id=message | blabla
	    driver.findElement(By.id("message")).sendKeys("blabla");
	    // 14 | click | css=#submitMessage > span | 
	    driver.findElement(By.cssSelector("#submitMessage > span")).click();
	    // 15 | verifyText | css=.alert | Your message has been successfully sent to our team.
	    assertEquals(driver.findElement(By.cssSelector(".alert")).getText(), "Your message has been successfully sent to our team.");
		
	}
	
	@Test
	public void ContactUsCustomerService(WebDriver driver) throws Exception {
		System.out.println("ContactUs");
		
	    // 3 | click | linkText=Contact us | 
	    driver.findElement(By.linkText("Contact us")).click();
	    // 4 | click | id=id_contact | 
	    driver.findElement(By.id("id_contact")).click();
	    // 5 | select | id=id_contact | label=Webmaster
	    {
	    	WebElement dropdown = driver.findElement(By.id("id_contact"));
	    
	    	dropdown.findElement(By.xpath("//option[. = 'Customer Service']")).click();
	    }
	    // 6 | click | css=option:nth-child(3) | 
	    driver.findElement(By.cssSelector("option:nth-child(3)")).click();
	    
	    {
	    	// 7 | verifyText | id=desc_contact1 | If a technical problem occurs on this website
	    	assertEquals(driver.findElement(By.id("desc_contact1")).getText(), "For any question about a product, an order");
	    }


	    // 8 | click | id=email | 
	    driver.findElement(By.id("email")).click();
	    // 9 | type | id=email | testeurfou@gmail.com
	    driver.findElement(By.id("email")).sendKeys("testeurfou@gmail.com");
	    // 10 | click | id=id_order | 
	    driver.findElement(By.id("id_order")).click();
	    // 11 | type | id=id_order | 1234
	    driver.findElement(By.id("id_order")).sendKeys("1234");
	    // 12 | click | id=message | 
	    driver.findElement(By.id("message")).click();
	    // 13 | type | id=message | blabla
	    driver.findElement(By.id("message")).sendKeys("blabla");
	    // 14 | click | css=#submitMessage > span | 
	    driver.findElement(By.cssSelector("#submitMessage > span")).click();
	    // 15 | verifyText | css=.alert | Your message has been successfully sent to our team.
	    assertEquals(driver.findElement(By.cssSelector(".alert")).getText(), "Your message has been successfully sent to our team.");
		
	}
	
}
