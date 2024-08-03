package com.sample.TestNG;
// grouping concept 
//class - 1

import org.testng.annotations.*;

public class paymentPhone() {
    @Test
    public void loginByEmail(){
        System.out.println("payed through email");
    }
    @Test
    public void paymentWebsite(){
        System.out.println("paid through website");
    }
    @Test
    public void paymentATM(){
        System.out.println("logged in thorugh password");
    }
}
