package testcases.OrderingPage;

import basePage.BasePage;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.AssertCollector;
import utils.TestReporter;

import static utils.Constants.*;
import static utils.WaitingUtility.elementFluentWaitVisibility;

public class OrderingPageTest extends BaseTest {
    BasePage.MyDelegate del = new BasePage.MyDelegate() {
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
        AssertCollector.verifyCondition(del.getCurrentUrl().equals(BASE_URL + "/onestepcheckout/"));
        AssertCollector.verifyCondition(customerAccountPage.myAccountLink.getText().contains("Зуев Степан"));
    }

    @Test
    public void verifyAuthModalWindowTest() {
        TestReporter.testTitle("Test ID - C41076");
        JSONObject data = orderingGuestPage.data();
        orderingGuestPage.createOrder(data);
        orderingGuestPage.modalAuthLink.click();
        elementFluentWaitVisibility(orderingGuestPage.authEnterButton, driver).click();
        elementFluentWaitVisibility(orderingGuestPage.errorText, driver);
        AssertCollector.assertTrue(orderingGuestPage.errorText.isDisplayed(), "Required text is present");
        JSONObject data2 = orderingGuestPage.authModalFormData();
        data2.put("email", "");
        data2.put("password", "YZde8m");
        orderingGuestPage.authorizationBlockModalWindow(data2);
        orderingGuestPage.closeModalButton.click();
        orderingGuestPage.modalAuthLink.click();
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
        AssertCollector.verifyCondition(del.getCurrentUrl().equals(BASE_URL + "/regulations"));
        del.closeDriverToAnyTabOfBrowser(1);
        del.switchDriverToAnyTabOfBrowser(FIRST_TAB_BROWSER);
        orderingGuestPage.consentPersonalDataProcessingLink.click();
        del.switchDriverToAnyTabOfBrowser(SECOND_TAB_BROWSER);
        AssertCollector.verifyCondition(del.getCurrentUrl().equals(BASE_URL +
                "/media/rules/Consent_to_personal_data_processing.pdf"));
        del.closeDriverToAnyTabOfBrowser(1);
        del.switchDriverToAnyTabOfBrowser(FIRST_TAB_BROWSER);
        orderingGuestPage.salesPurchaseAgreementLink.click();
        del.switchDriverToAnyTabOfBrowser(SECOND_TAB_BROWSER);
        AssertCollector.verifyCondition(del.getCurrentUrl().equals(BASE_URL +
                "/media/rules/Sales_and_Purchase_Agreement.pdf"));
        del.closeDriverToAnyTabOfBrowser(1);
        del.switchDriverToAnyTabOfBrowser(FIRST_TAB_BROWSER);
    }

    //maximum length 256 symbols validation problem in delivery comment field
    @Test
    public void verifySelfDeliveryTest() {
        TestReporter.testTitle("Test ID - C41070");
        JSONObject data = orderingGuestPage.data();
        orderingGuestPage.createOrder(data);
        orderingGuestPage.selfDeliveryRadioButton.click();
        AssertCollector.verifyCondition(orderingGuestPage.selfDeliveryRadioButton.isEnabled());
        AssertCollector.verifyCondition(orderingGuestPage.deliveryHeader.getText().contains("Доставка"));
        del.scrollByCoordinate();
        AssertCollector.assertTrue(orderingGuestPage.deliveryAddressField.getText().
                contains("г Томск, ул Сибирская, д 10"));
        del.fillInputField(orderingGuestPage.deliveryCommentField, driver, RandomStringUtils.randomAlphabetic(255));
        AssertCollector.assertEquals(orderingGuestPage.deliveryCommentField.getAttribute("value").length(),
                " Number of symbols is equal ", RandomStringUtils.randomAlphabetic(255).length());
    }

    @Test
    public void verifyCourierDeliveryTest() {
        TestReporter.testTitle("Test ID - C41072");
        JSONObject data = orderingGuestPage.data();
        orderingGuestPage.createOrder(data);
        AssertCollector.verifyCondition(orderingGuestPage.courierDeliveryRadioButton.isEnabled());
        AssertCollector.assertTrue(orderingGuestPage.deliveryAddressField.getAttribute("value").
                contains("г Томск, ул Сибирская, д 10"));
        del.scrollByCoordinate();
        del.fillInputField(orderingGuestPage.deliveryAddressField, driver, "Томск");
        elementFluentWaitVisibility(orderingGuestPage.addressSuggestionList, driver).click();
        elementFluentWaitVisibility(orderingGuestPage.addressErrorField, driver);
        AssertCollector.verifyCondition(orderingGuestPage.addressErrorField.isDisplayed());
        del.fillInputField(orderingGuestPage.deliveryFloorField, driver, "1");
        del.fillInputField(orderingGuestPage.deliveryPorchField, driver, "3");
    }

    @Test
    public void verifyCompositionOrderTest() {
        TestReporter.testTitle("Test ID - C41073");
        JSONObject data = orderingGuestPage.data();
        orderingGuestPage.createOrder(data);
        AssertCollector.assertTrue(orderingGuestPage.compositionOrderHeader.isDisplayed());
        AssertCollector.assertTrue(orderingGuestPage.editCompositionOrderHeader.isDisplayed());
        elementFluentWaitVisibility(orderingGuestPage.editCompositionOrderHeader, driver).click();
        AssertCollector.assertEqualsJ(del.getCurrentUrl(), BASE_URL + "/checkout/cart/",
                "Urls are equals");
        del.backPage();
        AssertCollector.assertEqualsJ(del.getCurrentUrl(), BASE_URL + "/onestepcheckout/",
                "Urls are equals");
        elementFluentWaitVisibility(orderingGuestPage.reviewOrder, driver);
        System.out.println(orderingGuestPage.reviewOrder.getText());
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
        data.put("firstName", RandomStringUtils.randomAlphabetic(45));
        data.put("lastName", RandomStringUtils.randomAlphabetic(45));
        elementFluentWaitVisibility(orderingGuestPage.payBankCardRadioButton, driver).click();
        AssertCollector.verifyCondition(orderingGuestPage.payBankCardRadioButton.isEnabled());
        del.scrollByCoordinate();
        del.fillInputField(orderingGuestPage.deliveryCommentField, driver, RandomStringUtils.randomAlphabetic(10));
        del.fillInputField(orderingGuestPage.deliveryFloorField, driver, "1");
        del.fillInputField(orderingGuestPage.deliveryPorchField, driver, "3");
        del.fillInputField(orderingGuestPage.deliveryAddressField, driver, "Томск, пр. Мира 20, оф.4");
        elementFluentWaitVisibility(orderingGuestPage.selfDeliveryRadioButton, driver).click();
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
        del.fillInputField(orderingGuestPage.deliveryCommentField, driver, RandomStringUtils.randomAlphabetic(10));
        del.fillInputField(orderingGuestPage.deliveryFloorField, driver, "1");
        del.fillInputField(orderingGuestPage.deliveryPorchField, driver, "3");
        del.fillInputField(orderingGuestPage.deliveryAddressField, driver, "Томск, пр. Мира 20, оф.4");
        orderingGuestPage.createOrderButton.click();
        elementFluentWaitVisibility(orderingGuestPage.firstNameFieldAdvice, driver);
        AssertCollector.verifyCondition(orderingGuestPage.firstNameFieldAdvice.getText().
                contains("Это поле обязательно для заполнения."));
        AssertCollector.verifyCondition(orderingGuestPage.lastNameFieldAdvice.getText().
                contains("Это поле обязательно для заполнения."));
    }

    @Test
    public void verifyEmptyEmailFieldTest() {
        TestReporter.testTitle("Test ID - C41080");
        JSONObject data = orderingGuestPage.data();
        data.put("firstName", RandomStringUtils.randomAlphabetic(45));
        data.put("lastName", RandomStringUtils.randomAlphabetic(45));
        data.put("email", "");
        orderingGuestPage.createOrder(data);
        del.scrollByCoordinate();
        del.fillInputField(orderingGuestPage.deliveryCommentField, driver, RandomStringUtils.randomAlphabetic(10));
        del.fillInputField(orderingGuestPage.deliveryFloorField, driver, "1");
        del.fillInputField(orderingGuestPage.deliveryPorchField, driver, "3");
        del.fillInputField(orderingGuestPage.deliveryAddressField, driver, "Томск, пр. Мира 20, оф.4");
        orderingGuestPage.createOrderButton.click();
        elementFluentWaitVisibility(orderingGuestPage.emailFieldAdvice, driver);
        AssertCollector.verifyCondition(orderingGuestPage.emailFieldAdvice.getText().
                contains("Это поле обязательно для заполнения."));
        data = orderingGuestPage.data();
        data.put("email", "a.shauloandersenlab.com");
        orderingGuestPage.identificationBlock(data);
        orderingGuestPage.createOrderButton.click();
        elementFluentWaitVisibility(orderingGuestPage.emailFieldAdvice, driver);
        AssertCollector.assertEqualsJ(orderingGuestPage.emailFieldAdvice.getText(),
                "Пожалуйста, введите правильный адрес электронной почты (email). Например, ivanivanov@domain.com.",
                "Error messages are equals");
        data = orderingGuestPage.data();
        data.put("email", "a.shaulo@andersenlabcom");
        orderingGuestPage.identificationBlock(data);
        orderingGuestPage.createOrderButton.click();
        elementFluentWaitVisibility(orderingGuestPage.emailFieldAdvice, driver);
        AssertCollector.assertEqualsJ(orderingGuestPage.emailFieldAdvice.getText(),
                "Пожалуйста, введите правильный адрес электронной почты (email). Например, ivanivanov@domain.com.",
                "Error messages are equals");
        data = orderingGuestPage.data();
        data.put("email", "a..shaulo@andersenlab.com");
        orderingGuestPage.identificationBlock(data);
        orderingGuestPage.createOrderButton.click();
        elementFluentWaitVisibility(orderingGuestPage.emailFieldAdvice, driver);
        AssertCollector.assertEqualsJ(orderingGuestPage.emailFieldAdvice.getText(),
                "Пожалуйста, введите правильный адрес электронной почты (email). Например, ivanivanov@domain.com.",
                "Error messages are equals");
        data = orderingGuestPage.data();
        data.put("email", "a.s ha ulo@andersenlab.com");
        orderingGuestPage.identificationBlock(data);
        orderingGuestPage.createOrderButton.click();
        elementFluentWaitVisibility(orderingGuestPage.emailFieldAdvice, driver);
        AssertCollector.assertEqualsJ(orderingGuestPage.emailFieldAdvice.getText(),
                "Пожалуйста, введите правильный адрес электронной почты (email). Например, ivanivanov@domain.com.",
                "Error messages are equals");
        data = orderingGuestPage.data();
        data.put("email", "a.shaulo@anders enlab.com");
        orderingGuestPage.identificationBlock(data);
        orderingGuestPage.createOrderButton.click();
        elementFluentWaitVisibility(orderingGuestPage.emailFieldAdvice, driver);
        AssertCollector.assertEqualsJ(orderingGuestPage.emailFieldAdvice.getText(),
                "Пожалуйста, введите правильный адрес электронной почты (email). Например, ivanivanov@domain.com.",
                "Error messages are equals");
    }

    @Test
    public void verifyEmptyPhoneAndAddressFieldsTest() {
        TestReporter.testTitle("Test ID - C41081-41082");
        JSONObject data = orderingGuestPage.data();
        data.put("firstName", RandomStringUtils.randomAlphabetic(45));
        data.put("lastName", RandomStringUtils.randomAlphabetic(45));
        data.put("email", "test@test.ru");
        data.put("phone", "");
        orderingGuestPage.createOrder(data);
        del.scrollByCoordinate();
        del.fillInputField(orderingGuestPage.deliveryCommentField, driver, RandomStringUtils.randomAlphabetic(10));
        del.fillInputField(orderingGuestPage.deliveryFloorField, driver, "1");
        del.fillInputField(orderingGuestPage.deliveryPorchField, driver, "3");
        del.fillInputField(orderingGuestPage.deliveryAddressField, driver, "");
        orderingGuestPage.createOrderButton.click();
        elementFluentWaitVisibility(orderingGuestPage.phoneFieldAdvice, driver);
        AssertCollector.verifyCondition(orderingGuestPage.phoneFieldAdvice.getText().
                contains("Это поле обязательно для заполнения."));
        AssertCollector.verifyCondition(orderingGuestPage.addressFieldAdvice.getText().
                contains("Это поле обязательно для заполнения."));
        data = orderingGuestPage.data();
        data.put("phone", RandomStringUtils.randomNumeric(9));
        orderingGuestPage.identificationBlock(data);
        del.fillInputField(orderingGuestPage.deliveryAddressField, driver, "Томск, пр. Мира 20, оф.4");
        orderingGuestPage.agreementCheckBoxAdvice.click();
        orderingGuestPage.createOrderButton.click();
        elementFluentWaitVisibility(orderingGuestPage.phoneNotice, driver);
        AssertCollector.assertEqualsJ(orderingGuestPage.phoneNotice.getText(),
                "Значение \"Телефон\" должно соответствовать формату: +7XXXXXXXXXX",
                "Error messages are equals");
    }

    @Test
    public void orderingDefaultAddress() {
        TestReporter.testTitle("Test ID - C41300");
        orderingPhysicalPage.orderingDefaultAddress();
    }

    @Test
    public void orderingNewAddress() {
        TestReporter.testTitle("Test ID - C41314");
        orderingPhysicalPage.orderingNewAddress();
    }

    @Test
    public void orderingChangeAddress() {
        TestReporter.testTitle("Test ID - C41454");
        orderingPhysicalPage.orderingChangedAddress();
    }

    @Test
    public void orderingChangeStoreAddress() {
        TestReporter.testTitle("Test ID - C41313");
        orderingPhysicalPage.orderingChangedStoreAddress();
    }

}
