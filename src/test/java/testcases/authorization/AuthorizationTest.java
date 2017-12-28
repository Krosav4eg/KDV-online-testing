package testcases.authorization;

import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;

/**
 * @author Sergey Potapov
 */
public class AuthorizationTest extends BaseTest {

    @Test
    public void verifyOpeningMainPageTest() {
        TestReporter.testTitle("Test ID = 34442");
        authorizationPage.verifyOpeningMainPage();
    }

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
    public void verifyCopyWriteTest() {
        TestReporter.testTitle("Test ID = 34447");
        authorizationPage.verifyCopyWrite();
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
    public void verifyTextInForOrganizationsTabTest() {
        TestReporter.testTitle("Test ID = 34451");
        authorizationPage.verifyTextInForOrganizationsTab();
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
    public void verifyEmailFieldWithoutAtTest() {
        TestReporter.testTitle("Test ID = 34487");
        authorizationPage.verifyEmailFieldWithoutAt();
    }

    @Test
    public void verifyEmailFieldWithoutDomainNameTest() {
        TestReporter.testTitle("Test ID = 34488");
        authorizationPage.verifyEmailFieldWithoutDomainName();
    }

    @Test
    public void verifyEmailFieldWithMoreThanOneDotTest() {
        TestReporter.testTitle("Test ID = 34489");
        authorizationPage.verifyEmailFieldWithMoreThanOneDot();
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

    @Test
    public void verifyPasswordContainsOnlySpacesTest() {
        TestReporter.testTitle("Test ID = 34494");
        authorizationPage.verifyPasswordContainsOnlySpaces();
    }

    @Test
    public void verifyPasswordContainsSpacesAtStartAndEndTest() {
        TestReporter.testTitle("Test ID = 34495");
        authorizationPage.verifyPasswordContainsSpacesAtStartAndEnd();
    }

    @Test
    public void verifyEnterWithUnconfirmedEmailTest() {
        TestReporter.testTitle("Test ID = 37057");
        authorizationPage.verifyEnterWithUnconfirmedEmail();
    }
}
