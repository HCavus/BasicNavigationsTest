package com.cbt.tests.FirstSeleniumHomework;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VyTrackTitleTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://app.vytrack.com/user/login");
        Thread.sleep(2000);
        WebElement usernameBox=driver.findElement(By.id("prependedInput"));
        usernameBox.sendKeys("User4");
        Thread.sleep(2000);
        WebElement passwordBox=driver.findElement(By.id("prependedInput2"));
        passwordBox.sendKeys("UserUser123");
        Thread.sleep(2000);
        WebElement loginButton=driver.findElement(By.id("_submit"));
        loginButton.submit();
        Thread.sleep(2000);

        WebElement nameOnTop=driver.findElement(By.cssSelector("a[href='javascript: void(0);']"));

        String name=nameOnTop.getText();
        nameOnTop.click();
        Thread.sleep(2000);
        //    1               2           3
        //ul.dropdown-menu >li>a[href='/config/user/profile']
        //1.find the list that contains all the options
        //2.the options on that list
        //3.find the link within those
        WebElement myconfi=driver.findElement(By.cssSelector("ul.dropdown-menu >li>a[href='/config/user/profile']"));
        myconfi.click();
       // WebElement myconfiguration=driver.findElement(By.linkText("My Configuration"));
       // myconfiguration.click();
        Thread.sleep(2000);
        String title=driver.getTitle();
        if(title.startsWith(name)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Title:"+title);
            System.out.println("Title does not start with "+name);
        }
        driver.close();
    }
}
