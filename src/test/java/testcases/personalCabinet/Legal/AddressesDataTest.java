package testcases.personalCabinet.Legal;

import org.json.JSONObject;
import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;

import static utils.Constants.FADEEV_EMAIL;
import static utils.Constants.FADEEV_PASSWORD;

public class AddressesDataTest extends BaseTest {

	@Test
	public void verifyCardApprovedAndEdit() {
		TestReporter.testTitle("Test ID = 41697");
		JSONObject data = authorizationPage.mainAuthorizationInfo();
		data.put("email",FADEEV_EMAIL);
		data.put("password", FADEEV_PASSWORD);
		authorizationPage.verifyAuthFields(data);
		deliveryAddressPage.verifyCardApprovedAddress();
	}

	@Test
	public void verifyCardNotApproved() {
		TestReporter.testTitle("Test ID = 41627");
		JSONObject data = authorizationPage.mainAuthorizationInfo();
		data.put("email", FADEEV_EMAIL);
		data.put("password",FADEEV_PASSWORD);
		authorizationPage.verifyAuthFields(data);
		deliveryAddressPage.verifyCardNotApprovedAddress();
	}

	@Test
	public void verifyAddNewApproved() {
		TestReporter.testTitle("Test ID = 41762");
		JSONObject data = authorizationPage.mainAuthorizationInfo();
		data.put("email",FADEEV_EMAIL);
		data.put("password", FADEEV_PASSWORD);
		authorizationPage.verifyAuthFields(data);
		deliveryAddressPage.addAddresses();
	}

	@Test
	public void verifyApprovedAddresses() {
		TestReporter.testTitle("Test ID = 41945");
		JSONObject data = authorizationPage.mainAuthorizationInfo();
		data.put("email",FADEEV_EMAIL);
		data.put("password", FADEEV_PASSWORD);
		authorizationPage.verifyAuthFields(data);
		deliveryAddressPage.verifyCardApprovedAddress();
	}
}
