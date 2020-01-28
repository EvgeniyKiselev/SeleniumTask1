import Path.PathForElements;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;

public class SberValidationTest {

    private WebDriver driver;
    private String baseUrl;

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        baseUrl = "http://www.sberbank.ru/ru/person";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void testInsurance() {
        PathForElements path = new PathForElements(
                "Petrov",
                "Petr",
                "18.08.1980",
                "Достоевский",
                "Федор",
                "Михайлович",
                "18.08.1980",
                "1111",
                "123456",
                "18.08.2015",
                "Паспортный стол №15");

        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        WebElement mainMenu =  driver.findElement(By.xpath("//ul[@class = 'lg-menu__list']//button[@class = 'lg-menu__link']/span[contains(text(), 'Страхование')]"));
        wait.until(ExpectedConditions.visibilityOf(mainMenu)).getText();
        mainMenu.click();
        WebElement insuranceInMainMenu = driver.findElement(By.xpath("//div[@class = 'lg-menu__sub']//a[contains(text(), 'Страхование путешественников')]"));
        wait.until(ExpectedConditions.visibilityOf(insuranceInMainMenu)).getText();
        insuranceInMainMenu.click();
        WebElement h2text = driver.findElement(By.xpath("//span/../../..//h2[contains(text(), 'Страхование путешественников')]"));
        wait.until(ExpectedConditions.visibilityOf(h2text));
        Assert.assertEquals("Страхование путешественников", h2text.getText());
        h2text.isDisplayed();
        WebElement btnFormalizeOnline = driver.findElement(By.xpath("//b[contains(text(), 'Оформить онлайн')]"));
        wait.until(ExpectedConditions.visibilityOf(btnFormalizeOnline));
        btnFormalizeOnline.click();
        WebElement minimal = driver.findElement(By.xpath("//h3[contains(text(), 'Минимальная')]"));
        wait.until(ExpectedConditions.visibilityOf(minimal));
        minimal.click();
        WebElement formalizeButton = driver.findElement(By.xpath("//button[contains(text(), 'Оформить')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(formalizeButton);
        wait.until(ExpectedConditions.visibilityOf(formalizeButton));
        wait.until(ExpectedConditions.elementToBeClickable(formalizeButton));
        formalizeButton.click();

        WebElement inputSurnameNameOfInsured = driver.findElement(By.xpath("//input[@id = 'surname_vzr_ins_0']"));
        wait.until(ExpectedConditions.elementToBeClickable(inputSurnameNameOfInsured));
        inputSurnameNameOfInsured.click();
        inputSurnameNameOfInsured.sendKeys(path.getSurnameOfInsured());
        WebElement inputNameOfInsured = driver.findElement(By.xpath("//input[@id = 'name_vzr_ins_0']"));
        wait.until(ExpectedConditions.elementToBeClickable(inputNameOfInsured));
        inputNameOfInsured.click();
        inputNameOfInsured.sendKeys(path.getNameOfInsured());
        WebElement inputDateOfBirthOfInsured = driver.findElement(By.xpath("//input[@id = 'birthDate_vzr_ins_0']"));
        wait.until(ExpectedConditions.elementToBeClickable(inputDateOfBirthOfInsured));
        inputDateOfBirthOfInsured.click();
        inputDateOfBirthOfInsured.sendKeys(path.getDateOfBirthOfInsured());
        WebElement inputLastNameOfPayer = driver.findElement(By.xpath("//input[@id = 'person_lastName']"));
        wait.until(ExpectedConditions.elementToBeClickable(inputLastNameOfPayer));
        inputLastNameOfPayer.click();
        inputLastNameOfPayer.sendKeys(path.getLastNameOfPayer());
        WebElement inputNameOfPayer = driver.findElement(By.xpath("//input[@id = 'person_firstName']"));
        wait.until(ExpectedConditions.elementToBeClickable(inputNameOfPayer));
        inputNameOfPayer.click();
        inputNameOfPayer.sendKeys(path.getNameOfPayer());
        WebElement inputFatherNameOfPayer = driver.findElement(By.xpath("//input[@id = 'person_middleName']"));
        wait.until(ExpectedConditions.elementToBeClickable(inputFatherNameOfPayer));
        inputFatherNameOfPayer.click();
        inputFatherNameOfPayer.sendKeys(path.getFatherNameOfPayer());
        WebElement inputDateOfBirthOfPayer = driver.findElement(By.xpath("//input[@id = 'person_birthDate']"));
        wait.until(ExpectedConditions.elementToBeClickable(inputDateOfBirthOfPayer));
        inputDateOfBirthOfPayer.click();
        inputDateOfBirthOfPayer.sendKeys(path.getDateOfBirthOfPayer());
        WebElement inputDocSeries = driver.findElement(By.xpath("//input[@id = 'passportSeries']"));
        wait.until(ExpectedConditions.elementToBeClickable(inputDocSeries));
        inputDocSeries.click();
        inputDocSeries.sendKeys(path.getDocSeries());
        WebElement inputDocNumber = driver.findElement(By.xpath("//input[@id = 'passportNumber']"));
        wait.until(ExpectedConditions.elementToBeClickable(inputDocNumber));
        inputDocNumber.click();
        inputDocNumber.sendKeys(path.getDocNumber());
        WebElement inputDocDate = driver.findElement(By.xpath("//input[@id = 'documentDate']"));
        wait.until(ExpectedConditions.elementToBeClickable(inputDocDate));
        inputDocDate.click();
        inputDocDate.sendKeys(path.getDocDate());
        WebElement getDocIssue = driver.findElement(By.xpath("//input[@id = 'documentIssue']"));
        wait.until(ExpectedConditions.elementToBeClickable(getDocIssue));
        getDocIssue.click();
        getDocIssue.sendKeys(path.getDocIssue());

        Assert.assertEquals(path.getSurnameOfInsured(), inputSurnameNameOfInsured.getAttribute("value"));
        Assert.assertEquals(path.getNameOfInsured(), inputNameOfInsured.getAttribute("value"));
        Assert.assertEquals(path.getDateOfBirthOfInsured(), inputDateOfBirthOfInsured.getAttribute("value"));
        Assert.assertEquals(path.getLastNameOfPayer(), inputLastNameOfPayer.getAttribute("value"));
        Assert.assertEquals(path.getNameOfPayer(), inputNameOfPayer.getAttribute("value"));
        Assert.assertEquals(path.getFatherNameOfPayer(), inputFatherNameOfPayer.getAttribute("value"));
        Assert.assertEquals(path.getDateOfBirthOfPayer(), inputDateOfBirthOfPayer.getAttribute("value"));
        Assert.assertEquals(path.getDocSeries(), inputDocSeries.getAttribute("value"));
        Assert.assertEquals(path.getDocNumber(), inputDocNumber.getAttribute("value"));
        Assert.assertEquals(path.getDocDate(), inputDocDate.getAttribute("value"));
        Assert.assertEquals(path.getDocIssue(), getDocIssue.getAttribute("value"));

        WebElement btnContinue =  driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]"));
        wait.until(ExpectedConditions.elementToBeClickable(btnContinue));
        btnContinue.click();

        WebElement validationMessage = driver.findElement(By.xpath("//div[@class ='alert-form alert-form-error']"));
        wait.until(ExpectedConditions.visibilityOf(validationMessage));
        Assert.assertEquals("При заполнении данных произошла ошибка", validationMessage.getText());
        validationMessage.isDisplayed();
    }

    @After
    public void afterTest() {
        driver.quit();
    }
}
