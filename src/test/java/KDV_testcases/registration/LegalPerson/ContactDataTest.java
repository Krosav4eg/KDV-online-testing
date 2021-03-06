package KDV_testcases.registration.LegalPerson;

import Core.utils.TestReporter;
import KDV_testcases.base.BaseTest;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class ContactDataTest extends BaseTest {

    @Test
    public void verifyMandatoryEmptyFirstNameTest() {
        TestReporter.testTitle("Test ID = C37688,40272,40275");
        JSONObject verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("firstName", "");
        registrationPage.mandatoryFieldForIndividualFillIn(verifyData, "Это поле обязательно для заполнения.");
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
        personalCabinetPage.verifyLengthOfPhone();
        data = registrationPage.mainInfoRegistration();
        data.put("phone", "  ");
        registrationPage.verifyAuthorizationFieldsIndividual(data);
        personalCabinetPage.verifyPhoneIsEmpty();
        data = registrationPage.mainInfoRegistration();
        data.put("phone", "@!#$%&*()_+/*");
        registrationPage.verifyAuthorizationFieldsIndividual(data);
        personalCabinetPage.verifyPhoneIsEmpty();
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
        registrationPage.mandatoryFieldForIndividualFillIn(data, "Значение \"Телефон\" должно соответствовать формату: +7XXXXXXXXXX");
    }
}
