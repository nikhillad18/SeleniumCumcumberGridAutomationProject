package com.qa.factory;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tldriver=new ThreadLocal<>();

	public WebDriver initDriver(String browser) {
		if(browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			tldriver.set(new ChromeDriver(options));
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
		}
		else if(browser.equalsIgnoreCase("Remote")) {
			DesiredCapabilities caps=new DesiredCapabilities();
			caps.setPlatform(Platform.WINDOWS);
			caps.setBrowserName("chrome");
			try {
				tldriver.set(new RemoteWebDriver(new URL("http://192.168.0.102:4444/"),caps));
			} catch (Exception e) {
				System.out.print("Exception in setting up the remote triver exception is as below");
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Incorrect browser mentioned to Initiliaze "+browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return tldriver.get();
	}

	public static synchronized WebDriver  getDriver() {
		return tldriver.get();
	}


}
