package com.sample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//webdriver methods
//3.wait methods
public class Selenium6 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        //implicit wait
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait for 5sec

        //explicit wait 
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10)); //declaration
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        //explicit usage on input box - if the box is enabled
        myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']"))).sendKeys("username");
        //explicit usage on the submit button - if the button is clickable
        myWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']"))).click();
        driver.close();


    }
}
