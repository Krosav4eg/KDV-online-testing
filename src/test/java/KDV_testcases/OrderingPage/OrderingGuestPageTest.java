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
import static Core.utils.Constants.BASE_URL;

public class OrderingGuestPageTest extends BaseTest {

    private BasePage.MyDelegate del = new BasePage.MyDelegate() {
    };

    @Test
    public void verifyAuthorizationLInkTest() {
        TestReporter.testTitle("Test ID - C41075");
        JSONObject data = orderingGuestPage.data();
        orderingGuestPage.createOrder(data);
        orderingGuestPage.modalAuthLink.click();
        AssertCollector.assertTrue(orderingGuestPage.modalAuthForm.isDisplayed(),
                "Modal authorization form is appear");
        orderingGuestPage.closeModalButton.click();
        orderingGuestPage.modalAuthLink.click();
        JSONObject data1 = orderingGuestPage.authModalFormData();
        orderingGuestPage.authorizationBlockModalWindow(data1);
        AssertCollector.verifyCondition(del.getCurrentUrlDelegate().equals(BASE_URL + "/onestepcheckout/"));
        AssertCollector.verifyCondition(customerAccountPage.myAccountLink.getText().contains("Зуев Степан"));
    }

    @Test
    public void verifyAuthModalWindowTest() {
        TestReporter.testTitle("Test ID - C41076");
        JSONObject data = orderingGuestPage.data();
        orderingGuestPage.createOrder(data);
        orderingGuestPage.modalAuthLink.click();
        orderingGuestPage.clickOnWebElement(orderingGuestPage.authEnterButton);
        AssertCollector.assertTrue(orderingGuestPage.errorText.isDisplayed(), "Required text is present");
        JSONObject data2 = orderingGuestPage.authModalFormData();
        data2.put("email", "");
        data2.put("password", "YZde8m");
        orderingGuestPage.authorizationBlockModalWindow(data2);
        orderingGuestPage.clickOnWebElement(orderingGuestPage.closeModalButton);
        orderingGuestPage.clickOnWebElement(orderingGuestPage.modalAuthLink);
        AssertCollector.assertTrue(orderingGuestPage.errorText.isDisplayed(), "Required text is present");
        data2 = orderingGuestPage.authModalFormData();
        data2.put("email", "test_s.zuevmagdv.com");
        data2.put("password", "YZde8m");
        orderingGuestPage.authorizationBlockModalWindow(data2);
        AssertCollector.assertTrue(orderingGuestPage.errorText.isDisplayed(), "Required text is present");
    }

    //problem with validation length and validation message in first name and last name fields
    @Test
    public void verifyCheckAndInputValueTest() {
        TestReporter.testTitle("Test ID - C41062,40067,41064");
        JSONObject data = orderingGuestPage.data();
        orderingGuestPage.createOrder(data);
        data.put("firstName", "Анна-Мар'я" + RandomStringUtils.randomAlphabetic(35));
        data.put("lastName", "Анна-Мар'я" + RandomStringUtils.randomAlphabetic(35));
        orderingGuestPage.identificationBlock(data);
        AssertCollector.assertEquals(orderingGuestPage.firstNameTxt.getAttribute("value").length(),
                " Number of symbols is equal ", RandomStringUtils.randomAlphabetic(45).length());
        AssertCollector.assertEquals(orderingGuestPage.lastNameTxt.getAttribute("value").length(),
                " Number of symbols is equal ", RandomStringUtils.randomAlphabetic(45).length());
        orderingGuestPage.createOrderButton.click();
        AssertCollector.assertTrue(!orderingGuestPage.identificationBlock(data).
                contains("Пожалуйста, введите правильный адрес электронной почты (email). " +
                        "Например, ivanivanov@domain.com."));
        AssertCollector.assertEquals(orderingGuestPage.phoneTxt.getAttribute("value").length(),
                " Number of phone symbols is equal ", RandomStringUtils.randomAlphabetic(12).length());
    }

    @Test
    public void verifyCheckBoxTest() {
        TestReporter.testTitle("Test ID - C41069");
        JSONObject data = orderingGuestPage.data();
        orderingGuestPage.createOrder(data);
        del.scrollByCoordinate();
        orderingGuestPage.regulationsWebsiteLink.click();
        del.switchDriverToAnyTabOfBrowser(SECOND_TAB_BROWSER);
        del.verifyTabsCountAsExpected(TWO_TABS_BROWSER);
        AssertCollector.verifyCondition(del.getCurrentUrlDelegate().equals(BASE_URL + "/regulations"));
        del.closeDriverToAnyTabOfBrowser(1);
        del.switchDriverToAnyTabOfBrowser(FIRST_TAB_BROWSER);
        orderingGuestPage.consentPersonalDataProcessingLink.click();
        del.switchDriverToAnyTabOfBrowser(SECOND_TAB_BROWSER);
        AssertCollector.verifyCondition(del.getCurrentUrlDelegate().equals(BASE_URL +
                "/media/rules/Consent_to_personal_data_processing.pdf"));
        del.closeDriverToAnyTabOfBrowser(1);
        del.switchDriverToAnyTabOfBrowser(FIRST_TAB_BROWSER);
        orderingGuestPage.salesPurchaseAgreementLink.click();
        del.switchDriverToAnyTabOfBrowser(SECOND_TAB_BROWSER);
        AssertCollector.verifyCondition(del.getCurrentUrlDelegate().equals(BASE_URL +
                "/media/rules/Sales_and_Purchase_Agreement.pdf"));
        del.closeDriverToAnyTabOfBrowser(1);
        del.switchDriverToAnyTabOfBrowser(FIRST_TAB_BROWSER);
    }

    //validation fail. address input value has more than 255 symbols
    @Test
    public void verifyCourierDeliveryTest() {
        TestReporter.testTitle("Test ID - C41072,41070");
        JSONObject data = orderingGuestPage.data();
        orderingGuestPage.createOrder(data);
        AssertCollector.verifyCondition(orderingGuestPage.courierDeliveryRadioButton.isEnabled());
        AssertCollector.assertTrue(orderingGuestPage.deliveryAddressField.getAttribute("placeholder").
                contains("Томск, пр. Мира 20, оф.4"));
        data = orderingGuestPage.deliveryFormData();
        data.put("address", "Томск, пр. Мира 20, оф.4");
        data.put("comment", RandomStringUtils.randomAlphabetic(256));
        orderingGuestPage.deliveryFormInfo(data);
        AssertCollector.assertEquals(orderingGuestPage.deliveryCommentField.getAttribute("value").length(),
                " Number of symbols is equal ", RandomStringUtils.randomAlphabetic(255).length());
    }

    @Test
    public void verifyCompositionOrderTest() {
        TestReporter.testTitle("Test ID - C41073");
        JSONObject data = orderingGuestPage.data();
        orderingGuestPage.createOrder(data);
        AssertCollector.assertTrue(orderingGuestPage.compositionOrderHeader.isDisplayed());
        AssertCollector.assertTrue(orderingGuestPage.editCompositionOrderHeader.isDisplayed());
        orderingGuestPage.clickOnWebElement(orderingGuestPage.editCompositionOrderHeader);
        AssertCollector.assertEqualsJ(del.getCurrentUrlDelegate(), BASE_URL + "/checkout/cart/",
                "Urls are equals");
        del.backPage();
        AssertCollector.assertEqualsJ(del.getCurrentUrlDelegate(), BASE_URL + "/onestepcheckout/",
                "Urls are equals");
        orderingGuestPage.clickOnWebElement(orderingGuestPage.reviewOrder);
        AssertCollector.verifyCondition(orderingGuestPage.reviewOrder.getText().contains("Название товара"));
        AssertCollector.verifyCondition(orderingGuestPage.reviewOrder.getText().contains("Цена"));
        AssertCollector.verifyCondition(orderingGuestPage.reviewOrder.getText().contains("Кол-во"));
        AssertCollector.verifyCondition(orderingGuestPage.reviewOrder.getText().contains("Итого"));
        AssertCollector.verifyCondition(orderingGuestPage.totalShipping.getText().contains("Доставка и обработка"));
        AssertCollector.verifyCondition(orderingGuestPage.totalShipping.getText().contains("0,00"));
        AssertCollector.verifyCondition(orderingGuestPage.compositionOrderLastRow.getText().contains("Итого к оплате"));
        String actualPrice = (orderingGuestPage.compositionOrderLastRow.getText().substring(15, 23));
        String expectedPrice = orderingGuestPage.totalPriceCompositionOrder.getText();
        AssertCollector.assertEqualsJ(actualPrice, expectedPrice, "Price from row and total price are equals");
    }

    //maximum length 46 symbols validation problem in delivery comment field
    @Test
    public void verifyCreationOrderAsGuestTest() {
        TestReporter.testTitle("Test ID - C41074,4075");
        JSONObject data = orderingGuestPage.data();
        orderingGuestPage.createOrder(data);
        data.put("firstName", RandomStringUtils.randomAlphabetic(46));
        data.put("lastName", RandomStringUtils.randomAlphabetic(46));
        orderingGuestPage.clickOnWebElement(orderingGuestPage.payBankCardRadioButton);
        AssertCollector.verifyCondition(orderingGuestPage.payBankCardRadioButton.isEnabled());
        del.scrollByCoordinate();
        data = orderingGuestPage.deliveryFormData();
        orderingGuestPage.deliveryFormInfo(data);
        orderingGuestPage.clickOnWebElement(orderingGuestPage.selfDeliveryRadioButton);
        AssertCollector.verifyCondition(orderingGuestPage.selfDeliveryRadioButton.isEnabled());
    }

    @Test
    public void verifyEmptyFirstAndLastNameTest() {
        TestReporter.testTitle("Test ID - C41078-40079");
        JSONObject data = orderingGuestPage.data();
        data.put("firstName", "");
        data.put("lastName", "");
        orderingGuestPage.createOrder(data);
        del.scrollByCoordinate();
        data = orderingGuestPage.deliveryFormData();
        orderingGuestPage.deliveryFormInfo(data);
        orderingGuestPage.clickOrderButton();
        AssertCollector.verifyCondition(orderingGuestPage.firstNameFieldAdvice.getText().
                contains("Это поле обязательно для заполнения."));
        AssertCollector.verifyCondition(orderingGuestPage.lastNameFieldAdvice.getText().
                contains("Это поле обязательно для заполнения."));
    }

    @Test
    public void verifyEmptyEmailFieldTest() {
        TestReporter.testTitle("Test ID - C41080");
        JSONObject data = orderingGuestPage.data();
        data.put("firstName", RandomStringUtils.randomAlphabetic(46));
        data.put("lastName", RandomStringUtils.randomAlphabetic(46));
        data.put("email", "");
        orderingGuestPage.createOrder(data);
        del.scrollByCoordinate();
        data = orderingGuestPage.deliveryFormData();
        orderingGuestPage.deliveryFormInfo(data);
        orderingGuestPage.clickOrderButton();
        AssertCollector.verifyCondition(orderingGuestPage.emailFieldAdvice.getText().
                contains("Это поле обязательно для заполнения."));
        data = orderingGuestPage.data();
        data.put("email", "a.shauloandersenlab.com");
        orderingGuestPage.identificationBlock(data);
        orderingGuestPage.clickOrderButton();
        AssertCollector.assertEqualsJ(orderingGuestPage.emailFieldAdvice.getText(),
                "Пожалуйста, введите правильный адрес электронной почты (email). Например, ivanivanov@domain.com.",
                "Error messages are equals");
        data = orderingGuestPage.data();
        data.put("email", "a.shaulo@andersenlabcom");
        orderingGuestPage.identificationBlock(data);
        orderingGuestPage.clickOrderButton();
        AssertCollector.assertEqualsJ(orderingGuestPage.emailFieldAdvice.getText(),
                "Пожалуйста, введите правильный адрес электронной почты (email). Например, ivanivanov@domain.com.",
                "Error messages are equals");
        data = orderingGuestPage.data();
        data.put("email", "a..shaulo@andersenlab.com");
        orderingGuestPage.identificationBlock(data);
        orderingGuestPage.clickOrderButton();
        AssertCollector.assertEqualsJ(orderingGuestPage.emailFieldAdvice.getText(),
                "Пожалуйста, введите правильный адрес электронной почты (email). Например, ivanivanov@domain.com.",
                "Error messages are equals");
        data = orderingGuestPage.data();
        data.put("email", "a.s ha ulo@andersenlab.com");
        orderingGuestPage.identificationBlock(data);
        orderingGuestPage.clickOrderButton();
        AssertCollector.assertEqualsJ(orderingGuestPage.emailFieldAdvice.getText(),
                "Пожалуйста, введите правильный адрес электронной почты (email). Например, ivanivanov@domain.com.",
                "Error messages are equals");
        data = orderingGuestPage.data();
        data.put("email", "a.shaulo@anders enlab.com");
        orderingGuestPage.identificationBlock(data);
        orderingGuestPage.clickOrderButton();
        AssertCollector.assertEqualsJ(orderingGuestPage.emailFieldAdvice.getText(),
                "Пожалуйста, введите правильный адрес электронной почты (email). Например, ivanivanov@domain.com.",
                "Error messages are equals");
    }

    @Test
    public void verifyEmptyPhoneAndAddressFieldsTest() {
        TestReporter.testTitle("Test ID - C41081-41082");
        JSONObject data = orderingGuestPage.data();
        data.put("firstName", RandomStringUtils.randomAlphabetic(46));
        data.put("lastName", RandomStringUtils.randomAlphabetic(46));
        data.put("email", "test@test.ru");
        data.put("phone", "");
        orderingGuestPage.createOrder(data);
        del.scrollByCoordinate();
        data = orderingGuestPage.deliveryFormData();
        data.put("address", "");
        orderingGuestPage.deliveryFormInfo(data);
        orderingGuestPage.clickOrderButton();
        AssertCollector.verifyCondition(orderingGuestPage.phoneFieldAdvice.getText().
                contains("Это поле обязательно для заполнения."));
        AssertCollector.verifyCondition(orderingGuestPage.addressFieldAdvice.getText().
                contains("Это поле обязательно для заполнения."));
        data = orderingGuestPage.data();
        data.put("phone", RandomStringUtils.randomNumeric(9));
        orderingGuestPage.identificationBlock(data);
        data = orderingGuestPage.deliveryFormData();
        data.put("address", "Томск, пр. Мира 20, оф.4");
        orderingGuestPage.deliveryFormInfo(data);
        orderingGuestPage.clickCheckBoxAndOrderButton();
        WaitingUtility.elementFluentWaitVisibility(orderingGuestPage.phoneNotice);
        AssertCollector.assertEqualsJ(orderingGuestPage.phoneNotice.getText(),
                "Значение \"Телефон\" должно соответствовать формату: +7XXXXXXXXXX",
                "Error messages are equals");
    }
}
