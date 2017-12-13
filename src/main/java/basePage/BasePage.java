package basePage;

import logger.MagDvLogger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AssertCollector;
import utils.TestReporter;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static driverFactory.BrowserFactory.getDriver;
import static utils.Constants.COMMA_REGEX;
import static utils.Constants.RGBA_TO_RGB_REGEX;


/**
 * @author Sergey_Potapov
 */
public abstract class BasePage {

    protected WebDriver driver;
    private static final Logger LOGGER = MagDvLogger.getMagDvLogger().getLogger();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //========================CUSTOM METHODS=============================================

    protected String getText(WebElement element) {
        LOGGER.log(Level.INFO, " Get text of element ");
        TestReporter.step(" Get text of element ");
        return element.getText();
    }

    protected String getCurrentUrl() {
        LOGGER.log(Level.INFO, "Get current URL ");
        TestReporter.step("Get current URL ");
        return driver.getCurrentUrl().toString();
    }

    protected void getUrl(String url) {
        LOGGER.log(Level.INFO, "Navigate to needed url ");
        TestReporter.step("Navigate to needed url ");
        driver.navigate().to(url);
    }

    protected static String getElementColor(WebElement webElement, String colorSection) {
        LOGGER.log(Level.INFO, "Get element color");
        TestReporter.step("Get element color ");
        String rgb[] = webElement.getCssValue(colorSection).replaceAll(RGBA_TO_RGB_REGEX, "")
                .split(COMMA_REGEX);
        return String.format("#%s%s%s", toBrowserHexValue(Integer.parseInt(rgb[0])),
                toBrowserHexValue(Integer.parseInt(rgb[1])),
                toBrowserHexValue(Integer.parseInt(rgb[2])));
    }

    protected static String toBrowserHexValue(int number) {
        StringBuilder builder = new StringBuilder(Integer.toHexString(number & 0xff));
        while (builder.length() < 2) {
            builder.append("0");
        }
        return builder.toString();
    }

    protected static void moveMouseToAndClick(WebDriver driver, WebElement element, int x, int y) {
        TestReporter.step("Move to the element position ");
        LOGGER.log(Level.INFO, "Move to the element position");
        Actions action = new Actions(driver);
        TestReporter.step("Wait for page loading " + element);
        action.moveToElement(element, x, y).click().build().perform();
    }

    protected void clickElementByJS(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    protected static void hoverAndClick(WebDriver driver, WebElement mainElement, WebElement subElement) {
        LOGGER.log(Level.INFO, "Move to the main element position and click needed element " + mainElement);
        TestReporter.step(" Click on needed element " + subElement);
        Actions action = new Actions(driver);
        action.moveToElement(mainElement).perform();
        action.click(subElement).perform();
    }

    protected void clickOnIndexFromElementList(List<WebElement> element, int elementIndex) {
        LOGGER.log(Level.INFO, "Click on needed index of element " + elementIndex);
        TestReporter.step("Click on needed index of element " + elementIndex);
        try {
            List<WebElement> elementList = element;
            for (int i = 0; i <= elementList.size(); i++) {
                waitForJSandJQueryToLoad();
                elementList.get(elementIndex).click();
            }
        } catch (ElementNotVisibleException | ClassCastException e) {
            e.getMessage();
            LOGGER.log(Level.WARNING, "ElementNotVisibleException " + e.getMessage());
            TestReporter.step(" ElementNotVisibleException ");
        }
    }

    protected String getValueOfAttributeByName(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    protected void moveMouseTo(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    protected void scrollDown() {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
            LOGGER.log(Level.WARNING, "AWT Exception occurs, see message for details: %s", e.getMessage());
        }
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
    }

    public void scrollToNecessaryElement(WebElement element) {
        LOGGER.log(Level.INFO, "Scroll to necessary element on page");
        TestReporter.step("Scroll to necessary element on page");
        int y = element.getLocation().getY();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0," + y + ")");
    }

    protected static int getSumOfAllElementFromList(List<WebElement> element) {
        int totalCount = 0;
        try {
            LOGGER.log(Level.INFO, "Counting total elements on page ");
            TestReporter.step(" Counting total elements on page ");
            List<WebElement> elementList = element;
            totalCount = elementList.size();
        } catch (ElementNotVisibleException e) {
            e.getMessage();
            LOGGER.log(Level.WARNING, "ElementNotVisibleException, see message for details: %s " + e.getMessage());
        }
        return totalCount;
    }

    /**
     * Method for waiting for Javascript and jQuery to finish loading.
     * Execute Javascript to check if jQuery.active is 0
     * and document.readyState is complete, which means the JS and jQuery load is complete.
     */
    protected boolean waitForJSandJQueryToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = driver -> {
            try {
                return ((Long) ((JavascriptExecutor) getDriver()).executeScript("return jQuery.active") == 0);
            } catch (Exception e) {
                // no jQuery present
                LOGGER.log(Level.WARNING, "Exception, see message for details: %s " + e.getMessage());
                return true;
            }
        };
        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) getDriver()).executeScript("return document.readyState")
                .toString().equals("complete");
        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }


    protected void switchDriverToAnyTabOfBrowser(int tabIndex) {
        LOGGER.log(Level.INFO, "Navigate to needed tab " + tabIndex);
        TestReporter.step(" Navigate to needed tab " + tabIndex);
        String parentHandle = new ArrayList<>(driver.getWindowHandles()).get(0);
        String anyTabName = new ArrayList<>(driver.getWindowHandles()).get(tabIndex);
        driver.switchTo().window(anyTabName);
        System.setProperty("current.window.handle", parentHandle);
    }

    protected int getBrowserTabsCount() {
        return driver.getWindowHandles().size();
    }


    protected void verifyTabsCountAsExpected(int expectedCount) {
        LOGGER.log(Level.INFO, " Verify count of tabs " + expectedCount);
        TestReporter.step(" Verify count of tabs " + expectedCount);
        int actualCount = getBrowserTabsCount();
        AssertCollector.assertEqualsJ(actualCount, expectedCount, "Verifying browser tabs count");
    }

    /**
     * Method for verifying required text on page.
     *
     * @param expectedText- text which must be present on the page
     */
    protected void textPresent(String expectedText) {
        if (driver.getPageSource().contains(expectedText)) {
            LOGGER.log(Level.INFO, expectedText + " - Required text is present ");
            TestReporter.step(expectedText + " - Required text is present ");
        } else {
            LOGGER.log(Level.INFO, expectedText + " - Required text is present ");
            TestReporter.step(expectedText + " - Required text is present ");
        }
    }
}




