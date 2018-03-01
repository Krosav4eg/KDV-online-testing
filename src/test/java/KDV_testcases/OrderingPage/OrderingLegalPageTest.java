package KDV_testcases.OrderingPage;

import Core.basePage.BasePage;
import Core.utils.WaitingUtility;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.AssertCollector;
import Core.utils.TestReporter;

import static Core.utils.Constants.*;


public class OrderingLegalPageTest extends BaseTest {
    private BasePage.MyDelegate del = new BasePage.MyDelegate() {
    };

    @Test
    public void verifyCreateOrderWithDefaultAddressTest() {
        TestReporter.testTitle("Test ID = 41799");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", FADEEV_EMAIL);
        data.put("password", FADEEV_PASSWORD);
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
                FADEEV_PHONE, "Phones correct");
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
        WaitingUtility.elementFluentWaitVisibility(orderingLegalPage.orderLink);
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
    public void verifyCreateOrderWithChangingAddressTest() {
        TestReporter.testTitle("Test ID = 41801");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", FADEEV_EMAIL);
        data.put("password", FADEEV_PASSWORD);
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
        WaitingUtility.elementFluentWaitVisibility(orderingLegalPage.orderLink);
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
    public void verifyCreateOrderWithThirdAddressTest() {
        TestReporter.testTitle("Test ID = 41826");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", FADEEV_EMAIL);
        data.put("password", FADEEV_PASSWORD);
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
        orderingGuestPage.clickOnWebElement(orderingLegalPage.thirdAddressDropDownList);

        String currentName = del.getValueOfAttributeByName(orderingGuestPage.firstNameTxt, "value");
        AssertCollector.assertEqualsJ(currentName, "Павел",
                "First name is correct");

        AssertCollector.assertEqualsJ(del.getValueOfAttributeByName(orderingGuestPage.lastNameTxt, "value"),
                "Белоусов", "Last name is correct");

        AssertCollector.assertEqualsJ(del.getValueOfAttributeByName(orderingGuestPage.phoneTxt, "value"),
                FADEEV_PHONE, "Phones correct");

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
        WaitingUtility.elementFluentWaitVisibility(orderingLegalPage.orderLink);
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
    public void verifyCreateOrderWithoutLAstNadFirstNameFields() {
        TestReporter.testTitle("Test ID = 42013");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", FADEEV_EMAIL);
        data.put("password", FADEEV_PASSWORD);
        authorizationPage.verifyAuthFields(data);
        orderingLegalPage.createOrderForLegalPerson();
        JSONObject data1 = orderingLegalPage.data();
        data1.put("firstName", "");
        data1.put("lastName", "");
        data1.put("phone", "");
        orderingLegalPage.deliveryAddressBlock(data1);
        orderingGuestPage.clickOnWebElement(orderingGuestPage.createOrderButton);
        AssertCollector.assertTrue(orderingGuestPage.firstNameFieldAdvice.isDisplayed(),
                "Error Message is displayed");
        AssertCollector.assertTrue(orderingGuestPage.lastNameFieldAdvice.isDisplayed(),
                "Error Message is displayed");
        AssertCollector.assertTrue(orderingGuestPage.phoneFieldAdvice.isDisplayed(),
                "Error Message is displayed");
        JSONObject data2 = orderingLegalPage.data();
        data2.put("firstName", RandomStringUtils.randomAlphabetic(45));
        data2.put("lastName", RandomStringUtils.randomAlphabetic(45));
        data2.put("phone", "7111111");
        orderingLegalPage.deliveryAddressBlock(data2);
        orderingGuestPage.clickOnWebElement(orderingGuestPage.createOrderButton);
        WaitingUtility.elementFluentWaitVisibility(orderingGuestPage.phoneNotice);
        AssertCollector.assertTrue(orderingGuestPage.phoneNotice.isDisplayed(),
                "Error Message is displayed");
    }
}
