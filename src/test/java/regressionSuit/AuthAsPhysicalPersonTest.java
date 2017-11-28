package regressionSuit;

import regressionSuit.base.BaseTest;
import org.testng.annotations.Test;
import pages.MainPage;

/**
 * @author Sergey Potapov
 */

public class AuthAsPhysicalPersonTest extends BaseTest {
    @Test
    public void authorizationTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.authorization();
    }

}
