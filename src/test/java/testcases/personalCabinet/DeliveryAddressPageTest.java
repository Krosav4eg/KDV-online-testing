package testcases.personalCabinet;

import Core.basePage.BasePage;
import org.json.JSONObject;
import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.AssertCollector;
import utils.TestReporter;

import static utils.Constants.ACCOUNT_DELIVERY_ADDRESS_URL;
import static utils.Constants.ACCOUNT_INFORMATION_URL;

public class DeliveryAddressPageTest extends BaseTest {
    BasePage.MyDelegate del = new BasePage.MyDelegate() {
    };

    @Test
    public void verifyOpeningAddressItemTest() {
        TestReporter.testTitle("Test ID = 38710");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", "test_m.ponomareva@magdv.com");
        data.put("password", "ztq0d9e6");
        authorizationPage.verifyAuthFields(data);
        del.getUrlDelegate(ACCOUNT_DELIVERY_ADDRESS_URL);
        AssertCollector.assertEqualsJ(del.getCurrentUrlDelegate(), ACCOUNT_DELIVERY_ADDRESS_URL, "Urls are equals");
        AssertCollector.assertTrue(deliveryAddressPage.deliveryAddressHeader.isDisplayed(),
                "Required header is displayed");
    }

    @Test
    public void verifyAbsenceDeliveryAddressItemTest() {
        TestReporter.testTitle("Test ID = 38458");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", "test_i.makarov@magdv.com");
        data.put("password", "SWgeZWPs");
        authorizationPage.verifyAuthFields(data);
        orderingGuestPage.clickOnWebElement(deliveryAddressPage.deliveryAddressItemButton);
//        deliveryAddressPage.deliveryAddressItemButton.click();
        AssertCollector.assertEqualsJ(del.getCurrentUrlDelegate(), ACCOUNT_DELIVERY_ADDRESS_URL +
                "new/", "Urls are equals");
    }

    @Test
    public void verifyOneDeliveryAddressItemTest() {
        TestReporter.testTitle("Test ID = 38722,38728");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", "test_t.bolshakov@magdv.com");
        data.put("password", "sTU1iJ46");
        authorizationPage.verifyAuthFields(data);
        orderingGuestPage.clickOnWebElement(deliveryAddressPage.deliveryAddressItemButton);
        AssertCollector.assertEqualsJ(deliveryAddressPage.nameDeliveryByDefault.getText(), "Тимофей Большаков",
                "First name and last name are equals");
        AssertCollector.assertEqualsJ(deliveryAddressPage.deliveryAddressByDefault.getText(),
                "г Томск, ул Вавилова, д 13, кв 23",
                "Addresses are equals");
        AssertCollector.assertEqualsJ(deliveryAddressPage.phoneDeliveryByDefault.getText(), "+71111111111",
                "Phone numbers are equals");
        AssertCollector.assertTrue(deliveryAddressPage.byDefaultMark.isDisplayed());
        orderingGuestPage.clickOnWebElement(deliveryAddressPage.addressActionLink);
        AssertCollector.assertEqualsJ(del.getCurrentUrlDelegate(), ACCOUNT_DELIVERY_ADDRESS_URL + "edit/id/4236/",
                "Urls are equals");
        AssertCollector.assertEqualsJ(deliveryAddressPage.firstNameInEditDeliveryPage.getAttribute("value"),
                "Тимофей", "First names are correct");
        AssertCollector.assertEqualsJ(deliveryAddressPage.lastNameInEditDeliveryPage.getAttribute("value"),
                "Большаков", "Last names are correct");
        AssertCollector.assertEqualsJ(deliveryAddressPage.phoneInEditDeliveryPage.getAttribute("value"),
                "+71111111111", "Phone numbers are equals");
        AssertCollector.assertEqualsJ(deliveryAddressPage.addressInEditDeliveryPage.getAttribute("value"),
                "г Томск, ул Вавилова, д 13, кв 23", "Addresses are equals");
        AssertCollector.assertEqualsJ(deliveryAddressPage.florInEditDeliveryPage.getAttribute("value"),
                "1", "Flores are equals");
        AssertCollector.assertEqualsJ(deliveryAddressPage.porchInEditDeliveryPage.getAttribute("value"),
                "2", "Porches are equals");
    }

    @Test
    public void verifyChangingDeliveryAddressTest() {
        TestReporter.testTitle("Test ID = 40110");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", "test_s.zuev@magdv.com");
        data.put("password", "YZde8m");
        authorizationPage.verifyAuthFields(data);
        orderingGuestPage.clickOnWebElement(deliveryAddressPage.editDeliveryLink);
        AssertCollector.assertEqualsJ(del.getCurrentUrlDelegate(), ACCOUNT_INFORMATION_URL, "Urls are equals");
    }

    @Test
    public void verifyOpeningMyBookingItemTest() {
        TestReporter.testTitle("Test ID = 40112");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", "test_v.kalashnikova@magdv.com");
        data.put("password", "Q2ThNhHs");
        authorizationPage.verifyAuthFields(data);
//        myBookingPage.myBookingsItemButton.click();
        orderingGuestPage.clickOnWebElement(myBookingPage.myBookingsItemButton);
        del.textPresentDelegate("Мои заказы");
        del.textPresentDelegate("У вас пока нет оформленных заказов.");
    }

    @Test
    public void verifyCardApprovedAndEdit() {
        TestReporter.testTitle("Test ID = 41697");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", "test_g.fadeev@magdv.com");
        data.put("password", "gctbVY");
        authorizationPage.verifyAuthFields(data);
        deliveryAddressPage.verifyCardApprovedAddress();
    }

    @Test
    public void verifyCardNotApproved() {
        TestReporter.testTitle("Test ID = 41627");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", "test_g.fadeev@magdv.com");
        data.put("password", "gctbVY");
        authorizationPage.verifyAuthFields(data);
        deliveryAddressPage.verifyCardNotApprovedAddress();
    }

    @Test
    public void verifyAddNewApproved() {
        TestReporter.testTitle("Test ID = 41627");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", "test_g.fadeev@magdv.com");
        data.put("password", "gctbVY");
        authorizationPage.verifyAuthFields(data);
        deliveryAddressPage.addAddresses();
    }
}
