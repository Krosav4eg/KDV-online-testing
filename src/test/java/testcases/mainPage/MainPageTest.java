package testcases.mainPage;

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

    @Test
    public void verifyingAboutLinkFreeDeliveryTest() {
        mainPage.verifyingAboutLinkFreeDeliveringSection();
    }

    @Test
    public void verifyingOpeningPaymentUponReceivingTest() {
        mainPage.verifyingOpeningPaymentUponReceivingSection();
    }

    @Test
    public void verifyingClosingPaymentUponReceivingTest() {
        mainPage.verifyingClosingPaymentUponReceivingSection();
    }

    @Test
    public void verifyingAboutLinkPaymentUponReceivingTest() {
        mainPage.verifyingAboutLinkPaymentUponReceivingSection();
    }
}
