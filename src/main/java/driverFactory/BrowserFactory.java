package driverFactory;

import logger.MagDvLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

import static utils.Constants.CHROME_DRIVER_PATH;
import static utils.Constants.DRIVER_NAME_CHROME;


/**
 * @author Sergey Potapov
 */
public class BrowserFactory  extends DriverCapabilities{

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
        //killProcess();
        if (driverName != null)
        {
            switch (driverName)
            {
                case FIREFOX: {
                    LOGGER.log(Level.INFO, "set browser FIREFOX");
                    driverThread.set(new FirefoxDriver(firefoxCapabilities()));
                    break;
                }
                case CHROME: {
                    LOGGER.log(Level.INFO, "set browser CHROME");
                    driverThread.set(new ChromeDriver(chromeCapabilities()));
                    break;
                }
                default: {
                    LOGGER.log(Level.WARNING, "Incorrect browser name");
                    throw new RuntimeException("Incorrect browser name");
                }
            }
        }

        WebDriver driver= driverThread.get();
        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
        EventHandler handler = new EventHandler() {};
        driver = eventDriver.register(handler);
        return driver;
    }

    private static void killProcess()
    {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
        }
        catch (Exception ex)
        {
            ex.getMessage();
        }
    }
    /**
     * Getting personal object for every browser driver
     */
    public static WebDriver getDriver() {
        return driverThread.get();
    }
}
