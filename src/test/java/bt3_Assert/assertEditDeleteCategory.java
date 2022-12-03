package bt3_Assert;

import bt1and2_Annotation.AddCategory;
import common.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class assertEditDeleteCategory extends BaseTest {
    static String newname = "May";
    @Test (priority = 1)
    public static void editCategory() throws InterruptedException {

        AddCategory.addCategory();
        click("//table[contains(@class,'breakpoint-lg')]//tbody//tr[1]//a[@title='Edit']");
        //Enter new name
        clear("//input[@id='name']");
        enter("//input[@id='name']", newname);
        click("//button[.='Save']");
    }
    @Test (priority = 2)
    public static void checkAfterEdit() throws InterruptedException {
        search(newname);
        checkbyAssert(newname);
    }

    @Test (priority = 3)
    public static void deleteCategory() throws InterruptedException {
        search(newname);
        click("//table[contains(@class,'breakpoint-lg')]//tbody//tr[1]//a[@title='Delete']");
        click("//a[.='Delete']");
    }
    @Test (priority = 4)
    public static void checkAfterDelete() throws InterruptedException {
        search(newname);
        String actualTable = driver.findElement(By.xpath("//tr[@class='footable-empty']//td")).getText();
        Assert.assertEquals(actualTable, "Nothing found");
    }
}
