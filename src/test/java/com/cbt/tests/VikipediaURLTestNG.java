package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtilityWithTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VikipediaURLTestNG {
    @Test
    public void verifyURL() throws InterruptedException {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org/");
        Thread.sleep(3000);
        WebElement searchBox=driver.findElement(By.id("searchInput"));
        searchBox.sendKeys("selenium webdriver");
        WebElement searchButton=driver.findElement(By.xpath("//i[@class='sprite svg-search-icon']"));
        searchButton.click();
        Thread.sleep(3000);
        WebElement searchSoftware=driver.findElement(By.linkText("Selenium (software)"));
        searchSoftware.click();
        Thread.sleep(3000);
        String url=driver.getCurrentUrl();
        String urlPart="Selenium_(software)";
        System.out.println("VERIFYING URL ENDS WITH "+urlPart);
        Assert.assertTrue(url.endsWith(urlPart));

        driver.close();
    }
}
