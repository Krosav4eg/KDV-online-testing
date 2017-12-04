package testcases.header;

import org.testng.annotations.Test;
import testcases.base.BaseTest;

/**
 * @author Sergey Potapov
 */
public class HeaderTest extends BaseTest {
    @Test
    public void verifyLogoTest() {
        mainPage.checkCompanyLogo();
    }

    @Test
    public void verifyClosingModalWindowTest() {
        mainPage.closingModalWindow();
    }

    @Test
    public void verifyChangingCityTest() {
        mainPage.changeCity();
    }
}

