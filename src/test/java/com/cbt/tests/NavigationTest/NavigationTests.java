package com.cbt.tests.NavigationTest;

import com.cbt.utilities.BrowserFactory;

import org.openqa.selenium.WebDriver;

public class NavigationTests {
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
    public static void main(String[] args) {

        //getChrome();
        //getFirefox();
        getEdge();
    }

    public static void getChrome(){
        WebDriver driver= BrowserFactory.getDriver("Chrome");
        driver.get("http://google.com");
        String ggltitle1=driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String etsyTitle1=driver.getTitle();
        driver.navigate().back();
        String ggTitle2=driver.getTitle();
      if(ggltitle1.equals(ggTitle2)){
          System.out.println("PASS ON CHROME");
      }else{
          System.out.println("FAIL ON CHROME");
          System.out.println("Expect result: "+ggltitle1);
          System.out.println("Actual result: "+ggTitle2);
      }
      driver.navigate().forward();
        String etsyTitle2=driver.getTitle();
        if(etsyTitle1.equals(etsyTitle2)){
            System.out.println("PASS ON CHROME");
        }else{
            System.out.println("FAIL ON CHROME");
            System.out.println("Expect result: "+etsyTitle1);
            System.out.println("Actual result: "+etsyTitle2);
        }
        driver.close();
      }



    public static void getFirefox(){
        WebDriver driver= BrowserFactory.getDriver("firefox");
        driver.get("http://google.com");
        String ggltitle1=driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String etsyTitle1=driver.getTitle();
        driver.navigate().back();
        String ggTitle2=driver.getTitle();
        if(ggltitle1.equals(ggTitle2)){
            System.out.println("PASS ON FIREFOX");
        }else{
            System.out.println("FAIL ON FIREFOX");
            System.out.println("Expect result: "+ggltitle1);
            System.out.println("Actual result: "+ggTitle2);
        }
        driver.navigate().forward();
        String etsyTitle2=driver.getTitle();
        if(etsyTitle1.equals(etsyTitle2)){
            System.out.println("PASS ON FIREFOX");
        }else{
            System.out.println("FAIL ON FIREFOX");
            System.out.println("Expect result: "+etsyTitle1);
            System.out.println("Actual result: "+etsyTitle2);
        }
        driver.close();
    }

    public static void getEdge(){
        WebDriver driver= BrowserFactory.getDriver("edge");
        driver.get("http://google.com");
        String ggltitle1=driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String etsyTitle1=driver.getTitle();
        driver.navigate().back();
        String ggTitle2=driver.getTitle();
        if(ggltitle1.equals(ggTitle2)){
            System.out.println("PASS ON EDGE");
        }else{
            System.out.println("FAIL ON EDGE");
            System.out.println("Expect result: "+ggltitle1);
            System.out.println("Actual result: "+ggTitle2);
        }
        driver.navigate().forward();
        String etsyTitle2=driver.getTitle();
        if(etsyTitle1.equals(etsyTitle2)){
            System.out.println("PASS ON EDGE");
        }else{
            System.out.println("FAIL ON EDGE");
            System.out.println("Expect result: "+etsyTitle1);
            System.out.println("Actual result: "+etsyTitle2);
        }
        driver.close();
    }


    }

