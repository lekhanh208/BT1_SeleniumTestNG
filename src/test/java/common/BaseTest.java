package common;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    public void scroll(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    public void sleep(long seconds) throws InterruptedException {
        Thread.sleep(seconds*1000);
    }

    public void click(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }
    public void enter(String xpath, String text){
        driver.findElement(By.xpath(xpath)).sendKeys(text);
    }
    public void dynamicDropdown(String xpath, String text){
        click(xpath);
        driver.findElement(By.xpath(xpath + "//input")).sendKeys(text, Keys.ENTER);
    }
    public void staticDropdown(String xpath, String text){
        Select select = new Select(driver.findElement(By.xpath(xpath)));
        select.selectByVisibleText(text);
    }
    public void multipleSelect(String xpath, String text1, String text2){
        click(xpath);
        driver.findElement(By.xpath(xpath + "//input")).sendKeys(text1, Keys.ENTER);
        driver.findElement(By.xpath(xpath + "//input")).clear();
        driver.findElement(By.xpath(xpath + "//input")).sendKeys(text2, Keys.ENTER);
        click(xpath);
    }
    public void selectImage(String xpathBrowser, String image) throws InterruptedException {
        click(xpathBrowser);
        enter("//input[@class='form-control form-control-xs']",image);
        Thread.sleep(2000);
        click("//div[contains(@title,'"+ image +"')]");
        click("//button[.='Add Files']");
        scroll();
        sleep(2);
    }

    public void search(String name) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(name,Keys.ENTER);
        sleep(2);
        String textFirstItem = driver.findElement(By.xpath("//table[contains(@class,'breakpoint-lg')]//tbody//tr[1]/td[2]")).getText();
        System.out.println(textFirstItem);
        if (textFirstItem.equals(name)){
            System.out.println("New category "+ name +" is added to table: Pass");
        }
        else {
            System.out.println("New category "+ name +" is NOT added to table: Fail");
        }
    }


    @BeforeTest
    public void createBrowser(){
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
        Thread.sleep(2000);
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
