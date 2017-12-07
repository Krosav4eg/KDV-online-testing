package testcases.mainPage.categorySection;

import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;

/**
 * @author Sergey Potapov
 */
public class CategoryGoodsTest extends BaseTest {
    @Test
    public void verifySelectingCategoryTest() throws InterruptedException {
        TestReporter.testTitle("Test ID - C34335");
        mainPage.selectingCategory();
    }
}
