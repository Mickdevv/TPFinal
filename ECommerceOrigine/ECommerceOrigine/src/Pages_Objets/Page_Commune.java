package Pages_Objets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Page_Commune {
	@Test
	  public void SignOut(WebDriver driver) throws Exception {
	    driver.findElement(By.linkText("Sign out")).click();
	  }
	
	  @Test
	  public void AccesPanier(WebDriver driver) throws Exception {
	    driver.findElement(By.xpath("//header[@id='header']/div[3]/div/div/div[3]/div/a/b")).click();
	  }	
	  
}
