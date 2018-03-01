package KDV_testcases.registration.PhysicalPerson;


import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.TestReporter;

public class FillRequiredFieldsTest extends BaseTest {

    @Test
    public void verifyPressSendButtonWithoutFillingFieldsTest() {
        TestReporter.testTitle("Test ID = 37340");
        registrationPage.verifyPressSendButtonWithoutFillingFields();
    }

    @Test
    public void verifySendingWithoutFillingFirstNameFieldTest() {
        TestReporter.testTitle("Test ID = 37341");
        registrationPage.verifySendingWithoutFillingFirstNameField();
    }

    @Test
    public void verifySendingWithoutFillingLastNameFieldTest() {
        TestReporter.testTitle("Test ID = 37343");
        registrationPage.verifySendingWithoutFillingLastNameField();
    }

    @Test
    public void verifySendingWithoutFillingPhoneFieldTest() {
        TestReporter.testTitle("Test ID = 37344");
        registrationPage.verifySendingWithoutFillingPhoneField();
    }

    @Test
    public void verifySendingWithoutFillingEmailFieldTest() {
        TestReporter.testTitle("Test ID = 37345");
        registrationPage.verifySendingWithoutFillingEmailField();
    }

    @Test
    public void verifySendingWithoutFillingPasswordFieldTest() {
        TestReporter.testTitle("Test ID = 37346");
        registrationPage.verifySendingWithoutFillingPasswordField();
    }

    @Test
    public void verifySendingWithoutFillingConfirmPasswordFieldTest() {
        TestReporter.testTitle("Test ID = 37349");
        registrationPage.verifySendingWithoutFillingConfirmPasswordField();
    }

    @Test
    public void verifySendingWithoutFillingCheckboxTest() {
        TestReporter.testTitle("Test ID = 37351");
        registrationPage.verifySendingWithoutFillingCheckbox();
    }

    @Test
    public void verifyDuplicateEmailTest() {
        TestReporter.testTitle("Test ID = 37360");
        registrationPage.verifyDuplicateEmail();
    }

    @Test
    public void verifyForgotPasswordButtonTest() {
        TestReporter.testTitle("Test ID = 37365");
        registrationPage.verifyForgotPasswordButton();
    }

    @Test
    public void verifySuccessfulRegistrationTest() {
        TestReporter.testTitle("Test ID = 37366");
        registrationPage.verifySuccessfulRegistration();
    }
}
