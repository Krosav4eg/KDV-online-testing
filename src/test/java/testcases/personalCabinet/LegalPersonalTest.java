package testcases.personalCabinet;

import org.json.JSONObject;
import org.testng.annotations.Test;
import testcases.base.BaseTest;

public class LegalPersonalTest  extends BaseTest{


	@Test
	public void verifyFieldsNotApprovedUser()
	{
		JSONObject data = authorizationPage.mainAuthorizationInfo();
		data.put("email","test_a.grigoriev@magdv.com");
		data.put("password","vDBAwk");
		authorizationPage.verifyAuthFields(data);
		personalCabinetPage.verifyFieldsNotAuthorization();
	}

	@Test
	public void verifyFieldsApprovedUser()
	{
		JSONObject data = personalCabinetPage.mainAccountInfo();
		data.put("email","test_g.fadeev@magdv.com");
		data.put("password","gctbVY");
		authorizationPage.verifyAuthFields(data);
		personalCabinetPage.verifyFieldsAuthorization();
	}


	@Test
	public void verifyFieldsNotApprovedUserInfo()
	{
		JSONObject data = authorizationPage.mainAuthorizationInfo();
		data.put("email","test_a.grigoriev@magdv.com");
		data.put("password","vDBAwk");
		authorizationPage.verifyAuthFields(data);
		personalCabinetPage.verifyFieldsNotAuthorizationInfo();
	}
	@Test
	public void verifyFieldsApprovedUserInfo()
	{
		JSONObject data = authorizationPage.mainAuthorizationInfo();
		data.put("email","test_g.fadeev@magdv.com");
		data.put("password","gctbVY");
		authorizationPage.verifyAuthFields(data);
		personalCabinetPage.verifyFieldsAuthorizationInfo();
	}
}
