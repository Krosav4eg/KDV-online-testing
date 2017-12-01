package listener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import testcases.base.BaseTest;

import static utils.Constants.ERROR_SCREENSHOT_FOLDER;
import static utils.Constants.SUCCESS_SCREENSHOT_FOLDER;

/**
 * @author Sergey Potapov
 */
public class ListenerTest extends TestListenerAdapter implements ITestListener {
    protected static final Logger logger = LogManager.getLogger(ListenerTest.class);

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.info(iTestResult.getName() + "This test is success");
        BaseTest.capture(iTestResult.getName(), SUCCESS_SCREENSHOT_FOLDER);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println(" TEST: " + iTestResult);

        logger.error(">>>>>> This test is failed:<<<<<< " + iTestResult.getName());
        logger.error(">>>>>> This test is failed after:<<<<<< " + ((iTestResult.getEndMillis() - iTestResult.getStartMillis()) / 1000) + "Seconds");
        String messageErr = iTestResult.getThrowable().getMessage();
        try {
            logger.error(">>>>>>> Reason: Unable to locate current element by using selector:<<<<<< " + messageErr.substring(0, messageErr.indexOf('\n')));
        } catch (StringIndexOutOfBoundsException ex) {
            logger.error(">>>>>>> Reason: Unable to locate current element by using selector:<<<<<< " + messageErr.replace("Expected condition failed: waiting for visibility of Proxy element for: DefaultElementLocator", ""));
        }
        BaseTest.capture(iTestResult.getName(), ERROR_SCREENSHOT_FOLDER);
    }
}
