package testcases.registration.IndividualEntrepreneur;

import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.AssertCollector;
import utils.TestReporter;


public class OrganizationInfoTest extends BaseTest {

    @Test
    public void verifyIncorrectInnValueTest() {
        TestReporter.testTitle("Test ID = 37574");
        registrationPage.verifyIndividualEntrepreneurRadioButton();
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("taxId", RandomStringUtils.randomNumeric(9));
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).
                contains("Значение \"ИНН\" должно содержать 10 символов."));
    }
}
