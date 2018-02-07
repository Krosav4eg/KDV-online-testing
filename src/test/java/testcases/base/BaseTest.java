package testcases.base;

import Core.driverFactory.BrowserFactory;
import logger.MagDvLogger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.AuthorizationPage;
import pages.BasketPages.BasketPage;
import pages.CategoryPage.CardPage;
import pages.CategoryPage.CategoryPage;
import pages.CategoryPage.ModalWindow;
import pages.CustomerAccountPage;
import pages.MainPage;
import pages.OrderingPage.OrderingGuestPage;
import pages.OrderingPage.OrderingLegalPage;
import pages.OrderingPage.OrderingPhysicalPage;
import pages.PersonalAreaPage.*;
import pages.RegistrationPage;
import utils.TestReporter;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Core.driverFactory.BrowserFactory.testName;
import static utils.Constants.ERROR_SCREENSHOT_FOLDER;
import static utils.Constants.SUCCESS_SCREENSHOT_FOLDER;
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
    public WebDriver driver;
    @BeforeMethod
    public void verifyBrowser(Method method) {
        testName=method.getName();
        if (driver==null)
        {
            driver = singleton.setDriver();
            initPageElements();
            TestReporter.step("Open Main page");
            mainPage.openMainPage();
            screen();
        }
    }


    /**
     * Clean directory with error and success screenshots before starting auto tests
     * and set browser before starting auto tests
     */
    private void logStatus(ITestResult result,String date)
    {
	    switch (result.getStatus())
	    {
		    case ITestResult.FAILURE:
		    {
			    LOGGER.log(Level.WARNING, "TEST STATUS: FAILURE\t"+date);
			    break;
		    }
		    case ITestResult.SKIP:
		    {
			    LOGGER.log(Level.WARNING, "TEST STATUS: SKIP\t"+date);
			    break;
		    }
		    case ITestResult.SUCCESS:
		    {
			    LOGGER.log(Level.FINE, "TEST STATUS: PASSED\t"+date);
			    break;
		    }
	    }
    }

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

    @AfterMethod
    public void clearCookies(ITestResult result) {
        System.err.println(result.getStatus());
        System.err.println(result.getName());
        long millis=result.getEndMillis()-result.getStartMillis();
        String date=String.format("TEST TIME: %02d min, %02d sec",
                TimeUnit.MILLISECONDS.toMinutes(millis),
                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
        );
       driver.manage().deleteAllCookies();
       mainPage.openMainPage();
       logStatus(result,date);
    }

    /**
     * Method for closing browser and auto tests
     */
    @AfterTest()
    public void closeBrowser() {
        driver.quit();
        TestReporter.removeNumberStep();
    }

    @AfterClass
    public void closeAfterClass()
    {
    	driver.quit();
    	driver=null;
    }

    /**
     * Method for screenshot creation
     *
     * @param screenShotName -name of screenshot
     * @param folder -folder       which contain screenshots
     //* @return dest - destination where to be situated screenshots
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
            //LOGGER.log(Level.WARNING, "Error during screenshot taking: " + e.getMessage());
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