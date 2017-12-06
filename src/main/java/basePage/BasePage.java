package basePage;

import logger.MagDvLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import utils.TestReporter;

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

    public static String getBorderColor(WebElement webElement) {
        LOGGER.log(Level.INFO, "Get element color");
        TestReporter.step("Get element color ");
        String rgb[] = webElement.getCssValue("border-color").replaceAll(RGBA_TO_RGB_REGEX, "")
                .split(COMMA_REGEX);
        return String.format("#%s%s%s", toBrowserHexValue(Integer.parseInt(rgb[0])),
                toBrowserHexValue(Integer.parseInt(rgb[1])),
                toBrowserHexValue(Integer.parseInt(rgb[2])));
    }

    private static String toBrowserHexValue(int number) {
        StringBuilder builder = new StringBuilder(Integer.toHexString(number & 0xff));
        while (builder.length() < 2) {
            builder.append("0");
        }
        return builder.toString();
    }

    public static void moveMouseToAndClick(WebDriver driver, WebElement element, int x, int y) {
        TestReporter.step("Move to the element position ");
        LOGGER.log(Level.INFO, "Move to the element position");
        Actions action = new Actions(driver);
        TestReporter.step("Wait for page loading " + element);
        action.moveToElement(element, x, y).click().build().perform();
    }

    public static void hoverAndClick(WebDriver driver, WebElement mainElement, WebElement subElement) {
        LOGGER.log(Level.INFO, "Move to the main element position and click needed element");
        TestReporter.step(" Click on needed element " + subElement);
        Actions action = new Actions(driver);
        action.moveToElement(mainElement).perform();
        action.click(subElement).perform();
    }
}




