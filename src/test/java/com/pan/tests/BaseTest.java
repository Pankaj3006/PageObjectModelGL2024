package com.pan.tests;

import com.pan.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    void setUp()
    {
        Driver.initDriver();
    }

    @AfterMethod
    void tearDown()
    {
        Driver.quitDriver();
    }
}
