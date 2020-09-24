package tests.ui.selenoid;

import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class SelenoidTest extends BaseSelenoid {

    @Test
    public void testSelenoid() throws InterruptedException {
        driver.get("https://github.com");
        assertEquals("https://github.com/", driver.getCurrentUrl().toString());
        sleep(5000);
    }
}
