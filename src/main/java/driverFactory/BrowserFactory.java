package driverFactory;

import logger.MagDvLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Level;
import java.util.logging.Logger;

import static utils.Constants.CHROME_DRIVER_PATH;
import static utils.Constants.DRIVER_NAME_CHROME;


/**
 * @author Sergey Potapov
 */
public class BrowserFactory {

    private static final String FIREFOX = "Firefox";
    private static final String CHROME = "Chrome";
    private static final Logger LOGGER = MagDvLogger.getMagDvLogger().getLogger();

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
                    LOGGER.log(Level.INFO, "set browser FIREFOX");
                    DesiredCapabilities ffCapabilities = DesiredCapabilities.firefox();
                    driverThread.set(new FirefoxDriver(ffCapabilities));
                    break;
                }
                case CHROME: {
                    LOGGER.log(Level.INFO, "set browser CHROME");
                    DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
                    ChromeDriver chromeDriver = new ChromeDriver(chromeCapabilities);
                    driverThread.set(chromeDriver);
                    break;
                }
                default: {
                    LOGGER.log(Level.WARNING, "Incorrect browser name");
                    throw new RuntimeException("Incorrect browser name");
                }
            }
        }
        driverThread.get().manage().window().maximize();
        return driverThread.get();
    }

    /**
     * Getting personal object for every browser driver
     */
    public static WebDriver getDriver() {
        return driverThread.get();
    }
}
