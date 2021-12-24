package Pages_Objets;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Page_Sign_in {

	StringBuffer verificationErrors = new StringBuffer();

	@Test
	public void createAcount(WebDriver driver , 
			String vemail , String vgender , String vFirstName , String vLastName , 
			String vPwd , String vLigneadresse , String vCity , String vState , 
			String vZipCode , String vPhoneNumber
			
			) throws Exception {
		driver.findElement(By.linkText("Sign in")).click();

		System.out.println("Création de compte");

		driver.findElement(By.id("email_create")).click();
		driver.findElement(By.id("email_create")).clear();
		driver.findElement(By.id("email_create")).sendKeys(vemail);
		
		driver.findElement(By.xpath("//button[@id='SubmitCreate']/span")).click();
		
		// Civilité 
		if (vgender=="M") {
			driver.findElement(By.id("id_gender1")).click();
		} else {
			driver.findElement(By.id("id_gender2")).click();
		}
		
		driver.findElement(By.id("customer_firstname")).click();
		driver.findElement(By.id("customer_firstname")).clear();
		driver.findElement(By.id("customer_firstname")).sendKeys(vFirstName);
		
		driver.findElement(By.id("customer_lastname")).click();
		driver.findElement(By.id("customer_lastname")).clear();
		driver.findElement(By.id("customer_lastname")).sendKeys(vLastName);
		
		driver.findElement(By.id("passwd")).click();
		driver.findElement(By.id("passwd")).clear();
		driver.findElement(By.id("passwd")).sendKeys(vPwd);
		
		driver.findElement(By.id("address1")).click();
		driver.findElement(By.id("address1")).clear();
		driver.findElement(By.id("address1")).sendKeys(vLigneadresse);
		
		driver.findElement(By.id("city")).click();
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys(vCity);
		
		driver.findElement(By.id("id_state")).click();
		new Select(driver.findElement(By.id("id_state"))).selectByVisibleText(vState);
		driver.findElement(By.id("id_state")).click();
		
		driver.findElement(By.id("postcode")).click();
		driver.findElement(By.id("postcode")).clear();
		driver.findElement(By.id("postcode")).sendKeys(vZipCode);
		
		driver.findElement(By.id("phone_mobile")).click();
		driver.findElement(By.id("phone_mobile")).clear();
		driver.findElement(By.id("phone_mobile")).sendKeys(vPhoneNumber);
		
		driver.findElement(By.xpath("//button[@id='submitAccount']/span")).click();
		
	}
	
	  @Test
	  public void SignInWithValideAccount(WebDriver driver , String vemail , String vPwd) throws Exception {
		  
	    driver.findElement(By.linkText("Sign in")).click();
	    
	    driver.findElement(By.id("email")).click();
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys(vemail);
	  
	    driver.findElement(By.id("passwd")).click();
	    driver.findElement(By.id("passwd")).clear();
	    driver.findElement(By.id("passwd")).sendKeys(vPwd);
	    
	    driver.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();
	    driver.findElement(By.xpath("//div[@id='center_column']/h1")).click();
	    
	    try {
	      assertEquals(driver.findElement(By.xpath("//div[@id='center_column']/h1")).getText(), "My account");
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath("//div[@id='columns']/div[3]")).click();
	  }
	  
	  @Test
	  public void SignInWithInvalideAccount(WebDriver driver , String vemail , String vPwd) throws Exception {
	    driver.get("http://automationpractice.com/index.php?controller=order");
	    driver.findElement(By.linkText("Sign in")).click();
	    driver.findElement(By.id("email")).click();
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys(vemail);
	    driver.findElement(By.id("passwd")).click();
	    driver.findElement(By.id("passwd")).clear();
	    driver.findElement(By.id("passwd")).sendKeys(vPwd);
	    driver.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();
	    try {
	      assertEquals(driver.findElement(By.xpath("//div[@id='center_column']/div/ol/li")).getText(), "Invalid password.");
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	  }
	  


}
