package com.selenium.websiteTesting;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FlightBookingTest {

    @Test
    public void bookFlightTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://travel.agileway.net/login");

        driver.findElement(By.name("username")).sendKeys("agileway");
        driver.findElement(By.name("password")).sendKeys("testwise");
        driver.findElement(By.name("commit")).click();


        Select from = new Select(driver.findElement(By.name("fromPort")));
        from.selectByVisibleText("Sydney");


        Select to = new Select(driver.findElement(By.name("toPort")));
        to.selectByVisibleText("Melbourne");


        driver.findElement(By.name("departDate")).clear();
        driver.findElement(By.name("departDate")).sendKeys("10/10/2026");

       
        driver.findElements(By.name("flightNumber")).get(0).click();

        
        driver.findElement(By.name("submit")).click();

      
        assertTrue(driver.getCurrentUrl().contains("payment"));

        driver.quit();
    }
}
