package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SeleniumLectureFour {

    public static void main(String[] args) throws InterruptedException {
        // Lecture 4: Basic Selenium Automation with Locators
        String name = "Sam";
        // Setup ChromeDriver automatically using WebDriverManager
        WebDriverManager.chromedriver().setup();
        // Launch a new Chrome browser instance
        WebDriver driver = new ChromeDriver();
        // Maximize the browser window for better visibility
        driver.manage().window().maximize();
        // Navigate to the practice login page
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        // Locate the elements using different locators
        WebElement userName = driver.findElement(By.id("inputUsername"));
        WebElement password = driver.findElement(By.name("inputPassword"));
        WebElement rememberUserNameCheckBox = driver.findElement(By.name("chkboxOne"));
        WebElement rememberAgreeToTermsCheckBox = driver.findElement(By.name("chkboxTwo"));
        WebElement signInButton = driver.findElement(By.className("signInBtn"));
        WebElement visitUsButton = driver.findElement(By.id("visitUsTwo"));
        // Enter text into the fields
        userName.sendKeys(name);
        password.sendKeys("rahulshettyacademy");
        //click on the checkboxes
        rememberUserNameCheckBox.click();
        rememberAgreeToTermsCheckBox.click();
        // Click on the Sign In button
        signInButton.click();
        Thread.sleep(2000);
        //Finding element by Tag Name
        WebElement sucessMessage = driver.findElement(By.tagName("p"));
        WebElement logOutButton = driver.findElement(By.className("logout-btn"));
        WebElement userNameMessage = driver.findElement(By.tagName("h2"));
        // Capture text for assertions
        String userNameMessageText = userNameMessage.getText();
        System.out.println("User Name : " + userNameMessageText);
        System.out.println(sucessMessage.getText());
        // Assertions: validate login success and greeting message
        Assert.assertEquals(sucessMessage.getText(), "You are successfully logged in.");
        Assert.assertEquals(userNameMessageText, "Hello "+name+",");
        logOutButton.click();
        driver.close();
    }
}

