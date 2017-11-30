package basePage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static utils.Constants.BASE_URL;


/**
 * @author Sergey_Potapov
 */

public abstract class BasePage {

    protected WebDriver driver;
    private static final int WAITING_TIMEOUT = 15000;
    protected static final Logger logger = LogManager.getLogger(basePage.BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //========================CUSTOM METHODS=============================================

    protected void getUrl() {
        driver.get(BASE_URL);
    }

    protected void refreshPage() {
        driver.navigate().refresh();
    }

    /**
     * Method verifying that web element is clickable.
     *
     * @param element used to find the element
     */

    protected WebElement elementIsClickable(WebElement element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, WAITING_TIMEOUT);
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
}



