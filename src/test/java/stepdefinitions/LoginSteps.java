package stepdefinitions;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	private LoginPage loginPageObj=new LoginPage(DriverFactory.getDriver());
	private HomePage homePageObj;
	
	
	@Given("user is on saleforce login page")
	public void user_is_on_saleforce_login_page() {
	   loginPageObj.navigateToSalesforceLoginPage();   	
	}

	@When("user enters username")
	public void user_enters_username() {
		loginPageObj.enterusername();
	}

	@When("user enters password")
	public void user_enters_password() {
		loginPageObj.enterpasword();
	}

	@When("user clicks on submit button")
	public void user_clicks_on_submit_button() {
		homePageObj=loginPageObj.clickSubmitButton();
	}

	@Then("user should be directed to SalesforceHomePage")
	public void user_should_be_directed_to_salesforce_home_page() {
       System.out.println("Validation of the user navigation to the HomePage of salesforce");		
	}
}
