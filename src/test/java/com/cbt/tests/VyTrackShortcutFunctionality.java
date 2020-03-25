package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VyTrackShortcutFunctionality {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= BrowserFactory.getDriver("chrome");
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
        if(title.equals("Dashboard")){
            System.out.println("Pass: You are on "+title+" page");
        }else{
            System.out.println("Fail: You are on "+title+" page");
        }
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
        if(pageName.startsWith("Open Opportunities")){
            System.out.println("Pass: You are on "+pageName+" page");
        }else{
            System.out.println("Fail: You are on "+pageName+" page");
        }
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
        if(expectedMessage.equals(actualMessage)){
            System.out.println("Pass- Message : "+ actualMessage);
        }else{
            System.out.println("Fail");
            System.out.println("Expected message: "+expectedMessage);
            System.out.println("Actual message: "+actualMessage);
        }
        Thread.sleep(5000);
        WebElement shortcut2=driver.findElement(By.xpath("//a[@title='Shortcuts']"));
        String actualShortCutName=shortcut2.getAttribute("title");
        String expectedShortcutname="Shortcuts";
        if(expectedShortcutname.equals(actualShortCutName)){
            System.out.println("Pass- Shortcut: "+ actualShortCutName);
        }else{
            System.out.println("Fail");
            System.out.println("Expected shortcut: "+expectedShortcutname);
            System.out.println("Actual shortcut: "+actualShortCutName);
        }
        Thread.sleep(2000);
        driver.close();
    }
}
