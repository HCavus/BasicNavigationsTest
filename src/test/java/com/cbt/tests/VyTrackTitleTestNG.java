package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VyTrackTitleTestNG {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void verifyTitle() throws InterruptedException {

        driver.get("https://app.vytrack.com/user/login");
        Thread.sleep(2000);
        WebElement usernameBox = driver.findElement(By.id("prependedInput"));
        usernameBox.sendKeys("User4");
        Thread.sleep(2000);
        WebElement passwordBox = driver.findElement(By.id("prependedInput2"));
        passwordBox.sendKeys("UserUser123");
        Thread.sleep(2000);
        WebElement loginButton = driver.findElement(By.id("_submit"));
        loginButton.submit();
        Thread.sleep(2000);

        WebElement nameOnTop = driver.findElement(By.cssSelector("a[href='javascript: void(0);']"));

        String name = nameOnTop.getText();
        nameOnTop.click();
        Thread.sleep(2000);
        //    1               2           3
        //ul.dropdown-menu >li>a[href='/config/user/profile']
        //1.find the list that contains all the options
        //2.the options on that list
        //3.find the link within those
        WebElement myconfi = driver.findElement(By.cssSelector("ul.dropdown-menu >li>a[href='/config/user/profile']"));
        myconfi.click();
        // WebElement myconfiguration=driver.findElement(By.linkText("My Configuration"));
        // myconfiguration.click();
        Thread.sleep(2000);
        String title = driver.getTitle();

        System.out.println("Verifying Title starst with name");
        System.out.println("Title : "+title);
        System.out.println("Name: "+name);
        Assert.assertTrue(title.startsWith(name));

    }
}
