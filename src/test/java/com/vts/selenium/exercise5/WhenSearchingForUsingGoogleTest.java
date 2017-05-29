package com.vts.selenium.exercise5;




import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WhenSearchingForUsingGoogleTest {
	  private String baseUrl;
	  private WebDriver driver;
	  private ScreenshotHelper screenshotHelper;
	  
	  @Before
	  public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "/home/jagrat/Downloads/chromedriver");
	    baseUrl = System.getProperty("webdriver.base.url");
	    driver = new ChromeDriver();
//	    driver = new FirefoxDriver();
	    driver.get("https://www.google.co.in/");
	    driver.get(baseUrl);
	    screenshotHelper = new ScreenshotHelper();
	  }
	  
	  @After
	  public void saveScreenshotAndCloseBrowser() throws IOException {
	    screenshotHelper.saveScreenshot("screenshot.png");
	    driver.quit();
	  }
	  
	  @Test
	  public void pageTitleAfterSearchShouldBeginWithDrupal() throws IOException {
	    assertEquals("The page title should equal Google at the start of the test.", "Google", driver.getTitle());
	    
	    
	    
	  }
	  
	  private class ScreenshotHelper {
	  
	    public void saveScreenshot(String screenshotFileName) throws IOException {
	      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	      FileUtils.copyFile(screenshot, new File(screenshotFileName));
	    }
	  }
}
