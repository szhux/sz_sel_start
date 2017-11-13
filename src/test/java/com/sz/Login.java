package com.sz;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.testng.annotations.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Login extends com.sz.TestNgTestBase {
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
//	@Test
//	public void testUntitled() throws Exception{}
//	
//	private boolean acceptNextAlert = true;
//	private StringBuffer verificationErrors = new StringBuffer();
//	
	@Test
	public void testLogin() throws Exception{
		driver.get(baseUrl + "/php4dvd/");
//		driver.get("http://localhost:8080/php4dvd/");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("name")).sendKeys("admin");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
	}
	private boolean isElementPresent (By by){
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
		
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
