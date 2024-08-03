package com.sample.TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//Test Annotation
//priority of test cases
public class TestNG{
    WebDriver driver;
    @Test(priority=1)
    void openapp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("app opened");
    }
    @Test(priority=2)
    void login() throws InterruptedException{
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("logged in ");
    }
    @Test(priority=3)
    void logout(){
        driver.quit();
        System.out.println("logged out");
    }



}