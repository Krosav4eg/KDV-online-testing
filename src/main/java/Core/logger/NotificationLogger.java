package Core.logger;

import org.testng.ITestResult;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotificationLogger {

	public static String mailBody;
	public static String testState;
	private static Integer successTest = 0, failTest = 0, skipTest = 0;
	private static List<String> FailureTest = new ArrayList<>();
	private static List<String> SuccessTest = new ArrayList<>();
	private static List<String> SkippTest = new ArrayList<>();





	public static String TestStatus(ITestResult result) {
		switch (result.getStatus()) {
			case ITestResult.FAILURE: {
				testState = "FAILURE";
				failTest = failTest + 1;
				FailureTest.add("FAILED -\t "+result.getName() + "\t\n ");
				break;
			}
			case ITestResult.SUCCESS: {
				testState = "SUCCESS";
				successTest = successTest + 1;
				SuccessTest.add("PASSED -\t "+result.getName() + "\t\n");
				break;
			}
			case ITestResult.SKIP: {
				testState = "SKIP";
				skipTest = skipTest + 1;
				SkippTest.add("SKIPPED -\t "+ result.getName() + "\t\n");
				break;
			}
		}
		mailBody =getHead(successTest,failTest,skipTest,SkippTest,SuccessTest,FailureTest);
		return mailBody;
	}


	private static String getHead(int pass,int failure,int skipp,List<String> SkippTest,
	                       List<String> passTest,List<String> failedTest) {
		StringBuilder failedString= new StringBuilder();
		for (String aFailedTest : failedTest) {
			failedString.append("\t<div style=\"color:red;width: 100%;\">").append("<b>").append(aFailedTest).append("</b>\n</div>");
		}
		StringBuilder passString= new StringBuilder();
		for (String aPassTest : passTest) {
			passString.append("\t<div style=\"color:green;width: 100%;\">").append("<b>").append(aPassTest).append("</b>\n</div>");
		}
		StringBuilder skippString= new StringBuilder();
		for (String aSkippTest : SkippTest) {
			skippString.append("\t<div style=\"color:orange;width: 100%;\">").append("<b>").append(aSkippTest).append("</b>\n</div>");
		}
		return "<!DOCTYPE html>\n<head>\n<style>\n"
				+ "table { width: 100% }\n"
				+ "th { font:bold 8pt Tahoma; }\n"
				+ "td { font:normal 10pt Tahoma; }\n"
				+ "h1 {font:normal 14pt Tahoma;}\n"
				+ "</style>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "<h1>" + (new Date()) + "</h1>\n"
				+ "<table border=\"0\" cellpadding=\"5\" cellspacing=\"3\">\n"
				+ "<tr align=\"left\">\n"
				+ "\t<th style=\"width:33%\">Pass Tests:"+pass+"</th>\n"
				+ "\t<th style=\"width:33%\">Failure Tests:"+failure+"</th>\n"
				+ "\t<th style=\"width:33%\">Skipp Tests:"+skipp+"</th>\n"
				+ "</tr>\n"
				+"</table>"
				+ "\t<br>\n"
				+failedString
				+skippString
				+passString;



	}


}
