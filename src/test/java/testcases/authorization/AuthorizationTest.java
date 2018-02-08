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
//    }
//
//    @Test
//    public void verifyOpeningRegistrationLinkTest() {
//        TestReporter.testTitle("Test ID = 34443");
        authorizationPage.verifyOpeningRegistrationLink();
//    }
//
//    @Test
//    public void verifyOpeningContinueAsGuestLinkTest() {
//        TestReporter.testTitle("Test ID = 34444");
        authorizationPage.verifyOpeningContinueAsGuestLink();
//    }
//
//    @Test
//    public void verifyOpeningForOrganizationsLinkTest() {
//        TestReporter.testTitle("Test ID = 34445");
        authorizationPage.verifyOpeningForOrganizationsLink();
//    }
//
//
//    @Test
//    public void verifyOfTextInRegistrationTabTest() {
//        TestReporter.testTitle("Test ID = 34449");
        authorizationPage.verifyOfTextInRegistrationTab();
//    }
//
//    @Test
//    public void verifyOfTextInContinueAsGuestTabTest() {
//        TestReporter.testTitle("Test ID = 34450");
        authorizationPage.verifyOfTextInContinueAsGuestTab();
//    }
//
//    @Test
//    public void verifyTextInForOrganizationsTabTest() {
//        TestReporter.testTitle("Test ID = 34451");
        authorizationPage.verifyTextInForOrganizationsTab();
    }


}
