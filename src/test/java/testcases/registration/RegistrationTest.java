package testcases.registration;

import org.json.JSONObject;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.AssertCollector;
import utils.TestReporter;

public class RegistrationTest extends BaseTest {

    @Test
    public void verifyLegalFormByDefaultTest() {
        TestReporter.testTitle("Test ID = 37076");
        registrationPage.verifyLegalFormByDefault();
    }

    @Test
    public void verifyChoosingLegalFormTest() {
        TestReporter.testTitle("Test ID = 37077");
        registrationPage.verifyChoosingLegalForm();
    }

    @Test
    public void verifyForOrganizationsTextPresenceTest() {
        TestReporter.testTitle("Test ID = 37715");
        registrationPage.verifyForOrganizationsTextPresence();
    }

    @Test
    public void verifyFieldFirstNamePresenceTest() {
        TestReporter.testTitle("Test ID = 37097");
        registrationPage.verifyFieldFirstNamePresence();
    }

    @Test
    public void verifyInputInFirstNameFieldTest() {
        TestReporter.testTitle("Test ID = 37098");
        registrationPage.verifyInputInFirstNameField();
    }

    @Test
    public void verifyMaximumInputInFirstNameFieldTest() {
        TestReporter.testTitle("Test ID = 37103");
        registrationPage.verifyMaximumInputInFirstNameField();
    }

    @Test
    public void verifyInputNumbersInFirstNameFieldTest() {
        TestReporter.testTitle("Test ID = 37104");
        registrationPage.verifyInputNumbersInFirstNameField();
    }

    @Test
    public void verifyInputForbiddenSymbolsInFirstNameFieldTest() {
        TestReporter.testTitle("Test ID = 37105");
        registrationPage.verifyInputForbiddenSymbolsInFirstNameField();
    }

    @Test
    public void verifyInputSpecialSymbolsInFirstNameFieldTest() {
        TestReporter.testTitle("Test ID = 37106");
        registrationPage.verifyInputSpecialSymbolsInFirstNameField();
    }

    @Test
    public void verifyFieldLastNamePresenceTest() {
        TestReporter.testTitle("Test ID = 37113");
        registrationPage.verifyFieldLastNamePresence();
    }

    @Test
    public void verifyInputInLastNameFieldTest() {
        TestReporter.testTitle("Test ID = 37114");
        registrationPage.verifyInputInLastNameField();
    }

    @Test
    public void verifyMaximumInputInLastNameFieldTest() {
        TestReporter.testTitle("Test ID = 37115");
        registrationPage.verifyMaximumInputInLastNameField();
    }

    @Test
    public void verifyInputNumbersInLastNameFieldTest() {
        TestReporter.testTitle("Test ID = 37117");
        registrationPage.verifyInputNumbersInLastNameField();
    }

    @Test
    public void verifyInputForbiddenSymbolsInLastNameFieldTest() {
        TestReporter.testTitle("Test ID = 37118");
        registrationPage.verifyInputForbiddenSymbolsInLastNameField();
    }

    @Test
    public void verifyInputSpecialSymbolsInLastNameFieldTest() {
        TestReporter.testTitle("Test ID = 37119");
        registrationPage.verifyInputSpecialSymbolsInLastNameField();
    }

    @Test
    public void verifyFieldPhonePresenceTest() {
        TestReporter.testTitle("Test ID = 37278");
        registrationPage.verifyFieldPhonePresence();
    }

    @Test
    public void verifyMaskInPhoneFieldTest() {
        TestReporter.testTitle("Test ID = 37282");
        registrationPage.verifyMaskInPhoneField();
    }

    @Test
    public void verifyMaximumInputInPhoneFieldTest() {
        TestReporter.testTitle("Test ID = 37279");
        registrationPage.verifyMaximumInputInPhoneField();
    }

    @Test
    public void verifyInputForbiddenSymbolsInPhoneFieldTest() {
        TestReporter.testTitle("Test ID = 37281");
        registrationPage.verifyInputForbiddenSymbolsInPhoneField();
    }

    @Test
    public void verifyInputLettersInPhoneFieldTest() {
        TestReporter.testTitle("Test ID = 37283");
        registrationPage.verifyInputLettersInPhoneField();
    }

    @Test
    public void verifyInputSpacesInPhoneFieldTest() {
        TestReporter.testTitle("Test ID = 37285");
        registrationPage.verifyInputSpacesInPhoneField();
    }

    @Test
    public void verifyInputLessThenTenNumbersInPhoneFieldTest() {
        TestReporter.testTitle("Test ID = 37286");
        registrationPage.verifyInputLessThenTenNumbersInPhoneField();
    }

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
        TestReporter.testTitle("Test ID = 37522,37515,37522");
        JSONObject data= registrationPage.infoAuthorization();
        AssertCollector.assertTrue(!registrationPage.verifyAuthorizationInformation(data).contains("Это поле обязательно для заполнения."));
    }
    @Test
    public void verifyInputWrongEmailTest() {
        TestReporter.testTitle("Test ID = 37516");
        JSONObject data= registrationPage.infoAuthorization();
        data.put("email","test@test");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationInformation(data).contains("Пожалуйста, введите правильный адрес электронной почты"));
    }
    @Test
    public void verifyInputEmptyPasswordTest() {
        TestReporter.testTitle("Test ID = 37523");
        JSONObject data= registrationPage.infoAuthorization();
        data.put("password","");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationInformation(data).contains("Это поле обязательно для заполнения."));
        data.put("password","test");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationInformation(data).contains("Пожалуйста, введите не менее 6 символов без"));
    }
    @Test
    public void verifyInputSpacePasswordTest() {
        TestReporter.testTitle("Test ID = 37526");
        JSONObject data= registrationPage.infoAuthorization();
        data.put("password"," test ");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationInformation(data).contains("Это поле обязательно для заполнения."));
    }
    @Test
    public void verifyInputEmptyConfirmPasswordTest() {
        TestReporter.testTitle("Test ID = 37526");
        JSONObject data= registrationPage.infoAuthorization();
        data.put("confirmPassword","");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationInformation(data).contains("Это поле обязательно для заполнения."));
    }
    @Test
    public void verifyInputWrongConfirmPasswordTest() {
        TestReporter.testTitle("Test ID = 37528");
        JSONObject data= registrationPage.infoAuthorization();
        data.put("confirmPassword","test");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationInformation(data).contains("Это поле обязательно для заполнения."));
    }
    @Test
    public void verifyFields()
    {
        TestReporter.testTitle("Test ID = 37542");
        JSONObject dataAuthorization= registrationPage.infoAuthorization();
        AssertCollector.assertTrue(!registrationPage.verifyAuthorizationInformation(dataAuthorization).contains("Это поле обязательно для заполнения."));
        JSONObject data= registrationPage.mainInfoRegistration();
        AssertCollector.assertTrue(!registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));
    }
    @Test
    public void verifyFieldsEmptyFirstName()
    {
        TestReporter.testTitle("Test ID = 37542");
        JSONObject dataAuthorization= registrationPage.infoAuthorization();
        AssertCollector.assertTrue(!registrationPage.verifyAuthorizationInformation(dataAuthorization).contains("Это поле обязательно для заполнения."));
        JSONObject data= registrationPage.mainInfoRegistration();
        data.put("firstName","");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));
    }
}

