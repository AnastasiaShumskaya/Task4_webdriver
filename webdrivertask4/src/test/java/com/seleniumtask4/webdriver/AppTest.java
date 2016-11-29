package com.seleniumtask4.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class AppTest {

    private WebDriver driver = new FirefoxDriver();

    private String url = "https://192.168.100.26/";
    private String username = "AnastasiaShumskaya";
    private String password = "1";

    @BeforeMethod
    public void setUp() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to(url);
    }

    @AfterMethod
    public void tearsDown() {

        driver.close();
    }

    @Test
    public void loginTest1() {

        driver.findElement(By.id("Username")).sendKeys(username);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("SubmitButton")).click();
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("home"));
    }
}
