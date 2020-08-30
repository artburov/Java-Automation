package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.workPanel.WorkPanelMenu;

import static org.junit.Assert.*;

public class SearchResultPage extends WorkPanelMenu {
    //Search result for needed repository locators
    private final By repoKuso = By.xpath("//a[contains(text(),'BKuso')]");
    private final By repoBurov = By.xpath("//div[contains(text(),'artburov')]");
//    private final By repoBurov = By.xpath("//div[@id='dashboard-repos-container']//span[contains(text(),'Java-Automation')]");
    private final By repoKusoTitle = By.xpath("//a[contains(text(),'G44Automation') and @href='/BKuso/G44Automation']");
    private final By repoBurovTitle = By.xpath("//a[contains(text(),'Java-Automation') and @href='/artburov/Java-Automation']");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public RepositoryPage findKusoRepo() {
        validateTrue(repoKuso);
        driver.findElement(repoKuso).click();

        validateTrue(repoKusoTitle);
        return new RepositoryPage(this.driver);
    }

    public RepositoryPage findBurovRepo() {
        validateTrue(repoBurov);
        driver.findElement(repoBurov).click();

        validateTrue(repoBurovTitle);
        return new RepositoryPage(this.driver);
    }


    public void validateTrue(By element) {
        assertTrue(driver.findElement(element).isDisplayed());
    }

    public void validateFalse(By element) {
        assertFalse(driver.findElement(element).isDisplayed());
    }
}