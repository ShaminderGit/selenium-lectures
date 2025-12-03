package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLectureOne {
    public static void main(String[] args) {
        /*This session covers the basics of starting
        a browser with Selenium WebDriver
        and opening a webpage.
         */

        // Step 1: Setup ChromeDriver using Bonigarcia WebDriverManager
        // This automatically downloads and configures the correct driver version
        WebDriverManager.chromedriver().setup();
        // Step 2: Create a new Chrome browser instance
        WebDriver driver = new ChromeDriver();
        // Step 3: Maximize the browser window for better visibility
        driver.manage().window().maximize();
        // Step 4: Navigate to Google homepage
        driver.get("https://www.google.com");
        // Step 5: Fetch the current URL,titleOfThePage and pageSource of the loaded page
        String currentUrl = driver.getCurrentUrl();
        String titleOfThePage = driver.getTitle();
        String pageSource = driver.getPageSource();
        // Step 6: Print the details in the console
        System.out.println("CurrentUrl Is "+currentUrl);
        System.out.println("Title Of the Page Is "+titleOfThePage);
        System.out.println("Page Source Is " + pageSource);
        // Step 7: Close the browser window
        driver.close();
     /*
           // Interview Question 1: Why do we use WebDriverManager instead of System.setProperty?
           // Interview Question 2: What happens internally when we write WebDriver driver = new ChromeDriver()?
           // Interview Question 3: What is the difference between driver.close() and driver.quit()?
           // Interview Question 4: What does driver.get("https://www.google.com") do internally?
        */


    }
}
