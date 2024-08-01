package com.sample;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//handling slider, keyboard, opening new tab, new window
public class Selenium18 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");

        // Wait for the slider to be present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement slider = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']")));

        Actions action = new Actions(driver);
        System.out.println("Default position - " + slider.getLocation());
        action.dragAndDropBy(slider, 100, 0).perform();
        System.out.println("Position of slider after dragging - " + slider.getLocation());

        //keyboard actions
        driver.get("https://text-compare.com/");
        driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("Welcome");
        //ctrl+A
        action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
        //ctrl+C
        action.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
        //tab
        action.keyDown(Keys.TAB).keyUp(Keys.TAB);
        //ctrl+v
        action.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();

        //opening link in a page in a new tab in the same window
        driver.get("https://testautomationpractice.blogspot.com/");
        WebElement win = driver.findElement(By.xpath("//button[@onclick='myFunction()']"));
        //control+link
        action.keyDown(Keys.CONTROL).click(win).keyUp(Keys.CONTROL).perform();
        //get all list of page ids
        List<String> allPages = new ArrayList<>(driver.getWindowHandles());
        System.out.println(allPages.toString());
        //navigate to the latest new link and perform an action
        driver.switchTo().window(allPages.get(1));
        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Laptop");

        //opening a link in new window
        driver.switchTo().newWindow(WindowType.WINDOW);//this will open the link in new tab and shifts the cursor to the new tab
        //similarly to do this for a new tab
        // driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.quit();
    }
}
