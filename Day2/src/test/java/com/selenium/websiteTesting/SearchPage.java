package com.selenium.websiteTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    By searchBar = By.id("searchBar");
    By firstBook = By.cssSelector(".ui.card");

    public void searchBook(String bookName) {
        driver.findElement(searchBar).sendKeys(bookName);
    }

    public void addFirstBookToCart() {
        driver.findElement(firstBook).click();
    }
}
