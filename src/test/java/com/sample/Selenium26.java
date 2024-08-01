package com.sample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//handling shadow DOM
public class Selenium26 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://books-pwakit.appspot.com/");

        //shadow DOM element - copied this content from selectorHUB
        //This Element is inside single shadow DOM.
        // String cssSelectorForHost1 = "book-app[apptitle='BOOKS']";
        // Thread.sleep(1000);
        SearchContext shadow = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
        Thread.sleep(1000);
        shadow.findElement(By.cssSelector("#input")).sendKeys("selenium");
        driver.quit();
    }
}
