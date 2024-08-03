package com.sample.TestNG;
// grouping concept 
//class - 1

import org.testng.annotations.*;

public class TestNG4 {
    @Test(groups = {"sanity"})
    public void loginByEmail(){
        System.out.println("logged in thorugh email");
    }
    @Test(groups = {"sanity"})
    public void loginByPhone(){
        System.out.println("logged in thorugh phone");
    }
    @Test(groups = {"sanity"})
    public void loginBypwd(){
        System.out.println("logged in thorugh password");
    }
}
