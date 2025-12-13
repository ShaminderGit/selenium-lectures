package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SeleniumLectureNine {

    public static void main(String[] args) {
        // We will do an E2E test of an ecommerce website and implement waits.
        // Step 1: Create a shopping list of items to add to cart
        List<String> itemsForCart = new ArrayList<>();
       itemsForCart.add("Brocolli");
       itemsForCart.add("Carrot");
       itemsForCart.add("Capsicum");
       System.out.println("Item in the cart are");
       for (String item : itemsForCart) {
           System.out.println(item);
       }
        // Step 2: Define test data
       String url = "https://rahulshettyacademy.com/seleniumPractise/#/" ;
       String coupon = "rahulshettyacademy";
       String expectedPromoMessage = "Code applied ..!";

        // Step 3: Setup WebDriver (using WebDriverManager for Chrome)
       WebDriverManager.chromedriver().setup() ;
       WebDriver driver = new ChromeDriver();
       driver.get(url);

       // Step 4: Launch the website and maximize window
       driver.manage().window().maximize();
       // Step 5: Apply implicit wait (global wait for elements)
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
       // Step 6: Locate product names and their corresponding "Add to Cart" buttons
       List<WebElement> addToCartButton = driver.findElements(By.cssSelector(".product-action"));
       List<WebElement> productName = driver.findElements(By.cssSelector(".product-name"));
       //Step 7: Loop through product list and add matching items to cart
        for(int j= 0 ; j<itemsForCart.size();j++){
               for(int i= 0 ; i< productName.size();i++){
               if(productName.get(i).getText().contains(itemsForCart.get(j))){
                   addToCartButton.get(i).click();
               }
           }
       }
        // Step 8: Open cart and proceed to checkout
       WebElement cartCountButton = driver.findElement(By.cssSelector(".cart-icon"));
       WebElement proceedToCheckOutButton = driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']"));
       cartCountButton.click();
       proceedToCheckOutButton.click();
       // Step 9: Apply promo code
       WebElement promoCodeTextBox = driver.findElement(By.cssSelector(".promoCode"));
       WebElement promoApplyButton = driver.findElement(By.cssSelector(".promoBtn"));
       promoCodeTextBox.sendKeys(coupon);
       promoApplyButton.click();
       // Step 10: Explicit wait for promo message to appear
       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
       WebElement promoMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Code applied ..!']")));
       // Step 11: Validate promo message
       String promoMessageFromWebsite = promoMessage.getText();
       Assert.assertTrue(promoMessageFromWebsite.equals(expectedPromoMessage));
       WebElement placeOrder = driver.findElement(By.xpath("//button[text()='Place Order']"));
       // Step 12: Place order
       placeOrder.click();
       WebElement countryDropdown = driver.findElement(By.tagName("select"));
       // Step 13: Select country from dropdown
       Select country = new Select(countryDropdown);
       country.selectByVisibleText("China");
       // Step 14: Agree to terms and proceed
       WebElement agreeCheckbox = driver.findElement(By.cssSelector("input.chkAgree"));
       WebElement proceedButton = driver.findElement(By.xpath("//button[text()='Proceed']"));
       agreeCheckbox.click();
       proceedButton.click();
       // Step 15: Close browser
        driver.close();






















    }
}
