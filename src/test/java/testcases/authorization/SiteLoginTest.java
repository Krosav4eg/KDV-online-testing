package testcases.authorization;

import org.json.JSONObject;
import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.AssertCollector;
import utils.TestReporter;

public class SiteLoginTest extends BaseTest {

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

    @Test(alwaysRun = true)
    public void verifyEmailFieldTest() {
        TestReporter.testTitle("Test ID = 34488");
        authorizationPage.verifyEmailFieldWithoutDomainName();
    }

    @Test
    public void verifyEmailFieldWithMoreThanOneDotTest() {
        TestReporter.testTitle("Test ID = 34489");
        authorizationPage.verifyEmailFieldWithMoreThanOneDot();
    }

    //FAILED
    @Test
    public void verifyNotValidEmail() {
        TestReporter.testTitle("Test ID = 34487,34488,34489");
        JSONObject data = authorizationPage.authorizationData();
        data.put("email", "a.shauloandersenlab.com");
        AssertCollector.verifyCondition(authorizationPage.authForm(data).contains("Пожалуйста, введите правильный адрес электронной почты (email)"));
        data.put("email", "a.shaulo@andersenlabcom");
        AssertCollector.verifyCondition(authorizationPage.authForm(data).contains("Пожалуйста, введите правильный адрес электронной почты (email)"));
        data.put("email", "a..shaulo@andersenlab.com");
        AssertCollector.verifyCondition(authorizationPage.authForm(data).contains("Пожалуйста, введите правильный адрес электронной почты (email)"));
        data.put("email", "anastasiya.shaulo@gmail.com");
        AssertCollector.assertTrue(authorizationPage.authForm(data).contains("Эта учётная запись не подтверждена"));
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
    public void verifyTypingPasswordAuthTest() {
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
