package com.cbt.tests.TestCase2Practice;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase2Practice1_5 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDwn() {
        driver.quit();
    }

    /*
    Step 1. Go to “https://practice.cybertekschool.com”
    Step 2. Click on “Registration Form”
    Step 3. Enter “wrong_dob” into date of birth input box.
    Step 4. Verify that warning message is displayed: “The date of birth is not valid”

     */
    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Registration Form")).click();
        WebElement birthInputBox = driver.findElement(By.name("birthday"));

        birthInputBox.sendKeys("wrong_dob");
        WebElement message = driver.findElement(By.xpath("//small[@data-bv-validator='date']"));
        String actualMessage = message.getText();
        String expectedMessage = "The date of birth is not valid";
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    /*
    Step 1. Go to “https://practice.cybertekschool.com”
    Step 2. Click on “Registration Form”
    Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript

     */
    @Test
    public void test2() {
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Registration Form")).click();
        List<WebElement> options = driver.findElements(By.xpath("//label[@class='form-check-label']"));
        List<String> optionNames = new ArrayList<>();
        for (WebElement each : options) {
            optionNames.add(each.getText());
            Assert.assertTrue(each.isDisplayed());
            System.out.println(each.getText() + " is displayed");
        }

    }

    /*
    Step 1. Go to “https://practice.cybertekschool.com”
    Step 2. Click on “Registration Form”
    Step 3. Enter only one alphabetic character into ﬁrst name input box.
    Step 4. Verify that warning message is displayed: first name must be more than 2 and less than 64 characters long
     */
    @Test
    public void test3() {
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Registration Form")).click();
        WebElement firstNameBox = driver.findElement(By.name("firstname"));
        firstNameBox.sendKeys("a");
        WebElement message = driver.findElement(By.xpath("(//small[@data-bv-validator='stringLength'])[1]"));
        String actualMessage = message.getText();
        String expectedMessage = "first name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    /*
    Step 1. Go to https://practice.cybertekschool.com
    Step 2. Click on “Registration Form”
    Step 3. Enter only one alphabetic character into last name input box.
    Step 4. Verify that warning message is displayed: “The last name must be more than 2 and less than 64 characters long”

     */
    @Test
    public void test4() {
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Registration Form")).click();
        WebElement lastNameBox = driver.findElement(By.name("lastname"));
        lastNameBox.sendKeys("z");
        WebElement message = driver.findElement(By.xpath("(//small[@data-bv-validator='stringLength'])[2]"));
        String actualMessage = message.getText();
        String expectedMessage = "The last name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(actualMessage, expectedMessage);
    }
    /*
    Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter any valid ﬁrst name.
Step 4. Enter any valid last name.
Step 5. Enter any valid user name.
Step 6. Enter any valid password.
Step 7. Enter any valid phone number.
Step 8. Select gender.
Step 9. Enter any valid date of birth.
Step 10. Select any department.
Step 11. Enter any job title.
Step 12. Select java as a programming language.
Step 13. Click Sign up.
Step 14. Verify that following success message is displayed: “You've successfully completed registration!”
     */
    @Test
    public void test5() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Registration Form")).click();
        //Enter any valid first name.
        WebElement firstNameBox = driver.findElement(By.name("firstname"));
        firstNameBox.sendKeys("John");
        //Enter any valid last name.
        WebElement lastNameBox = driver.findElement(By.name("lastname"));
        lastNameBox.sendKeys("Smith");
        // Enter any valid user name.
        WebElement userNameBox = driver.findElement(By.name("username"));
        userNameBox.sendKeys("johnsmith");
        //enter email address
        WebElement emailBox = driver.findElement(By.name("email"));
        emailBox.sendKeys("abc@gmail.com");
        //  Enter any valid password.
        WebElement passwordBox = driver.findElement(By.name("password"));
        passwordBox.sendKeys("abcde123");
        // Enter any valid phone number.
        WebElement phoneBox = driver.findElement(By.name("phone"));
        phoneBox.sendKeys("777-777-7777");
        //Select gender.
        WebElement gender=driver.findElement(By.xpath("//input[@value='female']"));
        gender.click();
        //Enter any valid date of birth.
        WebElement birthdayBox = driver.findElement(By.name("birthday"));
        birthdayBox.sendKeys("10/17/2001");
        //Select any department.
        WebElement departmentBox = driver.findElement(By.name("department"));
        Select select=new Select(departmentBox);
        select.selectByVisibleText("Accounting Office");
        //Enter any job title.
        WebElement jobTitleBox = driver.findElement(By.name("job_title"));
        Select select1=new Select(jobTitleBox);
        select1.selectByVisibleText("Developer");
        //Select java as a programming language.
        WebElement language=driver.findElement(By.id("inlineCheckbox2"));
        language.click();
        //Click Sign up.
        WebElement submit=driver.findElement(By.id("wooden_spoon"));
        submit.click();
        //Verify that following success message is displayed: “You've successfully completed registration!”
        Thread.sleep(3000);
        WebElement message=driver.findElement(By.xpath("//div/h4/following-sibling::p"));
        String actualMessage = message.getText();
        String expectedMessage = "You've successfully completed registration!";
        Assert.assertEquals(actualMessage, expectedMessage);
}
}