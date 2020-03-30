package com.cbt.tests.FirstSeleniumHomework;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VikipediaURL {
    public static void main(String[] args) throws InterruptedException {

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
        if(url.endsWith("Selenium_(software)")){
            System.out.println("PASS");
            System.out.println(url+ " ends with 'Selenium_(software)'");
        }else{
            System.out.println("FAIL");
            System.out.println(url+ " does not end with 'Selenium_(software)'");
        }




driver.close();
    }
}
