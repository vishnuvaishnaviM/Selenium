package com.sample;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v125.input.model.DragData;

//handling date pickers - 1
public class Selenium15 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/datepicker/");
        Thread.sleep(10000);
        driver.switchTo().frame(0);
        driver.findElement(By.id("datepicker")).click(); //click on date picker input box to view the calendar
        //click on next/prev button in the calendar to reach to the desired month and year
        String year="2023";
        String month = "February";
        String date = "24";

        while (true) {
            String currMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String currYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            if(currMonth.equals(month) && currYear.equals(year)){
                break;
            }
            // if it is not matched click on next/prev button based on past/future date from present
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
        }

        List<WebElement> dateList = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td//a"));
        for(WebElement dt:dateList){
            if (dt.getText().equals(date)){
                dt.click();
                break;
            }
        }
        driver.quit();

    }
}
