package pages.workPanel;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.issues.IssuePage;
import pages.NavigationBar;

public abstract class WorkPanelMenu extends NavigationBar {
    //Tabs locators
    protected final By allTabsList = By.xpath("//ul[@class = 'UnderlineNav-body list-style-none ']/li");
    protected final By issuesTab = By.xpath("//span[contains(text(), 'Issues')]");
    protected final By pullRequestsTab = By.xpath("//span[contains(text(), 'Pull request')]");
    protected final By actionsTab = By.xpath("//span[contains(text(), 'Actions')]");
    protected final By projectsTab = By.xpath("//span[contains(text(), 'Projects')]");
    protected final By wikiTab = By.xpath("//span[contains(text(), 'Wiki')]");
    protected final By securityTab = By.xpath("//span[contains(text(), 'Security')]");
    protected final By insightsTab = By.xpath("//span[contains(text(), 'Insights')]");


    public WorkPanelMenu(WebDriver driver) {
        super(driver);
    }

    public IssuePage openProjectsIssues() {
        Assert.assertTrue(this.driver.findElement(issuesTab).isDisplayed());
        this.driver.findElement(issuesTab).click();
        return new IssuePage(this.driver);
    }
}
