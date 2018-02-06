package testcases.registration.individualEntrepreneur;

import Core.basePage.BasePage;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;

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
}
