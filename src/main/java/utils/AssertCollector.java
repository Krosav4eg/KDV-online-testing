package utils;

import logger.MagDvLogger;
import org.testng.Assert;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Sergey Potapov
 */
public class AssertCollector {

    private static final Logger LOGGER = MagDvLogger.getMagDvLogger().getLogger();

    public static void assertEquals(Object actual, String message, Object expected) {
        try {
            Assert.assertEquals(actual, expected);
            LOGGER.log(Level.INFO, expected.toString() +  message  + actual.toString());
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
}
