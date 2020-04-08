package com.cbt.tests.TestCase2Practice;

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

import java.util.concurrent.TimeUnit;

public class TestCse2Practice6_8 {
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
    Step 1. Go to "https://www.tempmailaddress.com/"
Step 2. Copy and save email as a string.
Step 3. Then go to “https://practice.cybertekschool.com”
Step 4. And click on “Sign Up For Mailing List".
Step 5. Enter any valid name.
Step 6. Enter email from the Step 2.
Step 7. Click Sign Up
Step 8. Verify that following message is displayed: “Thank you for signing up. Click the button below to return to the home page.”
Step 9. Navigate back to the “https:// www.tempmailaddress.com/”
Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
Step 11. Click on that email to open it.
Step 12. Verify that email is from: “do-notreply@practice.cybertekschool.com”
Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”

     */
    @Test
    public void test6() throws InterruptedException {
    driver.get("https://www.tempmailaddress.com/");
        WebElement emailbox=driver.findElement(By.id("email"));
        String email=emailbox.getText();
        System.out.println(email);
        driver.navigate().to("http://practice.cybertekschool.com/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        //Enter any valid name.
       WebElement nameBox= driver.findElement(By.name("full_name"));
       nameBox.sendKeys("Tom Smith");
        //Enter email from the Step 2.
        WebElement emailBox1=driver.findElement(By.name("email"));
        emailBox1.sendKeys(email);
        //Click Sign Up
        WebElement submit=driver.findElement(By.name("wooden_spoon"));
        submit.click();
        //Verify that following message is displayed: “Thank you for signing up. Click the button below to return to the home page.”
        WebElement message=driver.findElement(By.tagName("h3"));
        String actualMessage=message.getText();
        String expectedMessage="Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(expectedMessage,actualMessage);
        // Navigate back to the “https://www.tempmailaddress.com/”
        driver.navigate().to("https://www.tempmailaddress.com/");
        //Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
        Thread.sleep(4000);
//       // WebElement message1=driver.findElement(By.xpath("(//span[@class='glyphicon glyphicon-envelope'])[1]"));
//        String actualMessage1=message1.getText();
//        String expectedMessage1="do-not-reply@practice.cybertekschool.com";
//        Assert.assertEquals(expectedMessage1,actualMessage1);
//        //Step 11. Click on that email to open it.
//        message1.click();

        //Step 12. Verify that email is from: “do-not-reply@practice.cybertekschool.com”
        WebElement email1=driver.findElement(By.id("odesilatel"));
        String emailfrom=email1.getText();
        String expectedEmailfrom="do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(expectedEmailfrom,emailfrom);
        //Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
    }
    /*
    Step 1. Go to “https://practice.cybertekschool.com”
Step 2. And click on “File Upload".
Step 3. Upload any ﬁle with .txt extension from your computer.
Step 4. Click “Upload” button.
Step 5. Verify that subject is: “File Uploaded!”
Step 6. Verify that uploaded ﬁle name is displayed.
Note: use element.sendKeys(“/ﬁle/path”) with specifying path to the ﬁle for uploading.
Run this method against “Choose File” button.
     */
    @Test
    public void test7(){
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.linkText("File Upload")).click();

        WebElement chooseBox=driver.findElement(By.id("file-upload"));
        String  file="C:\\Users\\halim\\Desktop\\Zombie Attack.docx";
        chooseBox.sendKeys(file);

        WebElement uploadBtn=driver.findElement(By.id("file-submit"));
        uploadBtn.click();
        //Verify that subject is: “File Uploaded!”
        WebElement message=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(message.isDisplayed());
        String actualmessage=message.getText();
        String expectedMessage="File Uploaded!";
        Assert.assertEquals(expectedMessage,actualmessage);
        //Verify that uploaded ﬁle name is displayed.
        WebElement fileName=driver.findElement(By.id("uploaded-files"));
        Assert.assertTrue(fileName.isDisplayed());
        System.out.println("File name is: "+fileName.getText());

    }
    /*/
    Step 1. Go to “https://practice.cybertekschool.com”
Step 2. And click on “Autocomplete”.
Step 3. Enter “United States of America” into country input box.
Step 4. Verify that following message is displayed: “You selected: United States of America”

     */
    @Test
    public void test8(){
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Autocomplete")).click();
        WebElement countryInput=driver.findElement(By.id("myCountry"));
        countryInput.sendKeys("United States of America");
        WebElement submitBtn=driver.findElement(By.xpath("//input[@value='Submit']"));
        submitBtn.submit();
        WebElement message=driver.findElement(By.cssSelector("p#result"));
        Assert.assertTrue(message.isDisplayed());
        System.out.println("actual message: "+message.getText());
        //String actualMessage=message.getText();
        String expectedMessage="You selected: United States of America";
        System.out.println("Expected message: "+expectedMessage);
       // Assert.assertEquals(expectedMessage,actualMessage);
    }
}
