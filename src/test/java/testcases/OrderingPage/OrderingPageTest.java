package testcases.OrderingPage;

import basePage.BasePage;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.AssertCollector;
import utils.TestReporter;

public class OrderingPageTest extends BaseTest {
    BasePage.MyDelegate del = new BasePage.MyDelegate() {
    };

//    @Test
//    public void verifyAuthorizationLInkTest() {
//        TestReporter.testTitle("Test ID - C41074");
//        JSONObject data = orderingGuest.data();
//        orderingGuest.createOrder(data);
//        orderingGuest.modalAuthLink.click();
//        AssertCollector.assertTrue(orderingGuest.modalAuthForm.isDisplayed(),
//                "Modal authorization form is appear");
//        orderingGuest.closeModalButton.click();
//        orderingGuest.modalAuthLink.click();
//        JSONObject data1 = orderingGuest.authModalFormData();
//        orderingGuest.authorizationBlockModalWindow(data1);
//        AssertCollector.verifyCondition(del.getCurrentUrl().equals(BASE_URL + "/onestepcheckout/"));
//        AssertCollector.verifyCondition(customerAccountPage.myAccountLink.getText().contains("Зуев Степан"));
//    }

    //problem with validation length and validation message in first name and last name fields
    @Test
    public void verifyCheckAndInputValueTest() {
        TestReporter.testTitle("Test ID - C41062,40067,41064");
        JSONObject data = orderingGuest.data();
        orderingGuest.createOrder(data);
        data.put("firstName", "Анна-Мар'я" + RandomStringUtils.randomAlphabetic(35));
        data.put("lastName", "Анна-Мар'я" + RandomStringUtils.randomAlphabetic(35));
        orderingGuest.identificationBlock(data);
        AssertCollector.assertEquals(orderingGuest.firstNameTxt.getAttribute("value").length(),
                " Number of symbols is equal ", RandomStringUtils.randomAlphabetic(45).length());
        AssertCollector.assertEquals(orderingGuest.lastNameTxt.getAttribute("value").length(),
                " Number of symbols is equal ", RandomStringUtils.randomAlphabetic(45).length());
        orderingGuest.createOrderButton.click();
        AssertCollector.assertTrue(!orderingGuest.identificationBlock(data).
                contains("Пожалуйста, введите правильный адрес электронной почты (email). " +
                        "Например, ivanivanov@domain.com."));
        AssertCollector.assertEquals(orderingGuest.phoneTxt.getAttribute("value").length(),
                " Number of phone symbols is equal ", RandomStringUtils.randomAlphabetic(12).length());
    }
}
