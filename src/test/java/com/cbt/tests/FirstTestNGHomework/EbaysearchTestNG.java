package com.cbt.tests.FirstTestNGHomework;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EbaysearchTestNG {
    @Test
    public void verifyEbaysearch() throws InterruptedException {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://ebay.com");
        WebElement searchBox=driver.findElement(By.id("gh-ac"));
        Thread.sleep(3000);
        searchBox.sendKeys("wooden spoon");
        Thread.sleep(3000);
        WebElement clickButton=driver.findElement(By.id("gh-btn"));
        clickButton.click();
        WebElement firstResult=driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));
        String result1=firstResult.getText();
        result1=result1.substring(0,6).replace(",","");
        int res1=Integer.parseInt(result1);
        System.out.println("First Result:"+res1);
        WebElement all=driver.findElement(By.linkText("All"));
        all.click();
        Thread.sleep(3000);
        WebElement secondResult=driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));
        String result2=secondResult.getText();
        result2=result2.substring(0,6).replace(",","");
        int res2=Integer.parseInt(result2);
        System.out.println("Second Result: "+res2);
        System.out.println("VERIFYING THAT FIRST RESULT IS LESS THAN SECOND RESULT");
        Assert.assertTrue(res1<res2);

        Thread.sleep(3000);
        driver.navigate().back();
        WebElement searchbox2=driver.findElement(By.id("gh-ac"));
        String value=searchbox2.getAttribute("value");
        System.out.println(value);
        System.out.println("VERIFYING VALUE IS EQUALS TO 'WOODEN SPOON'");
        Assert.assertEquals(value,"wooden spoon");

        Thread.sleep(3000);
        driver.navigate().back();
        WebElement searchBox1=driver.findElement(By.id("gh-ac"));
        String value1=searchBox1.getAttribute("value");

        System.out.println("VERIFYING SEARCH BOX ON FIRST PAGE IS EMPTY");
        Assert.assertTrue(value1.isEmpty());


        driver.close();
    }
}
