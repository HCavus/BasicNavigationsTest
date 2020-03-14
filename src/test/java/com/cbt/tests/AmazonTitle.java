package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTitle {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");
        driver.manage().window().fullscreen();
        Thread.sleep(3000);
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("search");
        WebElement searchButton=driver.findElement(By.xpath("//input[@ class='nav-input']"));
       searchButton.click();
        String title=driver.getTitle();
        if(title.contains("search")){
            System.out.println("PASS: "+title+" contains 'search' term");
        }else{
            System.out.println("FAIL: "+title+" does not contains search term");
        }
        driver.close();
    }
}
