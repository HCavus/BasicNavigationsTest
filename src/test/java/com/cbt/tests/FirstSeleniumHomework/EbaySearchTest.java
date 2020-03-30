package com.cbt.tests.FirstSeleniumHomework;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbaySearchTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://ebay.com");
        WebElement searchBox=driver.findElement(By.id("gh-ac"));
        Thread.sleep(3000);
        searchBox.sendKeys("wooden spoon");
        Thread.sleep(3000);
        WebElement clickButton=driver.findElement(By.id("gh-btn"));
        clickButton.click();
        Thread.sleep(3000);
        WebElement firstResult=driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));
        String result1=firstResult.getText();
        result1=result1.substring(0,6).replace(",","");
        int res1=Integer.parseInt(result1);
        System.out.println(res1);
        WebElement all=driver.findElement(By.linkText("All"));
        all.click();
        WebElement secondResult=driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));
        String result2=secondResult.getText();
        result2=result2.substring(0,6).replace(",","");
        int res2=Integer.parseInt(result2);
        System.out.println(res2);
        if(res1<res2){
            System.out.println("Pass");
            System.out.println("first search is less than second search");
        }else{
            System.out.println("Fail");
            System.out.println("first search is  greater than second search");
        }
        Thread.sleep(3000);
        driver.navigate().back();
        WebElement searchbox2=driver.findElement(By.id("gh-ac"));
        String value=searchbox2.getAttribute("value");
        System.out.println(value);
        if(value.equals("wooden spoon")){
            System.out.println("Pass: Wooden spoon is in search box");
        }else{
            System.out.println("Fail: Wooden spoon is not in search box");
        }
        Thread.sleep(3000);
        driver.navigate().back();
        WebElement searchBox1=driver.findElement(By.id("gh-ac"));
        String value1=searchBox1.getAttribute("value");

        if(value1.isEmpty()){
            System.out.println("Pass: Search Box on first page is empty");
        }else{
            System.out.println("Fail");
            System.out.println("Expected a blank value");
            System.out.println("Actual: "+value1);
        }
        driver.close();
    }
}
