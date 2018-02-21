package KDV_testcases.base;

import Core.Email.SendMail;
import Core.driverFactory.BrowserFactory;
import KDV_business_logic.pages.PersonalAreaPage.*;
import listener.ListenerTest;
import Core.logger.LevelCustom;
import Core.logger.MagDvLogger;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Core.driverFactory.BrowserFactory.*;
import static Core.utils.Constants.*;
/**
 * @author Sergey Potapov
 */
public class BaseTest {


    public static String mailBody;
    public static String testState;
    private static Integer successTest = 0, failTest = 0, skipTest = 0;
    private static List<String> FailureTest = new ArrayList<>();
    private static List<String> SuccessTest = new ArrayList<>();
    private static List<String> SkippTest = new ArrayList<>();
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

//TODO in process not finished
    public  String TestStatus(ITestResult result) {
        switch (result.getStatus()) {
            case ITestResult.FAILURE: {
                testState = "FAILURE";
                failTest = failTest + 1;
                FailureTest.add("FAILED -\t "+result.getName() + "\t\n ");
                break;
            }
            case ITestResult.SUCCESS: {
                testState = "SUCCESS";
                successTest = successTest + 1;
                SuccessTest.add("PASSED -\t "+result.getName() + "\t\n");
                break;
            }
            case ITestResult.SKIP: {
                testState = "SKIP";
                skipTest = skipTest + 1;
                SkippTest.add("SKIPPED -\t "+ result.getName() + "\t\n");
                break;
            }
        }
        mailBody =getHead(successTest,failTest,skipTest,SkippTest,SuccessTest,FailureTest);
        return mailBody;
    }


    private String getHead(int pass,int failure,int skipp,List<String> SkippTest,
                           List<String> passTest,List<String> failedTest) {
        StringBuilder failedString= new StringBuilder();
        for (String aFailedTest : failedTest) {
            failedString.append("\t<div style=\"color:red;width: 100%;\">").append("<b>").append(aFailedTest).append("</b>\n</div>");
        }
        StringBuilder passString= new StringBuilder();
        for (String aPassTest : passTest) {
            passString.append("\t<div style=\"color:green;width: 100%;\">").append("<b>").append(aPassTest).append("</b>\n</div>");
        }
        StringBuilder skippString= new StringBuilder();
        for (String aSkippTest : SkippTest) {
            skippString.append("\t<div style=\"color:orange;width: 100%;\">").append("<b>").append(aSkippTest).append("</b>\n</div>");
        }
        return "<!DOCTYPE html>\n<head>\n<style>\n"
                + "table { width: 100% }\n"
                + "th { font:bold 10pt Tahoma; }\n"
                + "td { font:normal 14pt Tahoma; }\n"
                + "h1 {font:normal 16pt Tahoma;}\n"
                + "</style>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>" + (new Date()) + "</h1>\n"
                + "<table border=\"0\" cellpadding=\"5\" cellspacing=\"3\">\n"
                + "<tr align=\"left\">\n"
                + "\t<th style=\"width:33%\">Pass Tests:"+pass+"</th>\n"
                + "\t<th style=\"width:33%\">Failure Tests:"+failure+"</th>\n"
                + "\t<th style=\"width:33%\">Skipp Tests:"+skipp+"</th>\n"
                + "</tr>\n"
                +"</table>"
                + "\t<br>\n"
                +failedString
                +skippString
                +passString;



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
			    LOGGER.log(LevelCustom.SKIP, "TEST STATUS: SKIP\t"+date);
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

    @AfterMethod
    public void clearCookies(ITestResult result) {
        TestStatus(result);
        if(result.getStatus()==ITestResult.FAILURE) {
            new ListenerTest().onTestFailure(result);
        }
        long millis=result.getEndMillis()-result.getStartMillis();
        long tim=((millis % 60000)/1000)*1000;
        long timeS=millis -tim;
        String date = String.format("TEST TIME: %d:%d:%d", millis / 60000, (millis % 60000) / 1000,timeS);
        logStatus(result,date);
        driver.quit();
        driver=null;
    }

    /**
     * Method for closing browser and auto tests
     */
    @AfterTest()
    public void closeBrowser() {
        if(driver!=null)
        {
            driver.quit();
        }
        TestReporter.removeNumberStep();
    }
    @AfterSuite
    public void afterSuite()
    {
        new SendMail().sendMail(mailBody);
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