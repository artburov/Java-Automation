package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RepositoryPage extends NavigationBar {
    //Inside the repository locators
    private final By repoKusoPomFile = By.xpath("//a[@title='pom.xml']");
    private final By repoKusoSeleniumVersion = By.xpath("//td[@id='LC27' and text()='>3.141.59</' ]");

    private final By newIssueBtn = By.xpath("//span[contains(text(), 'New issue')]");

    //Issue lists
    private final By addedIssue = By.xpath("//a[contains(text(),'Test issue')]");
    private final By addedComment = By.xpath("//p[contains(text(),'Testing of addition a comment')]");


    public RepositoryPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage findPomFile() {
        validateTrue(repoKusoPomFile);
        driver.findElement(repoKusoPomFile).click();

        validateTrue(repoKusoSeleniumVersion);
        assertEquals("3.141.59", driver.findElement(repoKusoSeleniumVersion)
                .getText()
                .trim()
                .substring(9, 17));
        log.info("Version of selenium-java is " + repoSeleniumVersion());
        return new LoginPage(this.driver);
    }

    public RepositoryPage listOfTabs() {
        validateTrue(allTabsList);
        int counter = 1;

        for (WebElement element : driver.findElements(allTabsList)) {
            if (element.getText().matches(".*[^0-9].*")) {
                System.out.println("Name of tab #" + counter++ + ": " + element.getText()
                        .replaceAll("\\d", "")
                        .trim());
            } else
                System.out.println("Name of tab is: " + element.getText());
        }
        return this;
    }

    public RepositoryPage goToIssueTab() {
        validateTrue(issueTab);
        driver.findElement(issueTab).click();
        return this;
    }

    public IssuePage clickOnNewIssueBtn() {
        validateTrue(newIssueBtn);
        driver.findElement(newIssueBtn).click();
        return new IssuePage(this.driver);
    }

    public RepositoryPage verifyIssueTitle() {
        validateTrue(addedIssue);

        assertTrue(driver.findElement(addedIssue).getText().contains("Test issue"));
        return this;
    }

    public RepositoryPage verifyIssueComment() {
        validateTrue(addedIssue);
        driver.findElement(addedIssue).click();

        assertTrue(driver.findElement(addedComment).getText().contains("Testing of addition a comment"));
        return this;
    }

    public RepositoryPage returnToIssueTab() {
        validateTrue(issueTab);
        driver.findElement(issueTab).click();
        return this;
    }

    public void validateTrue(By element) {
        assertTrue(driver.findElement(element).isDisplayed());
    }

    public String repoSeleniumVersion() {
        return driver.findElement(repoKusoSeleniumVersion).getText().trim().substring(9, 17);
    }
}
