package com.cbt.tests.Homework_checkboxes_dropdowns_list;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Days {
    /*
     1. go to  http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox
     2. Randomly select a checkbox. As soon as you check any day, print the name of the day and
     uncheck immediately. After you check and uncheck Friday for the third time, exit the program.
NOTE: Remember some checkboxes are not selectable.
        You need to find a way to ignore them when they are randomly selected.
        It has to be dynamic. Do not hard code Saturday and Sunday.
        Use values of certain attributes
     */
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get(" http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> list = driver.findElements(By.cssSelector("input[id$='-input']"));
        System.out.println(list.size());//7

        Random ran = new Random();
        int count = 0;
        do {
            int num = ran.nextInt(6);
            if (list.get(num).isEnabled()) {
                list.get(num).click();
                Thread.sleep(2000);
                String[] days = list.get(num).getAttribute("id").split("-");
                String day = days[3];
                System.out.println(day);
                if (day.equals("Friday")) {
                    count++;
                }
                list.get(num).click();
                Thread.sleep(2000);

            }
        } while (count < 3);

    }
}
