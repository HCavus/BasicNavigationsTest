package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTitleWithTestNG {
    @Test
    public void verifySearch() throws InterruptedException {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");
        driver.manage().window().fullscreen();
        Thread.sleep(3000);
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("search");
        WebElement searchButton=driver.findElement(By.xpath("//input[@ class='nav-input']"));
        searchButton.click();
        String title=driver.getTitle();
        System.out.println("VERIFYING TITLE CONTAINS 'search' TERM");
        Assert.assertTrue(title.contains("search"));

        driver.close();
    }
}
