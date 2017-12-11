package testcases.mainPage.hitOfSales;

import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;

/**
 * @author Sergey Potapov
 */
public class HitOfSalesTest extends BaseTest {
    @Test
    public void verifyTotalSumHitSalesTest() {
        TestReporter.testTitle("Test ID - C34339");
        mainPage.verifySumAllElements();
    }

    @Test
    public void verifyAddingProductIntoBasketTest() throws InterruptedException {
        TestReporter.testTitle("Test ID - C34340");
        mainPage.verifyAddingIntoBasket();
    }
}
