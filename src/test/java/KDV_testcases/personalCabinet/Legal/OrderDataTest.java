package KDV_testcases.personalCabinet.Legal;

import org.json.JSONObject;
import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.TestReporter;

import static Core.utils.Constants.*;

public class OrderDataTest extends BaseTest{
	@Test
	public void verifyMyOrder() {
		TestReporter.testTitle("Test ID = 41792");
		JSONObject data = authorizationPage.mainAuthorizationInfo();
		data.put("email", FADEEV_EMAIL);
		data.put("password", FADEEV_PASSWORD);
		authorizationPage.verifyAuthFields(data);
	}

	@Test
	public void verifyMyOrderEmptyKist() {
		TestReporter.testTitle("Test ID = 41936");
		JSONObject data = authorizationPage.mainAuthorizationInfo();
		data.put("email", FADEEV_EMAIL);
		data.put("password", FADEEV_PASSWORD);
		authorizationPage.verifyAuthFields(data);
	}
}
