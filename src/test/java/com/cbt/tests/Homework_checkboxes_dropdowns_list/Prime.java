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

public class Prime {
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
    3. click search
    4. remember name first result that has prime label
    5. select Prime checkbox on the left
    6. verify that name first result that has prime label is same as step 4
    7. check the last checkbox under Brand on the left
     8. verify that name first result that has prime label is different
     */
    @Test
    public void test(){
        driver.get("https://amazon.com");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon");
        driver.findElement(By.xpath("//input[@type='submit']")).submit();
        WebElement primeLabel=driver.findElement(By.xpath("(//i[@aria-label='Amazon Prime'])[1]"));
        Assert.assertTrue(primeLabel.isDisplayed());
        String prime=primeLabel.getAttribute("aria-label");
        System.out.println(prime);

        WebElement checkBox=driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[1]"));
       checkBox.click();

       WebElement primeLabel2=driver.findElement(By.xpath("//li[@aria-label='Mondayou']/span/a/div/label/i"));
        Assert.assertTrue(primeLabel2.isDisplayed());

        String prime2=primeLabel2.getAttribute("aria-label");
        System.out.println(prime2);
        Assert.assertEquals(prime,prime2);
    }
}
