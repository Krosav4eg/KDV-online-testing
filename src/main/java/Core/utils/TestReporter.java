package Core.utils;

import org.testng.Assert;
import org.testng.Reporter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.String.format;

/**
 * @author Sergey Potapov
 */
public class TestReporter {
    private static final String ALL_TEXT_FONT_FAMILY = "font-family: Lucida Sans Unicode, Lucida Grande, sans-serif;";
    private static final String TEST_TITLE_TAG_STYLE = "\'color:#000000\'";
    private static final String LOG_TAG_STYLE = "\'color:#787878;" + ALL_TEXT_FONT_FAMILY + "size:2;\'";
    private static final String STEP_TAG_STYLE = "\'color:#202020;" + ALL_TEXT_FONT_FAMILY + "font-size: 1.4em;font-weight: bold;\'";
    private static final String STEP_MESSAGE_TAG_STYLE = "\'color:#202020;" + ALL_TEXT_FONT_FAMILY + "font-size: 1.3em;\'";
    private static final String TIME_TAG_STYLE = "\'color:#303030;" + ALL_TEXT_FONT_FAMILY + "\'";
    private static final String FAIL_TAG_STYLE = "\'color:#8B0000;" + ALL_TEXT_FONT_FAMILY + "font-size: 1.4em;\'";
    private static final String SUCCESS_TAG_STYLE = "\'color:#006400;" + ALL_TEXT_FONT_FAMILY + "font-size: 1.4em;\'";
    private static final String SKIP_TAG_STYLE = "\'color:#FFD700;" + ALL_TEXT_FONT_FAMILY + "font-size: 1.4em;\'";
    private static final String BORDER_TAG_STYLE = "\'color:#787878;" + ALL_TEXT_FONT_FAMILY + "font-size: 1.3em;\'";

    private static final String BR_TAG = "<br />";
    private static final String TEST_TITLE_TAG = "<h3 style=" + TEST_TITLE_TAG_STYLE + ">Start to execute test - %s</h3>";
    private static final String STEP_TAG = "<div style=" + STEP_TAG_STYLE + ">Step %s</div>";
    private static final String STEP_MESSAGE_TAG = "<div style=" + STEP_MESSAGE_TAG_STYLE + ">%s</div>";
    private static final String TIME_TAG = "<br /><time style=" + TIME_TAG_STYLE + ">%s</time>";
    private static final String LOG_TAG = "<span><font style=" + LOG_TAG_STYLE + ">%s</font></span>";
    private static final String MARK_TAG = "<strong style=" + LOG_TAG_STYLE + ">%s</strong>";
    private static final String SIMPLE_LOG_TAG = "<div style=" + LOG_TAG_STYLE + ">%s</div>";
    private static final String FAIL_TAG = BR_TAG + "<strong style=" + FAIL_TAG_STYLE + ">%s</strong>";
    private static final String SUCCESS_TAG = BR_TAG + "<strong style=" + SUCCESS_TAG_STYLE + ">%s</strong>";
    private static final String SKIP_TAG = BR_TAG + "<strong style=" + SKIP_TAG_STYLE + ">%s</strong>";
    private static final String BORDER_TAG = "<strong style=" + BORDER_TAG_STYLE + ">//================= %s =================//</strong>";
    private static final String P_TAG = "<p><font>%s</font></p>";
    private static final String SCREENSHOT_TAG = "<a href='%s'> <img src='%s' height='380' width='800'/></a>";
    private static ThreadLocal<AtomicInteger> numberStep = ThreadLocal.withInitial(() -> new AtomicInteger(1));

    public static void testTitle(String title) {
        Reporter.log(format(TEST_TITLE_TAG, title));
    }

    /**
     * This method will mark your message as a step in current executed test in report
     *
     * @param step - message that corresponds to a step in executed scenario
     */
    public static void step(String step) {
        Reporter.log(format(P_TAG, getTimeStamp() + format(STEP_TAG, numberStep.get().getAndIncrement() + ":") + format(STEP_MESSAGE_TAG, step)), false);
    }

    /**
     * This method mark your message as a part of step log,
     * so, if your message is not a step, but an important and should be included to report
     * you can use this method to add an intermediate verifications between steps
     *
     * @param stepInfo - message that should be logged to report of current test that executed
     */
    public static void stepInfo(String stepInfo) {
        Reporter.log(format(P_TAG, format(MARK_TAG, " step info: ") + format(LOG_TAG, stepInfo)), false);
    }

    /**
     * Let to add to report comparison results in format of:
     * Expected: [expected]
     * Actual: [actual]
     *
     * @param actual   - actual comparison value
     * @param expected - expected comparison value
     */
    public static void reportActualAndExpected(String actual, String expected) {
        String message = getActualAndExpectedMessage(actual, expected);
        stepInfo(message);
    }

    /**
     * Let to add log information to 'Log Output' report section
     *
     * @param simpleLogMessage - message that should be added to 'Log Output' section
     */
    public static void log(String simpleLogMessage) {
        Reporter.log(format(SIMPLE_LOG_TAG, simpleLogMessage));
    }

    /**
     * Mark your logged message in red color that indicates the Fail
     *
     * @param failureMessage - message that should be mark as fail
     */
    public static void fail(String failureMessage) {
        Reporter.log(format(FAIL_TAG, failureMessage));
    }

    /**
     * Mark your logged message in green color that indicates the Success
     *
     * @param successMessage - message that should be mark as success
     */
    public static void success(String successMessage) {
        Reporter.log(format(SUCCESS_TAG, successMessage));
    }

    /**
     * Mark your logged message in yellow color that indicates the Skip
     *
     * @param skipMessage - message that should be mark as skip
     */
    public static void skip(String skipMessage) {
        Reporter.log(format(SKIP_TAG, skipMessage));
    }

    /**
     * Appends border with message in report in format:
     * //================= YOUR_MESSAGE_HERE =================//
     *
     * @param borderMessage - message of the border
     */
    public static void appendBorderInReport(String borderMessage) {
        Reporter.log(format(BORDER_TAG, borderMessage));
    }

    /**
     * Let to get a simple string in html format with comparison result of actual and expected
     *
     * @param actual   - actual comparison value
     * @param expected - expected comparison value
     * @return - a string in simple html format, that could be then pasted in any other place or log message
     */
    public static String getActualAndExpectedMessage(Object actual, Object expected) {
        return "<br /><b>Expected:</b> [" + expected + "]</br>&nbsp;&nbsp;&nbsp;&nbsp;<b>Actual:</b> [" + actual + "]";
    }

    /**
     * Should be pasted in @After* methods for the correct displaying of step numbers in the tests
     */
    public static synchronized void removeNumberStep() {
        numberStep.remove();
    }

    private static void logScreenshot(String screenshotPath) {
        Reporter.log(format(SCREENSHOT_TAG, screenshotPath, screenshotPath));
    }

    public static void messageFail(String message) {
        TestReporter.fail(message);
        Assert.fail(message);
    }

    private static String getTimeStamp() {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        return format(TIME_TAG, timestamp.toString());
    }
}
