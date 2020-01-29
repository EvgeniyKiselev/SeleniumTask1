package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Init;


public class SberPage extends BasePage {
    @FindBy(xpath = "//span/../../..//h2[contains(text(), 'Страхование путешественников')]")
    public static WebElement h2;

    @FindBy(xpath = "//b[contains(text(), 'Оформить онлайн')]")
    public WebElement sendToPolicy;

    public void checkH2(String h2){
        h2.equals("Страхование путешественников");
    }

    public void selectSendToPolicy(){
        this.sendToPolicy.click();
    }

    public SberPage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }

   //public SberPage(){
   //    PageFactory.initElements(BaseSteps.getDriver(), this);
   //}

    public void waitSendAppClickable(){
        Wait<WebDriver> wait = new WebDriverWait(Init.getDriver(), 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(sendToPolicy));
    }
}
