package KDV_testcases.mainPage.hitOfSales;

import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.TestReporter;

/**
 * @author Sergey Potapov
 */
public class HitOfSalesTest extends BaseTest {
    @Test
    public void verifyTotalSumHitSalesTest() {//C34339 - объеденен с C34338, C34340-43
        TestReporter.testTitle("Test ID - C34339");
        mainPageSelector.verifySumAllElements();
        TestReporter.testTitle("Test ID - C34340");
        mainPageSelector.verifyAddingIntoBasket();
        mainPageSelector.openingModalWindowProductCard();
        mainPageSelector.openProductCard();
    }
}
