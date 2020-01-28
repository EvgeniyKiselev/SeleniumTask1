package steps;

import io.qameta.allure.Step;
import pages.SberPage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

public class SberSteps {
    @Step("выполнено нажатие на Отправить заявку")
    public void goToSendAppPage() {
        new DMSPage().sendAppBtn.click();
    }


    @Step("заголовок страницы - ДМС равен {0}")
    public void checkPageTitle(String expectedTitle) {
        String actualTitle = new DMSPage().title.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

}
