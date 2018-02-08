package testcases.registration.LegalPerson;

import Core.basePage.BasePage;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.AssertCollector;
import utils.TestReporter;

public class ContactDataTest extends BaseTest {

    private BasePage.MyDelegate del = new BasePage.MyDelegate() {
    };

    @Test
    public void verifyMandatoryEmptyFirstNameTest() {
        TestReporter.testTitle("Test ID = C37688,40272,40275");
        JSONObject verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("firstName", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFieldsIndividual(verifyData).
                contains("Это поле обязательно для заполнения."));
    }

    @Test
    public void verifyPhoneIncorrectValueTest() {
        TestReporter.testTitle("Test ID = 40276,40273,40274");
        JSONObject data = registrationPage.mainInfoRegistration();
        String pass = RandomStringUtils.randomAlphabetic(10);
        data.put("email", RandomStringUtils.randomAlphabetic(10) + "@test.com");
        data.put("password", pass);
        data.put("confirmPassword", pass);
        data.put("organizationName", "");
        data.put("taxId", "");
        data.put("reasonCode", "");
        data.put("legalAddress", "");
        data.put("company", "");
        data.put("address", "");
        data.put("comments", "");
        data.put("firstName", RandomStringUtils.randomAlphabetic(10));
        data.put("lastName", RandomStringUtils.randomAlphabetic(10));
        data.put("phone", RandomStringUtils.randomNumeric(11));
        registrationPage.verifyAuthorizationFieldsIndividual(data);
        AssertCollector.verifyCondition(registrationPage.phone.getAttribute("value").length() ==
                RandomStringUtils.randomAlphabetic(11).length());
        data = registrationPage.mainInfoRegistration();
        data.put("phone", "  ");
        registrationPage.verifyAuthorizationFieldsIndividual(data);
        AssertCollector.verifyCondition(registrationPage.phone.getText().isEmpty());
        data = registrationPage.mainInfoRegistration();
        data.put("phone", "@!#$%&*()_+/*");
        registrationPage.verifyAuthorizationFieldsIndividual(data);
        AssertCollector.verifyCondition(registrationPage.phone.getText().isEmpty());
        data = new JSONObject();
        data.put("email", RandomStringUtils.randomAlphabetic(10) + "@test.com");
        data.put("password", pass);
        data.put("confirmPassword", pass);
        data.put("organizationName", "ТЕСТ");
        data.put("taxId", RandomStringUtils.randomNumeric(12));
        data.put("reasonCode", RandomStringUtils.randomNumeric(9));
        data.put("legalAddress", RandomStringUtils.randomAlphabetic(20));
        data.put("company", "ТЕСТ");
        data.put("address", RandomStringUtils.randomAlphabetic(20));
        data.put("comments", RandomStringUtils.randomAlphabetic(20));
        data.put("firstName", RandomStringUtils.randomAlphabetic(20));
        data.put("lastName", RandomStringUtils.randomAlphabetic(20));
        data.put("phone", RandomStringUtils.randomNumeric(9));
        registrationPage.verifyAuthorizationFieldsIndividual(data);
        del.textPresentDelegate("Значение \"Телефон\" должно соответствовать формату: +7XXXXXXXXXX");
    }
}
