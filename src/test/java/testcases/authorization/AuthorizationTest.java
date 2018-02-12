package testcases.authorization;

import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;


/**
 * @author Sergey Potapov
 */
public class AuthorizationTest extends BaseTest {

    @Test
    public void verifyCopyWriteTest() {
        TestReporter.testTitle("Test ID = 34447");
        authorizationPage.verifyCopyWrite();
    }

    @Test
    public void verifyOpeningMainPageTest() //C34447 - в этом кейсе объеденены C34442, C34443-45, C34449-51
    {
        TestReporter.testTitle("Test ID = 34447");
        authorizationPage.verifyOpeningMainPage();
        authorizationPage.verifyOpeningRegistrationLink();
        authorizationPage.verifyOpeningContinueAsGuestLink();
        authorizationPage.verifyOpeningForOrganizationsLink();
        authorizationPage.verifyOfTextInRegistrationTab();
        authorizationPage.verifyOfTextInContinueAsGuestTab();
        authorizationPage.verifyTextInForOrganizationsTab();
    }
}
