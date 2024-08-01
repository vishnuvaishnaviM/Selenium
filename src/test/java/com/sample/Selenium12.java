package com.sample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.*;

//handling different dropdowns
public class Selenium12 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testautomationpractice.blogspot.com/");

        //select dropdown - that has select in the tag name
       WebElement drpOptions =  driver.findElement(By.xpath("//select[@id='country']"));
       Select drpList = new Select(drpOptions);
       //using selectByVisibleText()
       drpList.selectByVisibleText("France");
       //using selectByText()
       drpList.selectByValue("japan");
       //using selectByIndex()
       drpList.selectByIndex(3);
        //get the list of options in the dropdown and count no of values in the dropdown
        List<WebElement> options = drpList.getOptions();
        System.out.println("total number of options in dropdown - " + options.size());
        for(WebElement opt: options){
            System.out.println(opt.getText());
        }


        //bootstrap dropdown
        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2#google_vignette");
        driver.findElement(By.xpath("//span[@class='multiselect-selected-text']")).click();
        //select option
        driver.findElement(By.xpath("//label[normalize-space()='Python']")).click();

        //capture all the options and print size
        List<WebElement> options2 = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
        System.out.println("total options in bootstrap dropdown - " + options2.size());
        for(WebElement opt: options2){
            System.out.println(opt.getText());
        }

        //to select multiple options
        for(WebElement opt: options2){
            String text = opt.getText();
            if(text.equals("Java") || text.equals("Python") || text.equals("C#")){
                opt.click();
            }
        }

        //hidden dropout
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();

        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[6]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")).click();
        // driver.findElement(By.xpath("//span[normalize-space()='Account Assistant']")).click();
        //count no of options
        // driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[6]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")).click();
        Thread.sleep(5000);
        List<WebElement> opt3 =  driver.findElements(By.xpath("//div[@role='option']//span"));
        System.out.println(" total no of options in opt3 - " + opt3.size());
        driver.quit();
    }
}
