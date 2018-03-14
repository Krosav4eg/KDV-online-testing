package KDV_testcases.registration.IndividualEntrepreneur;

import Core.basePage.BasePage;
import Core.utils.TestReporter;
import KDV_testcases.base.BaseTest;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static Core.utils.Constants.KALASHNIKOVA_EMAIL;

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
        verifyData.put("email", "a..shaulo@andersenlab.com");
        registrationPage.inputCorrectEmail(verifyData);
        verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("email", "ulo@andersenlab.com");
        registrationPage.accountWithSuchEmailAlreadyExists(verifyData);
    }

    @Test
    public void verifyMandatoryEmptyTaxIdTest() {
        TestReporter.testTitle("Test ID = 37521,40070,40071");
        JSONObject verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("email", "a.sha#ulo@andersenlab.com");
        registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
        registrationPage.falseCheckForForgotPassword();
        verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("email", "a.sha$ulo@andersenlab.com");
        registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
        registrationPage.falseCheckForForgotPassword();
        verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("email", "a.sha%ulo@andersenlab.com");
        registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
        registrationPage.falseCheckForForgotPassword();
        verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("email", "a.sha^ulo@andersenlab.com");
        registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
        registrationPage.falseCheckForForgotPassword();
        verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("email", "a.sha&ulo@andersenlab.com");
        registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
        registrationPage.falseCheckForForgotPassword();
        verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("email", "a.sha*ulo@andersenlab.com");
        registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
        registrationPage.falseCheckForForgotPassword();
        verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("email", "a.sha()ulo@andersenlab.com");
        registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
        registrationPage.falseCheckForForgotPassword();
        verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("email", "a.sha_ulo@andersenlab.com");
        registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
        registrationPage.falseCheckForForgotPassword();
        verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("email", "a.sha+ulo@andersenlab.com");
        registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
        registrationPage.falseCheckForForgotPassword();
    }

    @Test
    public void verifyMandatoryCorrectPassTest() {
        TestReporter.testTitle("Test ID = 37522");
        JSONObject verifyData = registrationPage.mainInfoRegistration();
        registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
        registrationPage.mandatoryCorrectPass();
    }

    @Test
    public void verifyMandatoryWrongPassTest() {
        TestReporter.testTitle("Test ID = 37523");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("password", "11");
        registrationPage.passwordMustContainMoreSymbols(data);
        data = registrationPage.mainInfoRegistration();
        data.put("password", " 3132 ");
        registrationPage.passwordMustContainMoreSymbols(data);
    }

    @Test
    public void verifyMandatoryEmptyConfirmPasswordTest() {
        TestReporter.testTitle("Test ID = C40075");
        JSONObject verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("pass", "teea");
        verifyData.put("confirmPassword", "tes7676t234   ");
        registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
        registrationPage.verifyPasswordsAreEqual(verifyData);
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
        data.put("email", KALASHNIKOVA_EMAIL);
        registrationPage.accountWithSuchEmailAlreadyExistsWithEqualityCheck(data);
        data = registrationPage.mainInfoRegistration();
        data.put("password", "");
        registrationPage.fieldNecessaryToFillInWithData(data);
        data = registrationPage.mainInfoRegistration();
        data.put("confirmPassword", "");
        registrationPage.fieldNecessaryToFillInWithData(data);
    }
}
