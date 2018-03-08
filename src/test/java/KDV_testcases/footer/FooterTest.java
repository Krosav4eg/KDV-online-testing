package KDV_testcases.footer;

import Core.basePage.BasePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.TestReporter;

import java.lang.reflect.Method;

/**
 * @author Sergey Potapov
 */
public class FooterTest extends BaseTest {

    @BeforeMethod
    public void beforeGeneralTests(Method method) {
        BasePage.scrollToNecessaryElement(mainPageSelector.footer);
    }

    @Test
    public void verifyCopyWritingTest() {
        TestReporter.testTitle("Test ID - C34355");
        footerPage.verifyingCopyWriting();
    }

    @Test
    public void verifyContactDataLinkTest() {
        TestReporter.testTitle("Test ID - C34356");
        footerPage.openingContactDataLink();
    }

    @Test
    public void verifyOpeningAboutShopLinkTest() {//C34351 - объеденен с C34358-69
        TestReporter.testTitle("Test ID - C34351");
        footerPage.openingShopLink();
        footerPage.openingCustomerPickUpLink();
        footerPage.openingFreeDeliveryLink();
        footerPage.openingPaymentLink();
        footerPage.openingHowToBuyLink();
        footerPage.openingExchangeAndReturnLink();
        footerPage.openingInfoForLegalPersonsLink();
        footerPage.openingContractPurchaseSaleLink();
        footerPage.openingSupplyContractLink();
        footerPage.openingPersonalDataLink();
        footerPage.openingPoliticConfidentialLink();
        footerPage.openingRegulationsLink();
        footerPage.openingContactsLink();
    }

    @Test
    public void verifyOpeningVkLinkInFooterTest() {//C34352 - объеденен с C34353-57
        TestReporter.testTitle("Test ID - C34352");
        footerPage.openingVkLinkInFooter();
        footerPage.openingInstaInFooter();
        footerPage.openingGooglePlayInFooter();
        footerPage.clickingUpButtonInFooter();
    }

    @Test
    public void verifyAdditionalPhoneLinkTest() {
        TestReporter.testTitle("Test ID - 43017");
        footerPage.verifyAdditionalPhoneLink();
    }
}
