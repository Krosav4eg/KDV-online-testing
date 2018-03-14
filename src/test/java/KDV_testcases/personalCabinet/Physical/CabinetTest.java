package KDV_testcases.personalCabinet.Physical;

import org.json.JSONObject;
import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.TestReporter;

import static Core.utils.Constants.*;

public class CabinetTest extends BaseTest {

    // TODO: 12.01.2018 C38045 take id from DB
    @Test
    public void verifyAccountAndAddressByDefaultTest() {
        TestReporter.testTitle("Test ID = 38062-38066,38196-38200");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", AUTHORIZATION_EMAIL);
        data.put("password", AUTHORIZATION_PASSWORD);
        authorizationPage.verifyAuthFields(data);
        controlPanelPage.verifyAccountAndAddressByDefault();
       }

    @Test
    public void verifyControlPanelTest() {
        TestReporter.testTitle("Test ID = 37820,37821,37822");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", PHYSICAL_PERSON_EMAIL);
        data.put("password", PHYSICAL_PERSON_PASSWORD);
        authorizationPage.verifyAuthFields(data);
        controlPanelPage.verifyControlPanel();
    }
}
