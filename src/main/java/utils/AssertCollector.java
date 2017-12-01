package utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

/**
 * @author Sergey Potapov
 */
public class AssertCollector {

    protected static final Logger logger = LogManager.getLogger(basePage.BasePage.class);

    public static void assertEquals(Object actual, Object expected) {
        try {
            Assert.assertEquals(actual, expected);
            logger.info(expected.toString() + " value equals " + actual.toString());
        } catch (Throwable e) {
            logger.info(expected.toString() + " is not equals " + actual.toString());
            Assert.fail();
        }
    }

    public static void assertFalse(boolean condition) {
        Assert.assertFalse(condition);
        logger.info("expected condition " + condition);
    }
}
