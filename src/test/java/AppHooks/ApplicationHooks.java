package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	private Properties prop;

	@Before(order=0)
	public void getProperty() {
		configReader=new ConfigReader();
		prop=configReader.initProperties();
	}

	@Before(order=1)
	public void initilizeBrowser() {
		driverFactory=new DriverFactory();
		driver=driverFactory.initDriver(prop.getProperty("browser"));

	}

	@After(order=0)
	public void quitBrowser() {
		driver.quit();
	}


	@After(order=1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			String screenshotName=scenario.getName().replace(" ", "_");
            byte[] sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}

}
