package com.sample;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//writing to excel file
public class Selenium28 {
    public static void main(String[] args) throws IOException {
        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\Selenium\\demo\\test_data\\new.xlsx");
        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet sheet = book.createSheet("Sheet1");
        XSSFRow row1 = sheet.createRow(0);
        row1.createCell(0).setCellValue("selenium");
        row1.createCell(1).setCellValue(43);
        row1.createCell(2).setCellValue("Automation");

        XSSFRow row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("python");
        row2.createCell(1).setCellValue(213);
        row2.createCell(2).setCellValue("scripting");

        XSSFRow row3 = sheet.createRow(2); 
        row3.createCell(0).setCellValue("C#");
        row3.createCell(1).setCellValue(3);
        row3.createCell(2).setCellValue("new script");

        book.write(file);
        book.close();
        file.close();

        System.out.println("written file successfully ");
    }
}
