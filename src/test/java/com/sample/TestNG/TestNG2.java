package com.sample.TestNG;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

//assertions
public class TestNG2 {
    @Test
    public void hardAssertions(){
        //assertEquals
        Assert.assertEquals("abc","abc"); //true
        Assert.assertEquals(123, 123); //true
        // Assert.assertEquals("abc", 123); //false

        // assertNotEquals
        Assert.assertNotEquals("abc", "def"); //true

        Assert.assertTrue(true); //pass
        // Assert.assertTrue(false); //fail
        Assert.assertTrue(1==1); //pass - using expression

        //similar for assertFalse
        Assert.assertFalse(false);


    
    }

    @Test
    public void softAssert(){
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(1==4); //fail
        System.out.println("failed in soft assert method");
        sa.assertAll();
    }
}
