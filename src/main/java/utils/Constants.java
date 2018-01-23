package utils;

/**
 * @author Sergey Potapov
 */
public class Constants {


    //========================Data Based==================================
    /**
     * DB for connection to TestBD
     */
    protected  final String serverName = "";//"jdbc:postgresql://localhost:5432/TestLog";
    protected  final String userName = "";//"postgres";
    protected  final String passwordName ="";//"admin";

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

    //========================LOGGER FILES PATH=========================

    public static final String LOGGING_FOLDER =System.getProperty("user.dir");
    public static final String LOGGING_HTML_FILE =System.getProperty("user.dir") + "/test-output/Logging.html";
    public static final String LOGGING_TXT_FILE = System.getProperty("user.dir") + "/test-output/Logging.txt";

    //===============================REGEX==============================
    public static final String RGBA_TO_RGB_REGEX = "(rgba)|(rgb)|(\\()|(\\s)|(\\))";
    public static final String COMMA_REGEX = ",";

    //===============================UTIL CONSTANTS==============================
    public static final int FIRST_TAB_BROWSER = 0;
    public static final int SECOND_TAB_BROWSER = 1;
    public static final int TWO_TABS_BROWSER = 2;

    //===============================UTIL CONSTANTS==============================
    public static final String AUTORIZATION_PAGE_URL = "http://tomsk.demo.dev.magonline.ru/customer/account/login/";
    public static final String REGISTRATION_PAGE_URL = "http://tomsk.demo.dev.magonline.ru/customer/account/create/";
    public static final String ACCOUNT_INFORMATION_URL = "http://tomsk.demo.dev.magonline.ru/customer/account/edit/";
    public static final String ACCOUNT_DELIVERY_ADDRESS_URL = "http://tomsk.demo.dev.magonline.ru/customer/address/";
    public static final String ACCOUNT_PAGE_URL = "http://tomsk.demo.dev.magonline.ru/customer/account/";
    public static final String ABOUT_PAGE_URL = " http://tomsk.demo.dev.magonline.ru/about";
    public static final String PHYSICAL_PERSON_EMAIL = "test_i.makarov@magdv.com";
    public static final String PHYSICAL_PERSON_PASSWORD = "SWgeZWPs";
    public static final String AUTORIZATION_EMAIL = "test_a.evdokimov@magdv.com";
    public static final String AUTORIZATION_PASSWORD = "JOviF7J2";
    public static final String INCORRECT_EMAIL = "a.shaulo123@andersenlab.com";
    public static final String INCORRECT_PASSWORD = "As06051993";
    public static final String EMPTY_DATA = " ";
}
