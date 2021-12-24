package Pages_Objets;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Page_Shipping {
	@Test
	public void EtapeSippingControleSimlpe(WebDriver driver) throws Exception {
		StringBuffer verificationErrors = new StringBuffer();
		try {
			assertEquals(driver.findElement(By.xpath("//form[@id='form']/div/div[2]/p")).getText(), "Choose a shipping option for this address: My address");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}

		driver.findElement(By.id("cgv")).click();

		driver.findElement(By.xpath("//form[@id='form']/p/button/span")).click();
	}

}
