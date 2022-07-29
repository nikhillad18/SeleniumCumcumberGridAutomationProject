package stepdefinitions;

import java.util.List;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {
	private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
	private HomePage homePage;

	@Given("User is already logged into Salesforce Application")
	public void user_is_already_logged_into_salesforce_application() {
		homePage=loginPage.login();
	}

	@Given("user is on saleforce Home page")
	public void user_is_on_saleforce_home_page() {
		homePage.clickOnHomeTab();
	}

	@When("user clicks on the AppLauncher button")
	public void user_clicks_on_the_app_launcher_button() {
		homePage.clickAppLauncher();
	}

	@When("user enters Application name in the seatch box")
	public void user_enters_application_name_in_the_seatch_box(DataTable datatable) {
		List<String> applicationNames=datatable.asList();
		homePage.enterApplicationNameToBeSearchedInSearch(applicationNames.get(0));
	}


	@When("user Selects the application retrieved from the drop down list")
	public void user_selects_the_application_retrieved_from_the_drop_down_list(DataTable datatable) {
		List<String> applicationNames=datatable.asList();
		homePage.selectCloudApplicationFromAppConsole(applicationNames.get(0));
	}

	@Then("user should be directed to Application Page")
	public void user_should_be_directed_to_application_page(DataTable datatable) {
		List<String> applicationNames=datatable.asList();
		homePage.verifySalesCloudApplicationLoadedSuccessfully(applicationNames.get(0));
	}


}
