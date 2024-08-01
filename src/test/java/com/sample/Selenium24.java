package com.sample;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v125.page.model.WebAppManifest;

//enabling extensions during run time
public class Selenium24 {
    public static void main(String[] args) {
        ChromeOptions opt = new ChromeOptions();
        File file = new File("F:\\projects\\Selenium\\demo\\SelectorsHub-XPath-Helper-Chrome-Web-Store.crx");
        opt.addExtensions(file);
        WebDriver driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://text-compare.com/");
    }
}
