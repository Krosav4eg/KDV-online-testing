package testcases.mainPage.categorySection;

import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;

/**
 * @author Sergey Potapov
 */
public class CategoryGoodsTest extends BaseTest {
    @Test
    public void verifySelectingCategoryTest() {
        TestReporter.testTitle("Test ID - C34335");
        mainPage.selectingCategory();
    }

    @Test
    public void verifyMoveToCategoryTest() {
        TestReporter.testTitle("Test ID - C34336");
        mainPage.moveToCategory();
    }
    @Test
    public void verifyCategoryCardFields()
    {
        TestReporter.testTitle("Test ID - 39091");
        cardPage.verifyFieldsCard();
    }
    //BUGS
    @Test
    public void verifyAddProductFromCard()
    {
        TestReporter.testTitle("Test ID - 39091");
        cardPage.addProductFromCard();
    }
    //BUGS
    @Test
    public void verifyAddProductNotValid()
    {
        TestReporter.testTitle("Test ID - 40246");
        cardPage.addProductNotValidFromCard();
    }
}
