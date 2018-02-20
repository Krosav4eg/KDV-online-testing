package KDV_testcases.footer;

import Core.basePage.BasePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.AssertCollector;
import Core.utils.TestReporter;

import java.lang.reflect.Method;

/**
 * @author Sergey Potapov
 */
public class FooterTest extends BaseTest {

    private BasePage.MyDelegate del = new BasePage.MyDelegate() {
    };

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

    //TODO write id for test
    @Test
    public void verifyAdditionalPhoneLinkTest() {
        TestReporter.testTitle("Test ID - ");
        del.textPresentDelegate("8 800 250 5555");
        del.textPresentDelegate("Служба поддержки");
        AssertCollector.assertEqualsJ(mainPage.telLink.getAttribute("href"), "tel:8 800 250 5555",
                "references are equals");
        del.textPresentDelegate("+7 913 817-38-90");
        del.textPresentDelegate("Служба доставки в городе Томск:");
        AssertCollector.assertEqualsJ(mainPage.additionalTelLink.getAttribute("href"), "tel:+7 913 817-38-90",
                "references are equals");
    }
}
