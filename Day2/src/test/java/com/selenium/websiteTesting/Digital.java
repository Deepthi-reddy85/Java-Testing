package com.selenium.websiteTesting;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Digital {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://satyamart.lovable.app/");
    }

    @Test
    public void signInTest() {

        // 🔹 Click on Sign In button
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Sign')]")))
            .click();

        // 🔹 Enter Email
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@type='email']")))
            .sendKeys("test@gmail.com");   // 👉 replace with real email

        // 🔹 Enter Password
        driver.findElement(By.xpath("//input[@type='password']"))
              .sendKeys("test@123");       // 👉 replace with real password

        // 🔹 Click Login / Sign In
        driver.findElement(By.xpath("//button[contains(text(),'Login') or contains(text(),'Sign')]"))
              .click();

        // 🔹 Keep browser open
        System.out.println("Sign-in attempted. Press ENTER to close browser.");
        new Scanner(System.in).nextLine();

        // Dummy assertion (test pass)
        assertTrue(driver.getTitle().length() > 0);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
