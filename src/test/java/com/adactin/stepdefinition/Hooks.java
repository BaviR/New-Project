package com.adactin.stepdefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.adactin.runner.Runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;

public class Hooks {

	private static WebDriver driver = Runner.driver;

	@Before
	public void before_Hooks(Scenario scenario) {
		String name = scenario.getName();
		System.out.println("Scenario name : " + name);
	}

	@After
	public void after_Hooks(Scenario scenario) throws Throwable {
		Status status = scenario.getStatus();
		System.out.println("Scenario status : " + status);

		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destinate = new File(
					"C:\\Users\\Welcome\\eclipse-workspace\\Adactin_Project\\Failed_Screenshot\\img.png");
			FileUtils.copyFileToDirectory(source, destinate);
		}
	}

}
