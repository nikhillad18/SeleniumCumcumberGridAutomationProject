package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.util.ElementUtil;

public class HomePage {
	private WebDriver driver;
	private ElementUtil utility=new ElementUtil();


	private By homeTab=By.xpath("//span[contains(text(),'Home')]");
	By appLauncher=By.xpath("//span[contains(text(),'App Launcher')]/parent::div");
	By searchOption=By.xpath("//input[contains(@placeholder,'Search apps' )]");



	public HomePage(WebDriver driver) {
		this.driver=driver;       
	}


	public void clickOnHomeTab() {
		utility.waitForElement(driver, homeTab);
		driver.findElement(homeTab).click();
	}

	public void clickAppLauncher() {
		utility.waitForElement(driver, appLauncher);
		driver.findElement(appLauncher).click();

	}

	public void enterApplicationNameToBeSearchedInSearch(String applicationName) {
		utility.waitForElement(driver, searchOption);
		driver.findElement(searchOption).sendKeys(applicationName);
	}


	public void selectCloudApplicationFromAppConsole(String applicationName) {
		// //img[contains(@src,'logos/Salesforce/MarketingCloud/logo.png')]
		String cloudApplicationXpath="//img[contains(@src,'logos/Salesforce/"+applicationName+"Cloud/logo.png')]";
		//wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cloudApplicationXpath)));
		utility.waitForElement(driver, By.xpath(cloudApplicationXpath));
		driver.findElement(By.xpath(cloudApplicationXpath)).click();
	}


	public boolean verifySalesCloudApplicationLoadedSuccessfully(String applicationName) {
		try {
			utility.waitForElement(driver, By.xpath("//span[@title='"+applicationName+"']"));
		}catch(Exception e) {
			System.out.println("Not able to Land on "+applicationName+" Page after entering selecting the application from app launcher");
			e.printStackTrace();
		}
		return false;
	}
}
