package KDV_testcases.registration.LegalPerson;

import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.TestReporter;


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
}

