package testcases.mainPage.banner;

import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;

/**
 * @author Sergey Potapov
 */
public class BannerTest extends BaseTest{
    @Test
    public void switchSlideForwardTest() throws InterruptedException {
        TestReporter.testTitle("Test ID - C34331");
        mainPage.switchSlideForward();
    }
}
