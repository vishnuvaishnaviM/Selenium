package com.sample;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//taking screenshots
public class Selenium21 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com/");

        //takescreenshot interface
        TakesScreenshot ts = (TakesScreenshot)driver;
        //full page screenshot
        File outputfile1 = ts.getScreenshotAs(OutputType.FILE); //this will store the screenshot in outputfile1 variable
        File targetFile1 = new File(System.getProperty("user.dir")+"\\Selenium\\demo\\screenshots\\fullpage.png");
        outputfile1.renameTo(targetFile1); //copy sourcefile to target file
        
        //screenshot for a specific area of a page
        WebElement featureProduct = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
        File sourceFeature = featureProduct.getScreenshotAs(OutputType.FILE);
        File destFeature = new File(System.getProperty("user.dir")+"\\Selenium\\demo\\screenshots\\feature.png");
        sourceFeature.renameTo(destFeature);

        //screenshot for a specific element- 
        WebElement logoProduct = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        File sourcelogo = logoProduct.getScreenshotAs(OutputType.FILE);
        File destlogo = new File(System.getProperty("user.dir")+"\\Selenium\\demo\\screenshots\\logo.png");
        sourcelogo.renameTo(destlogo);


        driver.quit();
    }
}
