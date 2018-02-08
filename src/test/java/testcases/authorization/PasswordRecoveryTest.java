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
    public void verifyAuthorizationFormTest() //C34497 - добавлены C36970, C36974
    {
        TestReporter.testTitle("Test ID = C34497");
        authorizationPage.verifyReturnToAuthorizationForm();
        authorizationPage.verifyValidEmailInForgotPassword();
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

//    @Test
//    public void verifyValidEmailInForgotPasswordTest() {
//
//    }
}
