package KDV_testcases.personalCabinet.Physical;

import Core.basePage.BasePage;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.AssertCollector;
import Core.utils.TestReporter;

import static Core.utils.Constants.KALASHNIKOVA_EMAIL;
import static Core.utils.Constants.KALASHNIKOVA_PASSWORD;

public class AddingAddressTest extends BaseTest {

    BasePage.MyDelegate del = new BasePage.MyDelegate() {
    };

    @Test
    public void verifyFirstAndLastNameValuesTest() {
        TestReporter.testTitle("Test ID = 40099,40107");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", KALASHNIKOVA_EMAIL);
        data.put("password", KALASHNIKOVA_PASSWORD);
        authorizationPage.verifyAuthFields(data);
        data = accountDataPage.addingNewAddressInfo();
        data.put("firstName", RandomStringUtils.randomAlphabetic(45));
        data.put("lastName", RandomStringUtils.randomAlphabetic(45));
        accountDataPage.verifyAddingNewAccountFields(data);
        AssertCollector.verifyCondition(accountDataPage.firstNameInEditPage.getAttribute("value").length() ==
                RandomStringUtils.randomAlphabetic(45).length());
        AssertCollector.verifyCondition(accountDataPage.lastNameInEditPage.getAttribute("value").length() ==
                RandomStringUtils.randomAlphabetic(45).length());
        data = accountDataPage.addingNewAddressInfo();
        data.put("firstName", "Анна-Мар'я");
        data.put("lastName", "Анна-Мар'я");
        accountDataPage.verifyAddingNewAccountFields(data);
        AssertCollector.verifyCondition(accountDataPage.firstNameInEditPage.getAttribute("value") ==
                "Анна-Мар'я");
        AssertCollector.verifyCondition(accountDataPage.lastNameInEditPage.getAttribute("value") ==
                "Анна-Мар'я");
        orderingGuestPage.clickOnWebElement(accountDataPage.saveButtonInEditPage);
        del.textPresentDelegate("Адрес сохранён.");
        del.textPresentDelegate("Анна-Мар'я");
        del.textPresentDelegate("Томск, пр. Мира 20, оф.1");
        del.scrollByCoordinate();
        orderingGuestPage.clickOnWebElement(accountDataPage.deleteNewAddress);
        AssertCollector.verifyCondition(accountDataPage.deletionAddress.isDisplayed());
    }

    @Test
    public void verifyPhoneValueTest() {
        TestReporter.testTitle("Test ID = 40101");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", KALASHNIKOVA_EMAIL);
        data.put("password", KALASHNIKOVA_PASSWORD);
        authorizationPage.verifyAuthFields(data);
        data = accountDataPage.addingNewAddressInfo();
        data.put("phone", RandomStringUtils.randomNumeric(11));
        accountDataPage.verifyAddingNewAccountFields(data);
        AssertCollector.verifyCondition(accountDataPage.firstNameInEditPage.getAttribute("value").length() ==
                RandomStringUtils.randomAlphabetic(11).length());
    }

    @Test
    public void verifyRequiredAddressFieldsTest() {
        TestReporter.testTitle("Test ID = 40104");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", KALASHNIKOVA_EMAIL);
        data.put("password", KALASHNIKOVA_PASSWORD);
        authorizationPage.verifyAuthFields(data);
        data = accountDataPage.addingNewAddressInfo();
        data.put("address", RandomStringUtils.randomAlphabetic(255));
        accountDataPage.verifyAddingNewAccountFields(data);
        AssertCollector.verifyCondition(accountDataPage.firstNameInEditPage.getAttribute("value").length() ==
                RandomStringUtils.randomAlphabetic(255).length());
        accountDataPage.verifyAddressDropDownAddress();
        del.textPresentDelegate("Это поле обязательно для заполнения.");
    }

    @Test
    public void verifyRequiredFieldsTest() {
        TestReporter.testTitle("Test ID = 40108");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", KALASHNIKOVA_EMAIL);
        data.put("password", KALASHNIKOVA_PASSWORD);
        authorizationPage.verifyAuthFields(data);
        data = accountDataPage.addingNewAddressInfo();
        data.put("firstName", "");
        data.put("lastName", "");
        data.put("phone", "");
        data.put("address", "");
        data.put("floor", "");
        data.put("porch", "");
        accountDataPage.verifyAddingNewAccountFields(data);
        orderingGuestPage.clickOnWebElement(accountDataPage.saveButtonInEditPage);
        del.textPresentDelegate("Это поле обязательно для заполнения.");
    }
}
