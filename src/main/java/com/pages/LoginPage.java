package com.pages;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.util.ConfigReader;



public class LoginPage {
	private WebDriver driver;
	private Properties prop;
	private ConfigReader configReader;

	By userName=By.xpath("//input[@name='username']");
	By password=By.xpath("//input[@id='password']");
	By loginButton=By.xpath("//input[@id='Login']");


	public LoginPage(WebDriver driver) {
		try {
			this.driver=driver;
			configReader=new ConfigReader();
			prop=configReader.initProperties();

		} catch (Exception e) {
			System.out.println();
			e.printStackTrace();
		}
	}

	public void navigateToSalesforceLoginPage() {
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

	public void enterusername() {
		driver.findElement(userName).sendKeys(prop.getProperty("loginUsername"));
		System.out.println("User name entered successfully");
	}

	public void enterpasword() {
		driver.findElement(password).sendKeys(prop.getProperty("loginPassword"));
		System.out.println("Passwordentered successfully");
	}

	public HomePage clickSubmitButton() {
		driver.findElement(loginButton).click();
		System.out.println("Login button clicked successfully");
		return new HomePage(driver);
	}

	public HomePage login() {
		navigateToSalesforceLoginPage();
		driver.findElement(userName).sendKeys(prop.getProperty("loginUsername"));
		driver.findElement(password).sendKeys(prop.getProperty("loginPassword"));
		driver.findElement(loginButton).click();
		return new HomePage(driver);
	}

}
