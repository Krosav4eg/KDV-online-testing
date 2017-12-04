package testcases.MainPage;

import org.testng.annotations.Test;
import testcases.base.BaseTest;

/**
 * @author Sergey Potapov
 */
public class MainPageTest extends BaseTest {
    @Test
    public void verifyLowerPriceTest() {
        mainPage.verifyingOpeningLowerPricesSection();
    }

    @Test
    public void verifyClosingLowerPriceTest() {
        mainPage.verifyingClosingLowerPricesSection();
    }

    @Test
    public void verifyingAboutLinkLowerPrice() {
        mainPage.verifyingAboutLinkLowerPriceSection();
    }
    @Test
    public void verifyOpeningFreeDeliveryTest() {
        mainPage.verifyingOpeningFreeDeliveringSection();
    }
    @Test
    public void verifyClosingFreeDeliveryTest() {
        mainPage.verifyingClosingFreeDeliveringSection();
    }
}
