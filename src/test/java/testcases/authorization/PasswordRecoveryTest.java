package testcases.authorization;

import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;


public class PasswordRecoveryTest extends BaseTest {

    @Test
    public void verifyForgotPasswordTest() {
        TestReporter.testTitle("Test ID = 34497");
        authorizationPage.verifyForgotPassword();
    }

    @Test
    public void verifyAuthorizationFormTest() {
        TestReporter.testTitle("Test ID = 36970");
        authorizationPage.verifyReturnToAuthorizationForm();
    }

    @Test
    public void verifyEmailWithoutAtInForgotPasswordTest() {
        TestReporter.testTitle("Test ID = 36971");
        authorizationPage.verifyEmailWithoutAtInForgotPassword();
    }

    @Test
    public void verifyEmailFieldWithoutDomainNameInForgotPasswordFieldTest() {
        TestReporter.testTitle("Test ID = 36973");
        authorizationPage.verifyEmailFieldWithoutDomainNameInForgotPasswordField();
    }

    @Test
    public void verifyValidEmailInForgotPasswordTest() {
        TestReporter.testTitle("Test ID = 36974");
        authorizationPage.verifyValidEmailInForgotPassword();
    }
}
