package Core.driverFactory;

import Core.logger.MagDvLogger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;
import Core.utils.TestReporter;

import java.util.logging.Level;
import java.util.logging.Logger;

import static Core.utils.WaitingUtility.waitForJSandJQueryToLoad;
import static Core.utils.WaitingUtility.waitForPageLoad;

public abstract class EventHandler implements WebDriverEventListener {

    private static final Logger LOGGER = MagDvLogger.getMagDvLogger().getLogger();

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        LOGGER.log(Level.INFO, "Refresh Current Page\t");
        TestReporter.step("Refresh Current Page\t");
        waitForPageLoad(webDriver);
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
//		waitForPageLoad(webDriver);
        //System.out.println("beforeChangeValueOf "+ webElement);
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        if (charSequences != null) {
            LOGGER.log(Level.INFO, "Change value in element\t" + webElement + "\t add value:" + charSequences[0]);
            TestReporter.step("Change value in element\t" + webElement + "\t add value:" + charSequences[0]);
        }
    }

    @Override
    public void beforeClickOn(WebElement arg0, WebDriver arg1) {
        waitForJSandJQueryToLoad();
    }

    @Override
    public void afterClickOn(WebElement arg0, WebDriver arg1) {
        TestReporter.step("Click on - \t" + arg0);
        LOGGER.log(Level.INFO, "Click on - \t" + arg0);
        waitForJSandJQueryToLoad();
    }

    @Override
    public void afterNavigateForward(WebDriver arg0) {
    }

    @Override
    public void afterNavigateTo(String arg0, WebDriver arg1) {

    }

    @Override
    public void beforeNavigateTo(String arg0, WebDriver arg1) {

        LOGGER.log(Level.INFO, "Navigate to needed url\t" + arg0);
        TestReporter.step("Navigate to needed url\t" + arg0);
    }

    @Override
    public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
        LOGGER.log(Level.INFO, "Find element\t" + arg0);
        TestReporter.step("Find element\t" + arg0);
    }

    @Override
    public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {

    }

    @Override
    public void afterScript(String arg0, WebDriver arg1) {
    }

    @Override
    public void afterNavigateBack(WebDriver arg0) {
    }

    @Override
    public void beforeNavigateBack(WebDriver arg0) {
    }

    @Override
    public void beforeNavigateForward(WebDriver arg0) {
    }

    @Override
    public void beforeScript(String arg0, WebDriver arg1) {
    }

    @Override
    public void onException(Throwable arg0, WebDriver arg1) {

    }


}