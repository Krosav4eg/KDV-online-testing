package KDV_testcases.OrderingPage;

import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.TestReporter;

import static Core.utils.Constants.*;


public class OrderingLegalPageTest extends BaseTest {

    //Периодически возникает баг с кнопкой "Оформить заказ" на странице "Оформление заказа". Выдаёт 404 ошибку
    @Test(enabled = false)
    public void verifyCreateOrderWithDefaultAddressTest() {
        TestReporter.testTitle("Test ID = 41799");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", FADEEV_EMAIL);
        data.put("password", FADEEV_PASSWORD);
        JSONObject data1 = orderingLegalPage.dataSecond();
        authorizationPage.verifyAuthFields(data);
        orderingLegalPage.createOrderForLegalPerson();
        orderingLegalPage.verifyCreateOrder(data1);

    }

    //TODO Добавить задержку тест не успевает отрабатывать
    @Test
    public void verifyCreateOrderWithChangingAddressTest() {
        TestReporter.testTitle("Test ID = 41801");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", FADEEV_EMAIL);
        data.put("password", FADEEV_PASSWORD);
        authorizationPage.verifyAuthFields(data);
        orderingLegalPage.createOrderForLegalPerson();
        JSONObject data1 = orderingLegalPage.dataFirst();
        orderingLegalPage.verifyCreateOrder(data1);
    }
    //BUG 143 Периодически возникает баг с кнопкой "Оформить заказ" на странице "Оформление заказа". Выдаёт 404 ошибку
    @Test(enabled = false)
    public void verifyCreateOrderWithThirdAddressTest() {
        TestReporter.testTitle("Test ID = 41826");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", FADEEV_EMAIL);
        data.put("password", FADEEV_PASSWORD);
        authorizationPage.verifyAuthFields(data);
        orderingLegalPage.createOrderForLegalPerson();
        JSONObject data1 = orderingLegalPage.data();
        orderingLegalPage.verifyCreateOrder(data1);
    }

    //BUG 143 Периодически возникает баг с кнопкой "Оформить заказ" на странице "Оформление заказа". Выдаёт 404 ошибку
    @Test
    public void verifyCreateOrderWithoutLastNadFirstNameFields() {
        TestReporter.testTitle("Test ID = 42013");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", FADEEV_EMAIL);
        data.put("password", FADEEV_PASSWORD);
        authorizationPage.verifyAuthFields(data);
        orderingLegalPage.createOrderForLegalPerson();
        JSONObject data1 = orderingLegalPage.data();
        data1.put("firstName", "");
        data1.put("lastName", "");
        data1.put("phone", "");
        orderingLegalPage.deliveryAddressBlock(data1);
        orderingLegalPage.verifyPhoneFieldAdvice();
        orderingGuestPage.clickOnWebElement(orderingGuestPage.createOrderButton);
        orderingGuestPage.verifyingEmptyField();

        JSONObject data2 = orderingLegalPage.data();
        data2.put("firstName", RandomStringUtils.randomAlphabetic(45));
        data2.put("lastName", RandomStringUtils.randomAlphabetic(45));
        data2.put("phone", "7111111");
        orderingLegalPage.deliveryAddressBlock(data2);
        orderingLegalPage.verifyPhoneFieldAdvice();
    }
}
