//locators - id, Name, LinkText, PartialLinkText, Class Name, TagName
package com.sample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium2 {
    public static void main(String[] args) throws InterruptedException {
        

        //launch browser
        WebDriver driver = new ChromeDriver();
        //maximize window
        driver.manage().window().maximize();
        //open the url
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //locator- name - find element by name and give input to the text file
        Thread.sleep(1000);
        driver.findElement(By.name("username")).sendKeys("Admin");
        //locator - id - find element by id and validate if it is displayed
        boolean logostatus = driver.findElement(By.id("app")).isDisplayed();
        System.out.println(logostatus);

        //close the browser
        driver.close();

        WebDriver driver1= new ChromeDriver();
        driver1.get("https://www.opencart.com/");
        //Linktext
        driver1.findElement(By.linkText("Marketplace")).click();
        //partialLinkText
        driver1.findElement(By.partialLinkText("Market")).click();

        //className - to get the list of elements of a specific className and check the count of it
        // List<WebElement> listElements = driver1.findElements(By.className("nav navbar-nav"));
        // System.out.println(" total number of elements in the nav-bar for given className is - " +listElements.size());        

        //tagName
        List<WebElement> webElements = driver1.findElements(By.tagName("a"));
        System.out.println("count of a tag elements - " + webElements.size());
        driver.quit();
    }
    
}
