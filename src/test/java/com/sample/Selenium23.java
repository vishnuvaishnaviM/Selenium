package com.sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium23 {
    public static void main(String[] args) {
        // Handling SSL 
        ChromeOptions options2 = new ChromeOptions();
        options2.setAcceptInsecureCerts(true);
        
        WebDriver driver2 = null;
        try {
            driver2 = new ChromeDriver(options2);
            driver2.get("https://expired.badssl.com/");
            System.out.println("Page title is: " + driver2.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver2 != null) {
                driver2.quit();
            }
        }
    }
}
