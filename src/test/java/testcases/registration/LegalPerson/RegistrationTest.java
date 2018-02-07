package testcases.registration;

import Core.basePage.BasePage;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.AssertCollector;
import utils.TestReporter;

import static utils.Constants.AUTORIZATION_PAGE_URL;


public class RegistrationTest extends BaseTest {

    private BasePage.MyDelegate del2 = new BasePage.MyDelegate() {
    };

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
      public void verifyCheckboxConfirmPresenceTest() {
        TestReporter.testTitle("Test ID = 37354");
        registrationPage.verifyCheckboxConfirmPresence();
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
    //not pass due validation in both fields
    @Test
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
    @Test
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
    @Test
    public void verifyMaximumInputAddressFieldTest() {
        TestReporter.testTitle("Test ID = 40065,37421");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("address", RandomStringUtils.randomAlphanumeric(256));
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
        AssertCollector.assertEquals(registrationPage.address.getAttribute("value").length(),
                " Number of symbols is equal ", RandomStringUtils.randomAlphabetic(255).length());
        data = registrationPage.mainInfoRegistration();
        data.put("address", "Тульская обл, г Новомосковск, пр-кт Победы, д 5");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Внимание! Вы не указали номер квартиры, офиса."));
        data = registrationPage.mainInfoRegistration();
        data.put("address", "Тульская обл, г Новомосковск, пр-кт Победы, д 5, кв 5");
        AssertCollector.assertFalse(registrationPage.verifyAuthorizationFields(data).
                contains("Внимание! Вы не указали номер квартиры, офиса."));
    }

    //not pass due validation in all fields
    @Test
    public void verifyMaximumInputLengthFirstAndLastNameFieldTest() {
        TestReporter.testTitle("Test ID = 40067");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("firstName", RandomStringUtils.randomAlphanumeric(46));
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
        AssertCollector.assertEquals(registrationPage.firstName.getAttribute("value").length(),
                " Number of symbols is equal ", RandomStringUtils.randomAlphabetic(45).length());
        data = registrationPage.mainInfoRegistration();
        data.put("lastName", RandomStringUtils.randomAlphanumeric(46));
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
        AssertCollector.assertEquals(registrationPage.lastName.getAttribute("value").length(),
                " Number of symbols is equal ", RandomStringUtils.randomAlphabetic(45).length());
        data = registrationPage.mainInfoRegistration();
        data.put("firstName", "Анна-Мар'я" + RandomStringUtils.randomAlphanumeric(36));
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
        AssertCollector.assertEquals(registrationPage.firstName.getAttribute("value"),
                " Value of last name is equal ", registrationPage.firstName.getAttribute("value"));
        data = registrationPage.mainInfoRegistration();
        data.put("lastName", "Анна-Мар'я" + RandomStringUtils.randomAlphanumeric(36));
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
        AssertCollector.assertEquals(registrationPage.lastName.getAttribute("value"),
                " Value of last name is equal ", registrationPage.lastName.getAttribute("value"));
    }

    @Test
    public void verifyEmailFieldValidationTest() {
        TestReporter.testTitle("Test ID = 40069,40072,40074,40076,40077");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("email", "test@test.com");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
        AssertCollector.assertEquals(registrationPage.email.getAttribute("value"),
                " Value of email field is equal ", registrationPage.email.getAttribute("value"));
        data = registrationPage.mainInfoRegistration();
        data.put("password", RandomStringUtils.randomAlphanumeric(7));
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
        AssertCollector.assertEquals(registrationPage.password.getAttribute("value").length(),
                " Number of symbols is equal ", RandomStringUtils.randomAlphabetic(7).length());
        data = registrationPage.mainInfoRegistration();
        data.put("confirmPassword", RandomStringUtils.randomAlphanumeric(7));
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения."));
        AssertCollector.assertEquals(registrationPage.confirmPassword.getAttribute("value").length(),
                " Number of symbols is equal ", RandomStringUtils.randomAlphabetic(7).length());
    }

    @Test
    public void verifyPhoneFieldValidationTest() {
        TestReporter.testTitle("Test ID = 40068");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("phone", RandomStringUtils.randomAlphanumeric(10));
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения"));
        AssertCollector.assertEquals(registrationPage.phone.getAttribute("value"),
                " Value of email field is equal ", registrationPage.phone.getAttribute("value"));
    }

    @Test
    public void verifySuccessRegistrationTest() {
        TestReporter.testTitle("Test ID = 37564,37565,37485,37397,37681,37571,37572,37416,37479,37423,37567");
        JSONObject data = registrationPage.mainInfoRegistration();
        AssertCollector.verifyCondition(registrationPage.verifyAuthorizationFields(data).
                contains("Это поле обязательно для заполнения"));
        del2.textPresentDelegate("Требуется подтверждение учётной записи. Ссылка для подтверждения была" +
                " выслана на указанный адрес электронной почты. Чтобы выслать ссылку повторно нажмите сюда.");
        AssertCollector.assertEqualsJ(del2.getCurrentUrlDelegate(), AUTORIZATION_PAGE_URL, "Urls are equals");
    }
}

