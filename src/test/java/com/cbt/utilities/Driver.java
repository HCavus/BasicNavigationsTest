package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {
   private static WebDriver driver;
    private Driver(){

    }
    public static WebDriver getDriver(String browser) {
          driver=null;
        switch(browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                //ChromeOptions chromeOptions=new ChromeOptions().setHeadless(true);
                driver= new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            case "chrome_headless":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions=new ChromeOptions().setHeadless(true);
                //set capabilities --DesiredCapabilities -->extensions,proxy,platname
                driver=new ChromeDriver(chromeOptions);
            case "firefox_headless":
                WebDriverManager.firefoxdriver().setup();
               FirefoxOptions firefoxOptions=new FirefoxOptions().setHeadless(true);
                driver=new FirefoxDriver(firefoxOptions);
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
                break;

        }
        return driver;

    }
    public static void quit(){
        if(driver!=null) {
            driver.quit();
            driver=null;
            //if the driver does not exist and you try to close it then you will get error" Session does not exist"
        }
    }
}
