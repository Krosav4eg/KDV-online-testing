package utils;

/**
 * @author Sergey Potapov
 */
public class Constants {
    //========================BASE URL==================================
    public static final String BASE_URL = "http://tomsk.demo.dev.magonline.ru";

    //========================BROWSER DRIVER NAMES======================
    public static final String DRIVER_NAME_FIREFOX = "webdriver.gecko.driver";
    public static final String DRIVER_NAME_CHROME = "webdriver.chrome.driver";

    //========================BROWSER DRIVER PATH=======================
    public static final String FIREFOX_DRIVER_PATH = System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver.exe";
    public static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe";

    //========================SCREENSHOT PATH===========================
    public static final String ERROR_SCREENSHOT_FOLDER = System.getProperty("user.dir") + "/test-output/screenShots/ErrorScreenShot/";
    public static final String SUCCESS_SCREENSHOT_FOLDER = System.getProperty("user.dir") + "/test-output/screenShots/SuccessScreenShot/";


    //LOGGER FILES PATH
    public static final String LOG_FOLDER = System.getProperty("user.dir") + "/test-output/log/testlog.log";

}
