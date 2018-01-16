package utils;

import logger.MagDvLogger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static driverFactory.BrowserFactory.getDriver;

/**
 * @author Sergey Potapov
 */
public class WaitingUtility {
    private static final int WAITING_TIMEOUT = 30000;
    private static final Logger LOGGER = MagDvLogger.getMagDvLogger().getLogger();

    private WaitingUtility() {
    }

    public static void waitForPageLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, WAITING_TIMEOUT);
        TestReporter.step("Wait for page loading ");
        wait.until((ExpectedCondition<Boolean>) driver1 -> ((JavascriptExecutor) driver1).executeScript(
                "return document.readyState").equals("complete"));
    }

    /**
     * Method for waiting for Javascript and jQuery to finish loading.
     * Execute Javascript to check if jQuery.active is 0
     * and document.readyState is complete, which means the JS and jQuery load is complete.
     */
    public static boolean waitForJSandJQueryToLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = drivers -> {
            try {
                return ((Long) ((JavascriptExecutor) getDriver()).executeScript("return jQuery.active") == 0);
            } catch (Exception e) {
                // no jQuery present
                LOGGER.log(Level.WARNING, "Exception, see message for details: %s " + e.getMessage());
                TestReporter.fail("Exception, see message for details: %s " + e.getMessage());
                return true;
            }
        };
        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = drivers -> ((JavascriptExecutor) getDriver()).executeScript("return document.readyState")
                .toString().equals("complete");
        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }



    /**
     * Method verifying that web element is clickable.
     *
     * @param element used to find the element
     */
    public static WebElement elementIsClickable(WebElement element, WebDriver driver) {
       // WebDriverWait wait = new WebDriverWait(driver, WAITING_TIMEOUT);
        TestReporter.step("Click on - " + element);
        LOGGER.log(Level.INFO, " Click on - " + element);
        Wait<WebDriver> newWait = new FluentWait<>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(50, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        return newWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Method was created for helps to search for elements with certain intervals within a given period of time.
     * Web element searching every 50 MILLISECONDS for 30 seconds.
     * @param element - used to find the element
     */
    public static WebElement elementFluentWaitVisibility(WebElement element, WebDriver driver) {
        TestReporter.step("Click on - " + element);
        LOGGER.log(Level.INFO, " Click on - " + element);
        Wait<WebDriver> newWait = new FluentWait<>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(50, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        return newWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitInvisibilityOfElement(WebElement element, WebDriver driver) {
        TestReporter.step("Element isn't displayed ");
        LOGGER.log(Level.INFO, "Element isn't displayed ");
        WebDriverWait wait = new WebDriverWait(driver, WAITING_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void  sleepTime()
    {
        try {
            Thread.sleep(1000);
        }
        catch (Exception ex)
        {
             System.out.println(ex.getMessage());
        }
    }
}
