package KDV_testcases.registration.PhysicalPerson;

import Core.utils.TestReporter;
import KDV_testcases.base.BaseTest;
import org.json.JSONObject;
import org.testng.annotations.Test;


public class AuthorizationInfoTest extends BaseTest {

    @Test
    public void verifyFieldEmailPresenceTest() {
        TestReporter.testTitle("Test ID = 37298");
        registrationPage.verifyFieldEmailPresence();
    }

    @Test
    public void verifyEmailWithoutAtSymbolTest() {
        TestReporter.testTitle("Test ID = 37287");
        registrationPage.verifyEmailWithoutAtSymbol();
    }

    @Test
    public void verifyEmailWithoutDomainNameTest() {
        TestReporter.testTitle("Test ID = 37288");
        registrationPage.verifyEmailWithoutDomainName();
    }

    @Test
    public void verifyEmailWithMoreThanOneDotTest() {
        TestReporter.testTitle("Test ID = 37289");
        registrationPage.verifyEmailWithMoreThanOneDot();
    }

    @Test
    public void verifyEmailWithSpacesBeforeAtSymbolTest() {
        TestReporter.testTitle("Test ID = 37291");
        registrationPage.verifyEmailWithSpacesBeforeAtSymbol();
    }

    @Test
    public void verifyEmailWithSpacesAfterAtSymbolTest() {
        TestReporter.testTitle("Test ID = 37331");
        registrationPage.verifyEmailWithSpacesAfterAtSymbol();
    }

    @Test
    public void verifyFieldPasswordPresenceTest() {
        TestReporter.testTitle("Test ID = 37338");
        registrationPage.verifyFieldPasswordPresence();
    }

    @Test
    public void verifyPasswordLengthLessThanSixSymbolsTest() {
        TestReporter.testTitle("Test ID = 37292");
        registrationPage.verifyPasswordLengthLessThanSixSymbols();
    }

    @Test
    public void verifyPasswordWithOnlySpacesTest() {
        TestReporter.testTitle("Test ID = 37293");
        registrationPage.verifyPasswordWithOnlySpaces();
    }

    @Test
    public void verifyPasswordWithSpacesAtStartAndEndTest() {
        TestReporter.testTitle("Test ID = 37294");
        registrationPage.verifyPasswordWithSpacesAtStartAndEnd();
    }

    @Test
    public void verifyFieldConfirmPasswordPresenceTest() {
        TestReporter.testTitle("Test ID = 37337");
        registrationPage.verifyFieldConfirmPasswordPresence();
    }

    @Test
    public void verifyInputNewPasswordWithoutConfirmationTest() {
        TestReporter.testTitle("Test ID = 37295");
        registrationPage.verifyInputNewPasswordWithoutConfirmation();
    }

    @Test
    public void verifyInputEmailTest() {
        TestReporter.testTitle("Test ID = 37522,37515,37529,37530,37542");
        JSONObject data = registrationPage.mainInfoRegistration();
        registrationPage.verifyInputEmail(data);

    }

    @Test
    public void verifyInputWrongEmailTest() {
        TestReporter.testTitle("Test ID = 37516");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("email", "test@test");
        registrationPage.fieldNecessaryToFillInWithData(data, "Пожалуйста, введите правильный адрес электронной почты");

    }

    @Test
    public void verifyInputWrongPasswordTest() {
        TestReporter.testTitle("Test ID = 37523");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("password", "test");
        registrationPage.fieldNecessaryToFillInWithData(data, "Пожалуйста, введите не менее 6 символов без");
        data.put("password", " test ");
        registrationPage.fieldNecessaryToFillInWithData(data, "Пожалуйста, введите не менее 6 символов без");
    }

    @Test
    public void verifyInputEmptyConfirmPasswordTest() {
        TestReporter.testTitle("Test ID = 37526,37528");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("confirmPassword", "");
        registrationPage.fieldNecessaryToFillInWithData(data, "Это поле обязательно для заполнения.");
        data.put("confirmPassword", "test");
        registrationPage.fieldNecessaryToFillInWithData(data, "Пожалуйста, убедитесь, что ваши пароли совпадают.");


    }

    @Test
    public void verifyRegistrationTest() {
        TestReporter.testTitle("Test ID = 37533,37534,37550");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("company", "");
        registrationPage.fieldNecessaryToFillInWithData(data, "Это поле обязательно для заполнения.");
        data = registrationPage.mainInfoRegistration();
        data.put("taxId", "");
        registrationPage.fieldNecessaryToFillInWithData(data, "Это поле обязательно для заполнения.");
        data = registrationPage.mainInfoRegistration();
        data.put("reasonCode", "");
        registrationPage.fieldNecessaryToFillInWithData(data, "Это поле обязательно для заполнения.");
    }

    @Test
    public void verifyRegistrationAddressTest() {
        TestReporter.testTitle("Test ID = 37554,37556,37557");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("firstName", "");
        registrationPage.fieldNecessaryToFillInWithData(data, "Это поле обязательно для заполнения.");
        data = registrationPage.mainInfoRegistration();
        data.put("lastName", "");
        registrationPage.fieldNecessaryToFillInWithData(data, "Это поле обязательно для заполнения.");
        data = registrationPage.mainInfoRegistration();
        data.put("phone", "");
        registrationPage.fieldNecessaryToFillInWithData(data, "Это поле обязательно для заполнения.");
    }

    @Test
    public void verifyRegistrationAuthorizationTest() {
        TestReporter.testTitle("Test ID = 37558,37559,37560");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("password", "");
        registrationPage.fieldNecessaryToFillInWithData(data, "Это поле обязательно для заполнения.");
        data = registrationPage.mainInfoRegistration();
        data.put("confirmPassword", "");
        registrationPage.fieldNecessaryToFillInWithData(data, "Это поле обязательно для заполнения.");
        data = registrationPage.mainInfoRegistration();
        data.put("email", "");
        registrationPage.fieldNecessaryToFillInWithData(data, "Это поле обязательно для заполнения.");
    }

    @Test
    public void verifyRegistrationExistData() {
        TestReporter.testTitle("Test ID = 37558,37562");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("email", "a.shaulo@andersenlab.com");
        registrationPage.verifyAuthorizationFields(data);
        registrationPage.checkAlertText(data);
        data = registrationPage.mainInfoRegistration();
        data.put("taxId", "1234567891");
        registrationPage.checkAlertText(data);
    }

    @Test
    public void verifyRegistrationForgotPassword() {
        TestReporter.testTitle("Test ID = 37540");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("email", "a.shaulo@andersenlab.com");
        registrationPage.verifyAuthorizationFields(data);
        registrationPage.forgotPassword();
    }

    @Test
    public void verifyFields() {
        TestReporter.testTitle("Test ID = 37542");
        JSONObject data = registrationPage.mainInfoRegistration();
        registrationPage.verifyAuthorizationFields(data);
        registrationPage.verifyFieldsCorrect(data);
    }

    @Test
    public void verifyFieldsEmptyFirstName() {
        TestReporter.testTitle("Test ID = 37542");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("firstName", "");
        registrationPage.fieldNecessaryToFillInWithData(data, "Это поле обязательно для заполнения.");
    }

    @Test
    public void verifySubscriptionCheckboxPresenceTest() {
        TestReporter.testTitle("Test ID = 37352");
        registrationPage.verifySubscriptionCheckboxPresence();
    }

    @Test
    public void verifyWorkOfCheckboxConfirmTest() {
        TestReporter.testTitle("Test ID = 37353");
        registrationPage.verifyWorkOfCheckboxConfirm();
    }

    @Test
    public void verifyCheckboxConfirmPresenceTest() {
        TestReporter.testTitle("Test ID = 37354");
        registrationPage.verifyCheckboxConfirmPresence();
    }
}
