package Core.utils;

import static Core.readDocs.ReadXMLFile.readXML;

/**
 * @author Sergey Potapov
 */
public class Constants {

    //========================Data Based==================================
    /**
     * DB for connection to TestBD
     */
    protected final String serverName = "";//"jdbc:postgresql://localhost:5432/TestLog";
    protected final String userName = "";//"postgres";
    protected final String passwordName = "";//"admin";
    //========================BASE URL==================================
    public static String BASE_DRIVER = readXML("section", "driver");
    //========================BASE URL==================================
    public static String BASE_URL = readXML("section", "mainUrl");
    //========================BROWSER DRIVER NAMES======================
    public static final String DRIVER_NAME_FIREFOX = "webdriver.gecko.driver";
    public static final String DRIVER_NAME_CHROME = "webdriver.chrome.driver";
    //========================BROWSER DRIVER PATH=======================
    public static final String FIREFOX_DRIVER_PATH = System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver.exe";
    public static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe";
    public static final String CHROME_DRIVER_PATH_UNIX = readXML("section", "unixPath");
    //========================SCREENSHOT PATH===========================
    public static final String ERROR_SCREENSHOT_FOLDER = System.getProperty("user.dir") + "/test-output/screenShots/ErrorScreenShot/";
    public static final String SUCCESS_SCREENSHOT_FOLDER = System.getProperty("user.dir") + "/test-output/screenShots/SuccessScreenShot/";
    //========================LOGGER FILES PATH=========================
    public static final String LOGGING_FOLDER = System.getProperty("user.dir") + "/test-output/";
    public static final String LOGGING_HTML_FILE = System.getProperty("user.dir") + "/test-output/Logging.html";
    public static final String LOGGING_TXT_FILE = System.getProperty("user.dir") + "/test-output/Logging.txt";
    //===============================REGEX==============================
    public static final String RGBA_TO_RGB_REGEX = "(rgba)|(rgb)|(\\()|(\\s)|(\\))";
    public static final String COMMA_REGEX = ",";
    //===============================UTIL CONSTANTS==============================
    public static final int FIRST_TAB_BROWSER = 0;
    public static final int SECOND_TAB_BROWSER = 1;
    public static final int TWO_TABS_BROWSER = 2;
    //===============================UTIL CONSTANTS==============================
    public static final String AUTORIZATION_PAGE_URL =BASE_URL+ "/customer/account/login/";
    public static final String REGISTRATION_PAGE_URL = BASE_URL+"/customer/account/create/";
    public static final String ACCOUNT_INFORMATION_URL =BASE_URL+ "/customer/account/edit/";
    public static final String ACCOUNT_DELIVERY_ADDRESS_URL =BASE_URL+ "/customer/address/";
    public static final String ACCOUNT_PAGE_URL =BASE_URL+ "/customer/account/";
    public static final String ABOUT_PAGE_URL = BASE_URL+"/about";
    public static final String PHYSICAL_PERSON_EMAIL =  readXML("testData","physicalEmail");//"test_i.makarov@magdv.com";
    public static final String PHYSICAL_PERSON_PASSWORD = readXML("testData","physicalPass");
    public static final String AUTHORIZATION_EMAIL =  readXML("testData","authorizationEmail");//"test_a.evdokimov@magdv.com";
    public static final String AUTHORIZATION_PASSWORD =  readXML("testData","authorizationPass");//"JOviF7J2";
    public static final String INCORRECT_EMAIL = readXML("testData","incorrectEmail");// "a.shaulo123@andersenlab.com";
    public static final String INCORRECT_PASSWORD = readXML("testData","incorrectPass");// "As06051993";
    public static final String FADEEV_EMAIL = readXML("testData","fadeevEmail");
    public static final String FADEEV_PASSWORD = readXML("testData","fadeevPass");
    public static final String FADEEV_PHONE = readXML("testData","fadeevPhone");
    public static final String KALASHNIKOVA_EMAIL = readXML("testData","kalashnikovaEmail");
    public static final String KALASHNIKOVA_PASSWORD = readXML("testData","kalashnikovaPass");
    public static final String KALASHNIKOVA_PHONE = readXML("testData","kalashnikovaPhone");
    public static final String PONOMAREVA_EMAIL = readXML("testData","ponomarevaEmail");
    public static final String PONOMAREVA_PASSWORD = readXML("testData","ponomarevaPass");
    public static final String MAKAROVA_EMAIL = readXML("testData","makarovEmail");
    public static final String MAKAROVA_PASSWORD = readXML("testData","makarovPass");
    public static final String BOLSHAKOV_EMAIL = readXML("testData","bolshakovEmail");
    public static final String BOLSHAKOV_PASSWORD = readXML("testData","bolshakovPass");
    public static final String ZUEV_EMAIL = readXML("testData","zuevEmail");
    public static final String ZUEV_PASSWORD = readXML("testData","zuevPass");
    public static final String TEST_EMAIL = readXML("testData", "testEmail");//"test_t.bolshakov@magdv.com";
    public static final String TEST_PASSWORD = readXML("testData", "testPass");//"sTU1iJ46";
    public static final String EMPTY_DATA = " ";
}
