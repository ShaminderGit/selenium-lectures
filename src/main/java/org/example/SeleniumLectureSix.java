package org.example;

/*
Autosuggestive dropdowns:
A dropdown that suggests options dynamically as you type into an input field (e.g., Google search suggestions).
Contrast with static dropdowns:
Static = <select>/<option> tags, handled by Select class. Autosuggestive = dynamic list, handled with waits, loops, or action
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumLectureSix {
    public static void main(String[] args) throws InterruptedException {
        // Define input text and the option we want to select from the autosuggestive dropdown
        String textToEnterInTheField = "can";
        String textThatWeWantToFind = "Canada";
        // Define the practice site URL
        String url="https://rahulshettyacademy.com/dropdownsPractise/";
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // Maximize browser window and navigate to the practice site
        driver.manage().window().maximize();
        driver.get(url);
        // Pause briefly to allow page to load
        Thread.sleep(2000);
        // Locate the autosuggestive dropdown input field and type partial text
        WebElement autosuggestdropdown = driver.findElement(By.id("autosuggest"));
        autosuggestdropdown.sendKeys(textToEnterInTheField);
        // Pause to allow suggestions to appear
        Thread.sleep(2000);
        // Capture all suggestion elements from the dropdown list
        List<WebElement> autosuggestdropdowntwo = driver.findElements(By.xpath("//li[@class='ui-menu-item']//a"));
        // Iterate through suggestions and click the one that matches our desired text
         for (WebElement element : autosuggestdropdowntwo) {
           if(element.getText().equals(textThatWeWantToFind)){
               System.out.println(element.getText());
               element.click();
               break;
           }

       }
        // Close the browser
        driver.close();



    }
}
