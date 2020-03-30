package com.cbt.tests.FirstTestNGHomework;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2TestNG {
    @Test
    public void verifyTitle2(){
        List<String> urls = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com",
                "https://www.westelm.com",
                "https://walmart.com");
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get(urls.get(0));
        System.out.println("VERIFYING THE URL CONTAINS THE TITLE");
        String title1 = driver.getTitle();
        System.out.println("Title 1: " +title1);
        String url1 = driver.getCurrentUrl();
        System.out.println("Url 1: " +url1);

        Assert.assertTrue(url1.contains(title1.toLowerCase().replace(" ","")));


        driver.navigate().to(urls.get(1));
        System.out.println("VERIFYING THE URL CONTAINS THE TITLE");
        String title2 = driver.getTitle();
        System.out.println("Title 2: " +title2);
        String url2 = driver.getCurrentUrl();
        System.out.println("Url 2: " +url2);
        Assert.assertFalse(url2.contains(title2.toLowerCase().replace(" ","")));

        driver.navigate().to(urls.get(2));
        System.out.println("VERIFYING THE URL CONTAINS THE TITLE");
        String title3 = driver.getTitle();
        System.out.println("Title 3: " +title3);
        String url3 = driver.getCurrentUrl();
        System.out.println("Url 3: " +url3);
        Assert.assertFalse(url3.contains(title3.toLowerCase().replace(" ","")));

        driver.close();
    }
}
