package KDV_testcases.registration.IndividualEntrepreneur;

import Core.basePage.BasePage;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.AssertCollector;
import Core.utils.TestReporter;

public class InformationAuthorizationTest extends BaseTest {

    private BasePage.MyDelegate del = new BasePage.MyDelegate() {
    };

    //изменилась логика работы приложения. после ввода "email", "ulo@andersenlab.com".
    // выполняется переход на другую страницу и появляется текст:
    // "Требуется подтверждение учётной записи.
    // Ссылка ддя подтверждения была выслана на указанный адрес электронной почты. Чтобы выслатиь ссылку повторно нажмите"
    @Test
    public void verifyCorrectMailTest() {
        TestReporter.testTitle("Test ID = 37516");
        JSONObject verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("email", "a.shaulo@andersenlabcom");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFieldsIndividual(verifyData).
                contains("Пожалуйста, введите правильный адрес электронной почты (email)"));
        verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("email", "a..shaulo@andersenlab.com");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFieldsIndividual(verifyData).
                contains("Пожалуйста, введите правильный адрес электронной почты (email)"));
        verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("email", "ulo@andersenlab.com");
        registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
        del.textPresentDelegate("Требуется подтверждение учётной записи. Ссылка ддя подтверждения " +
                "была выслана на указанный адрес электронной почты. Чтобы выслатиь ссылку повторно нажмите");
//        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFieldsIndividual(verifyData).
//                contains("Учётная запись с таким адресом электронной почты уже существует"));
    }

    @Test
    public void verifyMandatoryEmptyTaxIdTest() {
        TestReporter.testTitle("Test ID = 37521,40070,40071");
        JSONObject verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("email", "a.sha#ulo@andersenlab.com");
        registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
        AssertCollector.assertFalse(del.getCurrentUrlDelegate().contains("account/forgotpassword/"));
        verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("email", "a.sha$ulo@andersenlab.com");
        registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
        AssertCollector.assertFalse(del.getCurrentUrlDelegate().contains("account/forgotpassword/"));
        verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("email", "a.sha%ulo@andersenlab.com");
        registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
        AssertCollector.assertFalse(del.getCurrentUrlDelegate().contains("account/forgotpassword/"));
        verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("email", "a.sha^ulo@andersenlab.com");
        registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
        AssertCollector.assertFalse(del.getCurrentUrlDelegate().contains("account/forgotpassword/"));
        verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("email", "a.sha&ulo@andersenlab.com");
        registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
        AssertCollector.assertFalse(del.getCurrentUrlDelegate().contains("account/forgotpassword/"));
        verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("email", "a.sha*ulo@andersenlab.com");
        registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
        AssertCollector.assertFalse(del.getCurrentUrlDelegate().contains("account/forgotpassword/"));
        verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("email", "a.sha()ulo@andersenlab.com");
        registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
        AssertCollector.assertFalse(del.getCurrentUrlDelegate().contains("account/forgotpassword/"));
        verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("email", "a.sha_ulo@andersenlab.com");
        registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
        AssertCollector.assertFalse(del.getCurrentUrlDelegate().contains("account/forgotpassword/"));
        verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("email", "a.sha+ulo@andersenlab.com");
        registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
        AssertCollector.assertFalse(del.getCurrentUrlDelegate().contains("account/forgotpassword/"));
    }

    @Test
    public void verifyMandatoryCorrectPassTest() {
        TestReporter.testTitle("Test ID = 37522");
        JSONObject verifyData = registrationPage.mainInfoRegistration();
        registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
        AssertCollector.assertTrue(del.getCurrentUrlDelegate().contains("customer/account/login/"));
    }

    @Test
    public void verifyMandatoryWrongPassTest() {
        TestReporter.testTitle("Test ID = 37523");
        JSONObject verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("pass", "131");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFieldsIndividual(verifyData).
                contains("Пожалуйста, введите не менее 6 символов без пробелов в конце и в начале."));
        verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("pass", "131 123");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFieldsIndividual(verifyData).
                contains("Пожалуйста, введите не менее 6 символов без пробелов в конце и в начале."));
    }

    @Test
    public void verifyMandatoryEmptyConfirmPasswordTest() {
        TestReporter.testTitle("Test ID = C40075");
        JSONObject verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("pass", "testsea");
        verifyData.put("confirmPassword", "test234   ");
        registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFieldsIndividual(verifyData).
                contains("Пожалуйста, убедитесь, что ваши пароли совпадают."));
    }

    //изменилась логика работы приложения. после ввода "email", "test@test.com".
    // теперь появляется текст:
    // "Учётная запись с таким адресом электронной почты уже существует." +
    //                " Если вы уверены, что это ваш адрес, то нажмите нажмите сюда для получения пароля на email. " +
    //                "С ним вы сможете получить доступ к вашей учётной записи.");
    @Test
    public void verifyEmailFieldValidationTest() {
        TestReporter.testTitle("Test ID = 40069,40072,40074,40076,40077");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("email", "test@test.com");
//        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
//                contains("Учётная запись с таким адресом электронной почты уже существует."));
        registrationPage.verifyAuthorizationFieldsIndividual(data);
        del.textPresentDelegate("Учётная запись с таким адресом электронной почты уже существует." +
                " Если вы уверены, что это ваш адрес, то нажмите нажмите сюда для получения пароля на email. " +
                "С ним вы сможете получить доступ к вашей учётной записи.");
        AssertCollector.assertEquals(registrationPage.email.getAttribute("value"),
                " Value of email field is equal ", registrationPage.email.getAttribute("value"));
        data = registrationPage.mainInfoRegistration();
        data.put("password", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
        data = registrationPage.mainInfoRegistration();
        data.put("confirmPassword", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
    }
}
