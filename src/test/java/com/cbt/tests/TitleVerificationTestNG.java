package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TitleVerificationTestNG {
    @Test
    public void verifyTitle() throws InterruptedException {
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");
        WebDriver driver= BrowserFactory.getDriver("Chrome");
        driver.get(urls.get(0));
        String title1=driver.getTitle();
        String url1=driver.getCurrentUrl();

        Thread.sleep(3000);
        driver.navigate().to(urls.get(1));
        String title2=driver.getTitle();
        String url2=driver.getCurrentUrl();

        Thread.sleep(3000);
        driver.navigate().to(urls.get(2));
        String title3=driver.getTitle();
        String url3=driver.getCurrentUrl();
        System.out.println("VERIFYING TITLES");
        Assert.assertEquals(title1,title2,title3);

        String urlPart="http://practice.cybertekschool.com";
        System.out.println("VERIFYING URL STARTS WITH "+urlPart);
       Assert.assertTrue(url1.startsWith(urlPart) && url2.startsWith(urlPart) && url3.startsWith(urlPart));

        driver.close();

    }
}
