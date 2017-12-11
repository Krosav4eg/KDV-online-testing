package testcases.mainPage.blockSmm;

import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;

/**
 * @author Sergey Potapov
 */
public class BlockSmmTest extends BaseTest {
    @Test
    public void verifyVkLinkTest() {
        TestReporter.testTitle("Test ID - C37058");
        mainPage.verifyVkLink();
    }

    @Test
    public void verifyInstagramLinkTest() {
        TestReporter.testTitle("Test ID - C37062");
        mainPage.verifyInstagramLink();
    }
}
