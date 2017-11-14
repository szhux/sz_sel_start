package com.sz;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.sz.pages.HomePage;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import java.util.regex.Pattern;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TesterBeginnerA extends TestNgTestBase{
//  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
//  private HomePage homepage;
  private static final String textOnPage = "тестирование";
//  @BeforeMethod
//public void setUp() throws Exception {
////    driver = new FirefoxDriver();
//    baseUrl = "https://ya.ru/";
//    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//  }

//  @BeforeMethod
//  public void initPageObjects() {
//    homepage = PageFactory.initElements(driver, HomePage.class);
//  }
  
  @Test
  public void testFindOnYaRu() throws Exception {
//	driver.get(baseUrl);
	driver.get("https://yandex.ru/");	  
	driver.findElement(By.id("text")).click();
    driver.findElement(By.id("text")).clear();
    driver.findElement(By.id("text")).sendKeys("тестирование");    
// this finder works fine for ya.ru 
//  driver.findElement(By.xpath("//button[@type='submit']")).click();
    
// this finder works fine for all yandex pages
    driver.findElement(By.xpath("html/body/div[1]/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div/form/div[2]/button")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    (new WebDriverWait(driver, 50))
//    .until(ExpectedConditions.titleContains("Тестирование программного обеспечения — Википедия"));
    
 // by linktest works fine
 //   driver.findElement(By.linkText("Тестирование программного обеспечения — Википедия")).click();
//	by xPath
    driver.findElement(By.xpath("html/body/div[3]/div[1]/div[2]/div[1]/div[1]/ul/li[3]/div/h2/a")).click();
    
    List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + textOnPage + "')]"));
    System.out.println(list.toString());
    Assert.assertTrue(list.size() > 0, "Text not found!");
    
//    assertTrue(, );        
  }
  
  

  @AfterMethod
public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      Assert.fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
  
//  public boolean verifyTextPresent(WebElement rootElement, String tag, String text) {
//	  List<WebElement> elements = rootElement.findElements(By.tagName(tag));
//	  boolean match = false;
//	  for (WebElement elem : elements){
//		  String elementText = elem.getText();
//		  if (elementText.contains(text)){
//			  match = true;
//			  break;
//		  }
//	  }
//	  
//	  try {
//		  Assert.assertTrue(match);
//		  System.out.println("\"" + text + "\" was found within elements within the passed in WebElement with ID (" + rootElement.getAttribute("id")+ ")");
//	  }
//	  catch (Exception e) {
//		  System.err.println("\"" + text + "\" not found within elements within the passed in WebElement with ID (" + rootElement.getAttribute("id")+ ")");
//	  }
//	  return match;
//	 }

}