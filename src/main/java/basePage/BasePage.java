package basePage;

import logger.MagDvLogger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import utils.TestReporter;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    protected static void hoverAndClick(WebDriver driver, WebElement mainElement, WebElement subElement) {
        LOGGER.log(Level.INFO, "Move to the main element position and click needed element " + mainElement);
        TestReporter.step(" Click on needed element " + subElement);
        Actions action = new Actions(driver);
        action.moveToElement(mainElement).perform();
        action.click(subElement).perform();
    }

    protected static void clickOnIndexFromElementList(List<WebElement> element, int elementIndex) {
        try {
            List<WebElement> elementList = element;
            for (int i = 0; i <= elementList.size(); i++) {
                elementList.get(elementIndex).click();
            }
        } catch (ElementNotVisibleException e) {
            e.getMessage();
            LOGGER.log(Level.WARNING, "ElementNotVisibleException " + e.getMessage());
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

    protected static int getSumOfAllElementFromList(List<WebElement> element) {
        int totalCount = 0;
        try {
            LOGGER.log(Level.INFO, "Counting total elements on page ");
            TestReporter.step(" Counting total elements on page ");
            List<WebElement> elementList = element;
            totalCount = elementList.size();
        } catch (ElementNotVisibleException e) {
            e.getMessage();
            LOGGER.log(Level.WARNING, "ElementNotVisibleException " + e.getMessage());
        }
        return totalCount;
    }
}




