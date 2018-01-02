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

}

