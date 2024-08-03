package com.sample;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

//data driven testing - test case
//calcuate and validate simple interest calculation
public class Selenium30 {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
        
        String filePath = System.getProperty("user.dir") + "\\Selenium\\demo\\test_data\\simple_interest.xlsx";
        int rowCount = Selenium29.getRowCount(filePath,"Sheet1");
        System.out.println("total number of rows in the file - " + rowCount);
        
        for(int i=1; i<=rowCount; i++) {
            // read data from file
            String principal = Selenium29.getCellData(filePath, "Sheet1", i, 0);
            String ROI = Selenium29.getCellData(filePath, "Sheet1", i, 1);
            String Period1 = Selenium29.getCellData(filePath, "Sheet1", i, 2);
            String Period2 = Selenium29.getCellData(filePath, "Sheet1", i, 3);
            String freq = Selenium29.getCellData(filePath, "Sheet1", i, 4);
            String expMatureValue = Selenium29.getCellData(filePath, "Sheet1", i, 5);

            // pass data from excel to the application
            driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principal);
            driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(ROI);
            driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(Period1);
            Select pe2 = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
            pe2.selectByVisibleText(Period2);
            Select fr = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
            fr.selectByVisibleText(freq);

            // Wait for the overlay to disappear
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("wzrk-overlay")));
            
            // Click the calculate button
            WebElement calculateButton = driver.findElement(By.xpath("//div[@class='cal_div']//a[1]"));
            calculateButton.click();

            // Retrieve and validate the result
            String actMatureValue = driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();

            // validate the results
            if(Double.parseDouble(expMatureValue) == Double.parseDouble(actMatureValue)) {
                Selenium29.setCellData(filePath, "Sheet1", i, 7, "Pass");
                Selenium29.fillGreenColor(filePath, "Sheet1", i, 7);
                System.out.println("test passed");
            } else {
                Selenium29.setCellData(filePath, "Sheet1", i, 7, "Fail");
                Selenium29.fillRedColor(filePath, "Sheet1", i, 7);
                System.out.println("test failed");
            }

            // Reset for the next iteration
            driver.findElement(By.xpath("//img[@class='PL5']")).click();
        }

        // Close the browser
        driver.quit();
    }
}
