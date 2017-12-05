package basePage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import utils.TestReporter;

import java.util.concurrent.TimeUnit;


/**
 * @author Sergey_Potapov
 */
public abstract class BasePage {

    protected WebDriver driver;
    private static final int WAITING_TIMEOUT = 30000;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //========================CUSTOM METHODS=============================================

    public static void waitForPageLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, WAITING_TIMEOUT);
        TestReporter.step("Wait for page loading ");
        wait.until((ExpectedCondition<Boolean>) driver1 -> ((JavascriptExecutor) driver1).executeScript(
                "return document.readyState").equals("complete"));
    }

    protected void moveMouseToAndClick(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        TestReporter.step("Wait for page loading " + element);
        action.moveToElement(element, 1, 1).click().perform();
    }

    protected boolean isElementDisplayed(WebElement element) {
        try {
            element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    /**
     * Method verifying that web element is clickable.
     *
     * @param element used to find the element
     */

    protected WebElement elementIsClickable(WebElement element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, WAITING_TIMEOUT);
        TestReporter.step("Click on - " + element);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Method helps fill input field.
     *
     * @param element - used to find the element
     * @param message - needed message in input field
     */
    protected void fillInputField(WebElement element, WebDriver driver, String message) {
        elementFluentWaitVisibility(element, driver).clear();
        elementFluentWaitVisibility(element, driver).sendKeys(message);
    }

    /**
     * Method was created for helps to search for elements with certain intervals within a given period of time.
     * Web element searching every 50 MILLISECONDS for 30 seconds.
     *
     * @param element - used to find the element
     */
    protected static WebElement elementFluentWaitVisibility(WebElement element, WebDriver driver) {
        Wait<WebDriver> newWait = new FluentWait<>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(50, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        return newWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement elementVisibility(WebElement element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, WAITING_TIMEOUT);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementNotPresent(WebElement element, WebDriver driver) {
        new WebDriverWait(driver, WAITING_TIMEOUT)
                .until(ExpectedConditions.stalenessOf(element));
    }

    protected void refreshPage() {
        driver.navigate().refresh();
    }

    protected String getText(WebElement element) {
        return element.getText();
    }

    protected String getCurrentUrl() {
        return driver.getCurrentUrl().toString();

    }

    protected String getValueOfAttributeByName(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }
}



