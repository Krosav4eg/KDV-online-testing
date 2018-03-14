package KDV_testcases.registration.IndividualEntrepreneur;

import Core.utils.TestReporter;
import KDV_testcases.base.BaseTest;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;


public class OrganizationInfoTest extends BaseTest {

    @Test
    public void verifyIncorrectInnValueTest() {
        TestReporter.testTitle("Test ID = 37574");
        registrationPage.verifyIndividualEntrepreneurRadioButton();
        JSONObject data = registrationPage.mainInfoRegistration();
        data.put("taxId", RandomStringUtils.randomNumeric(9));
        registrationPage.taxpayerIdMustContain10Symbols(data);
    }
}
