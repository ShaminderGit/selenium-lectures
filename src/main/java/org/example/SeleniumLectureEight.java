package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SeleniumLectureEight {

    public static void main(String[] args) {
        // Define the URL of the practice page
        String url = "https://rahulshettyacademy.com/AutomationPractice/";
        // Define the expected title of the page
        String title = "Practice Page";
        // Setup ChromeDriver using WebDriverManager (no need to manually download driver)
        WebDriverManager.chromedriver().setup();
        // Launch a new Chrome browser instance
        WebDriver driver=new ChromeDriver();
        // Maximize the browser window
        driver.manage().window().maximize();
        // Open the given UR
        driver.get(url);
        // Get the title of the current page
        String titleOfThePage = driver.getTitle();
        // Print the title to the console
        System.out.println(titleOfThePage);
        // Assertion
        Assert.assertEquals(title,titleOfThePage);
        // Locate the elements
        WebElement enterYourName = driver.findElement(By.cssSelector("#name"));
        WebElement alertButton   = driver.findElement(By.id("alertbtn"));
        WebElement confirmButton = driver.findElement(By.id("confirmbtn"));
        enterYourName.sendKeys("John Dow");
        // Click the "Alert" button to trigger a simple alert popup
        alertButton.click();
        // Switch Selenium’s focus to the alert popup
        Alert alert = driver.switchTo().alert();
        String textOfAlert = alert.getText();
        System.out.println(textOfAlert);
        // Accept the alert (click OK)
        alert.accept();
        // Important: You need to switch to the alert again
        enterYourName.sendKeys("John Dow Again");
        confirmButton.click();
        alert = driver.switchTo().alert();
        String textOfAlertTwo = alert.getText();
        System.out.println(textOfAlertTwo);
        // Dismiss the confirmation alert (click Cancel)
        alert.dismiss();
        driver.close();


    }
}
