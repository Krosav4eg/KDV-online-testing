package testcases.personalCabinet;

import Core.basePage.BasePage;
import com.google.common.base.Verify;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.AssertCollector;
import utils.TestReporter;

import static utils.Constants.*;

public class PersonalCabinetTest extends BaseTest {
    BasePage.MyDelegate del = new BasePage.MyDelegate() {
    };

    //test 40087 not pass due validation
    @Test
    public void verifyOpeningPersonalDataItemTest() {
        TestReporter.testTitle("Test ID = 38264,40087,38364,40095");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        authorizationPage.verifyAuthFields(data);
        del.getUrlDelegate(ACCOUNT_INFORMATION_URL);
        AssertCollector.verifyCondition(personalCabinetPage.personalDataHeaderInEditPage.
                isDisplayed());
        AssertCollector.verifyCondition(personalCabinetPage.personalDataInEditPage.
                isDisplayed());
        AssertCollector.verifyCondition(personalCabinetPage.sharingInEditPage.
                isDisplayed());
        data = personalCabinetPage.mainAccountInfo();
        data.put("firstName", RandomStringUtils.randomAlphanumeric(46));
        personalCabinetPage.verifyEditAccountFields(data);
        AssertCollector.assertEquals(personalCabinetPage.firstNameInEditPage.getAttribute("value").length(),
                " Number of symbols is equal ", RandomStringUtils.randomAlphabetic(46).length());
        data = personalCabinetPage.mainAccountInfo();
        data.put("lastName", RandomStringUtils.randomAlphanumeric(46));
        personalCabinetPage.verifyEditAccountFields(data);
        AssertCollector.assertEquals(personalCabinetPage.lastNameInEditPage.getAttribute("value").length(),
                " Number of symbols is equal ", RandomStringUtils.randomAlphabetic(46).length());
        data = personalCabinetPage.mainAccountInfo();
        data.put("firstName", "Анна-Мар'я" + RandomStringUtils.randomAlphabetic(36));
        personalCabinetPage.verifyEditAccountFields(data);
        AssertCollector.assertEquals(personalCabinetPage.firstNameInEditPage.getAttribute("value"),
                " Value of first name is equal ", personalCabinetPage.firstNameInEditPage.
                        getAttribute("value"));
        data = personalCabinetPage.mainAccountInfo();
        data.put("lastName", "Анна-Мар'я" + RandomStringUtils.randomAlphanumeric(36));
        personalCabinetPage.verifyEditAccountFields(data);
        AssertCollector.assertEquals(personalCabinetPage.lastNameInEditPage.getAttribute("value"),
                " Value of last name is equal ", personalCabinetPage.lastNameInEditPage.
                        getAttribute("value"));
        data = personalCabinetPage.mainAccountInfo();
        data.put("firstName", "Аркадий");
        data.put("lastName", "Евдокимов");
        personalCabinetPage.verifyEditAccountFields(data);
        del.scrollToNecessaryElementDelegate(personalCabinetPage.saveButtonInEditPage);
        personalCabinetPage.saveButtonInEditPage.click();
        AssertCollector.assertEqualsJ(del.getCurrentUrlDelegate(), ACCOUNT_PAGE_URL, "Urls are equals");
        AssertCollector.assertTrue(personalCabinetPage.nameInPersonalData.getText().contains("Аркадий Евдокимов"));
    }

    @Test
    public void verifyAccountPhoneFieldValidationTest() {
        TestReporter.testTitle("Test ID = 40088");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        authorizationPage.verifyAuthFields(data);
        del.getUrlDelegate(ACCOUNT_INFORMATION_URL);
        data = personalCabinetPage.mainAccountInfo();
        data.put("phone", RandomStringUtils.randomAlphanumeric(10));
        personalCabinetPage.verifyEditAccountFields(data);
        AssertCollector.assertEquals(personalCabinetPage.phoneInEditPage.getAttribute("value"),
                " Value of phone field is equal ", personalCabinetPage.phoneInEditPage.
                        getAttribute("value"));
    }

    @Test
    public void verifyEmailFieldValidationTest() {
        TestReporter.testTitle("Test ID = 40091");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        authorizationPage.verifyAuthFields(data);
        data = personalCabinetPage.mainAccountInfo();
        data.put("passwordInEditPage", AUTHORIZATION_EMAIL);
        personalCabinetPage.verifyEditAccountFields(data);
        AssertCollector.assertEquals(personalCabinetPage.emailInEditPage.getAttribute("value"),
                " Value of current password field is equal ", personalCabinetPage.emailInEditPage.
                        getAttribute("value"));
    }

    @Test
    public void verifyConfirmPasswordFieldValidationTest() {
        TestReporter.testTitle("Test ID = 40094,40098");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        authorizationPage.verifyAuthFields(data);
        data = personalCabinetPage.mainAccountInfo();
        data.put("passwordInEditPage", AUTHORIZATION_PASSWORD);
        personalCabinetPage.verifyEditAccountFields(data);
        AssertCollector.assertEquals(personalCabinetPage.passwordInEditPage.getAttribute("value"),
                " Value of current password field is equal ", personalCabinetPage.passwordInEditPage.
                        getAttribute("value"));
        del.scrollToNecessaryElementDelegate(personalCabinetPage.saveButtonInEditPage);
        personalCabinetPage.saveButtonInEditPage.click();
        AssertCollector.assertEquals(del.getCurrentUrlDelegate(), "Current url is equals", ACCOUNT_PAGE_URL);
    }

    @Test
    public void verifyAccountRequiredFieldsTest() {
        TestReporter.testTitle("Test ID = 38455,38456");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        authorizationPage.verifyAuthFields(data);
        data = personalCabinetPage.mainAccountInfo();
        data.put("firstName", "");
        data.put("lastName", "");
        data.put("email", "");
        data.put("phone", "");
        data.put("currentPassword", "");
        personalCabinetPage.verifyEditAccountFields(data);
        personalCabinetPage.changePasswordCheckbox.click();
        del.scrollToNecessaryElementDelegate(personalCabinetPage.saveButtonInEditPage);
        personalCabinetPage.saveButtonInEditPage.click();
        del.textPresentDelegate("Это поле обязательно для заполнения");
    }
    @Test
    public void verifyMyOrder()
    {
        TestReporter.testTitle("Test ID = 41792");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email","test_g.fadeev@magdv.com");
        data.put("password","gctbVY");
        authorizationPage.verifyAuthFields(data);
        personalCabinetPage.verifyOrder();
    }

}
