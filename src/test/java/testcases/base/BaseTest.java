package testcases.base;

import driverFactory.BrowserFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.MainPage;
import utils.TestReporter;

import java.io.File;
import java.io.IOException;

import static utils.Constants.ERROR_SCREENSHOT_FOLDER;
import static utils.Constants.SUCCESS_SCREENSHOT_FOLDER;

/**
 * @author Sergey Potapov
 */
public abstract class BaseTest {
    protected WebDriver driver;

    //=======DECLARATION OF PAGE CLASSES=======
    protected MainPage mainPage;

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

    /**
     * Method for screenshot creation
     *
     * @param screenShotName-name of screenshot
     * @param folder-             folder which contain screenshots
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
    }
}