package tests.api;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                GetPrivatExchangeRateArchiveTest.class,
                GetPrivatTerminalsTest.class,
                GetPrivatOfficesTest.class
        }
)

public class PrivateSuiteTest {
}
