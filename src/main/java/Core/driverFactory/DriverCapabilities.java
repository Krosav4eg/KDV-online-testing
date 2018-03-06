package Core.driverFactory;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;

public interface DriverCapabilities {

    /**
     * PROXY you can use only if you need to connect to some proxy server
     */
    static Capabilities chromeCapabilities() {
        //Proxy proxy = new Proxy();
        //proxy.setHttpProxy("178.62.38.197:8118");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
//        options.addArguments("--headless");
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        capability.setCapability("chrome.switches", Arrays.asList("--incognito"));
        capability.setBrowserName("chrome");
        capability.setPlatform(Platform.ANY);
        capability.setCapability(ChromeOptions.CAPABILITY, options);
//		 Proxy proxy = new Proxy();
//		 proxy.setHttpProxy("185.37.190.41");
        //capability.setCapability("proxy", proxy);
        return capability;
    }

    static Capabilities firefoxCapabilities() {
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(true);
        capability.setCapability(FirefoxDriver.PROFILE, profile);
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("start-maximized");
        capability.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        return capability;
    }
}

