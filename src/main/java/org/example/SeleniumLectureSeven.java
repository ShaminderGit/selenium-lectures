package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

/*

This program demonstrates how to locate and validate checkboxes using Selenium WebDriver.
It navigates to the practice site, finds all checkboxes with XPath,
prints their selection status to the console, and uses assertions to confirm
 that each checkbox is initially not selected. Finally, it closes the browser.
 */

public class SeleniumLectureSeven   {
    public static void main(String[] args) throws InterruptedException {
        // Define the practice site URL
        String url="https://rahulshettyacademy.com/dropdownsPractise/";
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // Maximize browser window and navigate to the practice site
        driver.manage().window().maximize();
        driver.get(url);
        // Pause briefly to allow page elements to load
        Thread.sleep(2000);
        // Locate all checkbox elements on the page using XPath
        List<WebElement> checkboxs = driver.findElements(By.xpath("//input[@type='checkbox']"));
        // Iterate through each checkbox
        for (WebElement checkbox : checkboxs) {
            // Check the current selection status (true if selected, false if not)
            boolean checkboxStatus = checkbox.isSelected();
            // Print the status to the console
            System.out.println(checkboxStatus);
            // Assert that each checkbox is initially not selected
            Assert.assertFalse(checkboxStatus);
        }
        // Close the browser after test execution
        driver.close();

    }
}
