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
    public void verifyVkLinkTest() throws InterruptedException {
        TestReporter.testTitle("Test ID - C37058");
        mainPage.verifyVkLink();
    }

    @Test
    public void verifyInstagramLinkTest() {
        TestReporter.testTitle("Test ID - C37062");
        mainPage.verifyInstagramLink();
    }

    @Test
    public void verifyGooglePlayLinkTest() {
        TestReporter.testTitle("Test ID - C37063");
        mainPage.verifyGooglePlayLink();
    }
}
