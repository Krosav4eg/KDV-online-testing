package KDV_testcases.personalCabinet.Physical;

import Core.basePage.BasePage;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.AssertCollector;
import Core.utils.TestReporter;

import static Core.utils.Constants.*;
import static Core.utils.WaitingUtility.elementFluentWaitVisibility;
import static Core.utils.WaitingUtility.elementIsVisible;

public class AccountDataTest extends BaseTest {

    BasePage.MyDelegate del = new BasePage.MyDelegate() {
    };

    @Test
    public void verifyOpeningPersonalDataItemTest() {
        TestReporter.testTitle("Test ID = 38264,40087,38364,40095");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        authorizationPage.verifyAuthFields(data);
        del.getUrlDelegate(ACCOUNT_INFORMATION_URL);
        AssertCollector.verifyCondition(elementIsVisible(accountDataPage.personalDataHeaderInEditPage));
        AssertCollector.verifyCondition(elementIsVisible(accountDataPage.personalDataInEditPage));
        AssertCollector.verifyCondition(elementIsVisible(accountDataPage.sharingInEditPage));
        data = accountDataPage.mainAccountInfo();
        data.put("firstName", RandomStringUtils.randomAlphanumeric(45));
        accountDataPage.verifyEditAccountFields(data);
        AssertCollector.verifyCondition(accountDataPage.firstNameInEditPage.getAttribute("value").length() ==
                RandomStringUtils.randomAlphabetic(45).length());
        data = accountDataPage.mainAccountInfo();
        data.put("lastName", RandomStringUtils.randomAlphanumeric(45));
        accountDataPage.verifyEditAccountFields(data);
        AssertCollector.verifyCondition(accountDataPage.lastNameInEditPage.getAttribute("value").length() ==
                RandomStringUtils.randomAlphabetic(45).length());
        data = accountDataPage.mainAccountInfo();
        data.put("firstName", "Аркадий");
        data.put("lastName", "Евдокимов");
        accountDataPage.verifyEditAccountFields(data);
        del.scrollToNecessaryElementDelegate(accountDataPage.saveButtonInEditPage);
        accountDataPage.saveButtonInEditPage.click();
        AssertCollector.verifyCondition(del.getCurrentUrlDelegate().contains(ACCOUNT_PAGE_URL));
        AssertCollector.verifyCondition(controlPanelPage.nameInPersonalData.getText().contains("Аркадий Евдокимов"));
    }

    @Test
    public void verifyEmailFieldValidationTest() {
        TestReporter.testTitle("Test ID = 40091,40096");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        authorizationPage.verifyAuthFields(data);
        data = accountDataPage.mainAccountInfo();
        data.put("email", AUTHORIZATION_EMAIL);
        accountDataPage.verifyEditAccountFields(data);
        AssertCollector.assertEquals(accountDataPage.emailInEditPage.getAttribute("value"),
                " Value of current password field is equal ", accountDataPage.emailInEditPage.
                        getAttribute("value"));
        del.scrollToNecessaryElementDelegate(accountDataPage.saveButtonInEditPage);
        accountDataPage.saveButtonInEditPage.click();
        AssertCollector.assertEquals(del.getCurrentUrlDelegate(), "Current url is equals", ACCOUNT_PAGE_URL);
        AssertCollector.assertTrue(controlPanelPage.emailInPersonalData.getText().contains(AUTHORIZATION_EMAIL));
    }

    @Test
    public void verifyConfirmPasswordFieldValidationTest() {
        TestReporter.testTitle("Test ID = 38298,40094,40098");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        authorizationPage.verifyAuthFields(data);
        data = accountDataPage.mainAccountInfo();
        data.put("passwordInEditPage", AUTHORIZATION_PASSWORD);
        accountDataPage.verifyEditAccountFields(data);
        AssertCollector.assertEquals(accountDataPage.passwordInEditPage.getAttribute("value"),
                " Value of current password field is equal ", accountDataPage.passwordInEditPage.
                        getAttribute("value"));
        del.scrollToNecessaryElementDelegate(accountDataPage.saveButtonInEditPage);
        accountDataPage.saveButtonInEditPage.click();
        AssertCollector.assertEquals(del.getCurrentUrlDelegate(), "Current url is equals", ACCOUNT_PAGE_URL);
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
        AssertCollector.assertTrue(controlPanelPage.phoneInPersonalData.getText().contains("+77711111111"));
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
        AssertCollector.assertTrue(elementIsVisible(accountDataPage.changePasswordHeader),
                "Required header is displayed");
        AssertCollector.assertTrue(elementIsVisible(accountDataPage.newPasswordField),
                "Required field is displayed");
        AssertCollector.assertTrue(elementIsVisible(accountDataPage.confirmPasswordField),
                "Required field is displayed");
    }

    @Test
    public void verifyCorrectChangingPasswordTest() {
        TestReporter.testTitle("Test ID = 38451");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", ZUEV_EMAIL);
        data.put("password", ZUEV_PASSWORD);
        authorizationPage.verifyAuthFields(data);
        accountDataPage.changingPassword(ZUEV_PASSWORD, ZUEV_PASSWORD);
        AssertCollector.assertTrue(accountDataPage.sucsessMessage.getText().contains("Данные учётной записи сохранены."));
    }
}
