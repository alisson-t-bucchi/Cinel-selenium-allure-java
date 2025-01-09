package AllureReports;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class OpenUser {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() throws IOException {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        driver.manage().window().maximize();
        driver.get("base.url");

        takeScreenshot("images1.png");
    }

    @Test(priority = 1)
    public void loginTest() throws IOException {
        // Realizando login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("username");
        driver.findElement(By.id("password")).sendKeys("password");

        takeScreenshot("images2.png");
        driver.findElement(By.cssSelector("button.btn")).click();
    }

    @Test(priority = 2)
    public void openMessage() throws IOException {
        // Abrindo mensagem
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"lastmessages\"]/table/tbody/tr/td[1]"))).click();
        takeScreenshot("images3.png");

        // Fechando mensagem
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dlgbtn_4\"]"))).click();
    }

    @Test(priority = 3)
    public void openUser() throws IOException {
        // Acessando perfil de usuário
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"header\"]/ul/li[4]/a/img"))).click();
        takeScreenshot("images4.png");

        // Executando ações no perfil do usuário
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/form/div[1]/button[1]/span"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dlgbtn_0\"]/i"))).click();
    }

    @Test(priority = 4)
    public void refreshPage() {
        // Atualizando página
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"header\"]/ul/li[2]/a/i"))).click();
    }

    @AfterClass
    public void tearDown() {
        // Logout e fechamento do navegador
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"logout\"]"))).click();
        driver.quit();
    }

    // Método auxiliar para capturar screenshots
    private void takeScreenshot(String fileName) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("C:\\Screenshots\\" + fileName));
    }
}
