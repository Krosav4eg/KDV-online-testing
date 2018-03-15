package KDV_testcases.mainPage.blockSmm;

import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.TestReporter;

/**
 * @author Sergey Potapov
 */
public class BlockSmmTest extends BaseTest {

    @Test
    public void verifyOpeningVkLinkTest() {//C37058 - объеденен с C37062 и C37063
        TestReporter.testTitle("Test ID - C37058");
        blockSmm.openingVkLink();
        blockSmm.openingInstagramLink();
        blockSmm.openingGooglePlayLink();
    }
}
