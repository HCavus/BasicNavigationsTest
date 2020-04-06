package com.cbt.tests.MyPractice;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RadioButtons {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void test1() {
    List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']/following-sibling::label"));
    for (WebElement radio : radioButtons) {
        System.out.println(radio.getText());
    }
}
    @Test
    public void test2() throws InterruptedException {

        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
        for(WebElement each: radioButtons){
            if(each.isEnabled()){
                each.click();
        Thread.sleep(2000);
            }
        }


}
}
