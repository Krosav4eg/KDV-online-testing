package utils;

import logger.MagDvLogger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

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
     * Method verifying that web element is clickable.
     *
     * @param element used to find the element
     */
    public static WebElement elementIsClickable(WebElement element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, WAITING_TIMEOUT);
        TestReporter.step("Click on - " + element);
        LOGGER.log(Level.INFO, " Click on - " + element);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Method was created for helps to search for elements with certain intervals within a given period of time.
     * Web element searching every 50 MILLISECONDS for 30 seconds.
     *
     * @param element - used to find the element
     */
    protected static WebElement elementFluentWaitVisibility(WebElement element, WebDriver driver) {
        TestReporter.step("Click on - " + element);
        Wait<WebDriver> newWait = new FluentWait<>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(50, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        return newWait.until(ExpectedConditions.visibilityOf(element));
    }
}
