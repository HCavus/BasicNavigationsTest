package com.cbt.tests.Homework_checkboxes_dropdowns_list;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;

public class Links {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.w3schools.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    /*
    1. go to https://www.w3schools.com/
    2. find all the elements in the page with the tag a
    3. for each of those elements, if it is displayed on the page, print the text and the href of that element.
     */
    @Test
    public void test(){
        List<WebElement> allElements=driver.findElements(By.tagName("a"));
        System.out.println(allElements.size()); //311

        System.out.println("ELEMENTS DISPLAYED ON THE PAGE");
        int count=0;
        for(WebElement each: allElements){
            if(each.isDisplayed()){
                System.out.println("text : "+each.getText()+"   -----   href : "+each.getAttribute("href"));
                count++;
            }
        }
        System.out.println("Number of elements displayed on the page: "+count);
    }
}
