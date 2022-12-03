package common;

import bt1and2_Annotation.AddCategory;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest extends KeyWord{

    @BeforeTest
    public void createBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @BeforeMethod
    public void loginCMS() throws InterruptedException {
        driver.get("https://demo.activeitzone.com/ecommerce/login");
        driver.findElement(By.xpath("//button[.='Copy']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        sleep(2);
    }

    @AfterMethod
    public void logoutCMS() {
        click("//span[.='admin']");
        click("//span[.='Logout']");

    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
