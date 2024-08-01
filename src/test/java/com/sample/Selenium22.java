package com.sample;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//headless testing
public class Selenium22 {
    public static void main(String[] args) {
        //headless mode for chrome
        ChromeOptions options1 = new ChromeOptions();
        // options1.addArguments("--headless=new"); //to enable headless testing
        options1.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});//to remove 'chrome is being controlled by automated test software'
        WebDriver driver = new ChromeDriver(options1);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com/");
        String logoProduct = driver.findElement(By.xpath("//div[@class='topic-block-title']//h2")).getText();
        System.out.println(logoProduct);
        driver.quit();


    }
}
