package com.sample;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//handling broken links
public class Selenium25 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://www.deadlinkcity.com/");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("total number of links - "+ links.size());

        for(WebElement link: links){
            String href = link.getAttribute("href");
            if(href==null || href.isEmpty()){
                System.out.println("link is null or not valid");
                continue;
            }
            //hit the url to the server
            try{
                URL linkURL = new URL(href); //converting href value from string type to URL type
                HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection();//open connection to the server
                conn.connect();//connect to the server and send request to the server
                if(conn.getResponseCode()>=400){
                    System.out.println(href + " - link is broken");
                }else{
                    System.out.println(href + " - link is not broken");
                }

            }
            catch(Exception e){
                
            }
        }
    }
}
