
/*
 * test case 1
 * launch chrome browser
 * open url - https://demo.opencart.com/
 * validate title and close browser
 */
package com.sample;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {
    public static void main(String[] args) throws InterruptedException {
        //launch browser
        // ChromeDriver driver = new ChromeDriver(); // this is one of the approach
        WebDriver driver = new ChromeDriver(); //this is preferable since it can be in future accessed to firefox , edge
        //opening url
        driver.get("https://www.opencart.com/");
        // Thread.sleep(90000);
        //get the title of the page 
        String act_title = driver.getTitle();
        if(act_title.equals("OpenCart - Open Source Shopping Cart Solution")){
            System.out.println("test case passed");
        }else{
            System.out.println("test case failed");
        }
        //close browser - 2 ways
        //driver.close(); - can close only one window at a time
        driver.quit(); // can close multiple commands at a time

    }
    
}
