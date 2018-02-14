package testcases.footer;

import Core.basePage.BasePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;

import java.lang.reflect.Method;

/**
 * @author Sergey Potapov
 */
public class FooterTest extends BaseTest {

    @BeforeMethod
    public void beforeGeneralTests(Method method) {
        BasePage.scrollToNecessaryElement(mainPage.footer);
    }

    @Test
    public void verifyCopyWritingTest() {
        TestReporter.testTitle("Test ID - C34355");
        mainPage.verifyingCopyWriting();
    }

    @Test
    public void verifyContactDataLinkTest() {
        TestReporter.testTitle("Test ID - C34356");
        mainPage.openingContactDataLink();
    }

    @Test
    public void verifyOpeningAboutShopLinkTest() {//C34351 - объеденен с C34358-69
        TestReporter.testTitle("Test ID - C34351");
        mainPage.openingShopLink();
        mainPage.openingCustomerPickUpLink();
        mainPage.openingFreeDeliveryLink();
        mainPage.openingPaymentLink();
        mainPage.openingHowToBuyLink();
        mainPage.openingExchangeAndReturnLink();
        mainPage.openingInfoForLegalPersonsLink();
        mainPage.openingContractPurchaseSaleLink();
        mainPage.openingSupplyContractLink();
        mainPage.openingPersonalDataLink();
        mainPage.openingPoliticConfidentialLink();
        mainPage.openingRegulationsLink();
        mainPage.openingContactsLink();
    }

    @Test
    public void verifyOpeningVkLinkInFooterTest() {//C34352 - объеденен с C34353-57
        TestReporter.testTitle("Test ID - C34352");
        mainPage.openingVkLinkInFooter();
        mainPage.openingInstaInFooter();
        mainPage.openingGooglePlayInFooter();
        mainPage.clickingUpButtonInFooter();
    }
}
