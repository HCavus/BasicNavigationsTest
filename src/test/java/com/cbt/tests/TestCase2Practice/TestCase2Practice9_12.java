package com.cbt.tests.TestCase2Practice;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase2Practice9_12 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDwn() {
        driver.quit();
    }
    /*
    Optional: If you want to to be a real selenium hero, use @DataProvider
     for tests cases from 9 through 12. Please use following documentation:
     https:// testng.org/doc/documentationmain.html#parameters-dataproviders
     Test case #9
     Step 1. Go to “https://practice.cybertekschool.com”
    Step 2. And click on “Status Codes”.
    Step 3. Then click on “200”.
    Step 4. Verify that following message is displayed: “This page returned a 200 status code”

     */
    @Test
    public void test9(){
        driver.get("https://practice.cybertekschool.com");
        driver.findElement(By.linkText("Status Codes")).click();
    }
}
