package KDV_testcases.personalCabinet.Legal;

import org.json.JSONObject;
import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.TestReporter;

import static Core.utils.Constants.*;

public class LegalDataTest extends BaseTest {

    @Test
    public void verifyFieldsNotApprovedUser() {
        TestReporter.testTitle("Test ID = 41510");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", "test_a.grigoriev@magdv.com");
        data.put("password", "vDBAwk");
        authorizationPage.verifyAuthFields(data);
        personalCabinetPage.verifyFieldsNotAuthorization();
    }

    @Test
    public void verifyFieldsApprovedUser() {
        TestReporter.testTitle("Test ID = 41521");
        JSONObject data = personalCabinetPage.mainAccountInfo();
        data.put("email", FADEEV_EMAIL);
        data.put("password", FADEEV_PASSWORD);
        authorizationPage.verifyAuthFields(data);
        personalCabinetPage.verifyFieldsAuthorization();
    }

    @Test
    public void verifyFieldsNotApprovedUserInfo() {
        TestReporter.testTitle("Test ID = 41522");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", "test_a.grigoriev@magdv.com");
        data.put("password", "vDBAwk");
        authorizationPage.verifyAuthFields(data);
        personalCabinetPage.verifyFieldsNotAuthorizationInfo();
    }

    @Test
    public void verifyFieldsApprovedUserInfo() {
        TestReporter.testTitle("Test ID = 41524");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", "test_g.fadeev@magdv.com");
        data.put("password", "gctbVY");
        authorizationPage.verifyAuthFields(data);
        personalCabinetPage.verifyFieldsAuthorizationInfo();
    }
}
