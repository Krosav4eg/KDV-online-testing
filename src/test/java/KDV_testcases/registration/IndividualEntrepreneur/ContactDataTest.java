package KDV_testcases.registration.IndividualEntrepreneur;

import Core.basePage.BasePage;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.AssertCollector;
import Core.utils.TestReporter;

import static KDV_business_logic.pages.PersonalAreaPage.PersonalCabinetPage.phoneInEditPage;

public class ContactDataTest extends BaseTest {
    private BasePage.MyDelegate del = new BasePage.MyDelegate() {
    };

    @Test
    public void verifyIncorrectFirstAndLastValuesTest() {
        TestReporter.testTitle("Test ID = 37618");
        registrationPage.verifyIndividualEntrepreneurRadioButton();
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("firstName", RandomStringUtils.randomNumeric(45));
        data.put("lastName", RandomStringUtils.randomNumeric(45));
        registrationPage.verifyAuthorizationFields(data);
        del.textPresentDelegate("Значение 'Фамилия' не должно быть пустым и может содержать только буквы, тире и апостроф.");
        del.textPresentDelegate("Значение 'Имя' не должно быть пустым и может содержать только буквы, тире и апостроф.");
        data = registrationPage.mainInfoRegistration();
        data.put("firstName", " !@#$%^&*()+_/|{}[]?><.,");
        data.put("lastName", " !@#$%^&*()+_/|{}[]?><.,");
        registrationPage.verifyAuthorizationFields(data);
        del.textPresentDelegate("Значение 'Фамилия' не должно быть пустым и может содержать только буквы, тире и апостроф.");
        del.textPresentDelegate("Значение 'Имя' не должно быть пустым и может содержать только буквы, тире и апостроф.");
    }

    @Test
    public void verifyIncorrectPhoneValuesTest() {
        TestReporter.testTitle("Test ID = 37633,37636");
        registrationPage.verifyIndividualEntrepreneurRadioButton();
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("phone", "@!#$%&*()_+/*");
        registrationPage.verifyAuthorizationFields(data);
        del.textPresentDelegate("Значение \"Телефон\" должно соответствовать формату: +7XXXXXXXXXX");

        data = registrationPage.mainInfoRegistration();
        data.put("phone", RandomStringUtils.randomNumeric(9));
        registrationPage.verifyAuthorizationFields(data);
        del.textPresentDelegate("Значение \"Телефон\" должно соответствовать формату: +7XXXXXXXXXX");
    }

    //not pass due validation in all fields
    @Test
    public void verifyMaximumInputLengthFirstAndLastNameFieldTest() {
        TestReporter.testTitle("Test ID = 40067");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("firstName", RandomStringUtils.randomAlphanumeric(46));
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
        AssertCollector.assertEquals(registrationPage.firstName.getAttribute("value").length(),
                " Number of symbols is equal ", RandomStringUtils.randomAlphabetic(45).length());
        data = registrationPage.mainInfoRegistration();
        data.put("lastName", RandomStringUtils.randomAlphanumeric(46));
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
        AssertCollector.assertEquals(registrationPage.lastName.getAttribute("value").length(),
                " Number of symbols is equal ", RandomStringUtils.randomAlphabetic(45).length());
        data = registrationPage.mainInfoRegistration();
        data.put("firstName", "Анна-Мар'я" + RandomStringUtils.randomAlphanumeric(36));
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
        AssertCollector.assertEquals(registrationPage.firstName.getAttribute("value"),
                " Value of last name is equal ", registrationPage.firstName.getAttribute("value"));
        data = registrationPage.mainInfoRegistration();
        data.put("lastName", "Анна-Мар'я" + RandomStringUtils.randomAlphanumeric(36));
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
        AssertCollector.assertEquals(registrationPage.lastName.getAttribute("value"),
                " Value of last name is equal ", registrationPage.lastName.getAttribute("value"));
    }

    @Test
    public void verifyPhoneFieldValidationTest() {
        TestReporter.testTitle("Test ID = 40068");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("phone", RandomStringUtils.randomAlphanumeric(10));
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения"));
        AssertCollector.assertEquals(phoneInEditPage.getAttribute("value"),
                " Value of email field is equal ", phoneInEditPage.getAttribute("value"));
    }
}
