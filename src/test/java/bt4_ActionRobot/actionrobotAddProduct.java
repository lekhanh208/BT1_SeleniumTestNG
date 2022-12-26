package bt4_ActionRobot;

import bt1and2_Annotation.AddCategory;
import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static org.testng.Assert.assertTrue;

public class actionrobotAddProduct extends BaseTest {

    public static String productName = "Computer";
    @Test
    public static void addProduct(){

        Actions action = new Actions(driver);

        //Create category
        AddCategory.addCategory();

        //Open Add new product form
        click("//span[.='Products']");
        click("//span[.='Add New product']");

        input("//input[@name='name']", productName);
        click("//button[@data-id='category_id']");
        enter("//button[@data-id='category_id']/following-sibling::div//input",AddCategory.categoryName);

        input("//input[@name='min_qty']", "5");
        enter("//span[@class='tagify__input']", "ABC");

        WebElement tags = driver.findElement(By.xpath("//tags"));
        action.sendKeys(tags, "Testing").sendKeys(Keys.ENTER).sendKeys(tags, "Selenium").sendKeys(Keys.ENTER).build().perform();

        scrollToElement("//button[@data-id='colors']");
        click("//input[@name='colors_active']/following-sibling::span");
        sleep(1);

        String oldTab = driver.getWindowHandle();
        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
        driver.findElement(By.linkText("Colors")).sendKeys(selectLinkOpeninNewTab);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        sleep(4);

        click("//div[@class='card-body']//tbody[1]/tr[3]/td[3]/a[@title='Edit']");
        copy("//input[@id='name']");

        driver.switchTo().window(oldTab);
        click("//button[@data-id='colors']");
        paste("//div[@class='dropdown-menu show']/descendant::input");
        sleep(3);

        driver.switchTo().window(tabs.get(1));
        sleep(4);
        driver.navigate().back();
        click("//div[@class='card-body']//tbody[1]/tr[4]/td[3]/a[@title='Edit']");
        copy("//input[@id='name']");

        driver.switchTo().window(oldTab);
        scrollToElement("//h5[.='Product price + stock']");

        delete("//div[@class='dropdown-menu show']/descendant::input");
        paste("//div[@class='dropdown-menu show']/descendant::input");
        sleep(3);

        String actual = getText("//button[@data-id='colors']/descendant::div[@class='filter-option-inner-inner']");
        assertTrue(actual.contains("2"));
        System.out.println(actual);

        scrollToEnd();
        click("//button[.='Save & Publish']");
        }


    }
