import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.MainPage;
import pages.PolicyPage;
import pages.SberPage;
import pages.SendAppPage;
import util.Init;

import static util.Init.initDriver;

public class SberValidationTestPageObjAllureCucumber  {

    @Before
    public void setUp(){
        initDriver();
    }

    @After
    public void close() {
        Init.closeDriver();
    }

    @Test
    public void testSberInsurance() throws Exception {

       // driver.get(baseUrl + "/");
        MainPage mainPage = new MainPage(Init.getDriver());
        mainPage.selectMenuItem("Страхование");
        mainPage.selectInsuranceItem("Страхование путешественников");

        new SberPage(Init.getDriver()).waitSendAppClickable();
        SberPage sberPage = new SberPage(Init.getDriver());
        sberPage.checkH2("Страхование путешественников");
        sberPage.selectSendToPolicy();

        PolicyPage policyPage = new PolicyPage(Init.getDriver());
        policyPage.selectMinimal();
        policyPage.selectSendButton();

        SendAppPage sendAppPage = new SendAppPage(Init.getDriver());
        sendAppPage.waitNavClickable();
        sendAppPage.fillField("Фамилия застрахованного", "Prokofiev");
        sendAppPage.fillField("Имя застрахованного", "Sergey");
        sendAppPage.fillField("Дата рождения застрахованного", "18.08.1980");
        sendAppPage.fillField("Фамилия страхователя", "Достоевский");
        sendAppPage.fillField("Имя страхователя", "Федор");
        sendAppPage.fillField("Отчество страхователя", "Михайлович");
        sendAppPage.fillField("Дата рождения страхователя", "18.05.1980");
        sendAppPage.fillField("Серия паспорта", "1111");
        sendAppPage.fillField("Номер паспорта", "123456");
        sendAppPage.fillField("Дата выдачи паспорта", "15.16.2013");
        sendAppPage.fillField("Кем выдан", "Паспортный стол");

        sendAppPage.getFillField("Фамилия застрахованного");
        sendAppPage.getFillField("Имя застрахованного");
        sendAppPage.getFillField("Дата рождения застрахованного");
        sendAppPage.getFillField("Фамилия страхователя");
        sendAppPage.getFillField("Имя страхователя");
        sendAppPage.getFillField("Отчество страхователя");
        sendAppPage.getFillField("Дата рождения страхователя");
        sendAppPage.getFillField("Серия паспорта");
        sendAppPage.getFillField("Номер паспорта");
        sendAppPage.getFillField("Дата выдачи паспорта");
        sendAppPage.getFillField("Кем выдан");
        sendAppPage.sendResult();
        sendAppPage.checkFieldErrorMessage(sendAppPage.getFieldErrorMessage(), "При заполнении данных произошла ошибка");
        System.out.println(sendAppPage.getFieldErrorMessage());
    }
}
