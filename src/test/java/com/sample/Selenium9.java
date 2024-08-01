package com.sample;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//handling checkboxes 
//handling alerts using switch to
public class Selenium9 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        List<WebElement> checkboxList =  driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
        //check all the checkboxes of all 7 days in a week
        for(WebElement check: checkboxList){
            check.click();
        }

        //to check last three elements in the given list - here it unchecks last 3 elements since all 7 elements are already checked
        for(int i=checkboxList.size()-3; i<checkboxList.size();i++){
            checkboxList.get(i).click();
        }

        //to check the checkboxes only if they are not checked
        for (WebElement check: checkboxList){
            if(!check.isSelected()){
                check.click();
            }
        }
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //handling alert popup

        //normal alert with just 'ok' button
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
        Alert alert = driver.switchTo().alert();   
        System.out.println(alert.getText());   //get the text on the alert
        alert.accept();//to accept the alert 
        
        //confirmation alert - ok and cancel
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
        Alert alert1 = driver.switchTo().alert();   
        System.out.println(alert1.getText());   //get the text on the alert
        alert1.dismiss();//to cancel the alert 

        //alert box having input box
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
        Alert alert2 = driver.switchTo().alert();   
        System.out.println(alert2.getText());   //get the text on the alert
        alert2.sendKeys("input"); //to type input in the alert text box
        alert2.accept();//to accept the alert 
        driver.quit();
    }
    
}
