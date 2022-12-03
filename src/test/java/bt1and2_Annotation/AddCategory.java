package bt1and2_Annotation;

import common.BaseTest;
import org.testng.annotations.Test;

public class AddCategory extends BaseTest {
    public static String name = "Mobile Phone";

    @Test(priority = 1)
    public static void addCategory() throws InterruptedException {

        //Open Add new category form
        click("//span[.='Products']");
        click("//span[.='Category']");
        click("//span[.='Add New category']");

        //Enter name
        enter("//input[@id='name']", name);

        //Select Parent Category
        dynamicDropdown("//label[.='Parent Category']/following-sibling::div/child::div", "T-shirts");

        //Enter Ordering Number
        enter("//input[@id='order_level']", "1000");

        //Select Type
        staticDropdown("//label[.='Type']/following-sibling::div/child::div//select", "Digital");

        //Select Banner
        selectImage("(//div[.='Browse'])[1]", "Group 1225");

        //Select Icon
        selectImage("(//div[.='Browse'])[2]", "Free");


        //Enter Meta Title
        enter("//input[@name='meta_title']", "TestNG-MK");

        //Select Filtering Attributes
        multipleSelect("//label[.='Filtering Attributes']/following-sibling::div/child::div", "Wheel", "Size");

        //Click Save button
        click("//button[.='Save']");
        sleep(2);
    }

    @Test(priority = 2)
    public static void checkCategoryNameIfElse() throws InterruptedException {
        System.out.println("**** Check Category Name is added to table by If Else ****");
        //Search category name added and check text by If Else
        search(name);
        checkbyIfElse(name);
    }

}
