package com.cbt.tests.Homework_checkboxes_dropdowns_list;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TodaysDate {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown ");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    /*
   1. go to http://practice.cybertekschool.com/dropdown
   2. verify that dropdowns under Select your date of birth display current year, month, day
    */
    @Test
    public void test() throws InterruptedException {
        WebElement year = driver.findElement(By.id("year"));

        Select year1 = new Select(year);
        WebElement selectedYear = year1.getFirstSelectedOption();
        Assert.assertEquals(selectedYear.getText(),"2020");
        Thread.sleep(3000);

        WebElement month = driver.findElement(By.id("month"));
        Select month1 = new Select(month);
        WebElement selectedMonth = month1.getFirstSelectedOption();
        Assert.assertEquals(selectedMonth.getText(),"March");
        Thread.sleep(3000);

        WebElement day = driver.findElement(By.id("day"));
        Select day1 = new Select(day);
        WebElement selectedDay = day1.getFirstSelectedOption();
        Assert.assertEquals(selectedDay.getText(),"30");

    }
}