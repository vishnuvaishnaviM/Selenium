package com.sample;

import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

// handling date pickers - 2
public class Selenium16 {

    static Month stringToMonth(String month) {
        HashMap<String, Month> monthmap = new HashMap<String, Month>();
        monthmap.put("January", Month.JANUARY);
        monthmap.put("February", Month.FEBRUARY);
        monthmap.put("March", Month.MARCH);
        monthmap.put("April", Month.APRIL);
        monthmap.put("May", Month.MAY);
        monthmap.put("June", Month.JUNE);
        monthmap.put("July", Month.JULY);
        monthmap.put("August", Month.AUGUST);
        monthmap.put("September", Month.SEPTEMBER);
        monthmap.put("October", Month.OCTOBER);
        monthmap.put("November", Month.NOVEMBER);
        monthmap.put("December", Month.DECEMBER);

        Month vmonth = monthmap.get(month);
        if (vmonth == null) {
            System.out.println("incorrect month");
        }
        return vmonth;
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.switchTo().frame("frame-one796456169");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on calendar icon
        WebElement calendarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='icon_calendar']")));
        calendarIcon.click();

        String reqYear = "2023";
        String reqMonth = "June";
        String reqDate = "24";

        // Select year
        WebElement year = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='ui-datepicker-year']")));
        scrollToElement(driver, year);
        Select selectYear = new Select(year);
        selectYear.selectByVisibleText(reqYear);

        // Select month
        while (true) {
            String actMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            Month aMonth = stringToMonth(actMonth);
            Month exMonth = stringToMonth(reqMonth);

            int res = exMonth.compareTo(aMonth);
            if (res < 0) {
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
            } else if (res > 0) {
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
            } else {
                break;
            }
        }

        // Select date
        List<WebElement> dateList = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td//a"));
        for (WebElement dt : dateList) {
            if (dt.getText().equals(reqDate)) {
                scrollToElement(driver, dt);
                dt.click();
                break;
            }
        }

        driver.quit();
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
