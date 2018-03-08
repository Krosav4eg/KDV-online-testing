package KDV_testcases.mainPage.blockSmm;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.TestReporter;

import java.lang.reflect.Method;

/**
 * @author Sergey Potapov
 */
public class BlockSmmTest extends BaseTest {

    @BeforeMethod
    public void beforeGeneralTests(Method method) {
        mainPageSelector.scrollToNecessaryElement(mainPageSelector.socialLinkSection);
    }

    @Test
    public void verifyOpeningVkLinkTest() {//C37058 - объеденен с C37062 и C37063
        TestReporter.testTitle("Test ID - C37058");
        mainPageSelector.openingVkLink();
        mainPageSelector.openingInstagramLink();
        mainPageSelector.openingGooglePlayLink();
    }
}
