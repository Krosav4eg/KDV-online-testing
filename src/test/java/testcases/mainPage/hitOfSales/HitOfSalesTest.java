package testcases.mainPage.hitOfSales;

import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;



/**
 * @author Sergey Potapov
 */
public class HitOfSalesTest extends BaseTest {
    @Test
    public void verifyTotalSumHitSalesTest() {//C34339 - объеденен с C34338, C34340-43
        TestReporter.testTitle("Test ID - C34339");
        mainPage.verifySumAllElements();
        TestReporter.testTitle("Test ID - C34340");
        mainPage.verifyAddingIntoBasket();
        mainPage.openingModalWindowProductCard();
        mainPage.openProductCard();
    }
}
