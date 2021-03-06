package Core.utils;

import Core.logger.MagDvLogger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Core.driverFactory.BrowserFactory.getDriver;
import static Core.readDocs.ReadXMLFile.readXML;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static Core.driverFactory.BrowserFactory.*;

/**
 * @author Sergey Potapov
 */
public class WaitingUtility {
    private static final int WAITING_TIMEOUT = Integer.parseInt(readXML("section", "waitTime"));
    private static final Logger LOGGER = MagDvLogger.getMagDvLogger().getLogger();

    protected WaitingUtility() {
    }

    public static void waitForPageLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, WAITING_TIMEOUT);
        TestReporter.step("Wait for page loading ");
        wait.until((ExpectedCondition<Boolean>) driver1 -> ((JavascriptExecutor) Objects.requireNonNull(driver1)).executeScript(
                "return document.readyState").equals("complete"));
    }

    static class StopWatch {

        private long startTime = 0;
        private long stopTime = 0;
        private boolean running = false;

        void start() {
            this.startTime = System.currentTimeMillis();
            this.running = true;
        }

        void stop() {
            this.stopTime = System.currentTimeMillis();
            this.running = false;
        }

        /**
         * Get time between start way of method to end of method
         *
         * @return long
         */
        long getElapsedTime() {
            long elapsed;
            if (running) {
                elapsed = (System.currentTimeMillis() - startTime);
            } else {
                elapsed = (stopTime - startTime);
            }
            return elapsed;
        }
    }

    /**
     * Method for waiting for Javascript and jQuery to finish loading.
     * Execute Javascript to check if jQuery.active is 0
     * and document.readyState is complete, which means the JS and jQuery load is complete.
     */
    public static boolean waitForJSandJQueryToLoad() {
        StopWatch watch = new StopWatch();
        watch.start();
        WebDriverWait wait = new WebDriverWait(driver, WAITING_TIMEOUT);
        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = drivers -> {
            try {
                return ((Long) ((JavascriptExecutor) getDriver()).executeScript("return jQuery.active") == 0);
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "Exception, see message for details: %s " + e.getMessage());
                TestReporter.fail("Exception, see message for details: %s " + e.getMessage());
                return true;
            }
        };
        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = drivers -> ((JavascriptExecutor) getDriver()).executeScript("return document.readyState")
                .toString().equals("complete");
        watch.stop();
        LOGGER.log(Level.INFO, "Wait Until Page Load " + String.valueOf(watch.getElapsedTime()) + "ms.");
        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }

    /**
     * Method verifying that web element is clickable.
     *
     * @param element used to find the element
     */
    public static WebElement elementIsClickable(WebElement element) {
        Wait<WebDriver> newWait = new FluentWait<>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        return newWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Method was created for helps to search for elements with certain intervals within a given period of time.
     * Web element searching every 50 MILLISECONDS for 30 seconds.
     *
     * @param element - used to find the element
     */
    public static WebElement elementFluentWaitVisibility(WebElement element) {
        Wait<WebDriver> newWait = new FluentWait<>(driver)
                .withTimeout(WAITING_TIMEOUT, TimeUnit.SECONDS)
                .pollingEvery(50, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        return newWait.until(visibilityOf(element));
    }

    public static WebElement elementFluentWaitClick(WebElement element) {
        Wait<WebDriver> newWait = new FluentWait<>(driver)
                .withTimeout(WAITING_TIMEOUT, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        return newWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitInvisibilityOfElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAITING_TIMEOUT);
        wait.until(visibilityOf(element));
    }

    public static void textIsPresent(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, WAITING_TIMEOUT);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static boolean elementIsDisplayed(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAITING_TIMEOUT);
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    public static boolean elementIsDisplayedTime(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAITING_TIMEOUT / 20);
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    public static boolean elementIsPresent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAITING_TIMEOUT / 30);
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).isEnabled();
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean elementIsVisibleTime(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean elementIsVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAITING_TIMEOUT);
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean elementIsSelected(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAITING_TIMEOUT);
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).isSelected();
        } catch (Exception ex) {
            return false;
        }
    }
}
