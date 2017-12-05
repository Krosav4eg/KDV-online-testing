package utils;

import logger.MagDvLogger;
import org.testng.Assert;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Sergey Potapov
 */
public class AssertCollector {

    private static final Logger LOGGER = MagDvLogger.getMagDvLogger().getLogger();

    public static void assertEquals(Object actual, String message, Object expected) {
        try {
            Assert.assertEquals(actual, expected);
            LOGGER.log(Level.INFO, expected.toString() + message + actual.toString());
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, expected.toString() + message + actual.toString());
            Assert.fail();
        }
    }

    public static void assertFalse(boolean condition) {
        Assert.assertFalse(condition);
        LOGGER.log(Level.INFO, " expected condition " + condition);
    }

    public static void assertTrue(boolean condition) {
        Assert.assertTrue(condition);
        LOGGER.log(Level.INFO, " expected condition " + condition);
    }

    /**
     * This method uses library assertJ for once-only comparison. "Try-catch" is used for remaining old logging logic,
     * but there is RuntimeException in the end that test can fail in appropriate situation.
     *
     * @param actual   - actual result obtained from UI
     * @param expected - expected result obtained from data file, db, etc
     * @param message  -  message send to reporter
     */
    public static void assertEqualsJ(Object actual, Object expected, String message) {
        try {
            assertThat(actual).isEqualTo(expected);
            TestReporter.success(message + TestReporter.getActualAndExpectedMessage(actual.toString(), expected.toString()));
            LOGGER.log(Level.INFO, expected.toString() + message + actual.toString());
        } catch (AssertionError e) {
            TestReporter.fail(message + TestReporter.getActualAndExpectedMessage(actual.toString(), expected.toString()));
            LOGGER.log(Level.WARNING, expected.toString() + message + actual.toString());
            Assert.fail(message);
        }
    }
}
