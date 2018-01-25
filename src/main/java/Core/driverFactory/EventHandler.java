package Core.driverFactory;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import static utils.WaitingUtility.waitForJSandJQueryToLoad;
import static utils.WaitingUtility.waitForPageLoad;

public abstract class EventHandler   implements WebDriverEventListener   {
	@Override
	public void beforeNavigateRefresh(WebDriver webDriver)
	{
		//System.out.println("beforeNavigateRefresh "+ webDriver);
	}

	@Override
	public void afterNavigateRefresh(WebDriver webDriver)
	{
		waitForPageLoad(webDriver);
		//System.out.println("afterNavigateRefresh " +webDriver);
	}

	@Override
	public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences)
	{

		waitForPageLoad(webDriver);
		//System.out.println("beforeChangeValueOf "+ webElement);
	}

	@Override
	public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences)
	{
		//System.out.println("afterChangeValueOf "+webElement);
	}
	public void beforeClickOn(WebElement arg0, WebDriver arg1)
	{
		waitForJSandJQueryToLoad(arg1);
		waitForPageLoad(arg1);
		//moveToElementJS(arg1,arg0);
		threadSleep();
		//System.out.println("beforeClickOn "+arg0+" WebDriver "+arg1);
	}

	public void afterClickOn(WebElement arg0, WebDriver arg1)
	{
		waitForPageLoad(arg1);
		//System.out.println("afterClickOn "+arg0+" WebDriver "+arg1);
	}

	public void afterNavigateForward(WebDriver arg0)
	{
		//System.out.println("afterNavigateForward "+arg0);
	}

	public void afterNavigateTo(String arg0, WebDriver arg1)
	{

		waitForPageLoad(arg1);
		//System.out.println("afterNavigateTo "+" WebDriver "+arg1);
	}

	public void beforeNavigateTo(String arg0, WebDriver arg1)
	{
		//System.out.println("beforeNavigateTo "+" WebDriver "+arg1);
	}

	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2)
	{

		waitForPageLoad(arg2);
		//System.out.println("beforeFindBy "+" WebElement "+arg1+" WebDriver "+arg2);
	}

	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2)
	{
		//System.out.println("afterFindBy "+arg0+" WebElement "+arg1+" WebDriver "+arg2);
	}

	public void afterScript(String arg0, WebDriver arg1)
	{
		threadSleep();
		//System.out.println("afterScript " +arg1);
	}

	public void afterNavigateBack(WebDriver arg0)
	{
		//System.out.println("afterNavigateBack "+arg0);
	}

	public void beforeNavigateBack(WebDriver arg0)
	{
		//System.out.println("beforeNavigateBack "+arg0);
	}

	public void beforeNavigateForward(WebDriver arg0)
	{
		//System.out.println("beforeNavigateForward "+arg0);
	}

	public void beforeScript(String arg0, WebDriver arg1)
	{

		waitForPageLoad(arg1);
		//System.out.println("beforeScript "+arg0);
	}

	public void onException(Throwable arg0, WebDriver arg1)
	{
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
	private void threadSleep()
	{
		try {
			Thread.sleep(250);
		}
		catch (Exception e)
		{
			System.out.println();
		}
	}
}