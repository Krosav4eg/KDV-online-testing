package testcases.base;

import driverFactory.BrowserFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.*;
import pages.AuthorizationPage;
import pages.BasketPages.BasketPage;
import pages.CategoryPage.CardPage;
import pages.CategoryPage.CategoryPage;
import pages.CategoryPage.ModalWindow;
import pages.CustomerAccountPage;
import pages.MainPage;
import pages.RegistrationPage;
import testcases.mainPage.basket.BasketTests;
import pages.personalCabinetPage.AccountDataPage;
import pages.personalCabinetPage.ControlPanelPage;
import pages.personalCabinetPage.DeliveryAddressPage;
import pages.personalCabinetPage.MyBookingPage;
import utils.TestReporter;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import static utils.Constants.BASE_URL;
import static utils.Constants.ERROR_SCREENSHOT_FOLDER;
import static utils.Constants.SUCCESS_SCREENSHOT_FOLDER;

/**
 * @author Sergey Potapov
 */
public abstract class BaseTest  {
    protected WebDriver driver;

    //=======DECLARATION OF PAGE CLASSES=========
    protected MainPage mainPage;
    protected AuthorizationPage authorizationPage;
    protected CustomerAccountPage customerAccountPage;
    protected RegistrationPage registrationPage;
    protected CategoryPage categoryPage;
    protected CardPage cardPage;
    protected ModalWindow modalWindow;
    protected AccountDataPage personalCabinetPage;
    protected ControlPanelPage controlPanelPage;
    protected DeliveryAddressPage deliveryAddressPage;
    protected MyBookingPage myBookingPage;
    protected PersonalCabinetPage personalCabinetPage;
    protected BasketPage basketPage;
    /**
     * Clean directory with error and success screenshots before starting auto tests
     * and set browser before starting auto tests
     */
    @BeforeTest
    public void runBrowser() {

        driver = BrowserFactory.setDriver("Chrome");
        initPageElements();
        TestReporter.step("Open main page");
        mainPage.openMainPage();
        if (new File(ERROR_SCREENSHOT_FOLDER).exists())
            try {
                FileUtils.cleanDirectory(new File(ERROR_SCREENSHOT_FOLDER));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        if (new File(ERROR_SCREENSHOT_FOLDER).exists())
            try {
                FileUtils.cleanDirectory(new File(SUCCESS_SCREENSHOT_FOLDER));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    }


    @AfterMethod
    public void clearCookies()
    {
        driver.manage().deleteAllCookies();
        mainPage.openMainPage();

    }
    //TODO it get test name ,need to improver, bad realization

    @BeforeMethod
    public void setUp(Method method) {
        System.err.println("DRIVER:"+ driver);
        System.err.println(method.getName());
    }
    /**
     * Method for screenshot creation
     *
     * @param screenShotName-name of screenshot
     * @param folder-folder       which contain screenshots
     * @return dest - destination where to be situated screenshots
     */
    public static String capture(String screenShotName, String folder) {
        TakesScreenshot takesScreenshot = ((TakesScreenshot) BrowserFactory.getDriver());
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String dest = folder + screenShotName + ".png";
        File destination = new File(dest);
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.log(Level.WARNING, "Error during screenshot taking: " + e.getMessage());
        }
        return dest;
    }

    /**
     * Method for closing browser and auto tests
     */
    @AfterTest()
    public void closeBrowser() {
        driver.quit();
        TestReporter.removeNumberStep();
    }

    private void initPageElements() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        authorizationPage = PageFactory.initElements(driver, AuthorizationPage.class);
        customerAccountPage = PageFactory.initElements(driver, CustomerAccountPage.class);
        registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        categoryPage = PageFactory.initElements(driver, CategoryPage.class);
        cardPage = PageFactory.initElements(driver, CardPage.class);
        modalWindow = PageFactory.initElements(driver, ModalWindow.class);
        personalCabinetPage = PageFactory.initElements(driver, PersonalCabinetPage.class);
         basketPage = PageFactory.initElements(driver, BasketPage.class);
        personalCabinetPage = PageFactory.initElements(driver, AccountDataPage.class);
        controlPanelPage = PageFactory.initElements(driver, ControlPanelPage.class);
        deliveryAddressPage = PageFactory.initElements(driver, DeliveryAddressPage.class);
        myBookingPage = PageFactory.initElements(driver, MyBookingPage.class);
    }
}