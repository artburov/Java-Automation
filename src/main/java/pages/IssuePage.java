package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IssuePage extends BasePage {

    private final By titleField = By.xpath("//input[@id='issue_title']");
    private final By commentField = By.xpath("//textarea[@id='issue_body']");
    private final By commentSubmitBtn = By.xpath("//button[@class='btn btn-primary']");


    public IssuePage(WebDriver driver) {
        super(driver);
    }

    public IssuePage inputTitle() {
        validateTrue(titleField);
        driver.findElement(titleField).clear();
        driver.findElement(titleField).sendKeys("Test issue");
        return this;
    }

    public IssuePage inputComment() {
        validateTrue(commentField);
        driver.findElement(commentField).clear();
        driver.findElement(commentField).sendKeys("Testing of addition a comment");
        return this;
    }

    public RepositoryPage submitNewIssue() {
        validateTrue(commentSubmitBtn);
        driver.findElement(commentSubmitBtn).click();
        return new RepositoryPage(this.driver);
    }

    public void validateTrue(By element) {
        Assert.assertTrue(driver.findElement(element).isDisplayed());
    }
}
