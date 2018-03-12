package KDV_testcases.registration.LegalPerson;

import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.AssertCollector;
import Core.utils.TestReporter;

public class OrganizationInfoTest extends BaseTest {

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

    //not pass due validation in both fields
    @Test(enabled = false)
    public void verifyMaximumInputLengthInOrganizationFullNameLegalAddressFieldTest() {
        TestReporter.testTitle("Test ID = 37568,40062,37486");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("organizationName", RandomStringUtils.randomAlphanumeric(256));
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
        AssertCollector.assertEquals(registrationPage.organizationFullName.getAttribute("value").length(),
                " Number of symbols is equal ", RandomStringUtils.randomAlphabetic(255).length());
        data = registrationPage.mainInfoRegistration();
        data.put("legalAddress", RandomStringUtils.randomAlphanumeric(256));
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
        AssertCollector.assertEquals(registrationPage.legalAddress.getAttribute("value").length(),
                " Number of symbols is equal ", RandomStringUtils.randomAlphabetic(255).length());
    }

    //not pass due validation in both fields
    @Test(enabled = false)
    public void verifyMaximumInputLengthInCompanyAndCommentsFieldTest() {
        TestReporter.testTitle("Test ID = 40063,40066,37480,37424");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("company", RandomStringUtils.randomAlphanumeric(256));
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
        AssertCollector.assertEquals(registrationPage.company.getAttribute("value").length(),
                " Number of symbols is equal ", RandomStringUtils.randomAlphabetic(255).length());
        data = registrationPage.mainInfoRegistration();
        data.put("comments", RandomStringUtils.randomAlphanumeric(1001));
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
        AssertCollector.assertEquals(registrationPage.comments.getAttribute("value").length(),
                " Number of symbols is equal ", RandomStringUtils.randomAlphabetic(1000).length());
    }

    //not pass due validation
    @Test(enabled = false)
    public void verifyMaximumInputAddressFieldTest() {
        TestReporter.testTitle("Test ID = 40065,37421");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("address", RandomStringUtils.randomAlphanumeric(256));
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
        AssertCollector.assertTrue(registrationPage.address.getAttribute("value").length()
                == RandomStringUtils.randomAlphabetic(255).length());
        data = registrationPage.mainInfoRegistration();
        data.put("address", "Тульская обл, г Новомосковск, пр-кт Победы, д 5");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Внимание! Вы не указали номер квартиры, офиса."));
        data = registrationPage.mainInfoRegistration();
        data.put("address", "Тульская обл, г Новомосковск, пр-кт Победы, д 5, кв 5");
        AssertCollector.assertFalse(registrationPage.verifyAuthorizationFields(data).
                contains("Внимание! Вы не указали номер квартиры, офиса."));
    }
}
