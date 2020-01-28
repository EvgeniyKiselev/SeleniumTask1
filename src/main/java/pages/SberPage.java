package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class SberPage extends BasePageObject {
    @FindBy(xpath = "//span/../../..//h2[contains(text(), 'Страхование путешественников')]")
    public WebElement h2;

    @FindBy(xpath = "//b[contains(text(), 'Оформить онлайн')]")
    public WebElement sendAppBtn;

    public SberPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
}
