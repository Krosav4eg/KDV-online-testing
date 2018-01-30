package Core.driverFactory;

import com.google.common.base.Verify;
import com.google.common.base.VerifyException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import static utils.WaitingUtility.waitForJSandJQueryToLoad;
import static utils.WaitingUtility.waitForPageLoad;

public abstract class EventHandler   implements WebDriverEventListener   {
//	@Override
//	public void beforeAlertAccept(WebDriver webDriver) {
//
//	}
//
//	@Override
//	public void afterAlertAccept(WebDriver webDriver) {
//
//	}
//
//	@Override
//	public void afterAlertDismiss(WebDriver webDriver) {
//
//	}
//
//	@Override
//	public void beforeAlertDismiss(WebDriver webDriver) {
//
//	}
	@Override
	public void beforeNavigateRefresh(WebDriver webDriver)
	{
		//System.out.println("beforeNavigateRefresh "+ webDriver);
	}

	@Override
	public void afterNavigateRefresh(WebDriver webDriver)
	{
		//waitForPageLoad(webDriver);
		//System.out.println("afterNavigateRefresh " +webDriver);
	}

	@Override
	public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences)
	{
//		waitForPageLoad(webDriver);
		//System.out.println("beforeChangeValueOf "+ webElement);
	}

	@Override
	public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences)
	{
		//System.out.println("afterChangeValueOf "+webElement);
	}
	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1)
	{
		waitForJSandJQueryToLoad(arg1);
		//threadSleep();
		//waitForPageLoad(arg1);
		//moveToElementJS(arg1,arg0);
		//threadSleep();
		//System.out.println("beforeClickOn "+arg0+" WebDriver "+arg1);
	}
	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1)
	{
		//waitForPageLoad(arg1);
		//System.out.println("afterClickOn "+arg0+" WebDriver "+arg1);
	}
	@Override
	public void afterNavigateForward(WebDriver arg0)
	{
		//System.out.println("afterNavigateForward "+arg0);
	}
	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1)
	{

		//waitForPageLoad(arg1);
		//threadSleep();
		//System.out.println("afterNavigateTo "+" WebDriver "+arg1);
	}
	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1)
	{
		//System.out.println("beforeNavigateTo "+" WebDriver "+arg1);
	}
	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2)
	{


		//waitForPageLoad(arg2);
		//System.out.println("beforeFindBy "+" WebElement "+arg1+" WebDriver "+arg2);
	}
	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2)
	{
		//System.out.println("afterFindBy "+arg0+" WebElement "+arg1+" WebDriver "+arg2);
	}
	@Override
	public void afterScript(String arg0, WebDriver arg1)
	{
		//threadSleep();
		//System.out.println("afterScript " +arg1);
	}
	@Override
	public void afterNavigateBack(WebDriver arg0)
	{
		//System.out.println("afterNavigateBack "+arg0);
	}
	@Override
	public void beforeNavigateBack(WebDriver arg0)
	{
		//System.out.println("beforeNavigateBack "+arg0);
	}
	@Override
	public void beforeNavigateForward(WebDriver arg0)
	{
		//System.out.println("beforeNavigateForward "+arg0);
	}
	@Override
	public void beforeScript(String arg0, WebDriver arg1)
	{

		//waitForPageLoad(arg1);
		//System.out.println("beforeScript "+arg0);
	}
	@Override
	public void onException(Throwable arg0, WebDriver arg1)
	{
		System.err.println("Exception :"+arg0);
		if (arg0 instanceof VerifyException)
		{
		//	arg1.close();
		}
		//capture(testName,ERROR_SCREENSHOT_FOLDER);

	}



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


	//TODO not completed
	/***
	 * Need to implement it refactoring
	 */
	private void screenBrowser() {

	}

}