package testcases.OrderingPage;

import org.json.JSONObject;
import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;

public class OrderingPage extends BaseTest{
	@Test
	public void switchSlideForwardTest() {
		TestReporter.testTitle("Test ID - C41074");
		JSONObject data= orderingGuest.data();
		orderingGuest.createOrder(data);
	}
}
