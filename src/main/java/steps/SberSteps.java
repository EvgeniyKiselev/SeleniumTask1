/*package steps;

import io.qameta.allure.Step;
import pages.SberPage;


import static org.junit.Assert.assertTrue;

public class SberSteps {

    @Step("заголовок страницы - Страхование путешественников равен {0}")
    public void checkPageTitle() {
        String actualTitle = new SberPage().h2.getText();
        String expectedTitle = "Страхование путешественников";
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

    @Step("выполнено нажатие на Оформить онлайн")
    public void goToSendAppPage() {
        new SberPage().sendToPolicy.click();
    }

}

 */
