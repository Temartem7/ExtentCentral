package com.BasePackage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.extentManager.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		ExtentManager.setExtent();
	}

	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	public static String screenshot(WebDriver driver, String fileName) {
		String dateName = new SimpleDateFormat("yyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "\\Screenshot\\" + fileName + "_" + dateName + ".png";
		File finalPath = new File(path);
		try {
			FileUtils.copyFile(src, finalPath);
		} catch (Exception e) {
			e.getMessage();
		}
		return path;
	}
	
	
	//extent report date and time 
	public static String getCurrTime() {
		String currDate= new SimpleDateFormat("yyy-MM-dd-hhmmss").format(new Date());
		return currDate;
	}

}
