package utils;

public class Constants {

    //========================BASE URL==================================
    public static final String BASE_URL = "http://tomsk.demo.dev.magonline.ru";

    //========================BROWSER DRIVER NAMES==================================
    public static final String DRIVER_NAME_FIREFOX = "webdriver.gecko.driver";
    public static final String DRIVER_NAME_CHROME = "webdriver.chrome.driver";

    //========================BROWSER DRIVER PATH===================================
    public static final String FIREFOX_DRIVER_PATH = System.getProperty("user.dir") + "/src/main/resources/driver/geckodriver.exe";
    public static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "/src/main/resources/driver/chromedriver.exe";
}
