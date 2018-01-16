package driverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

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
		//System.out.println("beforeChangeValueOf "+ webElement);
	}

	@Override
	public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences)
	{
		//System.out.println("afterChangeValueOf "+webElement);
	}
	public void beforeClickOn(WebElement arg0, WebDriver arg1)
	{
	//	threadSleep();
		waitForPageLoad(arg1);
		waitForJSandJQueryToLoad(arg1);
		//System.out.println("beforeClickOn "+arg0+" WebDriver "+arg1);
	}

	public void afterClickOn(WebElement arg0, WebDriver arg1)
	{
		waitForPageLoad(arg1);
		waitForJSandJQueryToLoad(arg1);
		//System.out.println("afterClickOn "+arg0+" WebDriver "+arg1);
	}

	public void afterNavigateForward(WebDriver arg0)
	{
		//System.out.println("afterNavigateForward "+arg0);
	}

	public void afterNavigateTo(String arg0, WebDriver arg1)
	{
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
			screenBrowser();
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
			Thread.sleep(100);
		}
		catch (Exception e)
		{

		}
	}
}