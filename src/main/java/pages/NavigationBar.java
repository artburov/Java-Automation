package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertTrue;

public abstract class NavigationBar extends HomePage {
    //log-out locators
    private final By avatarImage = By.xpath("//*[@aria-label='View profile and more']");
    private final By signOut = By.xpath("//button[contains(text(),'Sign out')]");


    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public HomePage signOut() {
        validateTrue(avatarImage);
        driver.findElement(avatarImage).click();
        driver.findElement(signOut).click();

        validateTrue(signOutAssertText);

        log.info("Logout from Git was done on " +
                (new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss")).format(new Date()));
        return new HomePage(this.driver);
    }

    public void validateTrue(By element) {
        assertTrue(driver.findElement(element).isDisplayed());
    }
}
