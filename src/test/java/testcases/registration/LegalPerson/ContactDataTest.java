package testcases.registration.LegalPerson;

import org.json.JSONObject;
import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.AssertCollector;
import utils.TestReporter;

public class ContactDataTest extends BaseTest {

    @Test
    public void verifyMandatoryEmptyFirstNameTest() {
        TestReporter.testTitle("Test ID = C37688,40272,40275");
        JSONObject verifyData=registrationPage.mainInfoRegistration();
        verifyData.put("firstName","");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFieldsIndividual(verifyData).
                contains("Это поле обязательно для заполнения."));
    }
}
