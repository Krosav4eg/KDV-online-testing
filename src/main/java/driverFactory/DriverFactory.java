package driverFactory;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

import static utils.Constants.CHROME_DRIVER_PATH;
import static utils.Constants.DRIVER_NAME_CHROME;

/**
 * @author Sergey Potapov
 */

public class DriverFactory {

    private static final String FIREFOX = "Firefox";
    private static final String CHROME = "Chrome";

    protected static final Logger logger = LogManager.getLogger(DriverFactory.class);

    /**
     * There is pre-initialization of the driver and his way that is it prior to calling object
     */

    static {
        System.setProperty(DRIVER_NAME_CHROME, CHROME_DRIVER_PATH);
    }

    /**
     * There is pre-initialization of the driver and his way that is it prior to calling object
     */
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();


    /**
     * There is setting driver by name
     *
     * @param driverName-name needed browser driver
     */
    public static WebDriver setDriver(String driverName) {
        if (driverName != null) {
            switch (driverName) {
                case FIREFOX: {
                    logger.info("set browser FIREFOX");
                    DesiredCapabilities ffCapabilities = DesiredCapabilities.firefox();
                    driverThread.set(new FirefoxDriver(ffCapabilities));
                    break;
                }
                case CHROME: {
                    logger.info("set browser CHROME");
                    DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
                    ChromeDriver chromeDriver = new ChromeDriver(chromeCapabilities);
                    driverThread.set(chromeDriver);
                    break;
                }
                default: {
                    logger.error("Incorrect browser name");
                    throw new RuntimeException("Incorrect browser name");
                }
            }
        }
        class TimeOuts {
            private static final int DEFAULT_TIMEOUT = 30000;
            private static final int PAGE_LOAD_TIMEOUT = 180000;

        }

        driverThread.get().manage().window().maximize();
        driverThread.get().manage().timeouts().pageLoadTimeout(TimeOuts.PAGE_LOAD_TIMEOUT, TimeUnit.MILLISECONDS);
        driverThread.get().manage().timeouts().implicitlyWait(TimeOuts.DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
        return driverThread.get();
    }

    /**
     * Getting personal object for every browser driver
     */

    public static WebDriver getDriver() {
        return driverThread.get();
    }

}