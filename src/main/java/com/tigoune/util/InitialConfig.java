package com.tigoune.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InitialConfig {

	public static WebDriver chromedriver = null;

	InternetExplorerDriver iedriver = null;

	


	public static void webBroserConfig(String webBroserType, String url) {

		if (webBroserType.equals("chrome")) {
			String exePath = "src/test/resources/driver/chromedriver6.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			chromedriver = new ChromeDriver();
			chromedriver.get(url);
			chromedriver.manage().window().maximize();
			chromedriver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
		}

	}


	public static void closeBrowser() {

		chromedriver.quit();

	}

	protected static WebElement el(By by) {
		return chromedriver.findElement(by);
	}

	protected static void click(By by) {
		el(by).click();
	}

	protected static void type(By by, String str) {
		el(by).sendKeys(str);

	}

	protected static String getTextByXpath(String xpath) {

		return chromedriver.findElement(By.xpath(xpath)).getText();

	}

	protected static void clickStringXpath(String xpath) {

		chromedriver.findElement(By.xpath(xpath));

	}

	protected static String getAttributeXpath(String xpath) {

		return chromedriver.findElement(By.xpath(xpath)).getAttribute("href");

	}

	protected static void openUrl(String url) {
		chromedriver.get(url);
	}

	protected static void scroll() {
		((JavascriptExecutor) chromedriver).executeScript("scroll(0,400)");
	}

	protected static void waitForElement(By element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(chromedriver, timeOutInSeconds);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(element),
				ExpectedConditions.presenceOfElementLocated(element), ExpectedConditions.elementToBeSelected(element)));
	}

}