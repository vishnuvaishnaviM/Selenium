package com.sample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//creating utility class for excel functions
public class Selenium29 {   
    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static CellStyle style;

    //return total no of rows in the sheet
    public static int getRowCount(String xlfile, String xlsheet) throws IOException
    {
        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        int rowCount = ws.getLastRowNum();
        wb.close();
        fi.close();
        return rowCount;
    }
    //return number of cells in each row
    public static int getCellCount(String xlfile, String xlsheet, int rowCount) throws IOException
    {
        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(rowCount);
        int cellCount = row.getLastCellNum();
        wb.close();
        fi.close();
        return cellCount;
    }

    public static String getCellData(String xlfile, String xlsheet, int rowCount, int colNum) throws IOException
    {
        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(rowCount);
        cell = row.getCell(colNum);
        String data;
        try{
            // data = cell.toString();
            //another approach of above line
            DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell); //returns the formatted value of a cell

        }

    }

    
}
