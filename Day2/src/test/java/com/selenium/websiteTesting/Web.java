package com.selenium.websiteTesting;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web {

    @Test
    void validLoginTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://travel.agileway.net/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("agileway", "testwise");

        assertTrue(driver.getCurrentUrl().contains("welcome"));

        driver.quit();
    }
}
