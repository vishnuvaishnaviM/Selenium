package com.sample;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium8 {
    public static void main(String[] args) throws MalformedURLException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //another approach to get the url - here the URL is passed in string format
        // driver.navigate().to("https://demo.nopcommerce.com/");

        //using navigate().to() method to get the URL where the URL is passed in URL object format
        URL myurl = new URL("https://demo.nopcommerce.com/");
        driver.navigate().to(myurl);

        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //navigate().back() method
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());

        //navigate().forward() method
        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());

        //navigate().refresh() method
        driver.navigate().refresh();

        //usage of getWindowHandle and getWindowHandles
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();
        Set<String> urlDetails = driver.getWindowHandles();

        //to access the ids stored in this list we cannot use the index , since index is not supported in Set collection. 
        //so first convert set to List and store the IDs
        List<String> UrlList = new ArrayList<>(urlDetails);

        //switching between windows - approach1 (when there are only two to three urls to switch)
        String parentId = UrlList.get(0);
        String childId = UrlList.get(1);
        System.out.println(driver.getTitle());
        //switch to window based on ID
        driver.switchTo().window(childId);
        System.out.println(driver.getCurrentUrl());
        //switch to parent window
        driver.switchTo().window(parentId);


        //approach 2 - using loop when there are more than 4 to 5 urls
        for(String window: UrlList){
            String title = driver.switchTo().window(window).getTitle();
            System.out.println("--------titles----------");
            System.out.println(driver.getTitle());
            if(title.equals("OrangeHRM")){
                //to close a specific browser window - here it closes the window that matches with the given title
                driver.close();
            }
        }
        driver.quit();
    }
    
}
