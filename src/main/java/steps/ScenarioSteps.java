/**
package steps;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.Когда;

import static pages.SberPage.h2;

public class ScenarioSteps {
    MainPageSteps mainPageSteps = new MainPageSteps();

    SberSteps sberSteps = new SberSteps();

    SendAppSteps sendAppSteps = new SendAppSteps();

    @When("^выбран пункт меню \"(.+)\"$")
    public void selectMenuItem(String menuName){
        mainPageSteps.selectMenuItem(menuName);
    }

    @When("^выбран вид страхования \"(.+)\"$")
    public void selectMenuInsurance(String menuName){
        mainPageSteps.selectMenuInsurance(menuName);
    }

    @Then("^заголовок страницы - Страхование путешественников равен \"(.+)\"$")
    public void checkTitleSberPage(String title){
        sberSteps.checkPageTitle();
    }

    @When("^выполнено нажати на кнопку Отправить заявку$")
    public void clickBtnSendApp(){
        dmsSteps.goToSendAppPage();
    }

    @Then("^заголовок страницы - Заявка на ДМС равен \"(.+)\"$")
    public void checkTitleSendAppPage(String title){
        sendAppSteps.checkPageTitle(title);
    }


    @When("^заполняются поля:$")
    public void fillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> sendAppSteps.fillField(field, value));

    }


    @Then("^значения полей равны:$")
    public void checkFillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> sendAppSteps.checkFillField(field, value));
    }

    @Then("^в поле \"(.+)\" присутствует сообщение об ошибке \"(.+)\"$")
    public void checkErrorMessage(String field, String errorMessage){
        sendAppSteps.checkErrorMessageField(field, errorMessage);

    }
}
*/