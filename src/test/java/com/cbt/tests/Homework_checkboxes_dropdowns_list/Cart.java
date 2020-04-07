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
        driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
        Random ran=new Random();
        int num=ran.nextInt(100);

        //remember the name  of a random result
         WebElement item=driver.findElement(By.xpath("(//a[@class='a-link-normal a-text-normal']/span)["+num+"]"));
         String itemName=item.getText();
        System.out.println("Item name: "+itemName);

        //remember the the price of a random result
        WebElement priceitem=driver.findElement(By.xpath("(//span[@class='a-price'])["+num+"]"));
        String price=priceitem.getText();
        System.out.println("Item price: "+price);

        //click on that random result
        driver.findElement(By.linkText(itemName)).click();

        //verify default quantity of items is 1
      List<WebElement> product=driver.findElements(By.id("productTitle"));
       Assert.assertEquals(product.size(),1);

        //verify that the name  is the same as the one from step 5
        WebElement product1=driver.findElement(By.id("productTitle"));
         String productName=product1.getText();
         System.out.println("Product name: "+productName);
         Assert.assertEquals(itemName,productName);

         //the price is the same as the one from step 5

         WebElement price1=driver.findElement(By.xpath("//span[@class='a-size-medium a-color-price']"));
         String productprice=price1.getText();
         System.out.println("product price: "+productprice);
        System.out.println("verifying the prices are the same");
        System.out.println("First price: "+price);
        System.out.println("Second price: "+productprice);

       // verify button "Add to Cart" is visible
        WebElement addToCart=driver.findElement(By.id("add-to-cart-button"));
        Assert.assertTrue(addToCart.isDisplayed());
    }
}
