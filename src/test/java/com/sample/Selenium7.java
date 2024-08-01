package com.sample;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

//webdriver methods - fluent wait method
public class Selenium7 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
                                    .withTimeout(Duration.ofSeconds(1000))
                                    .pollingEvery(Duration.ofSeconds(5))
                                    .ignoring(NoSuchElementException.class);
        
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        // Thread.sleep(10000);
        driver.manage().window().maximize();
        WebElement txtUserName = mywait.until(new Function<WebDriver,WebElement>() {
            public WebElement apply(WebDriver driver)
            {return driver.findElement(By.xpath("//input[@placeholder='Username']"));}
            
        });
        txtUserName.sendKeys("admin");
        driver.quit();
    }
    
}
