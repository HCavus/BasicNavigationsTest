package com.cbt.tests.FirstTestNGHomework;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VyTrackShortcutFunctionalityTestNG {
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
    public void test() throws InterruptedException {

        driver.get("https://app.vytrack.com/user/login");
        Thread.sleep(2000);
        WebElement usernameBox=driver.findElement(By.id("prependedInput"));
        usernameBox.sendKeys("salesmanager101");
        Thread.sleep(2000);
        WebElement passwordBox=driver.findElement(By.id("prependedInput2"));
        passwordBox.sendKeys("UserUser123");
        Thread.sleep(2000);
        WebElement loginButton=driver.findElement(By.id("_submit"));
        loginButton.submit();
        Thread.sleep(5000);
        String title=driver.getTitle();
        System.out.println("VERIFYING TITLE EQUALS 'Dashboard");
        Assert.assertEquals(title,"Dashboard");

        Thread.sleep(2000);
        WebElement shortcut=driver.findElement(By.className("fa-share-square"));
        shortcut.click();
        Thread.sleep(2000);
        WebElement full_listLink=driver.findElement(By.linkText("See full list"));
        full_listLink.click();
        Thread.sleep(2000);
        WebElement opportunitiesLink=driver.findElement(By.linkText("Opportunities"));
        opportunitiesLink.click();
        Thread.sleep(5000);

        String pageName=driver.getTitle();
        System.out.println("VERIFYING PAGE NAME STARTS WITH 'Open Opportunities'");
        Assert.assertTrue(pageName.startsWith("Open Opportunities"));

        Thread.sleep(2000);
        WebElement shortcut1=driver.findElement(By.className("fa-share-square"));
        shortcut1.click();
        Thread.sleep(2000);
        WebElement full_listLink1=driver.findElement(By.linkText("See full list"));
        full_listLink1.click();
        Thread.sleep(2000);
        WebElement vehicleServiceLogsLink=driver.findElement(By.linkText("Vehicle Services Logs"));
        vehicleServiceLogsLink.click();
        Thread.sleep(5000);

        WebElement messageItem=driver.findElement(By.xpath("//div[@class='message']"));
        String actualMessage=messageItem.getText();
        String expectedMessage="You do not have permission to perform this action.";

        System.out.println("VERIFYING Expected Message: "+expectedMessage);
        Assert.assertEquals(expectedMessage,actualMessage);


        Thread.sleep(5000);
        WebElement shortcut2=driver.findElement(By.xpath("//a[@title='Shortcuts']"));
        String actualShortCutName=shortcut2.getAttribute("title");
        String expectedShortcutname="Shortcuts";

        System.out.println("VERIFYING Actual shortCutname: "+expectedShortcutname);
        Assert.assertEquals(expectedShortcutname,actualShortCutName);

        Thread.sleep(2000);
    }
}
