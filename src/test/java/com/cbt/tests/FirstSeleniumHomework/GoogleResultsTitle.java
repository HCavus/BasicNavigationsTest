package com.cbt.tests.FirstSeleniumHomework;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class GoogleResultsTitle {
    public static void main(String[] args) {
        List<String> searchStrs = Arrays.asList("Java", "cucumber bdd",
                "Selenium web browser automation");

        for (int i = 0; i < 3; i++) {
            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get(" https://google.com ");
            WebElement searchBox = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
            searchBox.sendKeys(searchStrs.get(i));
            WebElement click1 = driver.findElement(By.xpath("//input[@class='gNO89b']"));
            click1.submit();
            WebElement result1 = driver.findElement(By.xpath("//cite[@class='iUh30 tjvcx']"));
            String text1 = result1.getText();
            WebElement click2 = driver.findElement(By.xpath("//h3[@class='LC20lb DKV0Md']"));
            click2.click();
            String result2 = driver.getCurrentUrl();
            if (text1.equals(result2)) {
                System.out.println(searchStrs.get(i)+" Pass");
                System.out.println("First Result: " + text1);
                System.out.println("Second Result: " + result2);
                System.out.println("==========================");
            } else {
                System.out.println(searchStrs.get(i)+" Fail");
                System.out.println("First Result: " + text1);
                System.out.println("Second Result: " + result2);
                System.out.println("=========================");
            }
            driver.close();
        }
    }
}
