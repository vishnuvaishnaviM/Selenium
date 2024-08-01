package com.sample;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//handle alerts using explicit wait
public class Selenium10 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));//explicit wait declaration

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
        Alert myalert = mywait.until(ExpectedConditions.alertIsPresent());//capture alert
        myalert.accept();

        //authenticated popup
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        driver.quit();

    }
    
}
