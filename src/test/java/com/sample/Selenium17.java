package com.sample;

import java.time.Duration;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//mouse actions - mouse hover, double-click ,drag and drop, right-click
public class Selenium17 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com/");

        WebElement computer = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        WebElement desktop = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Notebooks']"));

        
        Actions act = new Actions(driver);
        //mouse hover
        act.moveToElement(computer).moveToElement(desktop).click().build().perform();


        //right click 
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        WebElement right = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions action = new Actions(driver);
        action.contextClick(right).perform();
        //click on the copy buttin
        driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();
        driver.switchTo().alert().accept();

        //double click
        driver.get("https://testautomationpractice.blogspot.com/");
        WebElement doubleclick = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleclick).perform();
        String box1 = driver.findElement(By.xpath("//input[@id='field1']")).getText();
        String box2 = driver.findElement(By.xpath("//input[@id='field2']")).getText();
        if(box1.equals(box2)){
            System.out.println("double click action is performed");
        }else{
            System.out.println("double click failed");
        }

        //drag and drop
        WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dest = driver.findElement(By.xpath("//p[normalize-space()='Drop here']"));
        actions.dragAndDrop(source, dest).perform();
        driver.quit();
    }
}
