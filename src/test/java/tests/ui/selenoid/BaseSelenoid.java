package tests.ui.selenoid;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

import static helpers.ExcelReader.readProviderDataFromExcel;
import static helpers.FileReader.loadDataForCreateIssuesProvider;

public class BaseSelenoid {
    protected WebDriver driver;
    protected DesiredCapabilities capabilities;

    @Before
    public void SetUp() throws MalformedURLException {
        //Can be parametrized from Jenkins -> clean test -Dbrowser=${BROWSER}
        System.setProperty("browser", "chrome");
        String selectedBrowser = System.getProperty("browser");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (selectedBrowser.equals("firefox")) {
            capabilities.setBrowserName("firefox");
            capabilities.setVersion("79.0");
        } else {
            capabilities.setBrowserName("chrome");
            capabilities.setVersion("84.0");
        }

        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        driver = new RemoteWebDriver(
                URI.create("http://localhost:4444/wd/hub/").toURL(), capabilities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
