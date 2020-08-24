package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class RepositoryPage extends BasePage {
    //Inside the repository locators
    private final By repoKusoPomFile = By.xpath("//a[@title='pom.xml']");
    private final By repoKusoSeleniumVersion = By.xpath("//td[@id='LC27' and text()='>3.141.59</' ]");

    //Tabs locators
    private final By allTabsList = By.xpath("//ul[@class = 'UnderlineNav-body list-style-none ']/li//a");
    private final By issueTab = By.xpath("//span[contains(text(), 'Issues')]");
    private final By newIssueBtn = By.xpath("//span[contains(text(), 'New issue')]");

    //Issue lists
    private final By addedIssue = By.xpath("//a[contains(text(),'Test issue')]");
    private final By addedComment = By.xpath("//p[contains(text(),'Testing of addition a comment')]");


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

    public RepositoryPage listOfTabs() {
        validateTrue(allTabsList);

        for (WebElement element : driver.findElements(allTabsList)) {
            if (element.getText().matches(".*[^0-9].*")) {
                System.out.println("Name of tab is: " + element.getText()
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

    public RepositoryPage verifyIssueTitile() throws InterruptedException {
        sleep(1000);
        validateTrue(addedIssue);

        Assert.assertTrue(driver.findElement(addedIssue).getText().contains("Test issue"));
        return this;
    }

    public RepositoryPage verifyIssueComment() {
        validateTrue(addedIssue);
        driver.findElement(addedIssue).click();

        Assert.assertTrue(driver.findElement(addedComment).getText().contains("Testing of addition a comment"));
        return this;
    }

    public RepositoryPage returnToIssueTab() {
        validateTrue(issueTab);
        driver.findElement(issueTab).click();
        return this;
    }

    public void validateTrue(By element) {
        Assert.assertTrue(driver.findElement(element).isDisplayed());
    }

    public String repoSeleniumVersion() {
        return driver.findElement(repoKusoSeleniumVersion).getText().trim().substring(9, 17);
    }
}
