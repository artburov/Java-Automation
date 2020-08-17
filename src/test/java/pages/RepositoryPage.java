package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RepositoryPage extends BasePage {
    //Inside the repository locators
    private final By repoKusoPomFile = By.xpath("//a[@title='pom.xml']");
    private final By repoKusoSeleniumVersion = By.xpath("//td[@id='LC27' and text()='>3.141.59</' ]");

    public RepositoryPage(WebDriver driver) {
        super(driver);
    }

    public void findPomFile() {
        validateTrue(repoKusoPomFile);
        driver.findElement(repoKusoPomFile).click();

        validateTrue(repoKusoSeleniumVersion);
        Assert.assertEquals("3.141.59", driver.findElement(repoKusoSeleniumVersion)
                .getText()
                .trim()
                .substring(9, 17));
    }

    public void validateTrue(By element) {
        Assert.assertTrue(driver.findElement(element).isDisplayed());
    }

    public String repoSeleniumVersion() {
        return driver.findElement(repoKusoSeleniumVersion).getText().trim().substring(9, 17);
    }
}
