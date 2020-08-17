package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage{
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
        Assert.assertTrue(driver.findElement(element).isDisplayed());
    }

    public void validateFalse(By element) {
        Assert.assertFalse(driver.findElement(element).isDisplayed());
    }
}
