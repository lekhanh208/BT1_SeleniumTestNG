package bt3_Assert;

import bt1and2_Annotation.AddCategory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class assertAddCategory extends AddCategory {
    @Test(priority = 3)
    public void checkCategoryNameAssert(){
        System.out.println("**** Check Category Name is added to table by Assert ****");
        //Search category name added and check text by Assert
        search(categoryName);
        checkbyAssert(categoryName);
    }

    @Test(priority = 4)
    public void getTextPage(){
        SoftAssert softAssert = new SoftAssert();
        //Open All Categories page
        click("//span[.='Products']");
        click("//span[.='Category']");

        String headerPage = getText("//h1[@class='h3']");
        System.out.println("**** Check header page of All Categories ****");
        softAssert.assertEquals(headerPage, "All Categories");

        System.out.println("**** Check header data table of Categories ****");
        String headerTable = getText("//h5[@class='mb-0 h6']");
        softAssert.assertEquals(headerTable, "Categories");

        System.out.println("**** Check 'Add New category' button is enabled ****");
        WebElement addButton = driver.findElement(By.xpath("//span[.='Add New category']"));
        Assert.assertTrue(addButton.isEnabled(), "Nút Add New category chưa được bật");
        //Open Add New category form
        click("//span[.='Add New category']");

        System.out.println("**** Check header of Category Information form");
        String headerForm = getText("//h5[@class='mb-0 h6']");
        softAssert.assertEquals(headerForm, "Category Information");

        softAssert.assertAll();
    }

}
