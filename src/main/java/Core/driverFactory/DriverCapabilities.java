package Core.driverFactory;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;

 public class DriverCapabilities {

	 /**
	  * PROXY you can use only if you need to connect to some proxy server
	  */
	 static DesiredCapabilities chromeCapabilities() {
		 //Proxy proxy = new Proxy();
		// proxy.setHttpProxy("myhttpproxy:3337");
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("start-maximized");
		 DesiredCapabilities capability = DesiredCapabilities.chrome();
		 //	 capability.setCapability("proxy", proxy);
		 capability.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		 capability.setCapability("chrome.switches", Arrays.asList("--incognito"));
		 capability.setBrowserName("chrome");
		 capability.setPlatform(Platform.ANY);
		 capability.setCapability(ChromeOptions.CAPABILITY, options);
		 return capability;
	 }

	 static DesiredCapabilities firefoxCapabilities() {
		 DesiredCapabilities capability = DesiredCapabilities.chrome();
		 FirefoxProfile profile = new FirefoxProfile();
		 profile.setAcceptUntrustedCertificates(true);
		 profile.setAssumeUntrustedCertificateIssuer(true);
		 profile.setPreference("browser.download.folderList", 2);
		 profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		 capability.setCapability(FirefoxDriver.PROFILE, profile);
		 FirefoxOptions options= new FirefoxOptions();
		 options.addArguments("start-maximized");
		 capability.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
		 return capability;
	 }
 }

