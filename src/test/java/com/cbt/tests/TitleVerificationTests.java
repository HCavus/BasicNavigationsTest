package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerificationTests {
    public static void main(String[] args) throws InterruptedException {
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

        if(title1.equals(title2) && title1.equals(title3)){
            System.out.println("Verifying Titles: PASS");
        }else{
            System.out.println("Verifying Titles: FAIL");
            System.out.println("title 1:"+title1);
            System.out.println("title 2:"+title2);
            System.out.println("title 3:"+title3);
        }
        String urlPart="http://practice.cybertekschool.com";
if(url1.contains(urlPart) && url2.contains(urlPart) && url3.contains(urlPart)){
    System.out.println("Verifying URLS PASS. All pages start with "+urlPart);
}else{
    System.out.println("Verifying URLS: FAIL");
    System.out.println("URL 1: "+url1);
    System.out.println("URL 2: "+url2);
    System.out.println("URL 3: "+url3);
}
driver.close();

    }
}
