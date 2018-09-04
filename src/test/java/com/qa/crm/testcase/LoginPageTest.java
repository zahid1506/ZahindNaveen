package com.qa.crm.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.base.Base;
import com.qa.crm.pages.LoginPOM;

public class LoginPageTest extends Base{
	LoginPOM lp;

	@BeforeMethod
	public void init(){
		Base.initialization();
		lp=new LoginPOM(driver);
		
	}
	@Test(priority=1)
	
	public void verifylogo(){
		log.info("executing and checking if logo is displayed or not");
		lp.displaylogo();
	}
	@Test(priority=2)
	public void LoginToHome(){
		log.info("log in into the app");
		lp.loginTOHome();
	}
	@AfterMethod
	public void close(){
		driver.quit();
	}
}
// i m zahid from git
