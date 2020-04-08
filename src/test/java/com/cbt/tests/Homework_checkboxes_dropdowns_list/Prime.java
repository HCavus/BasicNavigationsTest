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

import java.util.concurrent.TimeUnit;

public class Prime {
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
    4. remember name first result that has prime label
    5. select Prime checkbox on the left
    6. verify that name first result that has prime label is same as step 4
    7. check the last checkbox under Brand on the left
     8. verify that name first result that has prime label is different
     */
    @Test
    public void test() {
        driver.get("https://amazon.com");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon");
        driver.findElement(By.xpath("//input[@type='submit']")).submit();
       driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

       //remember name first result that has prime label
        WebElement firstitem=driver.findElement(By.xpath("(//i[@aria-label='Amazon Prime']/../../../../../../div[2]/h2/a/span)[1]"));
        String firstItemName=firstitem.getText();
        System.out.println("First item name: "+firstItemName);

        //select Prime checkbox on the left
        WebElement checkBox=driver.findElement(By.xpath("//i[@aria-label='Prime Eligible']/../div/label/i"));
        checkBox.click();

        //verify that name first result that has prime label is same as step 4
        WebElement secondItem=driver.findElement(By.xpath("(//i[@aria-label='Amazon Prime']/../../../../../../div[2]/h2/a/span)[1]"));
        String secondItemName=secondItem.getText();
        System.out.println("Second item name: "+secondItemName);
        Assert.assertTrue(firstItemName.equals(secondItemName));

        //check the last checkbox under Brand on the left
        WebElement lastcheckbox=driver.findElement(By.xpath("//ul[@aria-labelledby='p_89-title']/li[10]/span/a/div/label/i"));
        lastcheckbox.click();

       WebElement thirdItem=driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        String thirdItemName=thirdItem.getText();
        System.out.println("Third item name: "+thirdItemName);

        //verify that name first result that has prime label is different
        Assert.assertFalse(firstItemName.equals(thirdItemName));
    }
}
