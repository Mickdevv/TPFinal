package Pages_Objets;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Page_Adress {

	 @Test
	  public void EtapeAdresseControleSimple(WebDriver driver , String VInfoCompl) throws Exception {
		 StringBuffer verificationErrors = new StringBuffer();
		 
	    try {
	      assertEquals(driver.findElement(By.xpath("//ul[@id='address_delivery']/li/h3")).getText(), "Your delivery address");
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }

	    try {
	      assertEquals(driver.findElement(By.xpath("//ul[@id='address_invoice']/li/h3")).getText(), "Your billing address");
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    driver.findElement(By.name("message")).click();
	    driver.findElement(By.name("message")).clear();
	    driver.findElement(By.name("message")).sendKeys(VInfoCompl);
	    
	    driver.findElement(By.xpath("//div[@id='center_column']/form/p/button/span")).click();
	  }
}
