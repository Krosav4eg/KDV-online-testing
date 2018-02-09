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
//    }
//
//    @Test
//    public void verifyAddingProductIntoBasketTest() {
//        TestReporter.testTitle("Test ID - C34340");
        mainPage.verifyAddingIntoBasket();
//    }
//
//    @Test
//    public void verifyOpeningModalWindowProductCardTest() {
//        TestReporter.testTitle("Test ID - C34342");
        mainPage.openingModalWindowProductCard();
//    }
//
//    @Test
//    public void verifyOpeningProductCardPTest() {
//        TestReporter.testTitle("Test ID - C34343");
        mainPage.openProductCard();
    }
}
