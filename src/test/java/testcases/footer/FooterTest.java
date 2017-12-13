package testcases.footer;

import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;

/**
 * @author Sergey Potapov
 */
public class FooterTest extends BaseTest {
    @Test
    public void verifyAboutShopLinkTest() {
        TestReporter.testTitle("Test ID - C34351");
        mainPage.verifyShopLink();
    }
}
