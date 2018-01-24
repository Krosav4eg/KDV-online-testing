package testcases.personalCabinet;


import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;

public class ControlPanelPageTest extends BaseTest{

    @Test
    public void verifyControlPanelHeaderTest() {
        TestReporter.testTitle("Test ID = 37820");
        controlPanelPage.verifyControlPanelHeader();
    }

    @Test
    public void verifyGreetingsBlockTest() {
        TestReporter.testTitle("Test ID = 37821");
        controlPanelPage.verifyGreetingsBlock();
    }

    @Test
    public void verifyOrdersBlockAbsenceTest() {
        TestReporter.testTitle("Test ID = 37822");
        controlPanelPage.verifyOrdersBlockAbsence();
    }

    @Test
    public void verifyOrdersBlockWithQuantityLessThenFiveTest() {
        TestReporter.testTitle("Test ID = 37823");
        controlPanelPage.verifyOrdersBlockWithQuantityLessThenFive();
    }

    @Test
    public void verifyOrdersBlockWithQuantityMoreThenFiveTest() {
        TestReporter.testTitle("Test ID = 37843");
        controlPanelPage.verifyOrdersBlockWithQuantityMoreThenFive();
    }

    @Test
    public void verifyLinkShowAllTest() {
        TestReporter.testTitle("Test ID = 37845");
        controlPanelPage.verifyLinkShowAll();
    }

    @Test
    public void verifyPersonalDataHeaderTest() {
        TestReporter.testTitle("Test ID = 38062");
        controlPanelPage.verifyPersonalDataHeader();
    }

    @Test
    public void verifyUserFirstNameAndLastNameInPersonalDataTest() {
        TestReporter.testTitle("Test ID = 38063");
        controlPanelPage.verifyUserFirstNameAndLastNameInPersonalData();
    }

    @Test
    public void verifyUserEmailTest() {
        TestReporter.testTitle("Test ID = 38064");
        controlPanelPage.verifyUserEmail();
    }

    @Test
    public void verifyUserPhoneTest() {
        TestReporter.testTitle("Test ID = 38065");
        controlPanelPage.verifyUserPhone();
    }

    @Test
    public void verifyPersonalDataEditButtonTest() {
        TestReporter.testTitle("Test ID = 38066");
        controlPanelPage.verifyPersonalDataEditButton();
    }

    @Test
    public void verifyAddressByDefaultHeaderTest() {
        TestReporter.testTitle("Test ID = 38196");
        controlPanelPage.verifyAddressByDefaultHeader();
    }

    @Test
    public void verifyUserFirstNameAndLastNameInAddressByDefaultTest() {
        TestReporter.testTitle("Test ID = 38197");
        controlPanelPage.verifyUserFirstNameAndLastNameInAddressByDefault();
    }

    @Test
    public void verifyAddressByDefaultTest() {
        TestReporter.testTitle("Test ID = 38198");
        controlPanelPage.verifyAddressByDefault();
    }

    @Test
    public void verifyUserPhoneInAddressByDefaultTest() {
        TestReporter.testTitle("Test ID = 38199");
        controlPanelPage.verifyUserPhoneInAddressByDefault();
    }

    @Test
    public void verifyAddressEditButtonTest() {
        TestReporter.testTitle("Test ID = 38200");
        controlPanelPage.verifyAddressEditButton();
    }
}
