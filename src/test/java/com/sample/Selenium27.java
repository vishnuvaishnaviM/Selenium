package com.sample;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//data driven testing - reading and writing in excel file
public class Selenium27 {
    public static void main(String[] args) throws IOException {
        //excel file - workbook - sheets - rows - cell

        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\Selenium\\demo\\test_data\\data1.xlsx");
        //reading excel file
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int totalRows = sheet.getLastRowNum();
        int totcells = sheet.getRow(0).getLastCellNum();
        System.out.println("total no of rows = "+totalRows);
        System.out.println("total no of cells in each row - " + totcells);
        for(int i=0;i<totalRows;i++){
            XSSFRow row = sheet.getRow(i);
            for(int j=0;j<totcells;j++){
                XSSFCell currCell = row.getCell(j);
                System.out.print(currCell + "   ");
            }
            System.out.println();
        }
        workbook.close();
        file.close();
    }
}
