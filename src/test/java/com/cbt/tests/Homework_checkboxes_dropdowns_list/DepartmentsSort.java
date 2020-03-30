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
import java.util.Collections;
import java.util.List;

public class DepartmentsSort {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.amazon.com ");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    /*
        1. go to https://www.amazon.com
        2. verify that default value of the All departments dropdown is All
        3. verify that options in the All departments dropdown are not sorted alphabetically
     */
    @Test
    public void test(){
    WebElement dropdown=driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect']"));
    Select list=new Select(dropdown);
    String defaultOption=list.getFirstSelectedOption().getText();
        System.out.println(defaultOption);
        Assert.assertTrue(defaultOption.startsWith("All"));

        List<WebElement> allList=list.getOptions();
        List<String> stringList=new ArrayList<>();
        for(WebElement each:allList) {
            stringList.add(each.getText());
        }
        List<String> stringList1=new ArrayList<>(stringList);
        System.out.println("BEFORE SORTED");
        for(String each:stringList1){
            System.out.println(each);
        }
        System.out.println("AFTER SORTED");
         Collections.sort(stringList);
         List<String> sortedList=new ArrayList<>(stringList);
         for(String each:sortedList){
            System.out.println(each);
        }
        Assert.assertFalse(stringList1.equals(sortedList));
    }
}
