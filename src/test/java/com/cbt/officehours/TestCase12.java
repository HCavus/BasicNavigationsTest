package com.cbt.officehours;

import com.cbt.utilities.BrowserFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase12 {
   // @Test(priority=100 , description = "Verify that the following message is displayed : 'This page returned a 500 status code'")
    public void testCase12() {
        //Test Case #12
     /*
     Step 1. Go to "https://practice-cybertekschool.herokuapp.com"
     Step 2. And click on "Status Codes".
     Step 3. Then click on "500".
     Step 4. Verify that following message is displayed: "This page returned a 500 status code"
      */
        //Step 1
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2
     /*
       xpath :
          //a[text()='Status Codes']
          //a[contains(text(),'Status Codes')]
          //ul/li[46]
          //a[@href="/status_codes"]
       linkText :
          lintText("Status Codes")
       partialLinkText:
          partialLintText("Status Codes")
          partiallinkText("Status")
          partiallinkText("Codes")
          CssSelector
          [href="/status_codes"]
      */
        WebElement statusCodeLink = driver.findElement(By.linkText("Status Codes"));
        statusCodeLink.click();
        //Step 3
        WebElement statusCode = driver.findElement(By.linkText("500"));
        statusCode.click();
        // Step 4
        String expectedMessage ="This page returned a 500 status code";
        WebElement displayedMessageElement = driver.findElement(By.xpath("//p"));
        String actualMessage = displayedMessageElement.getText();
        //System.out.println(actualMessage);
        if(actualMessage.contains(expectedMessage)){
            System.out.println("Passed");
        }else{
            System.out.println("FAILED");
        }
        driver.close();
    }
    /*
    Step 1. Go to "https://practice-cybertekschool.herokuapp.com"
    Step 2. And click on "Status Codes".
    Step 3. Then click on "404".
    Step 4. Verify that following message is displayed: "This page returned a 404 status code"
     */
   // @Test(priority = 1, description = "Verify that the following message is displayed : 'This page returned a 404 status code'")
    public void testCase11() throws InterruptedException {
        //Step 1
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2
        WebElement statusCodeLink = driver.findElement(By.linkText("Status Codes"));
        statusCodeLink.click();
        //Step 3
        WebElement statusCode = driver.findElement(By.linkText("404"));
        statusCode.click();
        Thread.sleep(3000);
        //Step 4
        String expectedMessage = "This page returned a 404 status code";
        WebElement displayedMessageElement = driver.findElement(By.xpath("//p"));
        String actualMessage = displayedMessageElement.getText();
        if (actualMessage.contains(expectedMessage)) {
            System.out.println("Passed");
        } else {
            System.out.println("FAILED");
        }
        driver.close();
    }
    }
