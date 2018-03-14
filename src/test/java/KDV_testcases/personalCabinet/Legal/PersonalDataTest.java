package KDV_testcases.personalCabinet.Legal;

import Core.utils.TestReporter;
import KDV_testcases.base.BaseTest;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class PersonalDataTest extends BaseTest {


    @Test
    public void verifyFieldsIsPresent() {
        TestReporter.testTitle("Test ID = 41552");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", "test_n.moiseeva@magdv.com");
        data.put("password", "bu5ttq");
        authorizationPage.verifyAuthFields(data);
        myBookingPage.selectItem();
        personalCabinetPage.verifyFieldsData();
    }

    @Test
    public void verifyFieldsPersonalData() {
        TestReporter.testTitle("Test ID = C41558");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", "test_n.moiseeva@magdv.com");
        data.put("password", "bu5ttq");
        authorizationPage.verifyAuthFields(data);
        JSONObject dataCab = personalCabinetPage.dataPersonal();
        dataCab.put("first", "");
        dataCab.put("last", "");
        dataCab.put("email", "");
        dataCab.put("phone", "");
        personalCabinetPage.fieldIsNecessaryToInputFalse(dataCab);
    }

    @Test
    public void verifyClearAllFields() {
        TestReporter.testTitle("Test ID = C41561");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", "test_n.moiseeva@magdv.com");
        data.put("password", "bu5ttq");
        authorizationPage.verifyAuthFields(data);
        JSONObject dataCab = personalCabinetPage.dataPersonal();
        dataCab.put("first", "");
        dataCab.put("last", "");
        dataCab.put("email", "");
        dataCab.put("phone", "");
        dataCab.put("newPass", "");
        dataCab.put("confirmPass", "");
        personalCabinetPage.fieldIsNecessaryToInputTrue(dataCab);
    }

    @Test
    public void verifyRewriteAllFields() {
        TestReporter.testTitle("Test ID = C41588");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", "test_n.moiseeva@magdv.com");
        data.put("password", "bu5ttq");
        authorizationPage.verifyAuthFields(data);
        JSONObject dataCab = personalCabinetPage.dataPersonal();
        String first = RandomStringUtils.randomAlphabetic(5);
        String last = RandomStringUtils.randomAlphabetic(5);
        String email = "test_n.moiseeva@magdv.com";
        String phone = RandomStringUtils.randomNumeric(10);
        dataCab.put("first", first);
        dataCab.put("last", last);
        dataCab.put("email", email);
        dataCab.put("phone", phone);
        dataCab.put("newPass", "");
        dataCab.put("confirmPass", "");
        personalCabinetPage.verifyRewritingFields(dataCab);
    }

    @Test
    public void verifyRewritePassword() {
        TestReporter.testTitle("Test ID = C41591");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", "test_n.moiseeva@magdv.com");
        data.put("password", "bu5ttq");
        authorizationPage.verifyAuthFields(data);
        JSONObject dataCab = personalCabinetPage.dataPersonal();
        dataCab.put("email", "test_n.moiseeva@magdv.com");
        dataCab.put("newPass", "bu5ttq");
        dataCab.put("confirmPass", "bu5ttq");
        personalCabinetPage.personDataSaved(dataCab);
    }

    @Test
    public void verifyWrongName() {
        TestReporter.testTitle("Test ID = C41598");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", "test_n.moiseeva@magdv.com");
        data.put("password", "bu5ttq");
        authorizationPage.verifyAuthFields(data);
        JSONObject dataCab = personalCabinetPage.dataPersonal();
        dataCab.put("email", "test_n.moiseeva@magdv.com");
        String email = "test_n.moiseeva@magdv.com";
        dataCab.put("email", email);
        dataCab.put("first", "!@#$%^&*()+_/|{}[]?>");
        dataCab.put("last", "!@#$%^&*()+_/|{}[]?>");
        personalCabinetPage.verifyInputWrongNameAndSurname(dataCab);
    }

    @Test
    public void verifyWrongEmail() {
        TestReporter.testTitle("Test ID = C41600");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", "test_n.moiseeva@magdv.com");
        data.put("password", "bu5ttq");
        authorizationPage.verifyAuthFields(data);
        JSONObject dataCab = personalCabinetPage.dataPersonal();
        dataCab.put("email", "test_n.moiseeva@magdv.com");
        String email = "a.shauloandersenlab.com";
        dataCab.put("email", email);
        personalCabinetPage.checkTheAddressIsCorrect(dataCab);
        dataCab.put("email", "test_n.moiseeva@magdv.com");
        email = "a.shaulo@andersenlabcom";
        dataCab.put("email", email);
        personalCabinetPage.checkTheAddressIsCorrect(dataCab);
        dataCab.put("email", "test_n.moiseeva@magdv.com");
        email = "a..shaulo@andersenlab.com";
        dataCab.put("email", email);
        personalCabinetPage.checkTheAddressIsCorrect(dataCab);
        dataCab.put("email", "test_n.moiseeva@magdv.com");
        email = "a.shaulo@anders enlab.com";
        dataCab.put("email", email);
        personalCabinetPage.checkTheAddressIsCorrect(dataCab);
    }

    @Test
    public void verifyWrongPhone() {
        TestReporter.testTitle("Test ID = C41602");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", "test_n.moiseeva@magdv.com");
        data.put("password", "bu5ttq");
        authorizationPage.verifyAuthFields(data);
        JSONObject dataCab = personalCabinetPage.dataPersonal();
        dataCab.put("email", "test_n.moiseeva@magdv.com");
        dataCab.put("phone", "@!#$%&*()_+/*");
        personalCabinetPage.obligatorilyFillTheField(dataCab);
        String phone = RandomStringUtils.randomNumeric(10);
        dataCab.put("phone", phone);
        personalCabinetPage.personDataSaved(dataCab);
    }

    @Test
    public void verifyWrongPass() {
        TestReporter.testTitle("Test ID = C41603");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", "test_n.moiseeva@magdv.com");
        data.put("password", "bu5ttq");
        authorizationPage.verifyAuthFields(data);
        JSONObject dataCab = personalCabinetPage.dataPersonal();
        String pass = RandomStringUtils.randomAlphabetic(5);
        dataCab.put("email", "test_n.moiseeva@magdv.com");
        dataCab.put("currentPass", pass);
        personalCabinetPage.isPasswordWrong(dataCab);
        dataCab.put("newPass", RandomStringUtils.randomAlphabetic(6));
        dataCab.put("confirmPass", RandomStringUtils.randomAlphabetic(7));
        personalCabinetPage.arePasswordsTheSame(dataCab);
    }
}
