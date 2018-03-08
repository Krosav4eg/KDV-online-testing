package KDV_testcases.mainPage.banner;

import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.TestReporter;

/**
 * @author Sergey Potapov
 */
public class BannerTest extends BaseTest {
    @Test
    public void switchSlideForwardTest() {
        TestReporter.testTitle("Test ID - C34331");
        mainPageSelector.switchSlideForward();
        mainPageSelector.switchSlidePreviously();
        mainPageSelector.switchBetweenSlides();
    }
}
