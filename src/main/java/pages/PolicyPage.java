package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.Init;

public class PolicyPage extends BasePage {
    @FindBy(xpath = "//h3[contains(text(), 'Минимальная')]")
    public WebElement minimal;

    @FindBy(xpath = "//button[contains(text(), 'Оформить')]")
    public WebElement sendButton;

    public PolicyPage() {

    }

    public void selectMinimal(){
        minimal.click();
    }

    public void selectSendButton(){
        //WebElement formalizeButton = driver.findElement(By.xpath("//button[contains(text(), 'Оформить')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(sendButton);
        wait.until(ExpectedConditions.visibilityOf(sendButton));
        wait.until(ExpectedConditions.elementToBeClickable(sendButton));
        sendButton.click();
    }

    public PolicyPage(WebDriver driver){
        PageFactory.initElements(Init.getDriver(), this);
        (new WebDriverWait(Init.getDriver(), 10))
                .until(ExpectedConditions.visibilityOf(minimal));
        this.driver = driver;
    }
}
