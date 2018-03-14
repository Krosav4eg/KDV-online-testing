package KDV_testcases.registration.LegalPerson;

import Core.utils.TestReporter;
import KDV_testcases.base.BaseTest;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class DeliveryAddressTest extends BaseTest {

    @Test
    public void verifyRegistrationComponentTest() {
        TestReporter.testTitle("Test ID = 37551,37552,37553,40279,40280,40281");
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("legalAddress", "");
        registrationPage.fieldNecessaryToFillInWithData(data);
        data = registrationPage.mainInfoRegistration();
        data.put("company", "");
        registrationPage.fieldNecessaryToFillInWithData(data);
        data = registrationPage.mainInfoRegistration();
        data.put("address", "");
        registrationPage.fieldNecessaryToFillInWithData(data);
    }
}
