package testcases.authorization;

import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;

/**
 * @author Sergey Potapov
 */
public class AuthorizationTest extends BaseTest {

    @Test
    public void verifyOpeningRegistrationLinkTest() {
        TestReporter.testTitle("Test ID = 34443");
        authorizationPage.verifyOpeningRegistrationLink();
    }

    @Test
    public void verifyOpeningContinueAsGuestLinkTest() {
        TestReporter.testTitle("Test ID = 34444");
        authorizationPage.verifyOpeningContinueAsGuestLink();
    }

    @Test
    public void verifyOpeningForOrganizationsLinkTest() {
        TestReporter.testTitle("Test ID = 34445");
        authorizationPage.verifyOpeningForOrganizationsLink();
    }

    @Test
    public void verifyChangingColorsForTabsTest() {
        TestReporter.testTitle("Test ID = 34446");
        authorizationPage.verifyChangingColorsForTabs();
    }

    @Test
    public void verifyOfTextInRegistrationTabTest() {
        TestReporter.testTitle("Test ID = 34449");
        authorizationPage.verifyOfTextInRegistrationTab();
    }

    @Test
    public void verifyOfTextInContinueAsGuestTabTest() {
        TestReporter.testTitle("Test ID = 34450");
        authorizationPage.verifyOfTextInContinueAsGuestTab();
    }

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

    @Test
    public void verifyEmailFieldWithNumbersAndSymbolsInInAuthTest() {
        TestReporter.testTitle("Test ID = 34491");
        authorizationPage.verifyEmailFieldWithNumbersAndSymbols();
    }

    @Test
    public void verifyEmailWithSpacesInAuthTest() {
        TestReporter.testTitle("Test ID = 34492");
        authorizationPage.verifyEmailWithSpaces();
    }

    @Test
    public void verifyTypingPasswordLessSixSymbolsInAuthTest() {
        TestReporter.testTitle("Test ID = 34493");
        authorizationPage.verifyTypingPasswordLessSixSymbols();
    }
}
