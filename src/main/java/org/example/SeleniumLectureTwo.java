package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLectureTwo {
    public static void main(String[] args) throws InterruptedException {
        // Lecture 2: Basic Selenium Automation with Locators
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
        userName.sendKeys("admin");
        password.sendKeys("admin123");
        // Click on the Sign In button
        signInButton.click();
        // Pause execution for 2 seconds to allow error message to appear
        Thread.sleep(2000);
        // Locate the error message using a CSS Selector
        WebElement errorMessage = driver.findElement(By.cssSelector("p.error"));
        // Print the error message text to the console
        System.out.println(errorMessage.getText());
        // Close the browser window
        driver.close();

    }
}
