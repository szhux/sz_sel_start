package com.sz;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FindOnYaRu extends TestNgTestBase{
//  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

//  @BeforeMethod
//public void setUp() throws Exception {
////    driver = new FirefoxDriver();
//    baseUrl = "https://ya.ru/";
//    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//  }

  @Test
  public void testFindOnYaRu() throws Exception {
//	driver.get(baseUrl);
	driver.get("https://ya.ru/");	  
    driver.findElement(By.id("text")).click();
    driver.findElement(By.id("text")).clear();
    driver.findElement(By.id("text")).sendKeys("Check");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
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
}