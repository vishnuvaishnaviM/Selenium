package com.sample;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

//reading data from .properties file
public class Selenium31 {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\Selenium\\demo\\config.properties");
        prop.load(file);

        //reading data from .properties file
        System.out.println("url name - "+ prop.getProperty("url"));
        System.out.println("email - "+ prop.getProperty("email"));
        System.out.println("pwd - "+ prop.getProperty("password"));
        System.out.println("orderid - "+ prop.getProperty("orderid"));
        System.out.println("customer id - "+ prop.getProperty("customerid"));


        //reading keys from the properties file
        Set<String> keys = prop.stringPropertyNames();
        System.out.println(keys);

        //another approach
        Set<Object> keys1 = prop.keySet();
        System.out.println(keys1);

        //reading only values from the file without keys
        Collection<Object> values = prop.values();
        System.out.println(values);
        file.close();
    }
}
