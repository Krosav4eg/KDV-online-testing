package KDV_testcases.registration.LegalPerson;

import org.json.JSONObject;
import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.AssertCollector;
import Core.utils.TestReporter;

public class DeliveryAddressTest extends BaseTest {

    @Test
    public void verifyRegistrationComponentTest() {
        TestReporter.testTitle("Test ID = 37551,37552,37553,40279,40280,40281");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("legalAddress", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));
        data = registrationPage.mainInfoRegistration();
        data.put("company", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));
        data = registrationPage.mainInfoRegistration();
        data.put("address", "");
        AssertCollector.assertTrue(registrationPage.verifyAuthorizationFields(data).contains("Это поле обязательно для заполнения."));
    }
}
