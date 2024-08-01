package com.sample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//java script executor, scrolling page, handling zoom using javascriptexecutor
public class Selenium19 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        //sending input to a text box using javascript executor - alternate of sendkeys method
        WebElement inputbox = driver.findElement(By.xpath("//input[@id='name']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;  //here we cannot directly assign driver to the JS since as per the hierarchy 
        //both the interfaces are not directly connected. so casting is required. also since driver interface is assigned to chromedriver 
        //class which is a child class for both the interfaces we are assigning child to the parent and it is an upcasting.

        //if driver is created to the chromedriver then the driver can be directly assigned to js without typecasting.
        // ChromeDriver driver = new ChromeDriver();
        // JavascriptExecutor js = driver;

        js.executeScript("arguments[0].setAttribute('value', 'John')", inputbox);

        //clicking on radio button - alternate for click()
        WebElement btn = driver.findElement(By.xpath("//input[@id='male']"));
        js.executeScript("arguments[0].click()", btn);

        //page scrolling
        //scrolling as per the given pixel number
        js.executeScript("window.scrollBy(0,1000)", ""); //since scrollbar is handled by the browser and not application it is not a webelement to pass as argument and argument is empty
        System.out.println(js.executeScript("return window.pageYOffset;")); //this will return the position of the Y to check if it scrolled as per the given pixel


        //scroll till the element is visible
        WebElement ele = driver.findElement(By.xpath("//h2[normalize-space()='Tabs']"));
        js.executeScript("arguments[0].scrollIntoView()", ele);
        System.out.println(js.executeScript("return window.pageYOffset;")); //this will return the position of the Y to check if it scrolled as per the given pixel

        //scroll till end of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", ""); //since scrollbar is handled by the browser and not application it is not a webelement to pass as argument and argument is empty
        System.out.println(js.executeScript("return window.pageYOffset;")); //this will return the position of the Y to check if it scrolled as per the given pixel

        //scroll till start of the page
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)", ""); //since scrollbar is handled by the browser and not application it is not a webelement to pass as argument and argument is empty
        System.out.println(js.executeScript("return window.pageYOffset;")); //this will return the position of the Y to check if it scrolled as per the given pixel


        //similarly to get the posision of xaxix we need to give pageXOffset
        //and to move to the extreme end of left and right - scrollWidth

        //minimize, maximize, zoom handling
        driver.manage().window().minimize();
        Thread.sleep(3000);// to see the minimize effect
        
        driver.manage().window().maximize();
        js.executeScript("document.body.style.zoom = '50%'");
        driver.quit();
    }
}
