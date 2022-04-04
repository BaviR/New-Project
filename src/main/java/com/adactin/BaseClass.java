
package com.adactin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver getdriver(String browsername) {

		try {
			if (browsername.equalsIgnoreCase("chrome")) {
//				System.setProperty("webdriver.chrome.driver",
//						System.getProperty("user.dir") + ("\\Driver\\chromedriver.exe")); // user.directory file is
//																							// predefined method
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}

			else if (browsername.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver",
						System.getProperty("user.dir") + ("\\Driver\\msedgedriver.exe"));
				driver = new EdgeDriver();

			} else {
				System.out.println("Invalid Browser");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.manage().window().maximize();
		return driver;
	}

	public static void getUrl(String Url) {

		try {
			driver.get(Url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void CurrentUrl() {
		driver.getCurrentUrl();

	}

	public static void forward() {
		driver.navigate().forward();

	}

	public static void backward() {
		driver.navigate().back();
	}

	public static void refresh() {
		driver.navigate().refresh();
	}

	public static void naviagteTo(String Url) {
		driver.navigate().to(Url);
	}

	public static void close() {
		driver.close();
	}

	public static void quit() {
		driver.quit();
	}

	public static void getTitle() {
		driver.getTitle();
	}

	public static void enabled(WebElement element) {
		element.isEnabled();
	}

	public static void displayed(WebElement element) {
		element.isDisplayed();
	}

	public static void selected(WebElement element) {
		element.isSelected();
	}

	public static void screenshot(String path) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver; // add typecast
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File destinateFile = new File(path); // create parameter excp.

		FileUtils.copyFileToDirectory(sourceFile, destinateFile); // throws excep.
	}

	public static void clear(WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
		}
	}

	public static void inputValue(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void click(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void dropdown(WebElement element, String Options, String value) {

		Select s = new Select(element); // take return type for new Select

		try {
			if (Options.equalsIgnoreCase("byIndex")) {
				int parseInt = Integer.parseInt(value); // take returntype for Integer.parseInt
				s.selectByIndex(parseInt);
			} else if (Options.equalsIgnoreCase("byValue")) {
				s.selectByValue(value);

			} else if (Options.equalsIgnoreCase("byVisibleText")) {
				s.selectByVisibleText(value);

			} else {
				System.out.println("Invalid Selection");
			}
		} catch (NumberFormatException e) {

			e.printStackTrace();
		}

	}

	public static void dropdown1(WebElement element, String Options, String value) {

		Select s = new Select(element); // take return type for new Select

		try {
			if (Options.equalsIgnoreCase("byIndex")) {
				int parseInt = Integer.parseInt(value); // take returntype for Integer.parseInt
				s.selectByIndex(parseInt);
			} else if (Options.equalsIgnoreCase("byValue")) {
				s.selectByValue(value);

			} else if (Options.equalsIgnoreCase("byVisibleText")) {
				s.selectByVisibleText(value);

			} else {
				System.out.println("Invalid Selection");
			}
		} catch (NumberFormatException e) {

			e.printStackTrace();
		}

	}

	public static void simpleAlert() {
		driver.switchTo().alert().accept();

	}

	public static void confirmAlert(String ok, String cancel) {

		if (ok.equalsIgnoreCase("ok")) {
			driver.switchTo().alert().accept();

		} else if (cancel.equalsIgnoreCase(cancel)) {
			driver.switchTo().alert().dismiss();

		}
	}

	public static void promptAlert(String ok, String value, String cancel) {
		if (ok.equalsIgnoreCase("ok")) {
			driver.switchTo().alert().sendKeys(value);
			driver.switchTo().alert().accept();
		} else if (cancel.equalsIgnoreCase("cancel")) {
			driver.switchTo().alert().sendKeys(value);
			driver.switchTo().alert().accept();

		}

	}

	public static void actionMethod(WebElement element) {
		Actions ac = new Actions(driver);
		ac.contextClick(element).build().perform();
	}

	public static void moveToElement(WebElement element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element).build().perform();
	}

	public static void dragDrop(WebElement element, WebElement element1) {
		Actions ad = new Actions(driver);
		ad.dragAndDrop(element, element1).build().perform();
	}

	public static void robotClass() throws AWTException {
		Robot rc = new Robot();
		rc.keyPress(KeyEvent.VK_DOWN);
		rc.keyRelease(KeyEvent.VK_DOWN);
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void pageUp(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver; // add typecast as JS
		js.executeScript("argument[0].scrollIntoView();", element);
	}

	public static void pageDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView();", element);
	}

	public static void frameMethod(String Option, String value, WebElement element) {
		try {
			if (Option.equalsIgnoreCase("byIndex")) {
				int index = Integer.parseInt(value);
				driver.switchTo().frame(index);
			} else if (Option.equalsIgnoreCase("byElement")) {
				driver.switchTo().frame(element);
			} else if (Option.equalsIgnoreCase("byString")) {
				driver.switchTo().frame(value);
			} else {
				System.out.println("Invalid selection");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public static void windowHandles() {
		Set<String> element = driver.getWindowHandles(); // returntype
		for (String st : element) {
			String title = driver.switchTo().window(st).getTitle(); // returntype
			System.out.println(title);
		}
	}

}
