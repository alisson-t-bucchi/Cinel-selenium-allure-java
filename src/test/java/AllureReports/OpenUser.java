package AllureReports;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OpenUser {

    WebDriver driver;

    @BeforeClass
    public void setup() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://formacao.cinel.pt");
        driver.manage().window().maximize();

    }

    @Test(priority = 1)
    public void loginTest() throws InterruptedException {

        driver.findElement(By.id("username")).sendKeys("Alisson_Bucchi");
        driver.findElement(By.id("password")).sendKeys("#ATBucchi081982");
        driver.findElement(By.cssSelector("button.btn")).click();
        Thread.sleep(5000);

    }


    @Test(priority = 2)
    public void openMessage() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"lastmessages\"]/table/tbody/tr/td[1]")).click(); //open message
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"dlgbtn_4\"]")).click(); //close message
        Thread.sleep(5000);
    }

    @Test(priority = 3)
    public void openUser() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"header\"]/ul/li[4]/a/img")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div[1]/button[1]/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"dlgbtn_0\"]/i")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 4)
    public void refreshPage() throws InterruptedException {

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"header\"]/ul/li[2]/a/i")).click();

    }

    @AfterClass
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"logout\"]")).click();
        driver.quit();

    }
}