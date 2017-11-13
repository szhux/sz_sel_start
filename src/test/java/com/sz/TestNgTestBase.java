package com.sz;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.Capabilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ru.stqa.selenium.factory.WebDriverPool;

/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase {

  protected static URL gridHubUrl = null;
  protected static String baseUrl;
  protected static Capabilities capabilities;

  protected WebDriver driver;

  @BeforeSuite
  public void initTestSuite() throws IOException {
    SuiteConfiguration config = new SuiteConfiguration();
    baseUrl = config.getProperty("site.url");
//    baseUrl = "https://ya.ru/";
    if (config.hasProperty("grid.url") && !"".equals(config.getProperty("grid.url"))) {
      gridHubUrl = new URL(config.getProperty("grid.url"));
    }
    capabilities = config.getCapabilities();
    

    
  }

  @BeforeMethod
  public void initWebDriver() {	  
//	  System.setProperty("webdriver.gecko.driver", "/Tools/Drivers/geckodriver-v0.19.1-win32/geckodriver.exe");
	  System.setProperty("webdriver.chrome.driver", "/Tools/Drivers/chromedriver_win32/chromedriver.exe");
	  
	  driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
	  
//	  driver = WebDriverPool.DEFAULT.getDriver(DesiredCapabilities.firefox());
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    WebDriverPool.DEFAULT.dismissAll();
  }
}
