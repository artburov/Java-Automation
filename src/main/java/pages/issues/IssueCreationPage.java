package pages.issues;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.RepositoryPage;
import pages.workPanel.WorkPanelMenu;

import java.util.Arrays;

public class IssueCreationPage extends WorkPanelMenu {
    private final By titleField = By.xpath("//input[@id='issue_title']");
    private final By commentField = By.xpath("//textarea[@id='issue_body']");
    private final By issueSubmitBtn = By.xpath("//button[@class='btn btn-primary']");

    //Labels menu locators
    private final By labelMenu = By.xpath("//details[@id='labels-select-menu']");
    private final By labelSearch = By.id("label-filter-field");
    private final By bugLabel = By.xpath("//span[contains(text(),'bug')]");
    private final By documentationLabel = By.xpath("//span[contains(text(),'documentation')]");
    private final By duplicateLabel = By.xpath("//span[contains(text(),'duplicate')]");
    private final By enhancementLabel = By.xpath("//span[contains(text(),'enhancement')]");
    private final By questionLabel = By.xpath("//span[contains(text(),'question')]");


    public IssueCreationPage(WebDriver driver) {
        super(driver);
    }

    public IssuePage inputTitle() {
        validateTrue(titleField);
        driver.findElement(titleField).clear();
        driver.findElement(titleField).sendKeys("Test issue");
        return new IssuePage(this.driver);
    }

    public IssuePage inputComment() {
        validateTrue(commentField);
        driver.findElement(commentField).clear();
        driver.findElement(commentField).sendKeys("Testing of addition a comment");
        return new IssuePage(this.driver);
    }

    public RepositoryPage submitNewIssue() {
        validateTrue(issueSubmitBtn);
        driver.findElement(issueSubmitBtn).click();
        return new RepositoryPage(this.driver);
    }

    private By selectLabel(String label) {
        return By.xpath(String.format("//span[contains(text(),'%s')]", label));
    }

    public IssuePage createIssue(String title, String comment, String... labels) {
        validateTrue(titleField);
        validateTrue(commentField);
        validateTrue(labelMenu);

        driver.findElement(titleField).clear();
        driver.findElement(titleField).sendKeys(title);

        driver.findElement(commentField).clear();
        driver.findElement(commentField).sendKeys(comment);

        driver.findElement(labelMenu).click();

        Arrays.stream(labels).forEach(label -> {
            Assert.assertTrue(this.driver.findElement(selectLabel(label)).isDisplayed());
            this.driver.findElement(selectLabel(label)).click();
        });

        this.driver.findElement(labelMenu).click();
        this.driver.findElement(issueSubmitBtn).click();

        return new IssuePage(this.driver);
    }
}
