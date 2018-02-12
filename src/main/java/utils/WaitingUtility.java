package utils;

import logger.MagDvLogger;
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
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

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
        wait.until((ExpectedCondition<Boolean>) driver1 -> ((JavascriptExecutor) Objects.requireNonNull(driver1)).executeScript(
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
    public static WebElement elementFluentWaitVisibility(WebElement element, WebDriver driver) {
        Wait<WebDriver> newWait = new FluentWait<>(driver)
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(50, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        return newWait.until(visibilityOf(element));
    }

    public static WebElement elementFluentWaitClick(WebElement element, WebDriver driver) {
        Wait<WebDriver> newWait = new FluentWait<>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        return newWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitInvisibilityOfElement(WebElement element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, WAITING_TIMEOUT);
        wait.until(visibilityOf(element));
    }

    public static void textIsPresent(WebElement element, WebDriver driver, String text) {
        WebDriverWait wait = new WebDriverWait(driver, WAITING_TIMEOUT);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static boolean elementIsDisplayed(WebElement element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }
}
