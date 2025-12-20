package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumLectureTen {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Let's try to understand Action Class + Window Handling");
        String url = "https://www.amazon.com/";
        // Setup Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        // Handle "Continue Shopping" button if present
        try {
            WebElement continueBtn = driver.findElement(By.cssSelector(".a-button-text"));
            if (continueBtn.isDisplayed()) {
                continueBtn.click();
            }
        } catch (NoSuchElementException ignored) {
            System.out.println("Continue shopping button not found");
        }
        //  Handle toaster popup (HTML popup, NOT JS alert)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            WebElement alert = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".a-button-inner"))
            );
            System.out.println("Alert appeared: " + alert.getText());
            alert.click();
        } catch (TimeoutException e) {
            System.out.println("Alert did not appear");
        }
       // Hover over "Account & Lists"
        WebElement dropDown = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        Actions action = new Actions(driver);
        action.moveToElement(dropDown).perform();
        // Get all items under "Your Account" flyout
        List<WebElement>   listOfItems = driver.findElements(By.xpath("//div[@id='nav-al-your-account']/ul/li/a/span"));
        System.out.println("Total items in your account list: " + listOfItems.size());
        // Open each item in a new tab (Ctrl + Click)
        for (WebElement item : listOfItems) {
            System.out.println("Item: " + item.getText());
            action.keyDown(Keys.CONTROL).click(item).keyUp(Keys.CONTROL).build().perform();
        }
        // Switch to each window, print details, and close child windows
        String parentWindow = driver.getWindowHandle();
        for(String window : driver.getWindowHandles()){
            driver.switchTo().window(window);
            String pageTitle = driver.getTitle();
            String parentHandle = driver.getWindowHandle();
            String urlOfCurrentWindow = driver.getCurrentUrl();
            System.out.println("Title: " +pageTitle);
            System.out.println("Handle: " +parentHandle);
            System.out.println("URL: "+ urlOfCurrentWindow);
            // Close only child windows
            if (!window.equals(parentWindow)) {
                driver.close();
            }
        }
        // Switch back to parent and close it
        driver.switchTo().window(parentWindow);
        driver.close();

     }
}



