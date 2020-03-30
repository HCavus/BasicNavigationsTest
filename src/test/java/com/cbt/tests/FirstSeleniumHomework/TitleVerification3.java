package com.cbt.tests.FirstSeleniumHomework;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com",
                "https://www.westelm.com",
                "https://walmart.com");
      //  WebDriver driver = BrowserFactory.getDriver("firefox");
        WebDriver driver = BrowserFactory.getDriver("edge");
        driver.get(urls.get(0));
        String title1 = driver.getTitle();
        System.out.println("Title 1: " +title1);
        String url1 = driver.getCurrentUrl();
        System.out.println("Url 1: " +url1);
        if (url1.contains(title1.toLowerCase().replace(" ", ""))) {
            System.out.println("PASS");
            System.out.println(url1 + " contains " + title1);
        } else {
            System.out.println("FAIL");
            System.out.println(url1 + " does not contain " + title1);
        }

        driver.navigate().to(urls.get(1));
        String title2 = driver.getTitle();
        System.out.println("Title 2: " +title2);
        String url2 = driver.getCurrentUrl();
        System.out.println("Url 2: " +url2);
        if (url2.contains(title2.toLowerCase().replace(" ", ""))) {
            System.out.println("PASS");
            System.out.println(url2 + " contains " + title2);
        } else {
            System.out.println("FAIL");
            System.out.println(url2 + " does not contain " + title2);
        }
        driver.navigate().to(urls.get(2));
        String title3 = driver.getTitle();
        System.out.println("Title 3: " +title3);
        String url3 = driver.getCurrentUrl();
        System.out.println("Url 3: " +url3);
        if (url3.contains(title3.toLowerCase().replace(" ", ""))) {
            System.out.println("PASS");
            System.out.println(url3 + " contains " + title3);
        } else {
            System.out.println("FAIL");
            System.out.println(url3 + " does not contain " + title3);
        }
        driver.close();
    }
}
