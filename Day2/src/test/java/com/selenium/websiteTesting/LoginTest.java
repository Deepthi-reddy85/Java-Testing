package com.selenium.websiteTesting;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void validLoginTest() {

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("inventory"));

        assertTrue(driver.getCurrentUrl().contains("inventory"));

        
    }
    //Test Cases 2
    public void emptyFieldTest() {
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://www.saucedemo.com/");
    	driver.findElement(By.id("user-name")).sendKeys("username1");
    	driver.findElement(By.id("password")).sendKeys("1234567890");
    	driver.findElement(By.id("login-button")).click();
    	
    }
}
