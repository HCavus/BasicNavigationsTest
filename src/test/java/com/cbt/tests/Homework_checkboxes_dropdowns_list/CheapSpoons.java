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
import java.util.concurrent.TimeUnit;

public class CheapSpoons {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");

    }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }

    /*
    1. go to https://amazon.com
    2. search for "wooden spoon"
    3. click on Price option Under $25 on the left
    4. verify that all results are cheaper than $25

     */
    @Test
    public void test() {
        driver.get("https://amazon.com");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon");
        driver.findElement(By.xpath("//input[@type='submit']")).submit();
         //click on Price option Under $25 on the left
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement under25=driver.findElement(By.xpath("//span[.='Under $25']"));
        under25.click();


        //    4. verify that all results are cheaper than $25
        List<WebElement> allPrices=driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        System.out.println(allPrices.size());

        List<String> prices=new ArrayList<>();
        for(WebElement each: allPrices){
            System.out.println(each.getText());
            prices.add(each.getText());
        }

        for(String each: prices){
            int num=Integer.parseInt(each);
            Assert.assertTrue(num<25);
        }
    }
}