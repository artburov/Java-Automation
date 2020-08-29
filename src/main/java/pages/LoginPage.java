package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class LoginPage extends BasePage {
    //Login locators
    private final By userNameField = By.id("login_field");
    private final By userPasswordField = By.id("password");
    private final By signInButton = By.name("commit");
    private final By errorMessage = By.xpath("//div[@class='container-lg px-2']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Setup system properties from code instead of Edit test class configuration
//    private final String userName = System.setProperty("user", "Test");
//    private final String userPass = System.setProperty("pass", "Test123");

    public void negativeAuthentication(String username, String userpass) {
        validateCredentialsFields();

        driver.findElement(userNameField).sendKeys(username);
        driver.findElement(userPasswordField).sendKeys(userpass);
        driver.findElement(signInButton).click();
    }

    public MainPage positiveAuthentication() {
        validateCredentialsFields();

        driver.findElement(userNameField).sendKeys(System.getProperty("user"));
        driver.findElement(userPasswordField).sendKeys(System.getProperty("pass"));
        driver.findElement(signInButton).click();
        return new MainPage(this.driver);
    }

    public void incorrectCredentialsMessage() {
        assertEquals("Incorrect username or password.", driver.findElement(errorMessage).getText());
    }

    public void validateCredentialsFields() {
        assertTrue(driver.findElement(userNameField).isDisplayed());
        assertTrue(driver.findElement(userPasswordField).isDisplayed());
        assertTrue(driver.findElement(signInButton).isDisplayed());
    }
}


