package com.sample;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//webdriver methods
//1.get methods
//2.conditional methods
public class Selenium5 {
    public static void main(String[] args) throws InterruptedException {
        //1.get methods
        WebDriver driver = new ChromeDriver();
        //get(url) - opens the url on the browser
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);
        //getTitle()
        System.out.println(driver.getTitle());
        //getCurrentUrl
        System.out.println(driver.getCurrentUrl());
        //getPageSource
        System.out.println(driver.getPageSource());
        //get ID of the single browser window
        System.out.println(driver.getWindowHandle());
        //get window handles
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();
        Set<String> windowUrls =  driver.getWindowHandles();
        System.out.println(windowUrls);

        //2.conditional methods
        //isDisplayed()
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        System.out.println( "is displayed - "+ driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed());

        //isEnabled
        System.out.println( "is enabled - "+ driver.findElement(By.xpath("//input[@id='small-searchterms']")).isEnabled());

        //isSelected
        System.out.println( "is selected - "+ driver.findElement(By.xpath("//input[@id='gender-male']")).isSelected());

        driver.quit();



    }
}
