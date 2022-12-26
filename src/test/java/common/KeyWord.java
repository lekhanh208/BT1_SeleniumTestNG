package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class KeyWord {

    public static WebDriver driver;

    public static void scrollToEnd() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public static void scrollToElement(String xpath){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", driver.findElement(By.xpath(xpath)));
    }

    public static void sleep(long seconds){
        try {
            Thread.sleep((long) (1000*seconds));

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void click(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public static void input(String xpath, String text) {
        driver.findElement(By.xpath(xpath)).sendKeys(text);
    }
    public static void enter(String xpath, String text) {
        driver.findElement(By.xpath(xpath)).sendKeys(text, Keys.ENTER);
    }

    public static void clear(String xpath){
        driver.findElement(By.xpath(xpath)).clear();
    }

    public static void dynamicDropdown(String xpath, String text) {
        click(xpath);
        driver.findElement(By.xpath(xpath + "/descendant::input")).sendKeys(text, Keys.ENTER);
    }

    public static void staticDropdown(String xpath, String text) {
        Select select = new Select(driver.findElement(By.xpath(xpath)));
        select.selectByVisibleText(text);
    }

    public static void multipleSelect(String xpath, String text1, String text2) {
        click(xpath);
        driver.findElement(By.xpath(xpath + "//input")).sendKeys(text1, Keys.ENTER);
        driver.findElement(By.xpath(xpath + "//input")).clear();
        driver.findElement(By.xpath(xpath + "//input")).sendKeys(text2, Keys.ENTER);
    }

    public static void selectImage(String xpathBrowser, String image){
        click(xpathBrowser);
        input("//input[@class='form-control form-control-xs']", String.valueOf(image.substring(0, 3)));
        sleep(3);
        input("//input[@class='form-control form-control-xs']", String.valueOf(image.substring(3)));
        sleep(3);
        click("//div[contains(@title,'" + image + "')]");
        click("//button[.='Add Files']");
        scrollToEnd();
        sleep(2);
    }

    public static void search(String name){
        click("//span[.='Products']");
        click("//span[.='Category']");
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(name, Keys.ENTER);
        KeyWord.sleep(2);
    }

    public static void checkbyIfElse(String name) {
        String textFirstItem = driver.findElement(By.xpath("//table[contains(@class,'breakpoint-lg')]//tbody//tr[1]/td[2]")).getText();
        System.out.println("Text of the first item is: " + textFirstItem);
        if (textFirstItem.equals(name)) {
            System.out.println("New category " + name + " is added to table: Pass");
        } else {
            System.out.println("New category " + name + " is NOT added to table: Fail");
        }
    }

    public static void checkbyAssert(String name){
        String textFirstItem = driver.findElement(By.xpath("//table[contains(@class,'breakpoint-lg')]//tbody//tr[1]/td[2]")).getText();
        System.out.println("Text of the first item is: " + textFirstItem);
        Assert.assertEquals(textFirstItem, name);
    }

    public static String getText(String xpath) {
        String actualText = driver.findElement(By.xpath(xpath)).getText();
        return actualText;
    }

    public static void copy(String xpath){
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(By.xpath(xpath))).keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
    }

    public static void paste(String xpathInput){
        Actions action = new Actions(driver);
        action.click(driver.findElement(By.xpath(xpathInput))).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).sendKeys(Keys.ENTER).build().perform();
    }

    public static void delete(String xpathInput){
        Actions action = new Actions(driver);
        action.click(driver.findElement(By.xpath(xpathInput))).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).build().perform();
    }
}
