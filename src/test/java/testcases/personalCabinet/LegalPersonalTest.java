package testcases.personalCabinet;

import org.apache.commons.lang.RandomStringUtils;
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
	public void verifyFieldsIsPresent()
	{

		TestReporter.testTitle("Test ID = 41552");
		JSONObject data = authorizationPage.mainAuthorizationInfo();
		data.put("email","test_n.moiseeva@magdv.com");
		data.put("password","bu5ttq");
		authorizationPage.verifyAuthFields(data);
		personalCabinetPage.verifyFieldsData();
	}
	@Test
	public void verifyFieldsPersonalData()
	{
		TestReporter.testTitle("Test ID = C41558");
		JSONObject data = authorizationPage.mainAuthorizationInfo();
		data.put("email","test_n.moiseeva@magdv.com");
		data.put("password","bu5ttq");
		authorizationPage.verifyAuthFields(data);
		JSONObject dataCab=personalCabinetPage.dataPersonal();
		dataCab.put("first","");
		dataCab.put("last","");
		dataCab.put("email","");
		dataCab.put("phone","");
		AssertCollector.assertTrue(personalCabinetPage.fillFields(dataCab,false).contains(
				"Это поле обязательно для заполнения."));
	}

	@Test
	public void verifyClearAllFields()
	{
		TestReporter.testTitle("Test ID = C41561");
		JSONObject data = authorizationPage.mainAuthorizationInfo();
		data.put("email","test_n.moiseeva@magdv.com");
		data.put("password","bu5ttq");
		authorizationPage.verifyAuthFields(data);
		JSONObject dataCab=personalCabinetPage.dataPersonal();
		dataCab.put("first","");
		dataCab.put("last","");
		dataCab.put("email","");
		dataCab.put("phone","");
		dataCab.put("newPass","");
		dataCab.put("confirmPass","");
		AssertCollector.assertTrue(personalCabinetPage.fillFields(dataCab,true).contains(
				"Это поле обязательно для заполнения."));
	}

	@Test
	public void verifyRewriteAllFields()
	{
		TestReporter.testTitle("Test ID = C41588");
		JSONObject data = authorizationPage.mainAuthorizationInfo();
		data.put("email","test_n.moiseeva@magdv.com");
		data.put("password","bu5ttq");
		authorizationPage.verifyAuthFields(data);
		JSONObject dataCab=personalCabinetPage.dataPersonal();
		String first=RandomStringUtils.randomAlphabetic(5);
		String last=RandomStringUtils.randomAlphabetic(5);
		String email="test_n.moiseeva@magdv.com";
		String phone=RandomStringUtils.randomNumeric(10);
		dataCab.put("first", first);
		dataCab.put("last",last);
		dataCab.put("email",email);
		dataCab.put("phone",phone);
		dataCab.put("newPass","");
		dataCab.put("confirmPass","");
		String allResult=personalCabinetPage.fillFields(dataCab,false);
		AssertCollector.verifyCondition(allResult.contains(first));
		AssertCollector.verifyCondition(allResult.contains(last));
		AssertCollector.verifyCondition(allResult.contains(email));
		AssertCollector.verifyCondition(allResult.contains(phone));
	}
	@Test
	public void verifyRewritePassword()
	{
		TestReporter.testTitle("Test ID = C41588");
		JSONObject data = authorizationPage.mainAuthorizationInfo();
		data.put("email","test_n.moiseeva@magdv.com");
		data.put("password","bu5ttq");
		authorizationPage.verifyAuthFields(data);
		JSONObject dataCab=personalCabinetPage.dataPersonal();
		dataCab.put("email","test_n.moiseeva@magdv.com");
		dataCab.put("newPass","bu5ttq");
		dataCab.put("confirmPass","bu5ttq");
		AssertCollector.assertTrue(personalCabinetPage.fillFields(dataCab,true).
				contains("Данные учётной записи сохранены."));
	}

	@Test
	public void verifyWrongName()
	{
		TestReporter.testTitle("Test ID = C41598");
		JSONObject data = authorizationPage.mainAuthorizationInfo();
		data.put("email","test_n.moiseeva@magdv.com");
		data.put("password","bu5ttq");
		authorizationPage.verifyAuthFields(data);
		JSONObject dataCab=personalCabinetPage.dataPersonal();
		dataCab.put("email","test_n.moiseeva@magdv.com");
		String email="test_n.moiseeva@magdv.com";
		dataCab.put("email",email);
		dataCab.put("first", "!@#$%^&*()+_/|{}[]?>");
		dataCab.put("last","!@#$%^&*()+_/|{}[]?>");
		String allResult=personalCabinetPage.fillFields(dataCab,false);
		AssertCollector.verifyCondition(allResult.contains("Значение 'Фамилия' не должно быть пустым и может содержать только буквы, тире и апостроф."));
		AssertCollector.verifyCondition(allResult.contains("Значение 'Имя' не должно быть пустым и может содержать только буквы, тире и апостроф."));

	}

	@Test
	public void verifyWrongEmail()
	{
		TestReporter.testTitle("Test ID = C41600");
		JSONObject data = authorizationPage.mainAuthorizationInfo();
		data.put("email","test_n.moiseeva@magdv.com");
		data.put("password","bu5ttq");
		authorizationPage.verifyAuthFields(data);
		JSONObject dataCab=personalCabinetPage.dataPersonal();
		dataCab.put("email","test_n.moiseeva@magdv.com");
		String email="a.shauloandersenlab.com";
		dataCab.put("email",email);
		String allResult=personalCabinetPage.fillFields(dataCab,false);
		AssertCollector.verifyCondition(allResult.contains("Пожалуйста, введите правильный адрес электронной почты (email)."));
		dataCab.put("email","test_n.moiseeva@magdv.com");
		email="a.shaulo@andersenlabcom";
		dataCab.put("email",email);
		allResult=personalCabinetPage.fillFields(dataCab,false);
		AssertCollector.verifyCondition(allResult.contains("Пожалуйста, введите правильный адрес электронной почты (email)."));
		dataCab.put("email","test_n.moiseeva@magdv.com");
		email="a..shaulo@andersenlab.com";
		dataCab.put("email",email);
		allResult=personalCabinetPage.fillFields(dataCab,false);
		AssertCollector.verifyCondition(allResult.contains("Пожалуйста, введите правильный адрес электронной почты (email)."));
		dataCab.put("email","test_n.moiseeva@magdv.com");
		email="a.shaulo@anders enlab.com";
		dataCab.put("email",email);
		allResult=personalCabinetPage.fillFields(dataCab,false);
		AssertCollector.verifyCondition(allResult.contains("Пожалуйста, введите правильный адрес электронной почты (email)."));

	}

	@Test
	public void verifyWrongPhone()
	{
		TestReporter.testTitle("Test ID = C41602");
		JSONObject data = authorizationPage.mainAuthorizationInfo();
		data.put("email","test_n.moiseeva@magdv.com");
		data.put("password","bu5ttq");
		authorizationPage.verifyAuthFields(data);
		JSONObject dataCab=personalCabinetPage.dataPersonal();
		dataCab.put("email","test_n.moiseeva@magdv.com");
		dataCab.put("phone","@!#$%&*()_+/*");
		String allResult=personalCabinetPage.fillFields(dataCab,false);
		AssertCollector.verifyCondition(allResult.contains("Это поле обязательно для заполнения."));
		String phone=RandomStringUtils.randomNumeric(10);
		dataCab.put("phone",phone);
		allResult=personalCabinetPage.fillFields(dataCab,false);
		AssertCollector.verifyCondition(allResult.contains("Данные учётной записи сохранены."));

	}

	@Test
	public void verifyWrongPass()
	{
		TestReporter.testTitle("Test ID = C41603");
		JSONObject data = authorizationPage.mainAuthorizationInfo();
		data.put("email","test_n.moiseeva@magdv.com");
		data.put("password","bu5ttq");
		authorizationPage.verifyAuthFields(data);
		JSONObject dataCab=personalCabinetPage.dataPersonal();
		String pass = RandomStringUtils.randomAlphabetic(5);
		dataCab.put("email","test_n.moiseeva@magdv.com");
		dataCab.put("currentPass",pass);
		String allResult=personalCabinetPage.fillFields(dataCab,false);
		AssertCollector.verifyCondition(allResult.contains("Неправильный текущий пароль"));
		dataCab.put("newPass",RandomStringUtils.randomAlphabetic(6));
		dataCab.put("confirmPass",RandomStringUtils.randomAlphabetic(7));
		allResult=personalCabinetPage.fillFields(dataCab,true);
		AssertCollector.verifyCondition(allResult.contains("Пожалуйста, убедитесь, что ваши пароли совпадают."));
	}

}
