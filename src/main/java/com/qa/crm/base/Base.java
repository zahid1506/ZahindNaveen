package com.qa.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	//pre-condition for my all pom and test classes=====
public static WebDriver driver;
public static Properties prop;
public static Logger log=Logger.getLogger("Base");

public Base(){
	
	BasicConfigurator.configure();
	DOMConfigurator.configure("Log4j.xml");
	try
	{
		
		
		prop=new Properties();
	FileInputStream fis=new FileInputStream("./src/main/java/com/qa/crm/frameworkUtility/config.properties");
	prop.load(fis);
	}
	catch(FileNotFoundException e){
		e.printStackTrace();
		
	}
	catch(IOException e){ 
		e.printStackTrace();
		
	}
}
public static void initialization(){
	String browsername=prop.getProperty("browser");
	if(browsername.equals("chrome")){
		log.info("before opening chrome");
		log.info("chrome is initialised");
		System.setProperty("webdriver.chrome.driver","C:/Users/Aritra/Desktop/selenium essentials/browser driver/chromedriver.exe");
		driver=new ChromeDriver();
		log.info("chrome is intialised");
		
	}
	else if(browsername.equals("firefox")){
		log.info("firefox is inilised");
		System.setProperty("webdriver.firefox.marionette","C:/Users/zahid/Desktop/selenium essentials/browser driver/geckodriver.exe");
		driver=new FirefoxDriver();
		
	}
	log.info("before loading url");
	driver.get(prop.getProperty("url"));
	log.info("after oading url");
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
}
}
