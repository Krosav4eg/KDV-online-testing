package testcases.registration;

import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;

public class RegistrationTest extends BaseTest {

    @Test
    public void verifyLegalFormByDefaultTest() {
        TestReporter.testTitle("Test ID = 37076");
        registrationPage.verifyLegalFormByDefault();
    }
    @Test
    public void verifyChoosingLegalFormTest() {
        TestReporter.testTitle("Test ID = 37077");
        registrationPage.verifyChoosingLegalForm();
    }

    @Test
    public void verifyForOrganizationsTextPresenceTest() {
        TestReporter.testTitle("Test ID = 37715");
        registrationPage.verifyForOrganizationsTextPresence();
    }

    @Test
    public void verifyFieldFirstNamePresenceTest() {
        TestReporter.testTitle("Test ID = 37097");
        registrationPage.verifyFieldFirstNamePresence();
    }

    @Test
    public void verifyInputInFirstNameFieldTest() {
        TestReporter.testTitle("Test ID = 37098");
        registrationPage.verifyInputInFirstNameField();
    }
}
