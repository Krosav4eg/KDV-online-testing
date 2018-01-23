package testcases.OrderingPage;

import basePage.BasePage;
import org.json.JSONObject;
import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.AssertCollector;
import utils.TestReporter;

import static utils.Constants.BASE_URL;

public class OrderingPageTest extends BaseTest {
    BasePage.MyDelegate del = new BasePage.MyDelegate() {
    };

    @Test
    public void verifyAuthorizationLInkTest() {
        TestReporter.testTitle("Test ID - C41074");
        JSONObject data = orderingGuest.data();
        orderingGuest.createOrder(data);
        orderingGuest.modalAuthLink.click();
        AssertCollector.assertTrue(orderingGuest.modalAuthForm.isDisplayed(),
                "Modal authorization form is appear");
        orderingGuest.closeModalButton.click();
        orderingGuest.modalAuthLink.click();
        JSONObject data1 = orderingGuest.authModalFormData();
        orderingGuest.authorizationBlockModalWindow(data1);
        AssertCollector.assertEqualsJ(del.getCurrentUrl(), BASE_URL + "/onestepcheckout/",
                "Urls are equals");
        AssertCollector.assertTrue(customerAccountPage.myAccountLink.getText().contains("Зуев Степан"));
    }
}
