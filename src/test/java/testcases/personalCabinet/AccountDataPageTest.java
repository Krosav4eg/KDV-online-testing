package testcases.personalCabinet;

import Core.basePage.BasePage;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.AssertCollector;
import utils.TestReporter;

import static utils.Constants.*;

public class AccountDataPageTest extends BaseTest {
    BasePage.MyDelegate del = new BasePage.MyDelegate() {
    };

    //test 40087 not pass due validation
    @Test
    public void verifyOpeningPersonalDataItemTest() {
        TestReporter.testTitle("Test ID = 38264,40087,38364,40095");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        authorizationPage.verifyAuthFields(data);
        del.getUrlDelegate(ACCOUNT_INFORMATION_URL);
        AssertCollector.assertTrue(accountDataPage.personalDataHeaderInEditPage.
                isDisplayed(), "Required header is displayed");
        AssertCollector.assertTrue(accountDataPage.personalDataInEditPage.
                isDisplayed(), "Required header is displayed");
        AssertCollector.assertTrue(accountDataPage.sharingInEditPage.
                isDisplayed(), "Required header is displayed");

        data = accountDataPage.mainAccountInfo();
        data.put("firstName", RandomStringUtils.randomAlphanumeric(46));
        accountDataPage.verifyEditAccountFields(data);
        AssertCollector.assertEquals(accountDataPage.firstNameInEditPage.getAttribute("value").length(),
                " Number of symbols is equal ", RandomStringUtils.randomAlphabetic(45).length());

        data = accountDataPage.mainAccountInfo();
        data.put("lastName", RandomStringUtils.randomAlphanumeric(46));
        accountDataPage.verifyEditAccountFields(data);
        AssertCollector.assertEquals(accountDataPage.lastNameInEditPage.getAttribute("value").length(),
                " Number of symbols is equal ", RandomStringUtils.randomAlphabetic(45).length());

        data = accountDataPage.mainAccountInfo();
        data.put("firstName", "Анна-Мар'я" + RandomStringUtils.randomAlphabetic(36));
        accountDataPage.verifyEditAccountFields(data);
        AssertCollector.assertEquals(accountDataPage.firstNameInEditPage.getAttribute("value"),
                " Value of first name is equal ", accountDataPage.firstNameInEditPage.
                        getAttribute("value"));

        data = accountDataPage.mainAccountInfo();
        data.put("lastName", "Анна-Мар'я" + RandomStringUtils.randomAlphanumeric(36));
        accountDataPage.verifyEditAccountFields(data);
        AssertCollector.assertEquals(accountDataPage.lastNameInEditPage.getAttribute("value"),
                " Value of last name is equal ", accountDataPage.lastNameInEditPage.
                        getAttribute("value"));

        data = accountDataPage.mainAccountInfo();
        data.put("firstName", "Аркадий");
        data.put("lastName", "Евдокимов");
        accountDataPage.verifyEditAccountFields(data);
        del.scrollToNecessaryElementDelegate(accountDataPage.saveButtonInEditPage);
        accountDataPage.saveButtonInEditPage.click();
        AssertCollector.assertEqualsJ(del.getCurrentUrlDelegate(), ACCOUNT_PAGE_URL, "Urls are equals");
        AssertCollector.assertTrue(controlPanelPage.nameInPersonalData.getText().contains("Аркадий Евдокимов"));
    }

    @Test
    public void verifyAccountPhoneFieldValidationTest() {
        TestReporter.testTitle("Test ID = 40088,40097");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        authorizationPage.verifyAuthFields(data);
        del.getUrlDelegate(ACCOUNT_INFORMATION_URL);
        data = accountDataPage.mainAccountInfo();
        data.put("phone", "+77111111111");
        accountDataPage.verifyEditAccountFields(data);
        AssertCollector.assertEquals(accountDataPage.phoneInEditPage.getAttribute("value"),
                " Value of phone field is equal ", accountDataPage.phoneInEditPage.
                        getAttribute("value"));
        del.scrollToNecessaryElementDelegate(accountDataPage.saveButtonInEditPage);
        accountDataPage.saveButtonInEditPage.click();
        AssertCollector.assertEqualsJ(del.getCurrentUrlDelegate(), ACCOUNT_PAGE_URL, "Urls are equals");
        AssertCollector.assertTrue(controlPanelPage.phoneInPersonalData.getText().contains(AUTORIZATION_EMAIL));
    }

    @Test
    public void verifyEmailFieldValidationTest() {
        TestReporter.testTitle("Test ID = 40091,40096");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        authorizationPage.verifyAuthFields(data);
        data = accountDataPage.mainAccountInfo();
        data.put("email", AUTORIZATION_EMAIL);
        accountDataPage.verifyEditAccountFields(data);
        AssertCollector.assertEquals(accountDataPage.emailInEditPage.getAttribute("value"),
                " Value of current password field is equal ", accountDataPage.emailInEditPage.
                        getAttribute("value"));
        del.scrollToNecessaryElementDelegate(accountDataPage.saveButtonInEditPage);
        accountDataPage.saveButtonInEditPage.click();
        AssertCollector.assertEquals(del.getCurrentUrlDelegate(), "Current url is equals", ACCOUNT_PAGE_URL);
        AssertCollector.assertTrue(controlPanelPage.emailInPersonalData.getText().contains(AUTORIZATION_EMAIL));
    }

    @Test
    public void verifyConfirmPasswordFieldValidationTest() {
        TestReporter.testTitle("Test ID = 40094,40098");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        authorizationPage.verifyAuthFields(data);
        data = accountDataPage.mainAccountInfo();
        data.put("passwordInEditPage", AUTORIZATION_PASSWORD);
        accountDataPage.verifyEditAccountFields(data);
        AssertCollector.assertEquals(accountDataPage.passwordInEditPage.getAttribute("value"),
                " Value of current password field is equal ", accountDataPage.passwordInEditPage.
                        getAttribute("value"));
        del.scrollToNecessaryElementDelegate(accountDataPage.saveButtonInEditPage);
        accountDataPage.saveButtonInEditPage.click();
        AssertCollector.assertEquals(del.getCurrentUrlDelegate(), "Current url is equals", ACCOUNT_PAGE_URL);
    }

    @Test
    public void verifyAccountRequiredFieldsTest() {
        TestReporter.testTitle("Test ID = 38455,38456,38419");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        authorizationPage.verifyAuthFields(data);
        data = accountDataPage.mainAccountInfo();
        data.put("firstName", "");
        data.put("lastName", "");
        data.put("email", "");
        data.put("phone", "");
        data.put("currentPassword", "");
        accountDataPage.verifyEditAccountFields(data);
        accountDataPage.changePasswordCheckbox.click();
        del.scrollToNecessaryElementDelegate(accountDataPage.saveButtonInEditPage);
        accountDataPage.saveButtonInEditPage.click();
        del.textPresentDelegate("Это поле обязательно для заполнения");
        del.scrollToNecessaryElementDelegate(accountDataPage.saveButtonInEditPage);
        AssertCollector.assertTrue(accountDataPage.changePasswordHeader.isDisplayed(),
                "Required header is displayed");
        AssertCollector.assertTrue(accountDataPage.newPasswordField.isDisplayed(),
                "Required field is displayed");
        AssertCollector.assertTrue(accountDataPage.confirmPasswordField.isDisplayed(),
                "Required field is displayed");
    }
}
