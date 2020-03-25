package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;

import com.cbt.utilities.StringUtilityWithTestNg;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;


public class NevigationTestsWithTestNg {

    /*
   1. Open	browser
   2. Go	to	website	https://google.com
   3. Save	the	title	in	a	string	variable
   4. Go	to	https://etsy.com
   5. Save	the	title	in	a	string	variable
   6. Navigate	back	to	previous	page
   7. Verify	that	title	is	same	is	in	step	3
   8. Navigate	forward	to	previous	page
   9. Verify	that	title	is	same	is	in	step	5
    */
  @Test
   public void getChrome(){
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://google.com");
        String ggltitle1=driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String etsyTitle1=driver.getTitle();
        driver.navigate().back();
        String ggTitle2=driver.getTitle();
      System.out.println("TESTING ON CHROME");
      System.out.println("VERIFYING THE TITLE IS THE SAME IN STEP 3");
      Assert.assertEquals(ggltitle1,ggTitle2);

      driver.navigate().forward();
      String etsyTitle2=driver.getTitle();
      System.out.println("TESTING ON CHROME");
      System.out.println("VERIFYING THE TITLE IS THE SAME IN STEP 5");
      Assert.assertEquals(ggltitle1,ggTitle2);
        driver.close();
    }
    @Test
    public void getFirefox(){
        WebDriver driver= BrowserFactory.getDriver("firefox");
        driver.get("http://google.com");
        String ggltitle1=driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String etsyTitle1=driver.getTitle();
        driver.navigate().back();
        String ggTitle2=driver.getTitle();
        System.out.println("TESTING ON FIREFOX");
        System.out.println("VERIFYING THE TITLE IS THE SAME IN STEP 3");
        Assert.assertEquals(ggltitle1,ggTitle2);

        driver.navigate().forward();
        String etsyTitle2=driver.getTitle();
        System.out.println("TESTING ON FIREFOX");
        System.out.println("VERIFYING THE TITLE IS THE SAME IN STEP 5");
        Assert.assertEquals(ggltitle1,ggTitle2);
        driver.close();
    }
@Test
    public void getEdge(){
        WebDriver driver= BrowserFactory.getDriver("edge");
        driver.get("http://google.com");
        String ggltitle1=driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String etsyTitle1=driver.getTitle();
        driver.navigate().back();
        String ggTitle2=driver.getTitle();
        System.out.println("TESTING ON EDGE");
        System.out.println("VERIFYING THE TITLE IS THE SAME IN STEP 3");
        Assert.assertEquals(ggltitle1,ggTitle2);

        driver.navigate().forward();
        String etsyTitle2=driver.getTitle();
        System.out.println("TESTING ON EDGE");
        System.out.println("VERIFYING THE TITLE IS THE SAME IN STEP 5");
        Assert.assertEquals(ggltitle1,ggTitle2);
        driver.close();
    }


    }


