package KDV_testcases.registration.PhysicalPerson;

import Core.basePage.BasePage;
import org.json.JSONObject;
import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.AssertCollector;
import Core.utils.TestReporter;


public class AuthorizationInfoTest extends BaseTest {

    private BasePage.MyDelegate del2 = new BasePage.MyDelegate() {
    };

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
        AssertCollector.assertFalse(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
    }

    @Test
    public void verifyInputWrongEmailTest() {
        TestReporter.testTitle("Test ID = 37516");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("email", "test@test");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Пожалуйста, введите правильный адрес электронной почты"));
    }

    @Test
    public void verifyInputWrongPasswordTest() {
        TestReporter.testTitle("Test ID = 37523");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("password", "test");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Пожалуйста, введите не менее 6 символов без"));
        data.put("password", " test ");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Пожалуйста, введите не менее 6 символов без"));
    }

    @Test
    public void verifyInputEmptyConfirmPasswordTest() {
        TestReporter.testTitle("Test ID = 37526,37528");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("confirmPassword", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
        data.put("confirmPassword", "test");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Пожалуйста, убедитесь, что ваши пароли совпадают."));

    }

    @Test
    public void verifyRegistrationTest() {
        TestReporter.testTitle("Test ID = 37533,37534,37550");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("company", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
        data = registrationPage.mainInfoRegistration();
        data.put("taxId", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
        data = registrationPage.mainInfoRegistration();
        data.put("reasonCode", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
    }

    @Test
    public void verifyRegistrationAddressTest() {
        TestReporter.testTitle("Test ID = 37554,37556,37557");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("firstName", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
        data = registrationPage.mainInfoRegistration();
        data.put("lastName", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
        data = registrationPage.mainInfoRegistration();
        data.put("phone", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
    }

    @Test
    public void verifyRegistrationAuthorizationTest() {
        TestReporter.testTitle("Test ID = 37558,37559,37560");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("password", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
        data = registrationPage.mainInfoRegistration();
        data.put("confirmPassword", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
        data = registrationPage.mainInfoRegistration();
        data.put("email", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
    }

    @Test
    public void verifyRegistrationExistData() {
        TestReporter.testTitle("Test ID = 37558,37562");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("email", "a.shaulo@andersenlab.com");
        registrationPage.verifyAuthorizationFields(data);
        AssertCollector.assertTrue(del2.getTextDelegate(registrationPage.getAlertTet).
                contains("Учётная запись с таким адресом электронной почты уже существует. "));
        data = registrationPage.mainInfoRegistration();
        data.put("taxId", "1234567891");
        System.out.println(del2.getTextDelegate(registrationPage.getAlertTet));
        AssertCollector.assertTrue(del2.getTextDelegate(registrationPage.getAlertTet).
                contains("Учётная запись с таким адресом электронной почты уже существует."));
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
        AssertCollector.assertTrue(del2.getCurrentUrlDelegate().contains("login/"));
    }

    @Test
    public void verifyFieldsEmptyFirstName() {
        TestReporter.testTitle("Test ID = 37542");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("firstName", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
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
