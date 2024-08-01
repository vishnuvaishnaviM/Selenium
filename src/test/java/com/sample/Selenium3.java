package com.sample;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//special locators - CSS locators
public class Selenium3 {
    public static void main(String[] args) {
        //launch browser and open URL

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        //search for the search box using css selector and give input in the search box
        //1.tag#id
        driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("mobiles");
        ////#id
        driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("AutoMobiles");
        

        //2.tag.classname
        driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("laptop");
        //.className
        driver.findElement(By.cssSelector(".search-box-text")).sendKeys("charger");

        //3.tag attribute
        driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("bag");
        //attribute
        driver.findElement(By.cssSelector("[placeholder='Search store']")).sendKeys("newbag");
        
        //4. tag class attribute
        driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("clothes");
        //class attribute
        driver.findElement(By.cssSelector(".search-box-text[name='q']")).sendKeys("newclothes");

        driver.close();
    }
}
