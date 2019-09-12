package com.mmt.qa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	static Properties prop;
	static WebDriver driver;
	
	public static void main(String args[]) {
		
	prop= new Properties();
	try {
		FileInputStream flr=new FileInputStream("C:\\Users\\ujjwalsaxena\\Desktop\\Qait@12M\\mmt\\src\\main\\java\\com\\mmt\\qa\\config\\Config.prop");
	   try {
		prop.load(flr);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Initbrowser();
	}
	
	public static void Initbrowser()
	{
	  String browsername=prop.getProperty("browser");
	  String urlname=prop.getProperty("url");
      if(browsername.equals("chrome"))
      {    	 
	  System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.get(prop.getProperty("url"));
	  driver.manage().deleteAllCookies();
	  driver.manage().window().maximize();
	  System.out.println("Launched MMT");
	  System.out.println("************************************************************");
      }
	}
	
}
