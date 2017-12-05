package testcases.header;

import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;

/**
 * @author Sergey Potapov
 */
public class HeaderTest extends BaseTest {
    @Test
    public void verifyLogoTest() {
        TestReporter.testTitle("Test ID - C34282");
        mainPage.checkCompanyLogo();
    }

    @Test
    public void verifyClosingModalWindowTest() {
        TestReporter.testTitle("Test ID - C34287");
        mainPage.closingModalWindow();
    }

    @Test
    public void verifyChangingCityTest() {
        TestReporter.testTitle("Test ID - C34283");
        mainPage.changeCity();
    }
}

