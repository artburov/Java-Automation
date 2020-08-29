package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertTrue;

public abstract class NavigationBar extends BasePage {
    //Tabs locators
    protected final By allTabsList = By.xpath("//ul[@class = 'UnderlineNav-body list-style-none ']/li");
    protected final By issueTab = By.xpath("//span[contains(text(), 'Issues')]");

    //log-out locators
    private final By avatarImage = By.xpath("//*[@aria-label='View profile and more']");
    private final By signOut = By.xpath("//button[contains(text(),'Sign out')]");
    private final By signOutAssertText = By.xpath("//h1[contains(text(),'Built for developers')]");


    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public LoginPage signOut() {
        validateTrue(avatarImage);
        driver.findElement(avatarImage).click();
        driver.findElement(signOut).click();

        validateTrue(signOutAssertText);

        log.info("Logout from Git was done on " +
                (new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss")).format(new Date()));
        return new LoginPage(this.driver);
    }

    public void validateTrue(By element) {
        assertTrue(driver.findElement(element).isDisplayed());
    }
}
