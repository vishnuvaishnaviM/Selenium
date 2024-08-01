package com.sample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//handling dynamic search changes of google search - handling auto suggest dropdown
public class Selenium13 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //give some basic input of the search and wait for 5 sec to load the dynamic search results
        driver.get("http://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("selenium");
        Thread.sleep(5000);
        List<WebElement> list1 = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
        System.out.println(list1.size());
        for(int i=0;i<list1.size();i++){
            System.out.println(list1.get(i).getText());
            if (list1.get(i).getText().equals("selenium")) {
                list1.get(i).click();
                break;
            }
        }
        driver.quit();
    }
}
