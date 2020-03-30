package com.cbt.tests.Homework_checkboxes_dropdowns_list;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MainDepartments {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/gp/site-directory");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    /*
    1. go to https://www.amazon.com/gp/site-directory
    2. verify that every main department name (indicated by blue rectangles in the picture)
     is present in the All departments dropdown (indicated by green rectangle in the picture)
     */
    @Test
    public void test(){
        WebElement allDropdown=driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect']"));
        Select list=new Select(allDropdown);
        List<WebElement> allList=list.getOptions();
        List<String>stringList=new ArrayList<>();
        for(WebElement each:allList){
            stringList.add(each.getText());
        }
        System.out.println("LIST OF ALL PRODUCTS");
        for(String each:stringList){
            System.out.println(each);
        }
        List<WebElement>mainProducts=driver.findElements(By.xpath("//h2[@class='fsdDeptTitle']"));
        List<String> mainProductsname=new ArrayList<>();
        for(WebElement each:mainProducts){
            mainProductsname.add(each.getText());
        }
        System.out.println("LIST OF ALL MAIN PRODUCTS");
        for(String each:mainProductsname){
            System.out.println(each);
        }
        for(int i=0; i<mainProductsname.size();i++){
            for(int j=0; j<stringList.size();j++){
                Assert.assertFalse(stringList.contains(mainProductsname));
            }
        }
    }

}
