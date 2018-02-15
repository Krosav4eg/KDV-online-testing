package testcases.personalCabinet.Physical;

import Core.basePage.BasePage;
import org.json.JSONObject;
import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.AssertCollector;
import utils.TestReporter;

import static utils.Constants.*;
import static utils.Constants.ACCOUNT_INFORMATION_URL;
import static utils.Constants.ZUEV_PASSWORD;
import static utils.WaitingUtility.elementIsVisible;

public class AddressesDataTest extends BaseTest {

	BasePage.MyDelegate del = new BasePage.MyDelegate() {
	};

	@Test
	public void verifyOpeningAddressItemPersonalTest() {
		TestReporter.testTitle("Test ID = 38710");
		JSONObject data = authorizationPage.mainAuthorizationInfo();
		data.put("email", PONOMAREVA_EMAIL);
		data.put("password", PONOMAREVA_PASSWORD);//"ztq0d9e6"
		authorizationPage.verifyAuthFields(data);
		del.getUrlDelegate(ACCOUNT_DELIVERY_ADDRESS_URL);
		AssertCollector.assertEqualsJ(del.getCurrentUrlDelegate(), ACCOUNT_DELIVERY_ADDRESS_URL, "Urls are equals");
		AssertCollector.assertTrue(elementIsVisible( deliveryAddressPage.deliveryAddressHeader),
				"Required header is displayed");
	}

	@Test
	public void verifyAbsenceDeliveryAddressItemPersonalTest() {
		TestReporter.testTitle("Test ID = 38458");
		JSONObject data = authorizationPage.mainAuthorizationInfo();
		data.put("email", MAKAROVA_EMAIL);
		data.put("password", MAKAROVA_PASSWORD);
		authorizationPage.verifyAuthFields(data);
		orderingGuestPage.clickOnWebElement(deliveryAddressPage.deliveryAddressItemButton);
		AssertCollector.assertEqualsJ(del.getCurrentUrlDelegate(), ACCOUNT_DELIVERY_ADDRESS_URL +
				"new/", "Urls are equals");
	}

	@Test
	public void verifyOneDeliveryAddressItemPersonalTest() {
		TestReporter.testTitle("Test ID = 38722,38728");
		JSONObject data = authorizationPage.mainAuthorizationInfo();
		data.put("email",BOLSHAKOV_EMAIL);
		data.put("password", BOLSHAKOV_PASSWORD);
		authorizationPage.verifyAuthFields(data);
		orderingGuestPage.clickOnWebElement(deliveryAddressPage.deliveryAddressItemButton);
		AssertCollector.assertEqualsJ(deliveryAddressPage.nameDeliveryByDefault.getText(), "Тимофей Большаков",
				"First name and last name are equals");
		AssertCollector.assertEqualsJ(deliveryAddressPage.deliveryAddressByDefault.getText(),
				"г Томск, ул Вавилова, д 13, кв 23",
				"Addresses are equals");
		AssertCollector.assertEqualsJ(deliveryAddressPage.phoneDeliveryByDefault.getText(), "+71111111111",
				"Phone numbers are equals");
			AssertCollector.assertTrue(elementIsVisible(deliveryAddressPage.byDefaultMark));
		orderingGuestPage.clickOnWebElement(deliveryAddressPage.addressActionLink);
		AssertCollector.assertEqualsJ(del.getCurrentUrlDelegate(), ACCOUNT_DELIVERY_ADDRESS_URL + "edit/id/4236/",
				"Urls are equals");
		AssertCollector.assertEqualsJ(deliveryAddressPage.firstNameInEditDeliveryPage.getAttribute("value"),
				"Тимофей", "First names are correct");
		AssertCollector.assertEqualsJ(deliveryAddressPage.lastNameInEditDeliveryPage.getAttribute("value"),
				"Большаков", "Last names are correct");
		AssertCollector.assertEqualsJ(deliveryAddressPage.phoneInEditDeliveryPage.getAttribute("value"),
				"+71111111111", "Phone numbers are equals");
		AssertCollector.assertEqualsJ(deliveryAddressPage.addressInEditDeliveryPage.getAttribute("value"),
				"г Томск, ул Вавилова, д 13, кв 23", "Addresses are equals");
		AssertCollector.assertEqualsJ(deliveryAddressPage.florInEditDeliveryPage.getAttribute("value"),
				"1", "Flores are equals");
		AssertCollector.assertEqualsJ(deliveryAddressPage.porchInEditDeliveryPage.getAttribute("value"),
				"2", "Porches are equals");
	}

	@Test
	public void verifyChangingDeliveryAddressPersonalTest() {
		TestReporter.testTitle("Test ID = 40110");
		JSONObject data = authorizationPage.mainAuthorizationInfo();
		data.put("email", ZUEV_EMAIL);
		data.put("password", ZUEV_PASSWORD);
		authorizationPage.verifyAuthFields(data);
		orderingGuestPage.clickOnWebElement(deliveryAddressPage.editDeliveryLink);
		AssertCollector.assertEqualsJ(del.getCurrentUrlDelegate(), ACCOUNT_INFORMATION_URL, "Urls are equals");
	}

}
