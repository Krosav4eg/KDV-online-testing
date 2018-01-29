package testcases.base;

import Core.driverFactory.BrowserFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.*;
import pages.BasketPages.BasketPage;
import pages.CategoryPage.CardPage;
import pages.CategoryPage.CategoryPage;
import pages.CategoryPage.ModalWindow;
import pages.OrderingPage.OrderingGuestPage;
import pages.OrderingPage.OrderingPhysicalPage;
import pages.PersonalAreaPage.*;
import utils.TestReporter;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import static utils.Constants.ERROR_SCREENSHOT_FOLDER;
import static utils.Constants.SUCCESS_SCREENSHOT_FOLDER;

/**
 * @author Sergey Potapov
 */
public class BaseTest  {
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

    BrowserFactory singleton = BrowserFactory.getInstance();
    WebDriver driver;

    @BeforeMethod
    public void verifyBrowser(Method method)
    {
        System.err.println(method.getName());
        if (driver==null)
        {
            //driver.quit();
            driver = singleton.setDriver("Chrome");
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
    @BeforeTest
    public void runBrowser() {
        driver = singleton.setDriver("Chrome");
        initPageElements();
        TestReporter.step("Open Main page");
        mainPage.openMainPage();
        screen();
    }

    private void screen()
    {
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
    public void clearCookies() {
        driver.manage().deleteAllCookies();
        mainPage.openMainPage();
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
        driver.close();
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
        basketPage = PageFactory.initElements(driver, BasketPage.class);
        accountDataPage = PageFactory.initElements(driver, AccountDataPage.class);
        controlPanelPage = PageFactory.initElements(driver, ControlPanelPage.class);
        deliveryAddressPage = PageFactory.initElements(driver, DeliveryAddressPage.class);
        myBookingPage = PageFactory.initElements(driver, MyBookingPage.class);
        orderingGuestPage = PageFactory.initElements(driver, OrderingGuestPage.class);
        orderingPhysicalPage = PageFactory.initElements(driver,OrderingPhysicalPage.class);
        personalCabinetPage = PageFactory.initElements(driver,PersonalCabinetPage.class);
    }
}