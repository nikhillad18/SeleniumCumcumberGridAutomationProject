package com.qa.util;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	public void waitForElement(WebDriver driver,By xpath) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
		System.out.println("Element is visible");

	}


	public void scrollIntoElement(WebDriver driver,WebElement element) {
		try {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		}catch(Exception e) {
			System.out.println("Exception while scrolling intoElement using Javascript executor");
			e.printStackTrace();
		}
	}

}
