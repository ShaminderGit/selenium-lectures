package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLectureThree {
    /*
     * Lecture 3: Understanding and Demonstrating Different Locator Strategies in Selenium
     *
     * In this lecture, we explore how to identify and interact with web elements
     * using multiple locator techniques:
     *
     * 1. linkText → Locates hyperlinks by their visible text.
     * 2. XPath (attribute-based) → Targets elements using specific attributes.
     * 3. CSS Selector (attribute-based) → Provides a shorter, faster alternative to XPath.
     * 4. XPath (index-based) → Selects elements when multiple nodes share the same attributes.
     * 5. XPath (parent-child traversal) → Navigates through the DOM hierarchy to reach elements.
     * 6. CSS Selector (traversal) → Locates nested elements by traversing parent-child relationships.
     */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        WebElement forgotYourPasswordLink = driver.findElement(By.linkText("Forgot your password?"));
        forgotYourPasswordLink.click();
        // Locate input fields using different locator strategies:
        //by using xpath
         WebElement inputNameField = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        //by using css selector
        WebElement inputEmailField = driver.findElement(By.cssSelector("input[placeholder='Email']"));
        //by using xpath with multiple tags
        WebElement inputPhoneNumber = driver.findElement(By.xpath("//input[@type='text'][3]"));
        //by xpath using travelling
        WebElement inputPhoneNumberTwo = driver.findElement(By.xpath("//form/input[3]"));
        //by using xpath
        WebElement resetLoginButton = driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[2]"));
        // Perform actions on located elements
        inputNameField.sendKeys("John Dow");
        inputEmailField.sendKeys("JohnDow@gmail.com");
        inputPhoneNumber.sendKeys("+91123456789");
        inputPhoneNumber.clear();
        inputPhoneNumberTwo.sendKeys("+14372111111");
        resetLoginButton.click();
        //Locate confirmation message using CSS selector (traversing form → p tag)
        WebElement textMessage = driver.findElement(By.cssSelector("form p"));
        String textMessageFromTheWebsite = textMessage.getText();
        // Print confirmation message to console
        System.out.println(textMessageFromTheWebsite);
        // Close browser
        driver.close();


    }
}
