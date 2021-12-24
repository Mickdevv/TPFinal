package Commun;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class OuvrirApplication {

	@Test
  public void LancerAppliChrome(WebDriver driver , String PathWebDriver , String vBaseUrl) throws Exception {
		System.setProperty("webdriver.chrome.driver", PathWebDriver);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(vBaseUrl);
	} 
  
	@Test
	  public void LancerAppliFireFox(WebDriver driver , String PathWebDriver , String vBaseUrl) throws Exception {
			System.setProperty("webdriver.gecko.driver", PathWebDriver);
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(vBaseUrl);
		} 

}
