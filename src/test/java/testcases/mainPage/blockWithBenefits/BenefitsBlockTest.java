package testcases.mainPage.blockWithBenefits;

import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;

/**
 * @author Sergey Potapov
 */
public class BenefitsBlockTest extends BaseTest {
    @Test
    public void verifyLowerPriceTest() {
        TestReporter.testTitle("Test ID - C34321");
        mainPage.verifyingOpeningLowerPricesSection();
    }

    @Test
    public void verifyClosingLowerPriceTest() {
        TestReporter.testTitle("Test ID - C34322");
        mainPage.verifyingClosingLowerPricesSection();
    }

    @Test
    public void verifyingAboutLinkLowerPrice() {
        TestReporter.testTitle("Test ID - C34323");
        mainPage.verifyingAboutLinkLowerPriceSection();
    }

    @Test
    public void verifyOpeningFreeDeliveryTest() {
        TestReporter.testTitle("Test ID - C34324");
        mainPage.verifyingOpeningFreeDeliveringSection();
    }

    @Test
    public void verifyClosingFreeDeliveryTest() {
        TestReporter.testTitle("Test ID - C34325");
        mainPage.verifyingClosingFreeDeliveringSection();
    }

    @Test
    public void verifyingAboutLinkFreeDeliveryTest() {
        TestReporter.testTitle("Test ID - C34326");
        mainPage.verifyingAboutLinkFreeDeliveringSection();
    }

    @Test
    public void verifyingOpeningPaymentUponReceivingTest() {
        TestReporter.testTitle("Test ID - C34327");
        mainPage.verifyingOpeningPaymentUponReceivingSection();
    }

    @Test
    public void verifyingClosingPaymentUponReceivingTest() {
        TestReporter.testTitle("Test ID - C34328");
        mainPage.verifyingClosingPaymentUponReceivingSection();
    }

    @Test
    public void verifyingAboutLinkPaymentUponReceivingTest() {
        TestReporter.testTitle("Test ID - C34329");
        mainPage.verifyingAboutLinkPaymentUponReceivingSection();
    }

    @Test
    public void verifyingBorderColorTest() {
        TestReporter.testTitle("Test ID - C34330");
        mainPage.verifyBorderColor();
    }
}
