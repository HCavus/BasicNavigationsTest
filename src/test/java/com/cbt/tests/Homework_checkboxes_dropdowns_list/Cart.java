package com.cbt.tests.Homework_checkboxes_dropdowns_list;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Cart {
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
     3. click search
     4. remember the name and the price of a random result
     5. click on that random result
      6. verify default quantity of items is 1
      7. verify that the name and the price is the same as the one from step 5
      8. verify button "Add to Cart" is visible
     */
    @Test
    public void test(){

        driver.get("https://amazon.com");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon");
        driver.findElement(By.xpath("//input[@type='submit']")).submit();

        Random ran=new Random();
        //int num=ran.nextInt(100);
        int num=4;
        List< WebElement>item=driver.findElements(By.xpath("(//a[@class='a-link-normal a-text-normal']/span)["+num+"]"));
        System.out.println(item.size());
        Assert.assertEquals(item.size(),1);
        String itemName=item.get(0).getText();
        System.out.println("Item name: "+itemName);
        WebElement priceitem=driver.findElement(By.xpath("(//span[@class='a-price'])["+num+"]"));
        String price=priceitem.getText();
        System.out.println("Item price: "+price);
       driver.findElement(By.linkText(itemName)).click();
       WebElement product=driver.findElement(By.id("productTitle"));
       String productName=product.getText();
        System.out.println(productName);
        Assert.assertEquals(itemName,productName);
       WebElement price1=driver.findElement(By.id("//span[@id='priceblock_ourprice']"));

       String productprice=price1.getText();
        System.out.println(productprice);
       Assert.assertEquals(price,productprice);
    }
}
