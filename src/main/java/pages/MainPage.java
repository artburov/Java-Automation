package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.workPanel.WorkPanelMenu;

import static org.junit.Assert.*;

public class MainPage extends WorkPanelMenu {
    //Search the specified repository locators
    private final By searchRepo = By.xpath("//input[@name= 'q' and @placeholder='Search or jump to…']");
    private final By needRepo = By.xpath("//div[contains(text(),'G44Automation')]");
    private final By burovRepo = By.xpath("//*[contains(text(),'Java-Automation')]");


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage validateUrl() {
        assertEquals("https://github.com/", driver.getCurrentUrl().toString());
        return this;
    }

    public SearchResultPage searchNeededRepo() {
        validateTrue(searchRepo);

        driver.findElement(searchRepo).click();
        driver.findElement(searchRepo).clear();
        driver.findElement(searchRepo).sendKeys("G44Automation");

        validateTrue(needRepo);

        driver.findElement(needRepo).click();
        return new SearchResultPage(this.driver);
    }

    public SearchResultPage searchBurovRepo() {
        validateTrue(searchRepo);

        driver.findElement(searchRepo).click();
        driver.findElement(searchRepo).clear();
        driver.findElement(searchRepo).sendKeys("Java-Automation");

        validateTrue(burovRepo);

        driver.findElement(burovRepo).click();
        return new SearchResultPage(this.driver);
    }

    public void validateTrue(By element) {
        assertTrue(driver.findElement(element).isDisplayed());
    }

    public void validateFalse(By element) {
        assertFalse(driver.findElement(element).isDisplayed());
    }
}
