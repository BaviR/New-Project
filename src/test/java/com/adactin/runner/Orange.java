package com.adactin.runner;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Orange {

	public static void main(String[] args) throws Throwable {
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\mahah\\eclipse-workspace\\Selenium\\Driver\\chromedriver.exe");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement findElement = driver.findElement(By.id("txtUsername"));
		findElement.sendKeys("Admin");
		WebElement yd = driver.findElement(By.xpath("//input[@type='password']"));
		yd.sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		// driver.findElement(By.xpath("//b[text()='My Info']")).click();
		// Thread.sleep(10000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement scroll = driver.findElement(By.xpath("(//a[text()='Qualifications'])[2]"));
		js.executeScript("arguments[0],scrollIntoView();", scroll);
		Thread.sleep(2000);
		scroll.click();
		driver.findElement(By.xpath("//input[@type='button'][10]")).click();
		WebElement dropdown = driver.findElement(By.id("education_code"));
		Select s = new Select(dropdown);
		s.selectByVisibleText("Bachelor's Degree");
		driver.findElement(By.xpath("//input[@type='text'][5]")).sendKeys("Madras university");
		driver.findElement(By.xpath("//input[@type='text'][6]")).sendKeys("Computer");
		driver.findElement(By.xpath("//input[@type='text'][7]")).sendKeys("2018");
		driver.findElement(By.xpath("//input[@type='text'][8]")).sendKeys("82");
		WebElement Startdate = driver.findElement(By.xpath("//input[@type='text'][9]"));
		Startdate.click();
		Startdate.sendKeys("2022-04-18");
		WebElement Enddate = driver.findElement(By.xpath("//input[@type='text'][10]"));
		Enddate.click();
		Enddate.sendKeys("2022-04-30");
		driver.findElement(By.xpath("//input[@type='button'][8]")).click();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File scrfile = ts.getScreenshotAs(OutputType.FILE);

	}

}
