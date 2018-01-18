package testcases.mainPage.categorySection;

import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;

/**
 * @author Sergey Potapov
 */
public class CategoryGoodsTest extends BaseTest {



    @Test
    public void verifyBreadCrumbs() {
        TestReporter.testTitle("Test ID - C39078");
        categoryPage.breadCrumbs();
    }

    @Test
    public void verifyHeader() {
        TestReporter.testTitle("Test ID - C39075");
        categoryPage.selectFromCategoryDropDown();

    }
    @Test
    public void verifyCommodityGrid() {
        TestReporter.testTitle("Test ID - C39081");
        categoryPage.commodityGridList();

    }
    //TODO BUG
    @Test
    public void verifyCheckBoxIsPresent() {
        TestReporter.testTitle("Test ID - C39083");
        categoryPage.CheckBox();
    }
    @Test
    public void verifySortDefault() {
        TestReporter.testTitle("Test ID - C39206");
        categoryPage.sortFilterDefault();
    }
    @Test
    public void verifySortPriceDesc() {
        TestReporter.testTitle("Test ID - C40223");
        categoryPage.sortFilterPrice();
    }
    //TODO BUG
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
    @Test
    public void verifyAddProductFromCard()
    {
        TestReporter.testTitle("Test ID - 39141");
        cardPage.addProductFromCard();
    }
    @Test
    public void verifyAddProductNotValidCase()
    {
        TestReporter.testTitle("Test ID - 40246");
        cardPage.addProductNotValidFromCard();
    }
    @Test
    public void verifyModalWindow()
    {
        TestReporter.testTitle("Test ID - 39126");
        moadalWindow.checkModalWindow();
    }
    @Test
    public  void verifyAddProductNotValid()
    {
        TestReporter.testTitle("Test ID - 40268");
        moadalWindow.AddProductNotValid();
    }
    @Test
    public  void verifyProductCard()
    {
        TestReporter.testTitle("Test ID - 39286");
        cardPage.validCardProductVerify();
    }
    @Test
    public  void verifyProductCardDescription()
    {
        TestReporter.testTitle("Test ID - 39306");
        cardPage.validCardProductVerifyDescription();
    }
    @Test
    public  void verifyProductCardComposition()
    {
        TestReporter.testTitle("Test ID - 40270");
        cardPage.validCardProductVerifyComposition();
    }
    @Test
    public  void verifyProductCardNotValid()
    {
        TestReporter.testTitle("Test ID - 40269");
        cardPage.verifyNotValidProductCard();
    }
    @Test
    public  void verifyProductCardAdvanceShop()
    {
        TestReporter.testTitle("Test ID - 40271");
        cardPage.validCardProductVerifyAdvantagesShop();
    }
}
