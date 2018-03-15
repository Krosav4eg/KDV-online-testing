package KDV_testcases.personalCabinet.Physical;

import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.TestReporter;

import static Core.utils.Constants.*;

public class AccountDataTest extends BaseTest {

    @Test
    public void verifyOpeningPersonalDataItemTest() {
        TestReporter.testTitle("Test ID = 38264,40087,38364,40095");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        authorizationPage.verifyAuthFields(data);
        accountDataPage.verifyAccountInfoVisibility();
        data = accountDataPage.mainAccountInfo();
        data.put("firstName", RandomStringUtils.randomAlphanumeric(45));
        data.put("lastName", RandomStringUtils.randomAlphanumeric(45));
        accountDataPage.verifyEditAccountFields(data);
        accountDataPage.verifyLengthFirstAndLastName();
        data = accountDataPage.mainAccountInfo();
        data.put("firstName", "Аркадий");
        data.put("lastName", "Евдокимов");
        accountDataPage.verifyEditAccountFields(data);
        accountDataPage.verifyUserNameAfterChangingFirstAndLastName();
    }

    @Test
    public void verifyEmailFieldValidationTest() {
        TestReporter.testTitle("Test ID = 40091,40096");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        authorizationPage.verifyAuthFields(data);
        data = accountDataPage.mainAccountInfo();
        data.put("email", AUTHORIZATION_EMAIL);
        accountDataPage.verifyEditAccountFields(data);
        accountDataPage.verifyEmailFieldValidation();
    }

    @Test
    public void verifyConfirmPasswordFieldValidationTest() {
        TestReporter.testTitle("Test ID = 38298,40094,40098");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        authorizationPage.verifyAuthFields(data);
        data = accountDataPage.mainAccountInfo();
        data.put("passwordInEditPage", AUTHORIZATION_PASSWORD);
        accountDataPage.verifyEditAccountFields(data);
        accountDataPage.verifyPasswordFieldValidation();
    }

    @Test
    public void verifyAccountPhoneFieldValidationTest() {
        TestReporter.testTitle("Test ID = 40088,40097");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        authorizationPage.verifyAuthFields(data);
        authorizationPage.navigateToUrl(ACCOUNT_INFORMATION_URL);
        data = accountDataPage.mainAccountInfo();
        data.put("phone", "+77111111111");
        accountDataPage.verifyEditAccountFields(data);
        accountDataPage.verifyPhoneFieldValidation();
    }

    @Test
    public void verifyAccountRequiredFieldsTest() {
        TestReporter.testTitle("Test ID = 38455,38456,38419");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        authorizationPage.verifyAuthFields(data);
        data = accountDataPage.mainAccountInfo();
        data.put("firstName", "");
        data.put("lastName", "");
        data.put("email", "");
        data.put("phone", "");
        data.put("currentPassword", "");
        accountDataPage.verifyEditAccountFields(data);
        accountDataPage.verifyImportantEmptyFieldAdvices();
    }

    @Test
    public void verifyCorrectChangingPasswordTest() {
        TestReporter.testTitle("Test ID = 38451");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", ZUEV_EMAIL);
        data.put("password", ZUEV_PASSWORD);
        authorizationPage.verifyAuthFields(data);
        accountDataPage.changingPassword(ZUEV_PASSWORD, ZUEV_PASSWORD);
    }
}
