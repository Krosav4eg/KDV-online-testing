package KDV_testcases.personalCabinet.Physical;

import org.json.JSONObject;
import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.TestReporter;

import static Core.utils.Constants.*;

public class AddressesDataTest extends BaseTest {

    @Test
    public void verifyOpeningAddressItemPersonalTest() {
        TestReporter.testTitle("Test ID = 38710");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", PONOMAREVA_EMAIL);
        data.put("password", PONOMAREVA_PASSWORD);
        authorizationPage.verifyAuthFields(data);
        authorizationPage.navigateToUrl(ACCOUNT_DELIVERY_ADDRESS_URL);
        deliveryAddressPage.verifyDeliveryAddressHeader();
    }

    @Test
    public void verifyAbsenceDeliveryAddressItemPersonalTest() {
        TestReporter.testTitle("Test ID = 38458");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", BOLSHAKOV_EMAIL);
        data.put("password", BOLSHAKOV_PASSWORD);
        authorizationPage.verifyAuthFields(data);
        deliveryAddressPage.verifyAbsenceDeliveryAddress();
    }

    @Test
    public void verifyOneDeliveryAddressItemPersonalTest() {
        TestReporter.testTitle("Test ID = 38722,38728");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", BOLSHAKOV_EMAIL);
        data.put("password", BOLSHAKOV_PASSWORD);
        authorizationPage.verifyAuthFields(data);
        deliveryAddressPage.verifyAbsenceDeliveryAddress();
    }

    @Test
    public void verifyChangingDeliveryAddressPersonalTest() {
        TestReporter.testTitle("Test ID = 40110");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", ZUEV_EMAIL);
        data.put("password", ZUEV_PASSWORD);
        authorizationPage.verifyAuthFields(data);
        deliveryAddressPage.verifyChangingDeliveryAddress();
    }
}
