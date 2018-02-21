package listener;

import Core.logger.MagDvLogger;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import KDV_testcases.base.BaseTest;

import java.util.logging.Level;
import java.util.logging.Logger;

import static Core.utils.Constants.ERROR_SCREENSHOT_FOLDER;
import static Core.utils.Constants.SUCCESS_SCREENSHOT_FOLDER;

/**
 * @author Sergey Potapov
 */
public class ListenerTest extends TestListenerAdapter implements ITestListener {

    private static final Logger LOGGER = MagDvLogger.getMagDvLogger().getLogger();

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        if (iTestResult.getStatus() == ITestResult.SUCCESS) {
            LOGGER.log(Level.INFO, iTestResult.getName() + "This test is success");
            BaseTest.capture(iTestResult.getName(), SUCCESS_SCREENSHOT_FOLDER);
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LOGGER.log(Level.WARNING, ">>>>>> This test is failed:<<<<<< " + iTestResult.getName());
        LOGGER.log(Level.WARNING, ">>>>>> This test is failed after:<<<<<< " + ((iTestResult.getEndMillis()
                - iTestResult.getStartMillis()) / 1000) + "Seconds");
        String messageErr = iTestResult.getThrowable().getMessage();
        try {
            LOGGER.log(Level.WARNING, ">>>>>>> Reason: Unable to locate current element by using selector:<<<<<< "
                    + messageErr.substring(0, messageErr.indexOf('\n')));
        } catch (StringIndexOutOfBoundsException ex) {
            LOGGER.log(Level.WARNING, ">>>>>>> Reason: Unable to locate current element by using selector:<<<<<< "
                    + messageErr.replace("Expected condition failed: waiting for visibility of Proxy element for: "
                    + "DefaultElementLocator", ""));
        }
        BaseTest.capture(iTestResult.getName(), ERROR_SCREENSHOT_FOLDER);
        LOGGER.log(Level.WARNING, "<a href=" + ERROR_SCREENSHOT_FOLDER + iTestResult.getName() +
                ".png> Error Screen:" + iTestResult.getName() + "</a>");
    }
}

