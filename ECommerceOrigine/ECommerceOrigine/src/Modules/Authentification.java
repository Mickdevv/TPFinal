package Modules;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages_Objets.Page_Sign_in;

public class Authentification {

	@Test
	public void CreateAcountWithoutControle(WebDriver driver , 
			String vemail , String vgender , String vFirstName , String vLastName , 
			String vPwd , String vLigneadresse , String vCity , String vState , 
			String vZipCode , String vPhoneNumber) throws Exception {
		
		new Page_Sign_in().createAcount(driver, vemail , vgender, vFirstName, vLastName, vPwd, vLigneadresse, vCity, vState, vZipCode, vPhoneNumber);
	}

	@Test
	public void CreateAcountWithControle(WebDriver driver , 
			String vemail , String vgender , String vFirstName , String vLastName , 
			String vPwd , String vLigneadresse , String vCity , String vState , 
			String vZipCode , String vPhoneNumber) throws Exception {

		//Todo
	}

	@Test
	public void SignInWithoutControle(WebDriver driver , 
			String vemail , String vPwd ) throws Exception {

		System.out.println("Call SignInWithValideAccount");
		new Page_Sign_in().SignInWithValideAccount(driver, vemail, vPwd);
	}

	@Test
	public void SignInWithControle(WebDriver driver , 
			String vemail , String vPwd ) throws Exception {

		System.out.println("Call SignInWithInvalideAccount");
		new Page_Sign_in().SignInWithInvalideAccount(driver, vemail, vPwd);

	}

}
