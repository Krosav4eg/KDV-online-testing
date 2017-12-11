package testcases.categorySelection;

import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;

/**
 * @author Sergey Potapov
 */
public class CategorySectionTest extends BaseTest {
    @Test
    public void verifySelectingCategoryTest() {
        TestReporter.testTitle("Test ID - C34335");
        mainPage.selectingCategory();
    }
}
