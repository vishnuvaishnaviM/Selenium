package com.sample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// handling web tables
// 1. static web tables
public class Selenium14 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        
        // Find number of rows in the table by calculating the number of tr in the table
        int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tbody//tr")).size();
        System.out.println("Total number of rows: " + rows);
        
        // Calculate the number of columns in the table
        int columns = driver.findElements(By.xpath("//table[@name='BookTable']//tbody//tr[1]//th")).size();
        System.out.println("Total number of columns: " + columns);
        
        // Get data from specific row and column
        String data = driver.findElement(By.xpath("//table[@name='BookTable']//tbody//tr[3]//td[3]")).getText();
        System.out.println("Data at 3rd row and 2nd column: " + data);
    
        // Print book names whose author is Mukesh
        for (int i = 2; i <= rows; i++) {
            String authorName = driver.findElement(By.xpath("//table[@name='BookTable']//tbody//tr[" + i + "]//td[2]")).getText();
            if (authorName.equals("Mukesh")) {
                String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tbody//tr[" + i + "]//td[1]")).getText();
                System.out.println("Book by Mukesh: " + bookName);
            }
        }
        
        int total = 0;
        // Print total price for all books
        for (int i = 2; i <= rows; i++) {
            String price = driver.findElement(By.xpath("//table[@name='BookTable']//tbody//tr[" + i + "]//td[4]")).getText();
            total += Integer.parseInt(price);
        }
        System.out.println("Total price: " + total);
        
        // Close the browser
        driver.quit();
    }
}
