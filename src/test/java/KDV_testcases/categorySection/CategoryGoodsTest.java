package KDV_testcases.categorySection;

import Core.utils.TestReporter;
import KDV_testcases.base.BaseTest;
import org.testng.annotations.Test;

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

    //TODO bug absence signatures "Статус" "В наличии"
    @Test(enabled = false)
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

    @Test
    public void verifyMoveToCategoryTest() {
        TestReporter.testTitle("Test ID - C34336");
        mainPageSelector.moveToCategory();
    }

    @Test
    public void verifyCategoryFieldsMainPage() {
        TestReporter.testTitle("Test ID - C39091");
        cardPage.verifyFieldsCardMainPage();
    }

    //TODO BUG with goods increment button
    @Test(enabled = false)
    public void verifyAddProductMainPage() {
        TestReporter.testTitle("Test ID - C39141");
        cardPage.addProductFromCardMainPage();
    }

    @Test
    public void verifyAddProductNotValidMainPage() {
        TestReporter.testTitle("Test ID - C40246");
        cardPage.addProductNotValidFromCardMainPage();
    }

    @Test
    public void verifyModalWindow() {
        TestReporter.testTitle("Test ID - C39126");
        modalWindow.checkModalWindow();
    }

    @Test
    public void verifyAddProductNotValidModalWindow() {
        TestReporter.testTitle("Test ID - C40268");
        modalWindow.addProductNotValidModalWindow();
    }

    @Test
    public void verifyProductCard() {
        TestReporter.testTitle("Test ID - C39286");
        cardPage.validCardProductVerify();
    }

    @Test
    public void verifyProductCardDescription() {
        TestReporter.testTitle("Test ID - C39306");
        cardPage.validCardProductVerifyDescription();
    }

    @Test
    public void verifyProductCardComposition() {
        TestReporter.testTitle("Test ID - C40270");
        cardPage.validCardProductVerifyComposition();
    }

    @Test
    public void verifyProductCardNotValid() {
        TestReporter.testTitle("Test ID - C40269,40916");
        cardPage.verifyNotValidProductCard();
    }

    @Test
    public void verifyProductCardAdvanceShop() {
        TestReporter.testTitle("Test ID - C40271");
        cardPage.validCardProductVerifyAdvantagesShop();
    }
}
