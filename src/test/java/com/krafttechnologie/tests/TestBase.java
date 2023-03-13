package com.krafttechnologie.tests;

import com.github.javafaker.Faker;
import com.krafttechnologie.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected Faker faker;


    @BeforeMethod
    public void setUp(){
        driver= Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver, 7);
        actions=new Actions(driver);
        faker=new Faker();
    }
    @AfterMethod
    public void tearDown(){
       // Driver.closeDriver();

    }
}
