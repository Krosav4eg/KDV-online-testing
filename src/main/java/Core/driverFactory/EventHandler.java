package Core.driverFactory;

import Core.logger.MagDvLogger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;
import utils.TestReporter;

import java.util.logging.Level;
import java.util.logging.Logger;

import static utils.WaitingUtility.waitForJSandJQueryToLoad;
import static utils.WaitingUtility.waitForPageLoad;

public abstract class EventHandler implements WebDriverEventListener {

    private static final Logger LOGGER = MagDvLogger.getMagDvLogger().getLogger();

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        //System.out.println("beforeNavigateRefresh "+ webDriver);
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        LOGGER.log(Level.INFO, "Refresh Current Page\t");
        TestReporter.step("Refresh Current Page\t");
        waitForPageLoad(webDriver);
        //System.out.println("afterNavigateRefresh " +webDriver);
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
            //System.out.println("afterChangeValueOf "+webElement);
        }
    }

    @Override
    public void beforeClickOn(WebElement arg0, WebDriver arg1) {
        waitForJSandJQueryToLoad();
        //threadSleep();
        //waitForPageLoad(arg1);
        //moveToElementJS(arg1,arg0);
        //threadSleep();
        //System.out.println("beforeClickOn "+arg0+" WebDriver "+arg1);
    }

    @Override
    public void afterClickOn(WebElement arg0, WebDriver arg1) {
        TestReporter.step("Click on - \t" + arg0);
        LOGGER.log(Level.INFO, "Click on - \t" + arg0);
        waitForJSandJQueryToLoad();
        //waitForPageLoad(arg1);
        //System.out.println("afterClickOn "+arg0+" WebDriver "+arg1);
    }

    @Override
    public void afterNavigateForward(WebDriver arg0) {
        //System.out.println("afterNavigateForward "+arg0);
    }

    @Override
    public void afterNavigateTo(String arg0, WebDriver arg1) {

        //waitForPageLoad(arg1);
        //threadSleep();
        //System.out.println("afterNavigateTo "+" WebDriver "+arg1);
    }

    @Override
    public void beforeNavigateTo(String arg0, WebDriver arg1) {

        LOGGER.log(Level.INFO, "Navigate to needed url\t" + arg0);
        TestReporter.step("Navigate to needed url\t" + arg0);
        //System.out.println("beforeNavigateTo "+" WebDriver "+arg1);
    }

    @Override
    public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
        LOGGER.log(Level.INFO, "Find element\t" + arg0);
        TestReporter.step("Find element\t" + arg0);
        //waitForPageLoad(arg2);
        //System.out.println("beforeFindBy "+" WebElement "+arg1+" WebDriver "+arg2);
    }

    @Override
    public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {

        //System.out.println("afterFindBy "+arg0+" WebElement "+arg1+" WebDriver "+arg2);
    }

    @Override
    public void afterScript(String arg0, WebDriver arg1) {
        //threadSleep();
        //System.out.println("afterScript " +arg1);
    }

    @Override
    public void afterNavigateBack(WebDriver arg0) {
        //System.out.println("afterNavigateBack "+arg0);
    }

    @Override
    public void beforeNavigateBack(WebDriver arg0) {
        //System.out.println("beforeNavigateBack "+arg0);
    }

    @Override
    public void beforeNavigateForward(WebDriver arg0) {
        //System.out.println("beforeNavigateForward "+arg0);
    }

    @Override
    public void beforeScript(String arg0, WebDriver arg1) {
        //waitForPageLoad(arg1);
        //System.out.println("beforeScript "+arg0);
    }

    @Override
    public void onException(Throwable arg0, WebDriver arg1) {
//        arg0.printStackTrace();
//        if (arg0.getLocalizedMessage().contains("no such window")) {
//            return;
//        }
//        capture(testName, ERROR_SCREENSHOT_FOLDER);
    }


}