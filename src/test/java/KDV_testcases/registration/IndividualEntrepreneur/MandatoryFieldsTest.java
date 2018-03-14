package KDV_testcases.registration.IndividualEntrepreneur;

import Core.utils.TestReporter;
import KDV_testcases.base.BaseTest;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static Core.utils.Constants.KALASHNIKOVA_EMAIL;

public class MandatoryFieldsTest extends BaseTest {

    @Test
    public void verifyMandatoryEmptyFieldsTest() {
        TestReporter.testTitle("Test ID = 37676");
        registrationPage.fieldNecessaryToFillInWithoutData();
    }

    @Test
    public void verifyMandatoryTaxIdTest() {
        TestReporter.testTitle("Test ID = 37677");
        JSONObject verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("taxId", "");
        registrationPage.mandatoryFieldForIndividualFillIn(verifyData, "Это поле обязательно для заполнения.");
        verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("taxId", RandomStringUtils.randomNumeric(10));
        registrationPage.mandatoryFieldForIndividualFillIn(verifyData, "Значение \"ИНН\" должно содержать 12 символов.");
    }

    @Test
    public void verifyMandatoryEmptyCompanyTest() {
        TestReporter.testTitle("Test ID = 37678");
        JSONObject verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("company", "");
        registrationPage.mandatoryFieldForIndividualFillIn(verifyData, "Это поле обязательно для заполнения.");
    }


    @Test
    public void verifyMandatoryEmptyOrganizationTest() {
        TestReporter.testTitle("Test ID = C37686");
        JSONObject verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("organizationName", "");
        registrationPage.mandatoryFieldForIndividualFillIn(verifyData, "Это поле обязательно для заполнения.");
    }

    @Test
    public void verifyMandatoryEmptyLegalTest() {
        TestReporter.testTitle("Test ID = C37685");
        JSONObject verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("legalAddress", "");
        registrationPage.mandatoryFieldForIndividualFillIn(verifyData, "Это поле обязательно для заполнения.");
    }


    @Test
    public void verifyMandatoryEmptyAddressTest() {
        TestReporter.testTitle("Test ID = C37687");
        JSONObject verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("address", "");
        registrationPage.mandatoryFieldForIndividualFillIn(verifyData, "Это поле обязательно для заполнения.");
    }

    @Test
    public void verifyMandatoryEmptyLastNameTest() {
        TestReporter.testTitle("Test ID = C37689");
        JSONObject verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("lastName", "");
        registrationPage.mandatoryFieldForIndividualFillIn(verifyData, "Это поле обязательно для заполнения.");
    }

    @Test
    public void verifyMandatoryEmptyPhoneTest() {
        TestReporter.testTitle("Test ID = C37690");
        JSONObject verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("phone", "");
        registrationPage.mandatoryFieldForIndividualFillIn(verifyData, "Это поле обязательно для заполнения.");
    }

    @Test
    public void verifyMandatoryEmailTest() {
        TestReporter.testTitle("Test ID = C37691,40069");
        JSONObject verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("email", "");
        registrationPage.mandatoryFieldForIndividualFillIn(verifyData, "Это поле обязательно для заполнения.");
    }

    @Test
    public void verifyMandatoryEmptyPasswordTest() {
        TestReporter.testTitle("Test ID = C37692,40072,40073");
        JSONObject verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("password", "");
        registrationPage.mandatoryFieldForIndividualFillIn(verifyData, "Это поле обязательно для заполнения.");
    }

    @Test
    public void verifyMandatoryEmptyConfirmPasswordTest() {
        TestReporter.testTitle("Test ID = C37693,40074");
        JSONObject verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("confirmPassword", "");
        registrationPage.mandatoryFieldForIndividualFillIn(verifyData, "Это поле обязательно для заполнения.");
    }

    @Test
    public void verifyMandatoryExistEmailTest() {
        TestReporter.testTitle("Test ID = C37679");
        JSONObject verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("email", KALASHNIKOVA_EMAIL);
        registrationPage.mandatoryFieldForIndividualFillIn(verifyData,
                "Учётная запись с таким адресом электронной почты уже существует.");
    }

    @Test
    public void verifyMandatoryExistTaxIdTest() {
        TestReporter.testTitle("Test ID = C37695");
        JSONObject verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("taxId", "1234567891");
        registrationPage.mandatoryFieldForIndividualFillIn(verifyData, "Значение \"ИНН\" должно содержать 12 символов.");
    }

    @Test
    public void verifyMandatoryTest() {
        TestReporter.testTitle("Test ID = C37681");
        JSONObject verifyData = registrationPage.mainInfoRegistration();
        registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
        registrationPage.verifySuccessRegistration();
    }

    @Test
    public void verifyNotSelectedCheckBoxTest() {
        TestReporter.testTitle("Test ID = C37694,40076,40077,37561");
        JSONObject verifyData = registrationPage.mainInfoRegistration();
        registrationPage.checkNotSelectedCheckbox(verifyData);
    }

    @Test
    public void verifySelectExistEmailTest() {
        TestReporter.testTitle("Test ID = C37683");
        JSONObject verifyData = registrationPage.mainInfoRegistration();
        verifyData.put("email", "a.shaulo@andersenlab.com");
        registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
        registrationPage.checkIfEmailExists();
    }

    @Test
    public void verifySuccessRegistrationTest() {
        TestReporter.testTitle("Test ID = 37564,37565,37485,37397,37681,37571,37572,37416,37479,37423,37567");
        JSONObject data = registrationPage.mainInfoRegistration();
        registrationPage.checkRegistrationSuccessful(data);
        registrationPage.verifySuccessRegistration();
    }
}
