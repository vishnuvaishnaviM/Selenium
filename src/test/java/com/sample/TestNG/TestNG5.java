package com.sample.TestNG;
// grouping concept 
//class - 2

import org.testng.annotations.*;

public class TestNG5 {
    @Test(groups = {"regression"})
    public void signupByEmail(){
        System.out.println("signed in thorugh email");
    }
    @Test(groups = {"regression"})
    public void signupByPhone(){
        System.out.println("signed in thorugh phone");
    }
    @Test(groups = {"regression"})
    public void signupBypwd(){
        System.out.println("signed in thorugh password");
    }
}
