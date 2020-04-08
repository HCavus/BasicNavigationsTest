package com.cbt.tests.TestCases_2Copy;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyUrlTests {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = BrowserFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDwn(){
        driver.quit();
    }

//  open browser
//	go to http://practice.cybertekschool.com/forgot_password  Links to an external site.
//  click on Retrieve password
// verify that url did not change
@Test
public void test1verifyUrl(){
    driver.get("http://practice.cybertekschool.com/forgot_password");

    WebElement retrievePassword=driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));
    retrievePassword.click();
    WebDriverWait wait=new WebDriverWait(driver,5);
    wait.until(ExpectedConditions.titleIs("Practice"));
    String expectedUrl="http://practice.cybertekschool.com/forgot_password";
    String actualUrl=driver.getCurrentUrl();
    Assert.assertEquals(expectedUrl,actualUrl);

}
/*
•	open browser
•	go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
•	enter any email
•	click on Retrieve password
•	verify that url changed to http://practice.cybertekschool.com/email_sent

 */
@Test
    public void test2verifyUrlChanged(){
    driver.get("http://practice.cybertekschool.com/forgot_password");
    driver.findElement(By.name("email")).sendKeys("abc@gmail.com");
    WebElement retrievePassword=driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));
    retrievePassword.click();
    WebDriverWait wait=new WebDriverWait(driver,5);
    wait.until(ExpectedConditions.titleIs("Practice"));
    String expectedUrl="http://practice.cybertekschool.com/email_sent";
    String actualUrl=driver.getCurrentUrl();
    Assert.assertEquals(expectedUrl,actualUrl);

}
/*
•	open browser
•	go to http://practice.cybertekschool.com/forgot_password  Links to an external site.
•	enter any email
•	verify that email is displayed in the input box
•	click on Retrieve password
•	verify that confirmation message says 'Your e-mail's been sent!'

 */
    @Test
    public void test3verifyConfirmationMessage(){
    driver.get("http://practice.cybertekschool.com/forgot_password");
    WebElement emailBox=driver.findElement(By.name("email"));
    emailBox.sendKeys("abc@gmail.com");

        WebElement retrievePassword=driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));
        retrievePassword.click();
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.titleIs("Practice"));
        WebElement confirmationMessage=driver.findElement(By.name("confirmation_message"));
        String message=confirmationMessage.getText();
        Assert.assertEquals(message,"Your e-mail's been sent!");
}
}
