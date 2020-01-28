package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MainPage extends BasePageObject {
    @FindBy(xpath = "//ul[@class = 'lg-menu__list']//button[@class = 'lg-menu__link']/span[contains(text(), 'Страхование')]")
    WebElement menuItems;

    @FindBy(xpath = "//div[@class = 'lg-menu__sub']//a[contains(text(), 'Страхование путешественников')]")
    WebElement menuInsurance;

    public MainPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMenuItem(String itemName){
        menuItems.click();
    }

    public void selectInsuranceItem(String itemName){
        menuInsurance.click();
    }
}
