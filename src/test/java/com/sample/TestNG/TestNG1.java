package com.sample.TestNG;

//Annotations
import org.testng.annotations.*;


public class TestNG1 {
    @BeforeMethod
    public void login(){
        System.out.println("logged in");
    }
    @AfterMethod
    public void logout(){
        System.out.println("logged out");
    }
    @Test
    public void firstsearch(){
        System.out.println("first search");
    }
    @Test
    public void secondSearch(){
        System.out.println("second search");
    }
    @BeforeClass
    public void BC(){
        System.out.println("before class------");
    }
    @AfterClass
    public void AC(){
        System.out.println("after class------");
    }
    @BeforeTest
    public void BT(){
        System.out.println("before test------");
    }
    @AfterTest
    public void AT(){
        System.out.println("After test------");
    }
    @BeforeSuite
    public void BS(){
        System.out.println("before suite------");
    }
    @AfterSuite
    public void AS(){
        System.out.println("After suite------");
    }
}
