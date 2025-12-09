package org.example;
// Handle static dropdown using Selenium's Select class
// Static dropdowns are built with <select> and <option> tags in HTML
// Steps:
// 1. Locate the dropdown element
// 2. Create a Select object with that element
// 3. Use selectByVisibleText(), selectByValue(), or selectByIndex() to choose an option


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.support.ui.Select;

public class SeleniumLectureFive {

    public static void main(String[] args)  throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");


        // Locate dropdown element using different locator strategies

        WebElement dropdownById = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        WebElement dropdownByName = driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
        WebElement dropdownByXPath = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
        WebElement dropdownByCss = driver.findElement(By.cssSelector("#ctl00_mainContent_DropDownListCurrency"));


        // Create Select objects for each locator
        Select selectById = new Select(dropdownById);
        Select selectByName = new Select(dropdownByName);
        Select selectByXpath = new Select(dropdownByXPath);
        Select selectByCSS = new Select(dropdownByCss);

        // Select option by Value and print selected text
        selectById.selectByValue("INR");
        String selectedTextOne = selectById.getFirstSelectedOption().getText();
        System.out.println(selectedTextOne);

        // Select option by Visible Text and print selected text
        selectByName.selectByVisibleText("AED");
        String selectedTextTwo = selectByName.getFirstSelectedOption().getText();
        System.out.println(selectedTextTwo);

        // Select option by Index and print selected text
        selectByXpath.selectByIndex(3);
        String selectedTextThree = selectByXpath.getFirstSelectedOption().getText();
        System.out.println(selectedTextThree);
        driver.close();







    }
}

