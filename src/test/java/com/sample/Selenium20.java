package com.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//uploading single and multiple files
public class Selenium20 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
        //upload single file
        WebElement button = driver.findElement(By.xpath("//input[@id='filesToUpload']")); 
        button.sendKeys("E:\\apply\\new.docx");
        if(driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("new.docx")){
            System.out.println("file uploaded successfully");
        }else{
            System.out.println("file upload failed");
        }

        //upload multiple files
        String file1 = "E:\\apply\\new.docx";
        String file2 = "E:\\apply\\new 7.txt";
        button.sendKeys(file1 +"\n"+file2);
        int nooffiles = driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
        if(nooffiles==3){
            System.out.println("multiple files uploaded successfully");

        }else{
            System.out.println("upload failed");
        }
        driver.quit();
    }
    
}
