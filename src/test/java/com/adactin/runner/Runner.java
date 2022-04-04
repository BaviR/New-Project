package com.adactin.runner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.adactin.BaseClass;
import com.adactin.config.File_Reader_Manager;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\adactin\\feature", glue = "com\\adactin\\stepdefinition", 
monochrome = true, tags = "@LoginMultiple or @Login" , plugin = {
		"pretty" , "html:target/report.html"})

public class Runner {

	public static WebDriver driver;

	@BeforeClass
	public static void setup() throws Throwable {
		String browser = File_Reader_Manager.getInstance().getInstanceCR().getBrowser();
		driver = BaseClass.getdriver(browser);
		String url = File_Reader_Manager.getInstance().getInstanceCR().getUrl();
		driver.get(url);
	}
}
