package testcases.footer;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;

import java.lang.reflect.Method;

/**
 * @author Sergey Potapov
 */
public class FooterTest extends BaseTest {

    @BeforeMethod
    public void beforeGeneralTests(Method method) {
        mainPage.scrollToNecessaryElement(mainPage.customerPickupLink);
    }

    @Test
    public void verifyAboutShopLinkTest() {
        TestReporter.testTitle("Test ID - C34351");
        mainPage.verifyShopLink();
    }

    @Test
    public void verifyCustomerPickupLinkTest() {
        TestReporter.testTitle("Test ID - C34358");
        mainPage.verifyCustomerPickUpLink();
    }

    @Test
    public void verifyFreeDeliveryLinkTest() {
        TestReporter.testTitle("Test ID - C34359");
        mainPage.verifyFreeDeliveryLink();
    }
}
