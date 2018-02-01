package testcases.OrderingPage;

import Core.basePage.BasePage;
import org.json.JSONObject;
import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.AssertCollector;
import utils.TestReporter;

import static utils.Constants.BASE_URL;


public class OrderingLegalPageTest extends BaseTest {
    BasePage.MyDelegate del = new BasePage.MyDelegate() {
    };

    @Test
    public void verifyCreateOrderWithDefaultAddress() {
        TestReporter.testTitle("Test ID = 41799");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", "test_g.fadeev@magdv.com");
        data.put("password", "gctbVY");
        authorizationPage.verifyAuthFields(data);
        orderingLegalPage.createOrderForLegalPerson();
        AssertCollector.assertEqualsJ(customerAccountPage.myAccountLink.getText(), "ООО Юрмет",
                "Company name is correct");
        del.textPresentDelegate("Адреса доставки (Торговые точки)");
        AssertCollector.assertTrue(orderingLegalPage.deliveryAddress.getText().contains("Томск, Иркутский тракт 114/1"),
                "Address is correct");
        orderingGuestPage.clickOnWebElement(orderingLegalPage.deliveryAddress);
        AssertCollector.assertTrue(orderingLegalPage.addressDropDownArea.isDisplayed(),
                "Address dropdown list is appear");
        orderingGuestPage.clickOnWebElement(orderingLegalPage.deliveryAddress);

        String currentName = del.getValueOfAttributeByName(orderingGuestPage.firstNameTxt, "value");
        AssertCollector.assertEqualsJ(currentName, "Илья",
                "First name is correct");

        AssertCollector.assertEqualsJ(del.getValueOfAttributeByName(orderingGuestPage.lastNameTxt, "value"),
                "Панфилов", "Last name is correct");

        AssertCollector.assertEqualsJ(del.getValueOfAttributeByName(orderingGuestPage.phoneTxt, "value"),
                "+71111111111", "Phones correct");

        AssertCollector.assertTrue(orderingLegalPage.transportDescription.getText().
                contains("Доставка грузовым транспортом: 0,00"), "Correct value");
        orderingGuestPage.clickOnWebElement(orderingGuestPage.createOrderButton);

        del.textPresentDelegate("Обработка, пожалуйста, подождите. Не нажимайте на обновление или кнопку" +
                " назад иначе этот заказ не будет оформлен.");
        del.textPresentDelegate("Ваш заказ принят.");
        del.textPresentDelegate("Спасибо за покупку!");
        del.textPresentDelegate("Вы получите письмо на ваш адрес электронной почты (email) с подробной " +
                "информацией о заказе и ссылкой на страницу, на которой можно проверить текущий статус заказа.\n" +
                "\n" +
                "Будем благодарны, если при оплате наличными Вы подготовите сумму без сдачи.");

        String orderNumberActual = orderingLegalPage.orderLink.getText();
        orderingGuestPage.clickOnWebElement(orderingLegalPage.continueShoppingButton);

        AssertCollector.assertEqualsJ(del.getCurrentUrlDelegate(),
                BASE_URL + "/", "Urls are equals");

        orderingGuestPage.clickOnWebElement(customerAccountPage.myAccountLink);

        AssertCollector.assertEqualsJ(del.getCurrentUrlDelegate(),
                BASE_URL + "/customer/account", "Urls are equals");
        del.getUrlDelegate(BASE_URL + "/sales/order/history/");

        AssertCollector.assertEqualsJ(orderNumberActual, orderingLegalPage.
                        getElementTextFromList(orderingLegalPage.orderNumberInList, 0).substring(2, 12)
                , "Number orders are equals");
    }

    @Test
    public void verifyCreateOrderWithChangingAddress() {
        TestReporter.testTitle("Test ID = 41801");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", "test_g.fadeev@magdv.com");
        data.put("password", "gctbVY");
        authorizationPage.verifyAuthFields(data);
        orderingLegalPage.createOrderForLegalPerson();
        AssertCollector.assertEqualsJ(customerAccountPage.myAccountLink.getText(), "ООО Юрмет",
                "Company name is correct");
        del.textPresentDelegate("Адреса доставки (Торговые точки)");
        AssertCollector.assertTrue(orderingLegalPage.deliveryAddress.getText().contains("Томск, Иркутский тракт 114/1"),
                "Address is correct");
        orderingGuestPage.clickOnWebElement(orderingLegalPage.deliveryAddress);
        AssertCollector.assertTrue(orderingLegalPage.addressDropDownArea.isDisplayed(),
                "Address dropdown list is appear");
        orderingGuestPage.clickOnWebElement(orderingLegalPage.secondAddressDropDownList);

        String currentName = del.getValueOfAttributeByName(orderingGuestPage.firstNameTxt, "value");
        AssertCollector.assertEqualsJ(currentName, "Софья",
                "First name is correct");

        AssertCollector.assertEqualsJ(del.getValueOfAttributeByName(orderingGuestPage.lastNameTxt, "value"),
                "Стрелкова", "Last name is correct");

        AssertCollector.assertEqualsJ(del.getValueOfAttributeByName(orderingGuestPage.phoneTxt, "value"),
                "+72222222222", "Phones correct");

        AssertCollector.assertTrue(orderingLegalPage.transportDescription.getText().
                contains("Доставка грузовым транспортом: 0,00"), "Correct value");
        orderingGuestPage.clickOnWebElement(orderingGuestPage.createOrderButton);

        del.textPresentDelegate("Обработка, пожалуйста, подождите. Не нажимайте на обновление или кнопку" +
                " назад иначе этот заказ не будет оформлен.");
        del.textPresentDelegate("Ваш заказ принят.");
        del.textPresentDelegate("Спасибо за покупку!");
        del.textPresentDelegate("Вы получите письмо на ваш адрес электронной почты (email) с подробной " +
                "информацией о заказе и ссылкой на страницу, на которой можно проверить текущий статус заказа.\n" +
                "\n" +
                "Будем благодарны, если при оплате наличными Вы подготовите сумму без сдачи.");

        String orderNumberActual = orderingLegalPage.orderLink.getText();
        orderingGuestPage.clickOnWebElement(orderingLegalPage.continueShoppingButton);

        AssertCollector.assertEqualsJ(del.getCurrentUrlDelegate(),
                BASE_URL + "/", "Urls are equals");

        orderingGuestPage.clickOnWebElement(customerAccountPage.myAccountLink);

        AssertCollector.assertEqualsJ(del.getCurrentUrlDelegate(),
                BASE_URL + "/customer/account", "Urls are equals");
        del.getUrlDelegate(BASE_URL + "/sales/order/history/");

        AssertCollector.assertEqualsJ(orderNumberActual, orderingLegalPage.
                        getElementTextFromList(orderingLegalPage.orderNumberInList, 0).substring(2, 12)
                , "Number orders are equals");
    }
}
