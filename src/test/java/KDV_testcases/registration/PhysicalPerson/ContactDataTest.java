package KDV_testcases.registration.PhysicalPerson;

import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.TestReporter;


public class ContactDataTest extends BaseTest {

    @Test
    public void verifyFieldFirstNamePresenceTest() {
        TestReporter.testTitle("Test ID = 37097");
        registrationPage.verifyFieldFirstNamePresence();
    }

    //    37098 был удалён объеденени из-за схожести проверок с 37103
    @Test
    public void verifyMaximumInputInFirstNameFieldTest() {
        TestReporter.testTitle("Test ID = 37103");
        registrationPage.verifyMaximumInputInFirstNameField();
    }

    //test not pass(validation problems)
    @Test(enabled = false)
    public void verifyInputNumbersInFirstNameFieldTest() {
        TestReporter.testTitle("Test ID = 37104");
        registrationPage.verifyInputNumbersInFirstNameField();
    }

    //accepting possibility inputting incorrect symbols
    @Test(enabled = false)
    public void verifyInputForbiddenSymbolsInFirstNameFieldTest() {
        TestReporter.testTitle("Test ID = 37105");
        registrationPage.verifyInputForbiddenSymbolsInFirstNameField();
    }

    @Test(enabled = false)
    public void verifyInputSpecialSymbolsInFirstNameFieldTest() {
        TestReporter.testTitle("Test ID = 37106");
        registrationPage.verifyInputSpecialSymbolsInFirstNameField();
    }

    @Test
    public void verifyFieldLastNamePresenceTest() {
        TestReporter.testTitle("Test ID = 37113");
        registrationPage.verifyFieldLastNamePresence();
    }

    @Test
    public void verifyInputInLastNameFieldTest() {
        TestReporter.testTitle("Test ID = 37114");
        registrationPage.verifyInputInLastNameField();
    }

    //test not pass(validation problems)
    @Test
    public void verifyMaximumInputInLastNameFieldTest() {
        TestReporter.testTitle("Test ID = 37115");
        registrationPage.verifyMaximumInputInLastNameField();
    }

    //test not pass(validation problems)
    @Test(enabled = false)
    public void verifyInputNumbersInLastNameFieldTest() {
        TestReporter.testTitle("Test ID = 37117");
        registrationPage.verifyInputNumbersInLastNameField();
    }

    //test not pass(validation problems)
    @Test(enabled = false)
    public void verifyInputForbiddenSymbolsInLastNameFieldTest() {
        TestReporter.testTitle("Test ID = 37118");
        registrationPage.verifyInputForbiddenSymbolsInLastNameField();
    }

    @Test
    public void verifyInputSpecialSymbolsInLastNameFieldTest() {
        TestReporter.testTitle("Test ID = 37119");
        registrationPage.verifyInputSpecialSymbolsInLastNameField();
    }

    @Test
    public void verifyFieldPhonePresenceTest() {
        TestReporter.testTitle("Test ID = 37278");
        registrationPage.verifyFieldPhonePresence();
    }

    @Test
    public void verifyMaskInPhoneFieldTest() {
        TestReporter.testTitle("Test ID = 37282");
        registrationPage.verifyMaskInPhoneField();
    }

    @Test
    public void verifyMaximumInputInPhoneFieldTest() {
        TestReporter.testTitle("Test ID = 37279");
        registrationPage.verifyMaximumInputInPhoneField();
    }

    @Test
    public void verifyInputForbiddenSymbolsInPhoneFieldTest() {
        TestReporter.testTitle("Test ID = 37281");
        registrationPage.verifyInputForbiddenSymbolsInPhoneField();
    }

    @Test
    public void verifyInputLettersInPhoneFieldTest() {
        TestReporter.testTitle("Test ID = 37283");
        registrationPage.verifyInputLettersInPhoneField();
    }

    @Test
    public void verifyInputSpacesInPhoneFieldTest() {
        TestReporter.testTitle("Test ID = 37285");
        registrationPage.verifyInputSpacesInPhoneField();
    }

    @Test
    public void verifyInputLessThenTenNumbersInPhoneFieldTest() {
        TestReporter.testTitle("Test ID = 37286");
        registrationPage.verifyInputLessThenTenNumbersInPhoneField();
    }
}
