package Core.driverFactory;

import logger.MagDvLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Core.driverFactory.DriverCapabilities.chromeCapabilities;
import static Core.driverFactory.DriverCapabilities.firefoxCapabilities;
import static com.sun.deploy.config.OSType.isUnix;
import static utils.Constants.*;


/**
 * @author Sergey Potapov
 */
public class BrowserFactory implements DriverCapabilities  {
    private static volatile BrowserFactory instance;

    public static BrowserFactory getInstance() {
        BrowserFactory localInstance = instance;
        if (localInstance == null) {
            synchronized (BrowserFactory.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new BrowserFactory();
                }
            }
        }
        return localInstance;
    }

    private static final String FIREFOX = "Firefox";
    private static final String CHROME = "Chrome";
    private static final String GRID = "GRID";
    private static final Logger LOGGER = MagDvLogger.getMagDvLogger().getLogger();


    /**
     * There is pre-initialization of the driver and his way that is it prior to calling object
     */
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    /**
     * There is setting driver by name
     */
    public  synchronized WebDriver setDriver()  {

        String driverName=BASE_DRIVER;
        WebDriver driver=null;
        if (driverName != null)
        {
            switch (driverName)
            {
                case FIREFOX: {
                    LOGGER.log(Level.INFO, "set browser FIREFOX");
                    System.setProperty(DRIVER_NAME_FIREFOX, FIREFOX_DRIVER_PATH);
                    driverThread.set(new FirefoxDriver(firefoxCapabilities()));
                    driver= driverThread.get();
                    break;
                }
                case CHROME: {
                    LOGGER.log(Level.INFO, "set browser CHROME");
                    if(isUnix ()){
                        System.out.println("This is Unix or Linux OS");
                        System.setProperty(DRIVER_NAME_CHROME, CHROME_DRIVER_PATH_UNIX);
                    }
                    else {
                        System.setProperty(DRIVER_NAME_CHROME, CHROME_DRIVER_PATH);
                    }
                    driverThread.set(new ChromeDriver(chromeCapabilities()));
                    driver= driverThread.get();
                    break;
                }
                case GRID: {
                    LOGGER.log(Level.INFO, "set browser GRID");
                    try {
                        String Node = "http://192.168.1.3:4444/wd/hub";
                        driver = new RemoteWebDriver(new URL(Node),chromeCapabilities());
                    }
                   catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Exception ERROR: "+ e.getMessage());
                    }
                    break;
                }
                default: {
                    LOGGER.log(Level.WARNING, "Incorrect browser name");
                    throw new RuntimeException("Incorrect browser name");
                }
            }
        }
        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
        EventHandler handler = new EventHandler() {};
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver = eventDriver.register(handler);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        return driver;
    }

    /**
     * Getting personal object for every browser driver
     */
    public static WebDriver getDriver() {
        return driverThread.get();
    }
}
