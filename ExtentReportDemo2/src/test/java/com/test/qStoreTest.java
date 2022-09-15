package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.BasePackage.BaseClass;
import com.extentManager.ExtentManager;


public class qStoreTest extends BaseClass{

	@Test
	public void verifyLogoTest() {
		
		WebElement img = driver.findElement(By.xpath("//img[@alt='My Store']"));		
		Assert.assertTrue(img.isDisplayed());
	}
	
	@Test
	public void loginTest() {
		
		driver.findElement(By.id("email")).sendKeys("admin@xyz.com");
		driver.findElement(By.id("passwd")).sendKeys("admin@123");
		driver.findElement(By.id("SubmitLogin")).click();
		String actTitle=driver.getTitle();
		String expTitle="My account - My Store_1";
		Assert.assertEquals(actTitle, expTitle);
	}
	
	@Test
	public void sampleTest() {
		
		ExtentManager.test.createNode("Validation 1");
		Assert.assertTrue(true);
		ExtentManager.test.createNode("Validation 2");
		Assert.assertTrue(true);
		ExtentManager.test.createNode("Validation 3");
		Assert.assertTrue(true);
		ExtentManager.test.createNode("Validation 4");
		Assert.assertTrue(true);
	}
}
