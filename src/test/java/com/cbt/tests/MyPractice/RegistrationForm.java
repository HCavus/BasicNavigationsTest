package com.cbt.tests.MyPractice;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationForm {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }
@AfterMethod
    public void tearDown(){
        driver.quit();
}
    @Test
    public void register(){
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("John");
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Smith");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("selenium");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("abc@gmail.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("abcd1234");
        driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("777-77-77");
        driver.findElement(By.cssSelector("input[value='female']")).click();
        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("10/16/2018");
        Select select1=new Select(driver.findElement(By.cssSelector("select[name='department']")));
        select1.selectByVisibleText("Department of Engineering");
        Select select2=new Select(driver.findElement(By.cssSelector("select[name='job_title']")));
        select2.selectByVisibleText("SDET");
        driver.findElement(By.cssSelector("input[value='java']")).click();
        driver.findElement(By.cssSelector("button[id='wooden_spoon']")).submit();
    }
}
