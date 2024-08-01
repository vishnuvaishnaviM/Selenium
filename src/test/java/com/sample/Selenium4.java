package com.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//locators - xpath
public class Selenium4 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.nopcommerce.com/");

        //xpath with single attribute
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("laptop bag");
        //xpath with multiple attribute
        driver.findElement(By.xpath("//input[@name='q'][@placeholder='Search store']")).sendKeys("new bag");
        //xpath with 'and' 'or' operator
        driver.findElement(By.xpath("//input[@name='q' and @placeholder='Search store']")).sendKeys("old bag");
        driver.findElement(By.xpath("//input[@name='q' or @placeholder='Search store']")).sendKeys("laptop");
        //by text()
        driver.findElement(By.xpath("//a[text()='Register']")).click();
        //xpath with contains()
        driver.findElement(By.xpath("//input[contains(@name, 'FirstName')]")).sendKeys("firstName");
        //xpath with starts-with()
        driver.findElement(By.xpath("//input[starts-with(@name, 'LastName')]")).sendKeys("LastName");
        //chained xpath
        driver.findElement(By.xpath("//div[@class='header-logo']/a/img")).click();
        driver.close();
    }
}
