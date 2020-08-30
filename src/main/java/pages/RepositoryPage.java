package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.workPanel.WorkPanelMenu;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RepositoryPage extends WorkPanelMenu {
    //Inside the repository locators
    private final By repoKusoPomFile = By.xpath("//a[@title='pom.xml']");
    private final By repoKusoSeleniumVersion = By.xpath("//td[@id='LC27' and text()='>3.141.59</' ]");


    public RepositoryPage(WebDriver driver) {
        super(driver);
    }

    public RepositoryPage findPomFile() {
        validateTrue(repoKusoPomFile);
        driver.findElement(repoKusoPomFile).click();

        validateTrue(repoKusoSeleniumVersion);
        assertEquals("3.141.59", driver.findElement(repoKusoSeleniumVersion)
                .getText()
                .trim()
                .substring(9, 17));
        log.info("Version of selenium-java is " + repoSeleniumVersion());
        return this;
    }

    public RepositoryPage listOfTabs() {
        validateTrue(allTabsList);
        AtomicInteger counter = new AtomicInteger(1);

        //Using stream and lambda
        List<WebElement> tabsItems = driver.findElements(allTabsList);
        tabsItems.stream()
                .filter(item -> item.getText().matches(".*[^0-9].*"))
                .forEach(item -> System.out.println("Name of tab #" + counter.getAndIncrement() + ": " + item.getText()
                        .replaceAll("\\d", "")
                        .trim()));

        //Or the same as above but using ForEach loop
//        for (WebElement element : driver.findElements(allTabsList)) {
//            if (element.getText().matches(".*[^0-9].*")) {
//                System.out.println("Name of tab #" + counter++ + ": " + element.getText()
//                        .replaceAll("\\d", "")
//                        .trim());
//            } else
//                System.out.println("Name of tab is: " + element.getText());
//        }
        return this;
    }

    public void validateTrue(By element) {
        assertTrue(driver.findElement(element).isDisplayed());
    }

    public String repoSeleniumVersion() {
        return driver.findElement(repoKusoSeleniumVersion)
                .getText()
                .replaceAll(" ", "")
                .replaceAll("<version>", "")
                .replaceAll("</version>", "");
    }
}
