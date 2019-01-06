package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utility {

public static WebDriver driver;	
	
public Utility(WebDriver driver){
this.driver=driver;	
}
	
public static String fetchValue(String Key) throws Exception{
FileInputStream Fin=new FileInputStream(".//property//config");	
Properties property=new Properties();
property.load(Fin);
return property.get(Key).toString();	
}
	
public static void LaunchBrowser() throws Exception{
System.setProperty("webdriver.gecko.driver", ".//driver//geckodriver.exe");	
driver=new FirefoxDriver();
driver.get(Utility.fetchValue("URL"));
}

public static void EnterText(String locator, String locatorValue, String text ){

switch(locator){
	case "xpath":
	driver.findElement(By.xpath(locatorValue)).sendKeys(text);	
	break;
	case "name":
	driver.findElement(By.name(locatorValue)).sendKeys(text);	
	break;
}
}


public static void WaitTime() throws Exception{
Thread.sleep(5000);	
}


public static void Click(String locator,String locatorValue){
	
switch(locator){
case "xpath":
	driver.findElement(By.xpath(locatorValue)).click();;	
	break;
case "name":
	driver.findElement(By.name(locatorValue)).click();	
	break;
}
}
public static void closeDriver(){
	driver.close();
}

	

}
