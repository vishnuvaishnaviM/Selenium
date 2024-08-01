package com.sample;

import java.time.Duration;
//switching between frames
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium11 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://ui.vision/demo/webtest/frames/");
        WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
        //switch to frame1
        driver.switchTo().frame(frame1);//passing frame as web Element
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("welcome");
        //switch back to page
        driver.switchTo().defaultContent();

        //fraame2
        WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("welcome2");
        //switch back to page
        driver.switchTo().defaultContent();


        //fraame3
        WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
        driver.switchTo().frame(frame3);
        driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("welcome3");
        //navigate to iframe inside a frame
        //since there is only one frame inside frame3 - using index concept
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//div[@id='i5']//div[@class='AB7Lab Id5V1']")).click();

        //come back to main page
        driver.switchTo().defaultContent();
        driver.quit();
    }


    }
    

