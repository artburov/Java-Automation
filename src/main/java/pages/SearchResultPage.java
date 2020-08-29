package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class SearchResultPage extends NavigationBar {
    //Search result for needed repository locators
    private final By repoKuso = By.xpath("//a[contains(text(),'BKuso')]");
    private final By repoKusoTitle = By.xpath("//a[contains(text(),'G44Automation') and @href='/BKuso/G44Automation']");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public RepositoryPage findSpecifiedRepo() {
        validateTrue(repoKuso);
        driver.findElement(repoKuso).click();

        validateTrue(repoKusoTitle);
        return new RepositoryPage(this.driver);
    }

    public void validateTrue(By element) {
        assertTrue(driver.findElement(element).isDisplayed());
    }

    public void validateFalse(By element) {
        assertFalse(driver.findElement(element).isDisplayed());
    }
}