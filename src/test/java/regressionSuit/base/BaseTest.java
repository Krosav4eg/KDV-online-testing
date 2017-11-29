package regressionSuit.base;

import driverFactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * @author Sergey Potapov
 */

public class BaseTest {
    protected WebDriver driver;

    /**
     * Set browser before starting auto tests
     */
    @BeforeTest
    public void setUp() {
        driver = DriverFactory.setDriver("Firefox");
    }

    /**
     * Method for closing browser and auto tests
     */
    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}