package KDV_testcases.registration.IndividualEntrepreneur;

import Core.utils.TestReporter;
import KDV_testcases.base.BaseTest;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class ContactDataTest extends BaseTest {

    @Test
    public void verifyIncorrectFirstAndLastValuesTest() {
        TestReporter.testTitle("Test ID = 37618");
        registrationPage.verifyIndividualEntrepreneurRadioButton();
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("firstName", RandomStringUtils.randomNumeric(45));
        data.put("lastName", RandomStringUtils.randomNumeric(45));
        registrationPage.valueForFirstAndLastNameMustPresent(data);
        data = registrationPage.mainInfoRegistration();
        data.put("firstName", " !@#$%^&*()+_/|{}[]?><.,");
        data.put("lastName", " !@#$%^&*()+_/|{}[]?><.,");
        registrationPage.valueForFirstAndLastNameMustPresent(data);
    }

    @Test
    public void verifyIncorrectPhoneValuesTest() {
        TestReporter.testTitle("Test ID = 37633,37636");
        registrationPage.verifyIndividualEntrepreneurRadioButton();
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("phone", "@!#$%&*()_+/*");
        registrationPage.fieldNecessaryToFillInWithData(data);
        data = registrationPage.mainInfoRegistration();
        data.put("phone", "8997");
        registrationPage.phoneValueMustMatchFormat(data);
    }

    //была убрана проверка длинны ввода строк, т.к. у нас появилось валидационное сообщение по превышению ввода символов
    //BUG 143 при воде в поля имя/фамилия значениия Анна-Мар'я появляетя сообщение что поле не может быть пустым
    @Test
    public void verifyMaximumInputLengthFirstAndLastNameFieldTest() {
        TestReporter.testTitle("Test ID = 40067");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("firstName", "Анна-Мар'я" + RandomStringUtils.randomAlphanumeric(36));
        registrationPage.checkFirstNameLessThan45Symbols(data);
        data = registrationPage.mainInfoRegistration();
        data.put("lastName", "Анна-Мар'я" + RandomStringUtils.randomAlphanumeric(36));
        registrationPage.checkLastNameLessThan45Symbols(data);
    }

    @Test
    public void verifyPhoneFieldValidationTest() {
        TestReporter.testTitle("Test ID = 40068");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("phone", "2121");
        registrationPage.phoneValueMustMatchFormat(data);
    }
}
