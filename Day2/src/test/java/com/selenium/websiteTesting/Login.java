package com.selenium.websiteTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {

    WebDriver driver;
    WebDriverWait wait;

    public Login(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By loginLink = By.id("login");
    By username = By.id("username");
    By password = By.id("password");
    By loginButton = By.id("loginButton");

    public void doLogin(String user, String pass) {

        // Click Login button
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();

        // WAIT for login popup fields
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));

        // Enter credentials
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);

        // Click Login
        driver.findElement(loginButton).click();
    }
}
