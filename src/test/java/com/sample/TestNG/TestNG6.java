package com.sample.TestNG;
// grouping concept 
//class - 3

import org.testng.annotations.*;

public class TestNG6 {
    @Test(groups = {"sanity","regression"})
    public void paymentEmail(){
        System.out.println("signed in thorugh email");
    }
    @Test(groups = {"sanity","regression"})
    public void PaymentPhone(){
        System.out.println("signed in thorugh phone");
    }
    @Test(groups = {"sanity","regression"})
    public void signupBypwd(){
        System.out.println("signed in thorugh password");
    }
}
