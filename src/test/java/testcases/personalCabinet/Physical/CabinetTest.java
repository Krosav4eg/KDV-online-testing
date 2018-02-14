package testcases.personalCabinet.Physical;

import Core.basePage.BasePage;
import org.json.JSONObject;
import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.AssertCollector;
import utils.TestReporter;

import static Core.basePage.BasePage.navigateBack;
import static utils.Constants.*;
import static utils.WaitingUtility.elementIsVisible;

public class CabinetTest extends BaseTest {
    BasePage.MyDelegate del = new BasePage.MyDelegate() {
    };

    // TODO: 12.01.2018 C38045 take id from DB

    @Test
    public void verifyAccountAndAddressByDefaultTest() {
        TestReporter.testTitle("Test ID = 38062-38066,38196-38200");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", AUTHORIZATION_EMAIL);
        data.put("password", AUTHORIZATION_PASSWORD);
        authorizationPage.verifyAuthFields(data);
        AssertCollector.verifyCondition(elementIsVisible(controlPanelPage.personalDataHeader,driver));
        AssertCollector.verifyCondition(controlPanelPage.nameInPersonalData.getText().
                contains("Аркадий Евдокимов"));
        AssertCollector.verifyCondition(controlPanelPage.emailInPersonalData.getText().equals(AUTHORIZATION_EMAIL));
        AssertCollector.verifyCondition(controlPanelPage.phoneInPersonalData.getText().equals("+77111111111"));

        String expLink = del.getValueOfAttributeByName(controlPanelPage.editPersonalDataButton, "href");
        (controlPanelPage.editPersonalDataButton).click();
        AssertCollector.verifyCondition(del.getCurrentUrlDelegate().equals(expLink));
        navigateBack();
        AssertCollector.verifyCondition(elementIsVisible(controlPanelPage.addressByDefaultHeader,driver));
        AssertCollector.verifyCondition(controlPanelPage.nameInAddressByDefault.getText().equals("Аркадий Евдокимов"));
        AssertCollector.verifyCondition(controlPanelPage.addressInAddressByDefault.getText().
                equals("г Кемерово, ул Варшавская, д 87, кв 12"));
        AssertCollector.verifyCondition(controlPanelPage.phoneInAddressByDefault.getText().equals("+71111111111"));
        del.scrollToNecessaryElementDelegate(controlPanelPage.editAddressButton);
        String expLink1 = del.getValueOfAttributeByName(controlPanelPage.editAddressButton, "href");
        (controlPanelPage.editAddressButton).click();
        AssertCollector.verifyCondition(del.getCurrentUrlDelegate().equals(expLink1));
    }

    @Test
    public void verifyControlPanelTest() {
        TestReporter.testTitle("Test ID = 37820,37821,37822");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", PHYSICAL_PERSON_EMAIL);
        data.put("password", PHYSICAL_PERSON_PASSWORD);
        authorizationPage.verifyAuthFields(data);
        AssertCollector.verifyCondition(elementIsVisible(controlPanelPage.controlPanelHeader,driver));
        del.textPresentDelegate("Здравствуйте, Иннокентий Макаров!");
        del.textPresentDelegate("Здесь вы можете просмотреть краткий обзор активности вашей учётной записи.");
    }
}
