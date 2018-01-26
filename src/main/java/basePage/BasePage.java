package basePage;

import logger.MagDvLogger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import utils.AssertCollector;
import utils.TestReporter;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.testng.Assert.fail;
import static utils.Constants.COMMA_REGEX;
import static utils.Constants.RGBA_TO_RGB_REGEX;
import static utils.WaitingUtility.elementFluentWaitVisibility;


/**
 * @author Sergey_Potapov
 */
public abstract class BasePage {



    public abstract static class MyDelegate {
        public String getTextDelegate(WebElement element) {
            LOGGER.log(Level.INFO, " Get text of element ");
            TestReporter.step(" Get text of element ");
            return element.getText();
        }

        public void textPresentDelegate(String expectedText) {
            if (driver.getPageSource().contains(expectedText)) {
                LOGGER.log(Level.INFO, expectedText + " - Required text is present on page");
                TestReporter.step(expectedText + " - Required text is present on page");
            } else {
                LOGGER.log(Level.INFO, expectedText + " - Required text is present on page");
                TestReporter.step(expectedText + " - Required text is present on page");
            }
        }

        public String getCurrentUrl() {
            LOGGER.log(Level.INFO, "Get current URL ");
            TestReporter.step("Get current URL ");
            return driver.getCurrentUrl().toString();
        }

        public void getUrl(String url) {
            LOGGER.log(Level.INFO, "Navigate to needed url ");
            TestReporter.step("Navigate to needed url ");
            driver.navigate().to(url);
        }

        public void scrollToNecessaryElement(WebElement element) {
            LOGGER.log(Level.INFO, "Scroll to necessary element ");
            TestReporter.step("Scroll to necessary element ");
            int y = element.getLocation().getY();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0," + y + ")");
        }

        //TODO more flexible method
        public void scrollByCoordinate() {
            LOGGER.log(Level.INFO, "Scroll to necessary element ");
            TestReporter.step("Scroll to necessary element ");
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,500)", "");
        }

        public void switchDriverToAnyTabOfBrowser(int tabIndex) {
            LOGGER.log(Level.INFO, "Navigate to needed tab " + tabIndex);
            TestReporter.step(" Navigate to needed tab " + tabIndex);
            String parentHandle = new ArrayList<>(driver.getWindowHandles()).get(0);
            String anyTabName = new ArrayList<>(driver.getWindowHandles()).get(tabIndex);
            driver.switchTo().window(anyTabName);
            System.setProperty("current.window.handle", parentHandle);
        }

        public int getBrowserTabsCount() {
            return driver.getWindowHandles().size();
        }


        public void verifyTabsCountAsExpected(int expectedCount) {
            LOGGER.log(Level.INFO, " Verify count of tabs " + expectedCount);
            TestReporter.step(" Verify count of tabs " + expectedCount);
            int actualCount = getBrowserTabsCount();
            AssertCollector.assertEqualsJ(actualCount, expectedCount, "Verifying browser tabs count");
        }

        public void closeDriverToAnyTabOfBrowser(int tabIndex) {
            String parentHandle = new ArrayList<>(driver.getWindowHandles()).get(0);
            String anyTabName = new ArrayList<>(driver.getWindowHandles()).get(tabIndex);
            driver.switchTo().window(anyTabName);
            driver.close();
            System.setProperty("close.current.window.handle", parentHandle);
        }
        public String getValueOfAttributeByName(WebElement element, String attribute) {
            return element.getAttribute(attribute);
        }

        public void fillInputField(WebElement element, WebDriver driver, String message) {
            LOGGER.log(Level.INFO, "Feel input field ");
            TestReporter.step("Feel input field ");
            elementFluentWaitVisibility(element, driver).clear();
            elementFluentWaitVisibility(element, driver).sendKeys(message);
        }
        public void backPage() {
            LOGGER.log(Level.INFO, "Navigate to back page ");
            TestReporter.step("Navigate to back page ");
            driver.navigate().back();
        }
    }

    protected static WebDriver driver;
    private static final Logger LOGGER = MagDvLogger.getMagDvLogger().getLogger();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //========================CUSTOM METHODS=============================================

    public String getText(WebElement element) {
        LOGGER.log(Level.INFO, " Get text of element ");
        TestReporter.step(" Get text of element ");
        return element.getText();
    }

    protected Double parseStringToDouble(String text) {
        String parseText = text.replaceAll(",", ".");
        parseText = parseText.replaceAll("[^\\d.]", "");
        return Double.valueOf(parseText);
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

    protected void backPage() {
        LOGGER.log(Level.INFO, "Navigate to back page ");
        TestReporter.step("Navigate to back page ");
        driver.navigate().back();
    }

    protected void fillInputField(WebElement element, WebDriver driver, String message) {
        LOGGER.log(Level.INFO, "Feel input field ");
        TestReporter.step("Feel input field ");
        elementFluentWaitVisibility(element, driver).clear();
        elementFluentWaitVisibility(element, driver).sendKeys(message);
    }

    protected void fillInputFieldAndPressEnterButton(WebElement element, String message) {
        element.clear();
        element.sendKeys(message);
        element.sendKeys(Keys.ENTER);
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

    protected static void doubleClickOnElement(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver).doubleClick(element);
        action.build().perform();
    }

    protected void clickElementByJS(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        sleepWait();
    }

    /**
     * scroll to Element
     */
    public static void moveToElementJS(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    /**
     * It just execute all browsers js script
     *
     * @param script example jQery("div:contains('test')").click()
     * @param driver
     */
    public static void CallJS(String script, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript(script);
    }

    protected static void hoverAndClick(WebDriver driver, WebElement mainElement, WebElement subElement) {
        LOGGER.log(Level.INFO, "Move to the main element position and click needed element " + mainElement);
        TestReporter.step(" Click on needed element " + subElement);
        Actions action = new Actions(driver);
        action.moveToElement(mainElement).perform();
        action.click(subElement).perform();
    }

    protected static void clickOnIndexFromElementList(List<WebElement> element, int elementIndex) {
        LOGGER.log(Level.INFO, "Click on needed index of element " + elementIndex);
        TestReporter.step("Click on needed index of element " + elementIndex);
        try {
            List<WebElement> elementList = element;
            for (int i = 0; i <= elementList.size(); i++) {
                elementList.get(elementIndex).click();
            }
        } catch (ElementNotVisibleException | ClassCastException | IndexOutOfBoundsException e) {
            e.getMessage();
            LOGGER.log(Level.WARNING, "ElementNotVisibleException " + e.getMessage());
            TestReporter.step(" ElementNotVisibleException ");
        }
    }

    protected String getValueOfAttributeByName(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    public void getValueOfInputField(WebElement element, String attribute) {
        if (getValueOfAttributeByName(element, attribute).isEmpty()) {
            LOGGER.log(Level.INFO, "Field is empty ");
            TestReporter.step(" Field is empty ");
        } else {
            LOGGER.log(Level.INFO, "Field isn't empty ");
            TestReporter.step(" Field isn't empty ");
            fail();
        }
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
            LOGGER.log(Level.WARNING, "ElementNotVisibleException, see message for details: %s " + e.getMessage());
            TestReporter.fail(" Couldn't shown total elements count on page ");
        }
        return totalCount;
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

    protected void sleepWait() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}




