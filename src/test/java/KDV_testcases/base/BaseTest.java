package KDV_testcases.base;

import Core.driverFactory.BrowserFactory;
import KDV_business_logic.pages.PersonalAreaPage.*;
import listener.ListenerTest;
import Core.logger.LevelCustom;
import Core.logger.MagDvLogger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import KDV_business_logic.pages.AuthorizationPage;
import KDV_business_logic.pages.BasketPages.BasketPage;
import KDV_business_logic.pages.CategoryPage.CardPage;
import KDV_business_logic.pages.CategoryPage.CategoryPage;
import KDV_business_logic.pages.CategoryPage.ModalWindow;
import KDV_business_logic.pages.CustomerAccountPage;
import KDV_business_logic.pages.MainPage;
import KDV_business_logic.pages.OrderingPage.OrderingGuestPage;
import KDV_business_logic.pages.OrderingPage.OrderingLegalPage;
import KDV_business_logic.pages.OrderingPage.OrderingPhysicalPage;
import KDV_business_logic.pages.RegistrationPage;
import Core.utils.TestReporter;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Core.driverFactory.BrowserFactory.*;
import static Core.logger.NotificationLogger.TestStatus;
import static Core.utils.Constants.*;

/**
 * @author Sergey Potapov
 */
public class BaseTest {
    private static final Logger LOGGER = MagDvLogger.getMagDvLogger().getLogger();
    //=======DECLARATION OF PAGE CLASSES=========
    protected MainPage mainPage;
    protected AuthorizationPage authorizationPage;
    protected CustomerAccountPage customerAccountPage;
    protected RegistrationPage registrationPage;
    protected CategoryPage categoryPage;
    protected CardPage cardPage;
    protected ModalWindow modalWindow;
    protected PersonalCabinetPage personalCabinetPage;
    protected AccountDataPage accountDataPage;
    protected ControlPanelPage controlPanelPage;
    protected DeliveryAddressPage deliveryAddressPage;
    protected MyBookingPage myBookingPage;
    protected BasketPage basketPage;
    protected OrderingGuestPage orderingGuestPage;
    protected OrderingPhysicalPage orderingPhysicalPage;
    protected OrderingLegalPage orderingLegalPage;

    private BrowserFactory singleton = BrowserFactory.getInstance();


    private void logStatus(ITestResult result, String date) {
        switch (result.getStatus()) {
            case ITestResult.FAILURE: {
                LOGGER.log(Level.WARNING, "TEST STATUS: FAILURE\t" + date);
                break;
            }
            case ITestResult.SKIP: {
                LOGGER.log(LevelCustom.SKIP, "TEST STATUS: SKIP\t" + date);
                break;
            }
            case ITestResult.SUCCESS: {
                LOGGER.log(Level.FINE, "TEST STATUS: PASSED\t" + date);
                break;
            }
        }
    }


    /**
     * Clean directory with error and success screenshots before starting auto tests
     * and set browser before starting auto tests
     */
    private void screen() {
        if (new File(ERROR_SCREENSHOT_FOLDER).exists())
            try {
                FileUtils.cleanDirectory(new File(ERROR_SCREENSHOT_FOLDER));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        if (new File(SUCCESS_SCREENSHOT_FOLDER).exists())
            try {
                FileUtils.cleanDirectory(new File(SUCCESS_SCREENSHOT_FOLDER));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    }

    @BeforeMethod
    public void verifyBrowser(Method method) {
        testName = method.getName();
        if (driver == null) {
            driver = singleton.setDriver();
            initPageElements();
            TestReporter.step("Open Main page");
            mainPage.openMainPage();
            screen();
        }
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            new ListenerTest().onTestFailure(result);
        }
        long millis = result.getEndMillis() - result.getStartMillis();
        long tim = ((millis % 60000) / 1000) * 1000;
        long timeS = millis - tim;
        String date = String.format("TEST TIME: %d:%d:%d", millis / 60000, (millis % 60000) / 1000, timeS);
        TestStatus(result);
        logStatus(result, date);
        driver.quit();
        driver = null;
    }

    /**
     * Method for closing browser and auto tests
     */
    @AfterTest()
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
        TestReporter.removeNumberStep();
    }
//    @AfterSuite
//    public void afterSuite()
//    {
//        new SendMail().sendMail(mailBody);
//    }


    /**
     * Method for screenshot creation
     *
     * @param screenShotName -name of screenshot
     * @param folder         -folder       which contain screenshots
     *                       //* @return dest - destination where to be situated screenshots
     */
    public static void capture(String screenShotName, String folder) {
        TakesScreenshot takesScreenshot = ((TakesScreenshot) BrowserFactory.getDriver());
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String dest = folder + screenShotName + ".png";
        File destination = new File(dest);
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initPageElements() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        authorizationPage = PageFactory.initElements(driver, AuthorizationPage.class);
        customerAccountPage = PageFactory.initElements(driver, CustomerAccountPage.class);
        registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        categoryPage = PageFactory.initElements(driver, CategoryPage.class);
        cardPage = PageFactory.initElements(driver, CardPage.class);
        modalWindow = PageFactory.initElements(driver, ModalWindow.class);
        basketPage = PageFactory.initElements(driver, BasketPage.class);
        accountDataPage = PageFactory.initElements(driver, AccountDataPage.class);
        controlPanelPage = PageFactory.initElements(driver, ControlPanelPage.class);
        deliveryAddressPage = PageFactory.initElements(driver, DeliveryAddressPage.class);
        myBookingPage = PageFactory.initElements(driver, MyBookingPage.class);
        orderingGuestPage = PageFactory.initElements(driver, OrderingGuestPage.class);
        orderingPhysicalPage = PageFactory.initElements(driver, OrderingPhysicalPage.class);
        personalCabinetPage = PageFactory.initElements(driver, PersonalCabinetPage.class);
        orderingLegalPage = PageFactory.initElements(driver, OrderingLegalPage.class);
    }
}