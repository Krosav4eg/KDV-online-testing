package testcases.authorization;

import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;

/**
 * @author Sergey Potapov
 */
public class AuthorizationTest extends BaseTest {

    @Test
    public void verifyTypingIncorrectPasswordInAuthTest() {
        TestReporter.testTitle("Test ID = 34462");
        authorizationPage.typeIncorrectPasswordInAuth();
    }

    @Test
    public void verifyTypingCorrectLoginIncorrectPasswordInAuthTest() {
        TestReporter.testTitle("Test ID = 34463");
        authorizationPage.typeCorrectLoginIncorrectPasswordInAuth();
    }

    @Test
    public void verifyTypingEmptyDataInAuthTest() {
        TestReporter.testTitle("Test ID = 34467");
        authorizationPage.typeEmptyDataInAuth();
    }

    @Test
    public void verifyTypingLoginWithoutPasswordInAuthTest() {
        TestReporter.testTitle("Test ID = 34472");
        authorizationPage.typeLoginWithoutPasswordInAuth();
    }

    @Test
    public void verifyTypingPasswordWithoutLoginInAuthTest() {
        TestReporter.testTitle("Test ID = 34474");
        authorizationPage.typePasswordWithoutLoginInAuth();
    }
}
