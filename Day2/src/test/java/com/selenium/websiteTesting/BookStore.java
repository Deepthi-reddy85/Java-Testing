package com.selenium.websiteTesting;

import java.time.Duration;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class BookStore {

    WebDriver driver;
    WebDriverWait wait;
    
    Login login;
    SearchPage search;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        login = new Login(driver);
        search = new SearchPage(driver);
    }

    @AfterEach
    void tearDown() throws Exception {
        System.out.println("Press Enter to close browser...");
        System.in.read();
        driver.quit();
    }

    @Test
    void loginSearchAddToCartTest() {

        // Open site
        driver.get("https://satyamart.lovable.app/");

        // LOGIN (popup)
        login.doLogin("admin", "admin123");

        // Confirm login success
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout")));

        // Search book
        search.searchBook("java");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui.card")));

        // Add to cart (simulated)
        search.addFirstBookToCart();
    }
}
