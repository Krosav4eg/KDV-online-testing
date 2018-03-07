package KDV_testcases.OrderingPage;

import Core.basePage.BasePage;
import Core.utils.AssertCollector;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.TestReporter;


public class OrderingPhysicalPageTest extends BaseTest {

    private BasePage.MyDelegate del = new BasePage.MyDelegate() {
    };


    @Test
    public void orderingDefaultAddress() {
        TestReporter.testTitle("Test ID - C41300");
        orderingPhysicalPage.orderingDefaultAddress();
    }

    @Test
    public void orderingNewAddress() {
        TestReporter.testTitle("Test ID - C41314");
        orderingPhysicalPage.orderingNewAddress();
    }

    @Test
    public void orderingChangeAddress() {
        TestReporter.testTitle("Test ID - C41454");
        orderingPhysicalPage.orderingChangedAddress();
    }

    @Test
    public void orderingChangeStoreAddress() {
        TestReporter.testTitle("Test ID - C41313");
        orderingPhysicalPage.orderingChangedStoreAddress();
    }

    @Test
    public void orderingWithRegistrationTest() {
        TestReporter.testTitle("Test ID - C539542");
        JSONObject data = orderingGuestPage.data();
        data.put("firstName", RandomStringUtils.randomAlphabetic(45));
        data.put("lastName", RandomStringUtils.randomAlphabetic(45));
        data.put("email", RandomStringUtils.randomAlphabetic(5) + "@test.ru");
        data.put("phone", RandomStringUtils.randomNumeric(11));
        orderingGuestPage.createOrder(data);
        orderingPhysicalPage.checkPhysicalPersonRadioButton();
        AssertCollector.assertTrue(orderingPhysicalPage.validateForm.getText().contains("Эта учётная запись не " +
                "подтверждена. Нажмите сюда для повторной отсылки письма с кодом подтверждения."));
    }

    @Test
    public void orderingRegistrationWithExistingTest() {
        TestReporter.testTitle("Test ID - C539546");
        JSONObject data = orderingGuestPage.data();
        data.put("firstName", RandomStringUtils.randomAlphabetic(45));
        data.put("lastName", RandomStringUtils.randomAlphabetic(45));
        data.put("email", RandomStringUtils.randomAlphabetic(5) + "@test.ru");
        data.put("phone", "1111111111");
        orderingGuestPage.createOrder(data);
        orderingPhysicalPage.orderingWithSamePhone();
        del.textPresentDelegate("Номер телефона уже используется.");
    }
}
