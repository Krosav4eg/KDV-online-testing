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
        categoryPage.checkBox();
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
    public void verifyCategoryFieldsMainPage()
    {
        TestReporter.testTitle("Test ID - C39091");
        cardPage.verifyFieldsCardMainPage();
    }
    @Test
    public void verifyAddProductMainPage()
    {
        TestReporter.testTitle("Test ID - C39141");
        cardPage.addProductFromCardMainPage();
    }
    @Test
    public void verifyAddProductNotValidMainPage()
    {
        TestReporter.testTitle("Test ID - C40246");
        cardPage.addProductNotValidFromCardMainPage();
    }
    @Test
    public void verifyModalWindow()
    {
        TestReporter.testTitle("Test ID - C39126");
        moadalWindow.checkModalWindow();
    }
    @Test
    public  void verifyAddProductNotValidModalWindow()
    {
        TestReporter.testTitle("Test ID - C40268");
        moadalWindow.addProductNotValidModalWindow();
    }
    @Test
    public  void verifyProductCard()
    {
        TestReporter.testTitle("Test ID - C39286");
        cardPage.validCardProductVerify();
    }
    @Test
    public  void verifyProductCardDescription()
    {
        TestReporter.testTitle("Test ID - C39306");
        cardPage.validCardProductVerifyDescription();
    }
    @Test
    public  void verifyProductCardComposition()
    {
        TestReporter.testTitle("Test ID - C40270");
        cardPage.validCardProductVerifyComposition();
    }
    //BUGS
    @Test
    public  void verifyProductCardNotValid()
    {
        TestReporter.testTitle("Test ID - C40269");
        cardPage.verifyNotValidProductCard();
    }
    @Test
    public  void verifyProductCardAdvanceShop()
    {
        TestReporter.testTitle("Test ID - C40271");
        cardPage.validCardProductVerifyAdvantagesShop();
    }
}
