package testcases.personalCabinet;

import org.json.JSONObject;
import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.AssertCollector;
import utils.TestReporter;

public class LegalPersonalTest  extends BaseTest{

	@Test
	public void verifyFieldsNotApprovedUser()
	{

		TestReporter.testTitle("Test ID = 41510");
		JSONObject data = authorizationPage.mainAuthorizationInfo();
		data.put("email","test_a.grigoriev@magdv.com");
		data.put("password","vDBAwk");
		authorizationPage.verifyAuthFields(data);
		personalCabinetPage.verifyFieldsNotAuthorization();
	}

	@Test
	public void verifyFieldsApprovedUser()
	{
		TestReporter.testTitle("Test ID = 41521");
		JSONObject data = personalCabinetPage.mainAccountInfo();
		data.put("email","test_g.fadeev@magdv.com");
		data.put("password","gctbVY");
		authorizationPage.verifyAuthFields(data);
		personalCabinetPage.verifyFieldsAuthorization();
	}

	@Test
	public void verifyFieldsNotApprovedUserInfo()
	{
		TestReporter.testTitle("Test ID = 41522");
		JSONObject data = authorizationPage.mainAuthorizationInfo();
		data.put("email","test_a.grigoriev@magdv.com");
		data.put("password","vDBAwk");
		authorizationPage.verifyAuthFields(data);
		personalCabinetPage.verifyFieldsNotAuthorizationInfo();
	}

	@Test
	public void verifyFieldsApprovedUserInfo()
	{
		TestReporter.testTitle("Test ID = 41524");
		JSONObject data = authorizationPage.mainAuthorizationInfo();
		data.put("email","test_g.fadeev@magdv.com");
		data.put("password","gctbVY");
		authorizationPage.verifyAuthFields(data);
		personalCabinetPage.verifyFieldsAuthorizationInfo();
	}
	@Test
	public void verifyFieldsPersonalData()
	{

		TestReporter.testTitle("Test ID = 41552");
		JSONObject data = authorizationPage.mainAuthorizationInfo();
		data.put("email","test_n.moiseeva@magdv.com");
		data.put("password","bu5ttq");
		authorizationPage.verifyAuthFields(data);
		personalCabinetPage.verifyFieldsData();
	}
	@Test
	public void verifyFieldsPersonalDataEmpty()
	{

		TestReporter.testTitle("Test ID = 41552");
		JSONObject data = authorizationPage.mainAuthorizationInfo();
		data.put("email","test_n.moiseeva@magdv.com");
		data.put("password","bu5ttq");
		authorizationPage.verifyAuthFields(data);
		JSONObject dataCab=personalCabinetPage.dataPersonal();
		dataCab.put("first","");
		dataCab.put("last","");
		dataCab.put("email","");
		dataCab.put("phone","");
		dataCab.put("currentPass","");
		dataCab.put("newPass","");
		AssertCollector.assertTrue(personalCabinetPage.fillFields(dataCab,true).contains(
				"Это поле обязательно для заполнения."));
	}

}
