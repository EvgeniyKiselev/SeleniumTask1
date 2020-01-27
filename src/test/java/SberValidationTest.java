import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import java.util.concurrent.TimeUnit;

public class SberValidationTest {

    /**
     * Задание лежит в корне проекта, в файле testCase1
     */

    WebDriver driver;
    String baseUrl;

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
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//ul[@class = 'lg-menu__list']//button[@class = 'lg-menu__link']/span[contains(text(), 'Страхование')]")).click();
        driver.findElement(By.xpath("//div[@class = 'lg-menu__sub']//a[contains(text(), 'Страхование путешественников')]")).click();

        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

        WebElement h2text = driver.findElement(By.xpath("//span/../../..//h2[contains(text(), 'Страхование путешественников')]"));
        wait.until(ExpectedConditions.visibilityOf(h2text)).getText();
        Assert.assertEquals("Страхование путешественников", driver.findElement(By.xpath("//span/../../..//h2[contains(text(), 'Страхование путешественников')]")).getText());
        driver.findElement(By.xpath("//span/../../..//h2[contains(text(), 'Страхование путешественников')]")).isDisplayed();

        driver.findElement(By.xpath("//b[contains(text(), 'Оформить онлайн')]")).click();
        driver.findElement(By.xpath("//h3[contains(text(), 'Минимальная')]")).click();

        WebElement formalizeButton = driver.findElement(By.xpath("//button[contains(text(), 'Оформить')]"));
        wait.until(ExpectedConditions.visibilityOf(formalizeButton)).getText();

        driver.findElement(By.xpath("//button[contains(text(), 'Оформить')]")).click();
        driver.findElement(By.xpath("//input[@id = 'surname_vzr_ins_0']")).sendKeys("Petrov");
        driver.findElement(By.xpath("//input[@id = 'name_vzr_ins_0']")).sendKeys("Petr");
        driver.findElement(By.xpath("//input[@id = 'birthDate_vzr_ins_0']")).sendKeys("05.01.1985");
        driver.findElement(By.xpath("//label[contains(text(), 'гражданин РФ')]")).click();
        driver.findElement(By.xpath("//input[@id = 'person_lastName']")).sendKeys("Ложкин");
        driver.findElement(By.xpath("//input[@id = 'person_firstName']")).sendKeys("Василий");
        driver.findElement(By.xpath("//input[@id = 'person_middleName']")).sendKeys("Валерьевич");
        driver.findElement(By.xpath("//input[@id = 'person_birthDate']")).click();
        driver.findElement(By.xpath("//input[@id = 'person_birthDate']")).sendKeys("05051986");
        driver.findElement(By.xpath("//input[@id = 'passportSeries']")).click();
        driver.findElement(By.xpath("//input[@id = 'passportSeries']")).sendKeys("1111");
        driver.findElement(By.xpath("//input[@id = 'passportNumber']")).sendKeys("111111");
        driver.findElement(By.xpath("//input[@id = 'documentDate']")).sendKeys("05.05.2007");
        driver.findElement(By.xpath("//input[@id = 'documentIssue']")).click();
        driver.findElement(By.xpath("//input[@id = 'documentIssue']")).sendKeys("Паспортным столом №20");

        Assert.assertEquals("Petrov", driver.findElement(By.xpath("//input[@id = 'surname_vzr_ins_0']")).getAttribute("value"));
        Assert.assertEquals("Petr", driver.findElement(By.xpath("//input[@id = 'name_vzr_ins_0']")).getAttribute("value"));
        Assert.assertEquals("05.01.1985", driver.findElement(By.xpath("//input[@id = 'birthDate_vzr_ins_0']")).getAttribute("value"));
        Assert.assertEquals("Ложкин", driver.findElement(By.xpath("//input[@id = 'person_lastName']")).getAttribute("value"));
        Assert.assertEquals("Василий", driver.findElement(By.xpath("//input[@id = 'person_firstName']")).getAttribute("value"));
        Assert.assertEquals("Валерьевич", driver.findElement(By.xpath("//input[@id = 'person_middleName']")).getAttribute("value"));
        Assert.assertEquals("05.05.1986", driver.findElement(By.xpath("//input[@id = 'person_birthDate']")).getAttribute("value"));
        Assert.assertEquals("1111", driver.findElement(By.xpath("//input[@placeholder = 'Серия']")).getAttribute("value"));
        Assert.assertEquals("111111", driver.findElement(By.xpath("//input[@id = 'passportNumber']")).getAttribute("value"));
        Assert.assertEquals("05.05.2007", driver.findElement(By.xpath("//input[@id = 'documentDate']")).getAttribute("value"));
        Assert.assertEquals("Паспортным столом №20", driver.findElement(By.xpath("//input[@id = 'documentIssue']")).getAttribute("value"));

        driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]")).click();
        WebElement validationMessage = driver.findElement(By.xpath("//div[@class ='alert-form alert-form-error']"));
        wait.until(ExpectedConditions.visibilityOf(validationMessage)).getText();

        Assert.assertEquals("При заполнении данных произошла ошибка", driver.findElement(By.xpath("//div[@class ='alert-form alert-form-error']")).getText());
        driver.findElement(By.xpath("//div[@class ='alert-form alert-form-error']")).isDisplayed();
    }

    @After
    public void afterTest() {
        driver.quit();
    }
}
