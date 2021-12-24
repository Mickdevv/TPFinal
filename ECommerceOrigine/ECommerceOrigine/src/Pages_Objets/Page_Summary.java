package Pages_Objets;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Page_Summary {
	StringBuffer verificationErrors = new StringBuffer();
	
	 @Test
	  public void EtapeSummaryControleSimple(WebDriver driver) throws Exception {
// Vérifier que nous avons le texte Delivery address
		 try {
	      assertEquals(driver.findElement(By.xpath("//div[@id='center_column']/div[3]/div/ul/li/h3")).getText(), "Delivery address\n																												(My address)");
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }

		// Vérifier que nous avons le texte Invoice address
	    driver.findElement(By.xpath("//div[@id='center_column']/div[3]/div[2]/ul/li/h3")).click();
	    try {
	      assertEquals(driver.findElement(By.xpath("//div[@id='center_column']/div[3]/div[2]/ul/li/h3")).getText(), "Invoice address\n																												(My address)");
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath("//div[@id='center_column']/div[3]/div/ul/li[2]/span")).click();
	    
	    // cliquer sur Proceed to CkeckOut
	    driver.findElement(By.xpath("//div[@id='center_column']/p[2]/a/span")).click();
	  }

}
