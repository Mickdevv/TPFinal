package Pages_Objets;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Page_Payment {
	@Test
	public void PaymentByBankWire(WebDriver driver) throws Exception {

		StringBuffer verificationErrors = new StringBuffer();

		try {
			assertEquals(driver.findElement(By.xpath("//div[@id='center_column']/h1")).getText(), "Please choose your payment method");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}

		driver.findElement(By.xpath("//div[@id='HOOK_PAYMENT']/div/div/p/a/span")).click();

		try {
			assertEquals(driver.findElement(By.xpath("//div[@id='center_column']/form/div/h3")).getText(), "Bank-wire payment.");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		
		driver.findElement(By.xpath("//p[@id='cart_navigation']/button/span")).click();
		
	    try {
	        assertEquals(driver.findElement(By.xpath("//div[@id='center_column']/p")).getText(), "Your order on My Store is complete.");
	      } catch (Error e) {
	        verificationErrors.append(e.toString());
	      }
		
	}

	@Test
	public void PaymentByCheck(WebDriver driver) throws Exception {

		StringBuffer verificationErrors = new StringBuffer();

		try {
			assertEquals(driver.findElement(By.xpath("//div[@id='center_column']/h1")).getText(), "Please choose your payment method");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}

		driver.findElement(By.xpath("//div[@id='HOOK_PAYMENT']/div[2]/div/p/a/span")).click();
		
		try {
			assertEquals(driver.findElement(By.xpath("//div[@id='center_column']/form/div/h3")).getText(), "Check payment");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		
		try {
			assertEquals(driver.findElement(By.xpath("//div[@id='center_column']/form/div/p/strong")).getText(), "You have chosen to pay by check. Here is a short summary of your order:");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		
		driver.findElement(By.xpath("//p[@id='cart_navigation']/button/span")).click();
		
	    try {
	        assertEquals(driver.findElement(By.xpath("//div[@id='center_column']/p")).getText(), "Your order on My Store is complete.");
	      } catch (Error e) {
	        verificationErrors.append(e.toString());
	      }
	    
	      try {
	        assertEquals(driver.findElement(By.xpath("//div[@id='center_column']/div/h3")).getText(), "Your check must include:");
	      } catch (Error e) {
	        verificationErrors.append(e.toString());
	      }      
	}

}
