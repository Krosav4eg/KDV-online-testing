package KDV_testcases.mainPage.blockWithBenefits;

import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.TestReporter;

/**
 * @author Sergey Potapov
 */
public class BenefitsBlockTest extends BaseTest {
    @Test
    public void verifyLowerPriceTest() {
        TestReporter.testTitle("Test ID - C34321");//C34321 - объеденен с C34322 и C34323
        mainPage.verifyingOpeningLowerPricesSection();
        mainPage.verifyingClosingLowerPricesSection();
        mainPage.verifyingAboutLinkLowerPriceSection();
    }

    @Test
    public void verifyOpeningFreeDeliveryTest() {//C34324 - объеденен с C34325 и C34326
        TestReporter.testTitle("Test ID - C34324");
        mainPage.verifyingOpeningFreeDeliveringSection();
        mainPage.verifyingClosingFreeDeliveringSection();
        mainPage.verifyingAboutLinkFreeDeliveringSection();
    }

    @Test
    public void verifyingOpeningPaymentUponReceivingTest() {//C34327 - объеденен с C34328 и C34329
        TestReporter.testTitle("Test ID - C34327");
        mainPage.verifyingOpeningPaymentUponReceivingSection();
        mainPage.verifyingClosingPaymentUponReceivingSection();
        mainPage.verifyingAboutLinkPaymentUponReceivingSection();
    }

    @Test
    public void verifyingBorderColorTest() {
        TestReporter.testTitle("Test ID - C34330");
        mainPage.verifyBorderColor();
    }
}
