package KDV_testcases.OrderingPage;

import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.TestReporter;

public class OrderingPhysicalPageTest extends BaseTest {

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
