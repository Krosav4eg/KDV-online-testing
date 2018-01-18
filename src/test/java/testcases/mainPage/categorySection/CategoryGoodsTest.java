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
    //TODO BUG
    @Test
    public void verifyAddProductFromCard()
    {
        TestReporter.testTitle("Test ID - 39091");
        cardPage.addProductFromCard();
    }
    //TODO BUG
    @Test
    public void verifyAddProductNotValidCase()
    {
        TestReporter.testTitle("Test ID - 40246");
        cardPage.addProductNotValidFromCard();
    }
    //TODO BUG
    @Test
    public void verifyModalWindow()
    {
        TestReporter.testTitle("Test ID - 39126");
        modalWindow.checkModalWindow();
    }
    //TODO BUG
    @Test
    public  void verifyAddProductNotValid()
    {
        TestReporter.testTitle("Test ID - 40268");
        modalWindow.AddProductNotValid();
    }
}
