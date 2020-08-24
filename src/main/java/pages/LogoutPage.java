package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage extends BasePage{
    //log-out locators
    private final By avatarImage = By.xpath("//*[@aria-label='View profile and more']");
    private final By signOut = By.xpath("//button[contains(text(),'Sign out')]");
    private final By signOutAssertText = By.xpath("//h1[contains(text(),'Built for developers')]");

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public void signOut() {
        validateTrue(avatarImage);
        driver.findElement(avatarImage).click();
        driver.findElement(signOut).click();

        validateTrue(signOutAssertText);
    }

    public void validateTrue(By element) {
        Assert.assertTrue(driver.findElement(element).isDisplayed());
    }
}
