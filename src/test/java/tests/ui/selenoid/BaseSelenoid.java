package tests.ui.selenoid;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class BaseSelenoid {
    protected WebDriver driver;
    protected DesiredCapabilities capabilities;

    @Before
    public void SetUp() throws MalformedURLException {
        /* Can be parametrized from Jenkins -> clean test -Dbrowser=${BROWSER} or just from edit configuration */

        //Manual select browser, ex. firefox, chrome, opera into ""
        System.setProperty("browser", "");
        String selectedBrowser = System.getProperty("browser");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch (selectedBrowser) {
            case "firefox":
                capabilities.setBrowserName("firefox");
                capabilities.setVersion("79.0");
                capabilities.setCapability("enableVNC", true);
                capabilities.setCapability("enableVideo", false);
                driver = new RemoteWebDriver(
                        URI.create("http://localhost:4444/wd/hub/").toURL(), capabilities);
                break;
            case "chrome":
            default:
                capabilities.setBrowserName("chrome");
                capabilities.setVersion("84.0");
                capabilities.setCapability("enableVNC", true);
                capabilities.setCapability("enableVideo", false);
                driver = new RemoteWebDriver(
                        URI.create("http://localhost:4444/wd/hub/").toURL(), capabilities);
                break;
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
