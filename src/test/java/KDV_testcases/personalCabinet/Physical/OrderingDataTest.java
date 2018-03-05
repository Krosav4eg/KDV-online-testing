package KDV_testcases.personalCabinet.Physical;

import Core.basePage.BasePage;
import org.json.JSONObject;
import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.TestReporter;

import static Core.utils.Constants.KALASHNIKOVA_EMAIL;
import static Core.utils.Constants.KALASHNIKOVA_PASSWORD;

public class OrderingDataTest extends BaseTest {

	BasePage.MyDelegate del = new BasePage.MyDelegate() {
	};

	@Test
	public void verifyOpeningMyBookingItemPersonalTest() {
		TestReporter.testTitle("Test ID = 40112");
		JSONObject data = authorizationPage.mainAuthorizationInfo();
		data.put("email", KALASHNIKOVA_EMAIL);
		data.put("password", KALASHNIKOVA_PASSWORD);
		authorizationPage.verifyAuthFields(data);
		orderingGuestPage.clickOnWebElement(myBookingPage.myBookingsItemButton);
		del.textPresentDelegate("Мои заказы");
		del.textPresentDelegate("У вас пока нет оформленных заказов.");
	}
}
