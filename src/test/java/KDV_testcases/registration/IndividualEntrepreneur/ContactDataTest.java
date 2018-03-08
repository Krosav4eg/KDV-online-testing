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

    @Test
    public void verifyIncorrectFirstAndLastValuesTest() {
        TestReporter.testTitle("Test ID = 37618");
        registrationPage.verifyIndividualEntrepreneurRadioButton();
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("firstName", RandomStringUtils.randomNumeric(45));
        data.put("lastName", RandomStringUtils.randomNumeric(45));
        String registration= registrationPage.verifyAuthorizationFields(data);
        AssertCollector.assertTrue(registration.contains("Значение 'Фамилия' не должно быть пустым и может содержать только буквы, " +
                "тире и апостроф."));
        AssertCollector.assertTrue(registration.contains("Значение 'Имя' не должно быть пустым и может содержать только буквы, " +
                "тире и апостроф."));
        data = registrationPage.mainInfoRegistration();
        data.put("firstName", " !@#$%^&*()+_/|{}[]?><.,");
        data.put("lastName", " !@#$%^&*()+_/|{}[]?><.,");
        registration= registrationPage.verifyAuthorizationFields(data);
        AssertCollector.assertTrue(registration.contains("Значение 'Фамилия' не должно быть пустым и может содержать только буквы, " +
                "тире и апостроф."));
        AssertCollector.assertTrue(registration.contains("Значение 'Имя' не должно быть пустым и может содержать только буквы, " +
                "тире и апостроф."));
    }

    @Test
    public void verifyIncorrectPhoneValuesTest() {
        TestReporter.testTitle("Test ID = 37633,37636");
        registrationPage.verifyIndividualEntrepreneurRadioButton();
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("phone", "@!#$%&*()_+/*");
        String registration=registrationPage.verifyAuthorizationFields(data);
        AssertCollector.assertTrue(registration.contains("Это поле обязательно для заполнения"));
        data = registrationPage.mainInfoRegistration();
        data.put("phone", "8997");
        registration=registrationPage.verifyAuthorizationFields(data);
        AssertCollector.assertTrue(registration.contains("Значение \"Телефон\" должно соответствовать формату: +7XXXXXXXXXX"));
    }

    //была убрана проверка длинны ввода строк, т.к. у нас появилось валидационное сообщение по превышению ввода символов
    //BUG 143 при воде в поля имя/фамилия значениия Анна-Мар'я появляетя сообщение что поле не может быть пустым
    @Test
    public void verifyMaximumInputLengthFirstAndLastNameFieldTest() {
        TestReporter.testTitle("Test ID = 40067");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("firstName", "Анна-Мар'я" + RandomStringUtils.randomAlphanumeric(36));
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Значение \"Имя\" не должно превышать 45 символов."));
        AssertCollector.assertEquals(registrationPage.firstName.getAttribute("value"),
                " Value of last name is equal ", registrationPage.firstName.getAttribute("value"));
        data = registrationPage.mainInfoRegistration();
        data.put("lastName", "Анна-Мар'я" + RandomStringUtils.randomAlphanumeric(36));
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Значение \"Фамилия\" не должно превышать 45 символов."));
        AssertCollector.assertEquals(registrationPage.lastName.getAttribute("value"),
                " Value of last name is equal ", registrationPage.lastName.getAttribute("value"));
    }

    @Test
    public void verifyPhoneFieldValidationTest() {
        TestReporter.testTitle("Test ID = 40068");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("phone", "2121");
        String text = registrationPage.verifyAuthorizationFields(data);
        AssertCollector.assertTrue(text.
                contains("Значение \"Телефон\" должно соответствовать формату: +7XXXXXXXXXX"));
    }
}
