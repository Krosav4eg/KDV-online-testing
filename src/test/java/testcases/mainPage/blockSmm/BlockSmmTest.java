package testcases.mainPage.blockSmm;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;

import java.lang.reflect.Method;

/**
 * @author Sergey Potapov
 */
public class BlockSmmTest extends BaseTest {

    @BeforeMethod
    public void beforeGeneralTests(Method method) {
        mainPage.scrollToNecessaryElement(mainPage.socialLinkSection);
    }

    @Test
    public void verifyOpeningVkLinkTest() {//C37058 - объеденен с C37062 и C37063
        TestReporter.testTitle("Test ID - C37058");
        mainPage.openingVkLink();
//    }
//
//    @Test
//    public void verifyOpeningInstagramLinkTest() {
//        TestReporter.testTitle("Test ID - C37062");
        mainPage.openingInstagramLink();
//    }
//
//    @Test
//    public void verifyOpeningGooglePlayLinkTest() {
//        TestReporter.testTitle("Test ID - C37063");
        mainPage.openingGooglePlayLink();
    }
}
