package com.seleniumtask4.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppTest {

    private String url = "https://192.168.100.26/";
    private String username = "AnastasiaShumskaya";
    private String password = "1qaz!QAZ";
    private String linkText = "Shumskaya, Anastasia";


    @Test
    public void webdriverTest1() {

        WebDriver driver = new FirefoxDriver();
        WebElement element;

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to(url);


        //Login page:
        //a)	Username input
        driver.findElement(By.cssSelector("#Username"));
        driver.findElement(By.xpath("//input[@id='Username']"));
        //b)	Password input
        driver.findElement(By.cssSelector("#Password"));
        driver.findElement(By.xpath("//input[@id='Password']"));
        //c)	Remember me label
        driver.findElement(By.cssSelector("div[class='editor-chbox'] > span"));
        driver.findElement(By.xpath("//div[@class='editor-chbox']/span"));
        //d)	Remember me input
        driver.findElement(By.cssSelector("#Remember"));
        driver.findElement(By.xpath("//input[@id='Remember']"));
        //e)	Login button
        driver.findElement(By.cssSelector("#SubmitButton"));
        driver.findElement(By.xpath("//button[@id='SubmitButton']"));

        element = driver.findElement(By.id("Username"));
        element.sendKeys(username);

        element = driver.findElement(By.id("Password"));
        element.sendKeys(password);

        element = driver.findElement(By.id("SubmitButton"));
        element.click();


        //Home page:
        //f)	Sign out link
        element = driver.findElement(By.cssSelector("a[title='Sign out'] > ins"));
        element = driver.findElement(By.xpath("//a[@title='Sign out']/ins"));

        //g)	Selector, which grabs all links to offices (see screenshot 1)
        List<WebElement> links = driver.findElements(By.cssSelector("li[class='widgetSelectableRow']"));
        links = driver.findElements(By.xpath("//li[@class='widgetSelectableRow']"));

        //h)	Link to Chapaeva 118 office
        element = driver.findElement(By.cssSelector("a[href='#Office-Chapaeva 118']"));
        element = driver.findElement(By.xpath("//a[@href='#Office-Chapaeva 118']"));

        //i)	Link to Lunch Voting
        element = driver.findElement(By.cssSelector("div[class='resource-link-container lunchvoting']"));
        element = driver.findElement(By.xpath("//div[@class='resource-link-container lunchvoting']"));


        //Vacation page -> Create Vacation tab:
        element = driver.findElement(By.id("vacationMenu"));
        element.click();
        //j)	Information span for Notification To
        element = driver.findElement(By.cssSelector("div[id='thirdContainer']>span"));
        element = driver.findElement(By.xpath("//div[@id='thirdContainer']/span"));
        //k)	Information span for Notification CC
        element = driver.findElement(By.cssSelector("div[id='fourthContainer']>span"));
        element = driver.findElement(By.xpath("//div[@id='fourthContainer']/span"));


        //Company page:
        element = driver.findElement(By.id("companyMenu"));
        element.click();
        //l)	Selector, which grabs all containers for companies (see screenshot 2)
        links = driver.findElements(By.cssSelector("ul#list-items > li"));
        links = driver.findElements(By.xpath("//ul[@id='list-items']/li"));
        //m)	Selector for Contact tab, which will be suited for all companies (see screenshot 3 and 4)
        element = driver.findElement(By.cssSelector("a[class*='tab-link-contact']"));
        element = driver.findElement(By.xpath("//span[contains(text(), 'Contact')]"));


        //1. By.id
        driver.findElement(By.id("homeMenu")).click();
        element = driver.findElement(By.id("widgetName"));
        Assert.assertTrue(element.isDisplayed(), "Element is not found by id");

        //2. By.name
        element = driver.findElement(By.name("SearchQuery"));
        Assert.assertTrue(element.isDisplayed(), "Element is not found by name");

        //3. By.className
        element = driver.findElement(By.className("ellipsis-full-container-hidden"));
        Assert.assertTrue(element.isDisplayed(), "Element is not found by className");

        //4. By TagName
        element = driver.findElement(By.tagName("ul"));
        Assert.assertTrue(element.isDisplayed(), "Element is not found by tagName");

        //5. By LinkText
        element = driver.findElement(By.linkText(linkText));
        Assert.assertTrue(element.isDisplayed(),"Element is not found by linkText");

        //6. By PartialLinkText
        element = driver.findElement(By.partialLinkText("Template"));
        Assert.assertTrue(element.isDisplayed(),"Element is not found by partialLinkText");

        //7. By cssSelector
        element = driver.findElement(By.cssSelector("button[title='Global search']"));
        Assert.assertTrue(element.isDisplayed(),"Element is not found by cssSelector");

        //8. By XPath
        element = driver.findElement(By.xpath("//div[@class='top-center-menu']"));
        Assert.assertTrue(element.isDisplayed(),"Element is not found by XPath");

        driver.close();
    }
}
