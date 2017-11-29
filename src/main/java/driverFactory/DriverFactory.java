package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

import static utils.Constants.DRIVER_NAME_FIREFOX;

/**
 * @author Sergey Potapov
 */

public class DriverFactory {

    private static final String FIREFOX = "Firefox";
    private static final String CHROME = "Chrome";

    private static final String PATH_TO_DRIVER_CHROME = "driver\\chromedriver.exe";
    private static final String PATH_TO_DRIVER_FIREFOX = "driver\\geckodriver.exe";



    /**
     * There is pre-initialization of the driver and his way that is it prior to calling object
     */
    static {
        System.setProperty(DRIVER_NAME_FIREFOX, PATH_TO_DRIVER_FIREFOX);
    }

    /**
     * There is pre-initialization of the driver and his way that is it prior to calling object
     */
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();


    /**
     * There is setting driver by name
     *
     * @param driverName-name needed browser driver
     * @author Sergey Potapov
     */
    public static WebDriver setDriver(String driverName) {
        if (driverName != null) {
            switch (driverName) {
                case FIREFOX: {
                    DesiredCapabilities ffCapabilities = DesiredCapabilities.firefox();
                    driverThread.set(new FirefoxDriver(ffCapabilities));
                    break;
                }
                case CHROME: {
                    DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
                    ChromeDriver chromeDriver = new ChromeDriver(chromeCapabilities);
                    driverThread.set(chromeDriver);
                    break;
                }
                default: {
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

}