package testcases.footer;

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
        mainPage.scrollToNecessaryElement(mainPage.footer);
    }

    @Test
    public void verifyOpeningAboutShopLinkTest() {
        TestReporter.testTitle("Test ID - C34351");
        mainPage.openingShopLink();
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
    public void verifyOpeningCustomerPickupLinkTest() {
        TestReporter.testTitle("Test ID - C34358");
        mainPage.openingCustomerPickUpLink();
    }

    @Test
    public void verifyOpeningFreeDeliveryLinkTest() {
        TestReporter.testTitle("Test ID - C34359");
        mainPage.openingFreeDeliveryLink();
    }

    @Test
    public void verifyOpeningPaymentLinkTest() {
        TestReporter.testTitle("Test ID - C34360");
        mainPage.openingPaymentLink();
    }

    @Test
    public void verifyOpeningHowToBuyLinkTest() {
        TestReporter.testTitle("Test ID - C34361");
        mainPage.openingHowToBuyLink();
    }

    @Test
    public void verifyOpeningExchangeAndReturnLinkTest() {
        TestReporter.testTitle("Test ID - C34362");
        mainPage.openingExchangeAndReturnLink();
    }

    @Test
    public void verifyOpeningInfoForLegalPersonsLinkTest() {
        TestReporter.testTitle("Test ID - C34363");
        mainPage.openingInfoForLegalPersonsLink();
    }

    @Test
    public void verifyOpeningContractPurchaseSaleLinkTest() {
        TestReporter.testTitle("Test ID - C34364");
        mainPage.openingContractPurchaseSaleLink();
    }

    @Test
    public void verifyOpeningSupplyContractLinkTest() {
        TestReporter.testTitle("Test ID - C34365");
        mainPage.openingSupplyContractLink();
    }

    @Test
    public void verifyOpeningPersonalDataLinkTest() {
        TestReporter.testTitle("Test ID - C34366");
        mainPage.openingPersonalDataLink();
    }

    @Test
    public void verifyOpeningPoliticConfidentialLinkTest() {
        TestReporter.testTitle("Test ID - C34367");
        mainPage.openingPoliticConfidentialLink();
    }
}
