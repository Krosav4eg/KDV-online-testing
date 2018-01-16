package testcases.registration;

import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.AssertCollector;
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

    @Test
    public void verifyMaximumInputInFirstNameFieldTest() {
        TestReporter.testTitle("Test ID = 37103");
        registrationPage.verifyMaximumInputInFirstNameField();
    }

    @Test
    public void verifyInputNumbersInFirstNameFieldTest() {
        TestReporter.testTitle("Test ID = 37104");
        registrationPage.verifyInputNumbersInFirstNameField();
    }

    @Test
    public void verifyInputForbiddenSymbolsInFirstNameFieldTest() {
        TestReporter.testTitle("Test ID = 37105");
        registrationPage.verifyInputForbiddenSymbolsInFirstNameField();
    }

    @Test
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

    @Test
    public void verifyMaximumInputInLastNameFieldTest() {
        TestReporter.testTitle("Test ID = 37115");
        registrationPage.verifyMaximumInputInLastNameField();
    }

    @Test
    public void verifyInputNumbersInLastNameFieldTest() {
        TestReporter.testTitle("Test ID = 37117");
        registrationPage.verifyInputNumbersInLastNameField();
    }

    @Test
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

    @Test
    public void verifyFieldEmailPresenceTest() {
        TestReporter.testTitle("Test ID = 37298");
        registrationPage.verifyFieldEmailPresence();
    }

    @Test
    public void verifyEmailWithoutAtSymbolTest() {
        TestReporter.testTitle("Test ID = 37287");
        registrationPage.verifyEmailWithoutAtSymbol();
    }

    @Test
    public void verifyEmailWithoutDomainNameTest() {
        TestReporter.testTitle("Test ID = 37288");
        registrationPage.verifyEmailWithoutDomainName();
    }

    @Test
    public void verifyEmailWithMoreThanOneDotTest() {
        TestReporter.testTitle("Test ID = 37289");
        registrationPage.verifyEmailWithMoreThanOneDot();
    }

    @Test
    public void verifyEmailWithSpacesBeforeAtSymbolTest() {
        TestReporter.testTitle("Test ID = 37291");
        registrationPage.verifyEmailWithSpacesBeforeAtSymbol();
    }

    @Test
    public void verifyEmailWithSpacesAfterAtSymbolTest() {
        TestReporter.testTitle("Test ID = 37331");
        registrationPage.verifyEmailWithSpacesAfterAtSymbol();
    }

    @Test
    public void verifyFieldPasswordPresenceTest() {
        TestReporter.testTitle("Test ID = 37338");
        registrationPage.verifyFieldPasswordPresence();
    }

    @Test
    public void verifyPasswordLengthLessThanSixSymbolsTest() {
        TestReporter.testTitle("Test ID = 37292");
        registrationPage.verifyPasswordLengthLessThanSixSymbols();
    }

    @Test
    public void verifyPasswordWithOnlySpacesTest() {
        TestReporter.testTitle("Test ID = 37293");
        registrationPage.verifyPasswordWithOnlySpaces();
    }

    @Test
    public void verifyPasswordWithSpacesAtStartAndEndTest() {
        TestReporter.testTitle("Test ID = 37294");
        registrationPage.verifyPasswordWithSpacesAtStartAndEnd();
    }

    @Test
    public void verifyFieldConfirmPasswordPresenceTest() {
        TestReporter.testTitle("Test ID = 37337");
        registrationPage.verifyFieldConfirmPasswordPresence();
    }

    @Test
    public void verifyInputNewPasswordWithoutConfirmationTest() {
        TestReporter.testTitle("Test ID = 37295");
        registrationPage.verifyInputNewPasswordWithoutConfirmation();
    }

    @Test
    public void verifyInputEmailTest() {
        TestReporter.testTitle("Test ID = 37522,37515,37529,37530");
        JSONObject data = registrationPage.mainInfoRegistration();
        AssertCollector.assertTrue(!registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));
    }

    @Test
    public void verifyInputWrongEmailTest() {
        TestReporter.testTitle("Test ID = 37516");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("email", "test@test");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).contains("Пожалуйста, введите правильный адрес электронной почты"));
    }

    @Test
    public void verifyInputWrongPasswordTest() {
        TestReporter.testTitle("Test ID = 37523");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("password", "test");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).contains("Пожалуйста, введите не менее 6 символов без"));
        data.put("password", " test ");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));
    }

    @Test
    public void verifyInputEmptyConfirmPasswordTest() {
        TestReporter.testTitle("Test ID = 37526,37528");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("confirmPassword", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));
        data.put("confirmPassword", "test");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));

    }


    @Test
    public void verifyRegistrationTest() {
        TestReporter.testTitle("Test ID = 37533,37534,37550");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("company", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));
        data = registrationPage.mainInfoRegistration();
        data.put("taxId", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));
        data = registrationPage.mainInfoRegistration();
        data.put("reasonCode", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));
    }

    @Test
    public void verifyRegistrationComponentTest() {
        TestReporter.testTitle("Test ID = 37551,37552,37553,37554,37556,37557,37558,37559");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("legalAddress", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));
        data = registrationPage.mainInfoRegistration();
        data.put("company", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));
        data = registrationPage.mainInfoRegistration();
        data.put("firstName", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));
    }

    @Test
    public void verifyRegistrationAddressTest() {
        TestReporter.testTitle("Test ID = 37551,37552,37553,37554,37556,37557,37558,37559");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("address", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));
        data = registrationPage.mainInfoRegistration();
        data.put("lastName", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));
        data = registrationPage.mainInfoRegistration();
        data.put("phone", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));
        data = registrationPage.mainInfoRegistration();
        data.put("password", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));
        data = registrationPage.mainInfoRegistration();
        data.put("confirmPassword", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));
        data = registrationPage.mainInfoRegistration();
        data.put("taxId", "1234567891");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));

    }


    @Test
    public void verifyFields() {
        TestReporter.testTitle("Test ID = 37542");
        JSONObject data = registrationPage.mainInfoRegistration();
        AssertCollector.assertTrue(!registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));
    }

    @Test
    public void verifyFieldsEmptyFirstName() {
        TestReporter.testTitle("Test ID = 37542");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("firstName", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));
    }


    public void verifyCoincidencePasswordAndConfirmationTest() {
        TestReporter.testTitle("Test ID = 37296");
        registrationPage.verifyCoincidencePasswordAndConfirmation();
    }

    @Test
    public void verifySubscriptionCheckboxPresenceTest() {
        TestReporter.testTitle("Test ID = 37352");
        registrationPage.verifySubscriptionCheckboxPresence();
    }

    @Test
    public void verifyWorkOfCheckboxConfirmTest() {
        TestReporter.testTitle("Test ID = 37353");
        registrationPage.verifyWorkOfCheckboxConfirm();
    }

    @Test
    public void verifyCheckboxConfirmPresenceTest() {
        TestReporter.testTitle("Test ID = 37354");
        registrationPage.verifyCheckboxConfirmPresence();
    }

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

    @Test
    public void verifyLegalEntitySelectedTest() {
        TestReporter.testTitle("Test ID = 37384");
        registrationPage.verifyLegalEntitySelected();
    }

    @Test
    public void verifyOrganizationFullNameFieldPresenceTest() {
        TestReporter.testTitle("Test ID = 37374");
        registrationPage.verifyOrganizationFullNameFieldPresence();
    }

    @Test
    public void verifyMaximumInputInFullNameTest() {
        TestReporter.testTitle("Test ID = 37375");
        registrationPage.verifyMaximumInputInFullName();
    }

    @Test
    public void verifyFieldForTaxpayerIdTest() {
        TestReporter.testTitle("Test ID = 37385");
        registrationPage.verifyFieldForTaxpayerId();
    }

    @Test
    public void verifyValidInputInTaxpayerIdFieldTest() {
        TestReporter.testTitle("Test ID = 37388");
        registrationPage.verifyValidInputInTaxpayerIdField();
    }

    @Test
    public void verifyInputLettersInTaxpayerIdFieldTest() {
        TestReporter.testTitle("Test ID = 37389");
        registrationPage.verifyInputLettersInTaxpayerIdField();
    }

    @Test
    public void verifyInputSymbolsInTaxpayerIdFieldTest() {
        TestReporter.testTitle("Test ID = 37390");
        registrationPage.verifyInputSymbolsInTaxpayerIdField();
    }

    @Test
    public void verifyInputLessThenTenDigitsInTaxpayerIdFieldTest() {
        TestReporter.testTitle("Test ID = 37391");
        registrationPage.verifyInputLessThenTenDigitsInTaxpayerIdField();
    }

    @Test
    public void verifyReasonCodeFieldPresenceTest() {
        TestReporter.testTitle("Test ID = 37393");
        registrationPage.verifyReasonCodeFieldPresence();
    }

    @Test
    public void verifyValidInputInReasonCodeFieldTest() {
        TestReporter.testTitle("Test ID = 37394");
        registrationPage.verifyValidInputInReasonCodeField();
    }

    @Test
    public void verifyInputLettersInReasonCodeFieldTest() {
        TestReporter.testTitle("Test ID = 37395");
        registrationPage.verifyInputLettersInReasonCodeField();
    }

    @Test
    public void verifyInputSymbolsInReasonCodeFieldTest() {
        TestReporter.testTitle("Test ID = 37396");
        registrationPage.verifyInputSymbolsInReasonCodeField();
    }

    @Test
    public void verifyInputLessThenNineDigitsInReasonCodeFieldTest() {
        TestReporter.testTitle("Test ID = 37397");
        registrationPage.verifyInputLessThenNineDigitsInReasonCodeField();
    }

    @Test
    public void verifyLegalAddressFieldPresenceTest() {
        TestReporter.testTitle("Test ID = 37416");
        registrationPage.verifyLegalAddressFieldPresence();
    }

    @Test
    public void verifyMaximumInputInLegalAddressTest() {
        TestReporter.testTitle("Test ID = 37421");
        registrationPage.verifyMaximumInputInLegalAddress();
    }

    @Test
    public void verifyCompanyFieldPresenceTest() {
        TestReporter.testTitle("Test ID = 37423");
        registrationPage.verifyCompanyFieldPresence();
    }

    @Test
    public void verifyMaximumInputInCompanyTest() {
        TestReporter.testTitle("Test ID = 37424");
        registrationPage.verifyMaximumInputInCompany();
    }

    @Test
    public void verifyAddressFieldPresenceTest() {
        TestReporter.testTitle("Test ID = 37479");
        registrationPage.verifyAddressFieldPresence();
    }

    @Test
    public void verifyPromptsInAddressFieldAfterInputTest() {
        TestReporter.testTitle("Test ID = 37564");
        registrationPage.verifyPromptsInAddressFieldAfterInput();
    }

    @Test
    public void verifyPromptChoosingInAddressFieldAfterInputTest() {
        TestReporter.testTitle("Test ID = 37565");
        registrationPage.verifyPromptChoosingInAddressFieldAfterInput();
    }

    @Test
    public void verifyFullAddressInputInAddressFieldTest() {
        TestReporter.testTitle("Test ID = 37567");
        registrationPage.verifyFullAddressInputInAddressField();
    }

    @Test
    public void verifyMaximumInputInAddressFieldTest() {
        TestReporter.testTitle("Test ID = 37480");
        registrationPage.verifyMaximumInputInAddressField();
    }

    @Test
    public void verifyCommentsFieldPresenceTest() {
        TestReporter.testTitle("Test ID = 37485");
        registrationPage.verifyCommentsFieldPresence();
    }

    @Test
    public void verifyMaximumInputInCommentsFieldTest() {
        TestReporter.testTitle("Test ID = 37486");
        registrationPage.verifyMaximumInputInCommentsField();
    }

    @Test
    public void verifyInputCorrectInnValueTest() {
        TestReporter.testTitle("Test ID = 37571,37572");
        JSONObject data = registrationPage.mainInfoRegistration();
        AssertCollector.assertFalse(registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));
    }

    //not pass due validation in both fields
    @Test
    public void verifyMaximumInputLengthInOrganizationFullNameLegalAddressFieldTest() {
        TestReporter.testTitle("Test ID = 37568,40062");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("organizationName", RandomStringUtils.randomAlphanumeric(256));
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));
        AssertCollector.assertEquals(registrationPage.organizationFullName.getAttribute("value").length(), " Number of symbols is equal ",
                RandomStringUtils.randomAlphabetic(255).length());
        data = registrationPage.mainInfoRegistration();
        data.put("legalAddress", RandomStringUtils.randomAlphanumeric(256));
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));
        AssertCollector.assertEquals(registrationPage.legalAddress.getAttribute("value").length(), " Number of symbols is equal ",
                RandomStringUtils.randomAlphabetic(255).length());
    }

    //not pass due validation in both fields
    @Test
    public void verifyMaximumInputLengthInCompanyAndCommentsFieldTest() {
        TestReporter.testTitle("Test ID = 40063,40066");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("company", RandomStringUtils.randomAlphanumeric(256));
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));
        AssertCollector.assertEquals(registrationPage.company.getAttribute("value").length(), " Number of symbols is equal ",
                RandomStringUtils.randomAlphabetic(255).length());
        data = registrationPage.mainInfoRegistration();
        data.put("comments", RandomStringUtils.randomAlphanumeric(1001));
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));
        AssertCollector.assertEquals(registrationPage.company.getAttribute("value").length(), " Number of symbols is equal ",
                RandomStringUtils.randomAlphabetic(1000).length());
    }

    //not pass due validation
    @Test
    public void verifyMaximumInputAddressFieldTest() throws InterruptedException {
        TestReporter.testTitle("Test ID = 40065");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("address", RandomStringUtils.randomAlphanumeric(256));
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));
        AssertCollector.assertEquals(registrationPage.address.getAttribute("value").length(), " Number of symbols is equal ",
                RandomStringUtils.randomAlphabetic(255).length());
        data = registrationPage.mainInfoRegistration();
        data.put("address", "Тульская обл, г Новомосковск, пр-кт Победы, д 5");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).contains("Внимание! Вы не указали " +
                "номер квартиры, офиса."));
        data = registrationPage.mainInfoRegistration();
        data.put("address", "Тульская обл, г Новомосковск, пр-кт Победы, д 5, кв 5");
        AssertCollector.assertFalse(registrationPage.verifyAuthorizationFields(data).contains("Внимание! Вы не указали " +
                "номер квартиры, офиса."));
    }
}

