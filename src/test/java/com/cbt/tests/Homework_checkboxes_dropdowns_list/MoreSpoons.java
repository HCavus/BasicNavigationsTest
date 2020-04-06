package com.cbt.tests.Homework_checkboxes_dropdowns_list;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MoreSpoons {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    /*
    1. go to https://amazon.com
    2. search for "wooden spoon"
    3. remember all Brand names on the left
    4. select Prime checkbox on the left
    5. verify that same Brand names are still displayed
     */
    @Test
    public void test() {
        driver.get("https://amazon.com");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon");
        driver.findElement(By.xpath("//input[@type='submit']")).submit();

        List<WebElement> brandList=driver.findElements(By.xpath("//ul[@aria-labelledby='p_89-title']/li"));
        System.out.println(brandList.size()); //10
        List<String> brandListNames=new ArrayList<>();
        for(WebElement each: brandList){
            System.out.println(each.getAttribute("aria-label"));
            brandListNames.add(each.getAttribute("aria-label"));

        }

        WebElement checkBox=driver.findElement(By.xpath("//i[@aria-label='Prime Eligible']/../div/label/i"));
        checkBox.click();

        List<WebElement> brandList2=driver.findElements(By.xpath("//ul[@aria-labelledby='p_89-title']/li"));
        System.out.println(brandList.size()); //10
        List<String> brandListNames2=new ArrayList<>();
        for(WebElement each: brandList2){
            System.out.println(each.getAttribute("aria-label"));
            brandListNames2.add(each.getAttribute("aria-label"));

        }
        //verify that same Brand names are still displayed
        Assert.assertEquals(brandListNames,brandListNames2);
    }
}
