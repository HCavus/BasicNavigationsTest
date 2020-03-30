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

import java.util.List;
import java.util.Random;

public class YearsMontsDays {
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
@Test
/*
1. go to http://practice.cybertekschool.com/dropdown
2. select a random year under Select your date of birth
3. select month January
 4. verify that days dropdown has current number of days
 5. repeat steps 3, 4 for all the months
NOTE: if you randomly select a leap year, verify February has 29 days
 */
    public void test() throws InterruptedException {
    WebElement yeardropdown = driver.findElement(By.id("year"));

    Random ran = new Random();
    int num = ran.nextInt(100);
    Select yearlist = new Select(yeardropdown);
    yearlist.selectByIndex(num);
    Thread.sleep(2000);
    String year=yearlist.getFirstSelectedOption().getText();
    System.out.println("Year: "+year);
    int numYear=Integer.parseInt(year);
    if(numYear%4==0){
        System.out.println(year+" is a leap year. February has 29 days. ");
    }

    for (int i = 0; i < 12; i++) {
        WebElement monthdropdown = driver.findElement(By.id("month"));

        Select monthlist = new Select(monthdropdown);
        List<WebElement> allmonths= monthlist.getOptions();
        String month=allmonths.get(i).getText();
        System.out.println("Month: "+month);
        monthlist.selectByIndex(i);
        Thread.sleep(2000);

        WebElement daydropdown = driver.findElement(By.id("day"));
        Select day = new Select(daydropdown);
       List<WebElement> alldays= day.getOptions();
        System.out.println("Number of days: "+alldays.size());

    }


    }
}

