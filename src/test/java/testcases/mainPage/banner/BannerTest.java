package testcases.mainPage.banner;

import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;

/**
 * @author Sergey Potapov
 */
public class BannerTest extends BaseTest {
    @Test
    public void switchSlideForwardTest() {
        TestReporter.testTitle("Test ID - C34331");
        mainPage.switchSlideForward();
    }
    @Test
    public void switchSlidePreviousTest() {
        TestReporter.testTitle("Test ID - C34332");
        mainPage.switchSlidePreviously();
    }
}
