package testcases.registration.individualEntrepreneur;

import Core.basePage.BasePage;
import org.json.JSONObject;
import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.AssertCollector;
import utils.TestReporter;

public class InformationAuthorizationTest extends BaseTest {

	private BasePage.MyDelegate del = new BasePage.MyDelegate() {
	};
	@Test
	public void verifyCorrectMailTest() {
		TestReporter.testTitle("Test ID = 37516");
		JSONObject verifyData=registrationPage.mainInfoRegistration();
		verifyData.put("email","a.shaulo@andersenlabcom");
		AssertCollector.assertTrue(registrationPage.verifyAuthorizationFieldsIndividual(verifyData).
				contains("Пожалуйста, введите правильный адрес электронной почты (email)"));
		verifyData=registrationPage.mainInfoRegistration();
		verifyData.put("email","a..shaulo@andersenlab.com");
		AssertCollector.assertTrue(registrationPage.verifyAuthorizationFieldsIndividual(verifyData).
				contains("Пожалуйста, введите правильный адрес электронной почты (email)"));
		verifyData=registrationPage.mainInfoRegistration();
		verifyData.put("email","ulo@andersenlab.com");
		AssertCollector.assertTrue(registrationPage.verifyAuthorizationFieldsIndividual(verifyData).
				contains("Пожалуйста, введите правильный адрес электронной почты (email)"));
	}
	@Test
	public void verifyMandatoryEmptyTaxIdTest() {
		TestReporter.testTitle("Test ID = 37521,40070,40071");
		JSONObject verifyData=registrationPage.mainInfoRegistration();
		verifyData.put("email","a.sha#ulo@andersenlab.com");
		registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
		AssertCollector.assertFalse(del.getCurrentUrlDelegate().contains("account/forgotpassword/"));
		verifyData=registrationPage.mainInfoRegistration();
		verifyData.put("email","a.sha$ulo@andersenlab.com");
		registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
		AssertCollector.assertFalse(del.getCurrentUrlDelegate().contains("account/forgotpassword/"));
		verifyData=registrationPage.mainInfoRegistration();
		verifyData.put("email","a.sha%ulo@andersenlab.com");
		registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
		AssertCollector.assertFalse(del.getCurrentUrlDelegate().contains("account/forgotpassword/"));
		verifyData=registrationPage.mainInfoRegistration();
		verifyData.put("email","a.sha^ulo@andersenlab.com");
		registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
		AssertCollector.assertFalse(del.getCurrentUrlDelegate().contains("account/forgotpassword/"));
		verifyData=registrationPage.mainInfoRegistration();
		verifyData.put("email","a.sha&ulo@andersenlab.com");
		registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
		AssertCollector.assertFalse(del.getCurrentUrlDelegate().contains("account/forgotpassword/"));
		verifyData=registrationPage.mainInfoRegistration();
		verifyData.put("email","a.sha*ulo@andersenlab.com");
		registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
		AssertCollector.assertFalse(del.getCurrentUrlDelegate().contains("account/forgotpassword/"));
		verifyData=registrationPage.mainInfoRegistration();
		verifyData.put("email","a.sha()ulo@andersenlab.com");
		registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
		AssertCollector.assertFalse(del.getCurrentUrlDelegate().contains("account/forgotpassword/"));
		verifyData=registrationPage.mainInfoRegistration();
		verifyData.put("email","a.sha_ulo@andersenlab.com");
		registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
		AssertCollector.assertFalse(del.getCurrentUrlDelegate().contains("account/forgotpassword/"));
		verifyData=registrationPage.mainInfoRegistration();
		verifyData.put("email","a.sha+ulo@andersenlab.com");
		registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
		AssertCollector.assertFalse(del.getCurrentUrlDelegate().contains("account/forgotpassword/"));
	}
 	@Test
 	public void verifyMandatoryCorrectPassTest() {
 		TestReporter.testTitle("Test ID = 37522");
 		JSONObject verifyData=registrationPage.mainInfoRegistration();
 		registrationPage.verifyAuthorizationFieldsIndividual(verifyData);
	    AssertCollector.assertTrue(del.getCurrentUrlDelegate().contains("customer/account/login/"));
 	}
 	@Test
 	public void verifyMandatoryWrongPassTest() {
 		TestReporter.testTitle("Test ID = 37523");
 		JSONObject verifyData=registrationPage.mainInfoRegistration();
 		verifyData.put("pass","131");
 		AssertCollector.assertTrue(registrationPage.verifyAuthorizationFieldsIndividual(verifyData).
 				contains("Пожалуйста, введите не менее 6 символов без пробелов в конце и в начале."));verifyData=registrationPage.mainInfoRegistration();
	    verifyData.put("pass","131 123");
	    AssertCollector.assertTrue(registrationPage.verifyAuthorizationFieldsIndividual(verifyData).
			    contains("Пожалуйста, введите не менее 6 символов без пробелов в конце и в начале."));
 	}

	@Test
	public void verifyMandatoryEmptyConfirmPasswordTest() {
		TestReporter.testTitle("Test ID = C40075");
		JSONObject verifyData=registrationPage.mainInfoRegistration();
		verifyData.put("confirmPassword","test234   ");
		verifyData.put("pass","testsea");
		AssertCollector.assertTrue(registrationPage.verifyAuthorizationFieldsIndividual(verifyData).
				contains("Это поле обязательно для заполнения."));
	}
}