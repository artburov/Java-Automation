package pages.issues;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.RepositoryPage;

import static org.junit.Assert.assertTrue;

public class IssuePage extends IssueCreationPage {
    private final By newIssueBtn = By.xpath("//span[contains(text(), 'New issue')]");

    //Verify added issue
    private final By addedIssue = By.xpath("//a[contains(text(),'Test issue')]");
    private final By addedComment = By.xpath("//p[contains(text(),'Testing of addition a comment')]");

    public IssuePage(WebDriver driver) {
        super(driver);
    }


    public IssueCreationPage clickOnNewIssueBtn() {
        validateTrue(newIssueBtn);
        driver.findElement(newIssueBtn).click();
        return new IssueCreationPage(this.driver);
    }

    public RepositoryPage verifyIssueTitle() {
        validateTrue(addedIssue);

        assertTrue(driver.findElement(addedIssue).getText().contains("Test issue"));
        return new RepositoryPage(this.driver);
    }

    public RepositoryPage verifyIssueComment() {
        validateTrue(addedIssue);
        driver.findElement(addedIssue).click();

        assertTrue(driver.findElement(addedComment).getText().contains("Testing of addition a comment"));
        return new RepositoryPage(this.driver);
    }

    public void validateTrue(By element) {
        assertTrue(driver.findElement(element).isDisplayed());
    }
}
