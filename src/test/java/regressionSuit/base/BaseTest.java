package regressionSuit.base;

import driverFactory.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static utils.Constants.ERROR_SCREENSHOT_FOLDER;
import static utils.Constants.LOG_FOLDER;
import static utils.Constants.SUCCESS_SCREENSHOT_FOLDER;

/**
 * @author Sergey Potapov
 */

public class BaseTest {
    protected WebDriver driver;

    /**
     * Clean directory with error and success screenshots before starting auto tests
     * and set browser before starting auto tests
     */
    @BeforeTest
    public void setUp() {
        driver = DriverFactory.setDriver("Chrome");
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
        /**
         * Clean log directory before starting
         */
        if (new File(LOG_FOLDER).exists()) {

            File[] files = new File(LOG_FOLDER).listFiles();

            if (files != null) {
                for (File file : files) {
                    try {
                        if (file.exists()) {
                            FileWriter fwOb = new FileWriter(file, false);
                            PrintWriter pwOb = new PrintWriter(fwOb, false);
                            pwOb.flush();
                            pwOb.close();
                            fwOb.close();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
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
        TakesScreenshot takesScreenshot = ((TakesScreenshot) DriverFactory.getDriver());
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

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}