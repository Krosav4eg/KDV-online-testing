package KDV_testcases.OrderingPage;

import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.AssertCollector;
import Core.utils.TestReporter;

public class OrderingGuestPageTest extends BaseTest {

    @Test
    public void verifyAuthorizationLinkTest() {
        TestReporter.testTitle("Test ID - C41075");
        JSONObject data = orderingGuestPage.data();
        orderingGuestPage.createOrder(data);
        orderingGuestPage.verifyAuthorizationLInk();
    }

    @Test
    public void verifyAuthModalWindowTest() {
        TestReporter.testTitle("Test ID - C41076");
        JSONObject data = orderingGuestPage.data();
        orderingGuestPage.createOrder(data);
        orderingGuestPage.selectAuthorizationLink();
        JSONObject data2 = orderingGuestPage.authModalFormData();
        data2.put("email", "");
        data2.put("password", "YZde8m");
        orderingGuestPage.authorizationBlockModalWindow(data2);
        orderingGuestPage.authorizationBlockModalWindowError();
        orderingGuestPage.closeAuthorizationLink();
        data2 = orderingGuestPage.authModalFormData();
        data2.put("email", "test_s.zuevmagdv.com");
        data2.put("password", "YZde8m");
        orderingGuestPage.authorizationBlockModalWindow(data2);
    }

    //problem with validation length and validation message in first name and last name fields
    @Test
    public void verifyCheckAndInputValueTest() {
        TestReporter.testTitle("Test ID - C41062,40067,41064");
        JSONObject data = orderingGuestPage.data();
        orderingGuestPage.createOrder(data);
        data.put("firstName", "Анна-Мар'я" + RandomStringUtils.randomAlphabetic(35));
        data.put("lastName", "Анна-Мар'я" + RandomStringUtils.randomAlphabetic(35));
        orderingGuestPage.identificationBlock(data);
        orderingGuestPage.verifyCheckAndInputValue(data);
    }

    @Test
    public void verifyCheckBoxTest() {
        TestReporter.testTitle("Test ID - C41069");
        JSONObject data = orderingGuestPage.data();
        orderingGuestPage.createOrder(data);
        orderingGuestPage.checkReglament();
    }

    //validation fail. address input value has more than 255 symbols
    @Test(enabled = false)
    public void verifyCourierDeliveryTest() {
        TestReporter.testTitle("Test ID - C41072,41070");
        JSONObject data = orderingGuestPage.data();
        orderingGuestPage.createOrder(data);
        AssertCollector.verifyCondition(orderingGuestPage.courierDeliveryRadioButton.isEnabled());
        AssertCollector.assertTrue(orderingGuestPage.deliveryAddressField.getAttribute("placeholder").
                contains("Томск, пр. Мира 20, оф.4"));
        data = orderingGuestPage.deliveryFormData();
        data.put("address", "Томск, пр. Мира 20, оф.4");
        data.put("comment", RandomStringUtils.randomAlphabetic(255));
        orderingGuestPage.deliveryFormInfo(data);
        orderingGuestPage.verifyingCommentFieldLength();
    }

    @Test
    public void verifyCompositionOrderTest() {
        TestReporter.testTitle("Test ID - C41073");
        JSONObject data = orderingGuestPage.data();
        orderingGuestPage.createOrder(data);
        orderingGuestPage.verifyCompositionOrder();
    }

    @Test
    public void verifyCreationOrderTest() {
        TestReporter.testTitle("Test ID - C41074");
        JSONObject data = orderingGuestPage.data();
        orderingGuestPage.createOrder(data);
        orderingGuestPage.orderingSelfGet(data);
    }

    //maximum length 46 symbols validation problem in delivery comment field
    @Test
    public void verifyCreationOrderAsGuestTest() {
        TestReporter.testTitle("Test ID - C41077");
        JSONObject data = orderingGuestPage.data();
        orderingGuestPage.createOrder(data);
        data.put("firstName", RandomStringUtils.randomAlphabetic(46));
        data.put("lastName", RandomStringUtils.randomAlphabetic(46));
        orderingGuestPage.verifypayBankCardRadioButton();
        data = orderingGuestPage.deliveryFormData();
        orderingGuestPage.deliveryFormInfo(data);
        orderingGuestPage.enabledSelfDeliveryButton();
    }

    @Test
    public void verifyEmptyFirstAndLastNameTest() {
        TestReporter.testTitle("Test ID - C41078-40079");
        JSONObject data = orderingGuestPage.data();
        data.put("firstName", "");
        data.put("lastName", "");
        orderingGuestPage.createOrder(data);
        data = orderingGuestPage.deliveryFormData();
        orderingGuestPage.deliveryFormInfo(data);
        orderingGuestPage.verifyingEmptyField();
    }

    @Test
    public void verifyEmptyEmailFieldTest() {
        TestReporter.testTitle("Test ID - C41080");
        JSONObject data = orderingGuestPage.data();
        data.put("firstName", RandomStringUtils.randomAlphabetic(46));
        data.put("lastName", RandomStringUtils.randomAlphabetic(46));
        data.put("email", "");
        orderingGuestPage.createOrder(data);
        data = orderingGuestPage.deliveryFormData();
        orderingGuestPage.deliveryFormInfo(data);
        orderingGuestPage.verifyingEmailEmptyField();
        data = orderingGuestPage.data();
        data.put("email", "a.shauloandersenlab.com");
        orderingGuestPage.identificationBlockWrong(data);
        orderingGuestPage.verifyingEmailEmptyField(data);
        data = orderingGuestPage.data();
        data.put("email", "a.shaulo@andersenlabcom");
        orderingGuestPage.identificationBlockWrong(data);
        orderingGuestPage.verifyingEmailEmptyField(data);
        data = orderingGuestPage.data();
        data.put("email", "a..shaulo@andersenlab.com");
        orderingGuestPage.identificationBlockWrong(data);
        orderingGuestPage.verifyingEmailEmptyField(data);
        data = orderingGuestPage.data();
        data.put("email", "a.s ha ulo@andersenlab.com");
        orderingGuestPage.identificationBlockWrong(data);
        orderingGuestPage.verifyingEmailEmptyField(data);
        data = orderingGuestPage.data();
        data.put("email", "a.shaulo@anders enlab.com");
        orderingGuestPage.identificationBlockWrong(data);
        orderingGuestPage.verifyingEmailEmptyField(data);
    }

    @Test
    public void verifyEmptyPhoneAndAddressFieldsTest() {
        TestReporter.testTitle("Test ID - C41081-41082");
        JSONObject data = orderingGuestPage.data();
        data.put("firstName", RandomStringUtils.randomAlphabetic(46));
        data.put("lastName", RandomStringUtils.randomAlphabetic(46));
        data.put("email", "test@test.ru");
        data.put("phone", "");
        orderingGuestPage.createOrder(data);
        data = orderingGuestPage.deliveryFormData();
        data.put("address", "");
        orderingGuestPage.deliveryFormInfo(data);
        orderingGuestPage.verifyPhoneAndAddressEmptyField();
        data = orderingGuestPage.data();
        data.put("phone", RandomStringUtils.randomNumeric(9));
        orderingGuestPage.identificationBlock(data);
        data = orderingGuestPage.deliveryFormData();
        data.put("address", "Томск, пр. Мира 20, оф.4");
        orderingGuestPage.deliveryFormInfo(data);
        orderingGuestPage.clickCheckBoxAndOrderButton();
    }
}
