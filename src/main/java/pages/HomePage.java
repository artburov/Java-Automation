package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    //log-out assert locators
    protected By signOutAssertText = By.xpath("//h1[contains(text(),'Built for developers')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
