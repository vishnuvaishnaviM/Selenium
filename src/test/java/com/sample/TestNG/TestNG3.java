package com.sample.TestNG;

import org.testng.Assert;
import org.testng.annotations.*;
//dependencies methods
public class TestNG3 {
    @Test(priority=1)
    public void openapp(){
        Assert.assertTrue(false); //fails - due to which below dependent methods will be skipped
    }

    @Test(priority=2, dependsOnMethods={"openapp"})
    public void login(){

    }
    @Test(priority=3, dependsOnMethods={"login"})
    public void search(){

    }
    @Test(priority=4, dependsOnMethods={"login"})
    public void advSearch(){

    }
    @Test (priority=5, dependsOnMethods={"login"})
    public void logout(){

    }
    
}
