package com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By email = By.id("user_email");
    private By password = By.id("user_password");
    private By loginButton = By.cssSelector("[name='commit']");
    private By forgotPassword = By.cssSelector("[href*='new']");

    public WebElement getEmail() {
        return driver.findElement(email);
    }

    public WebElement getPassword() {
        return driver.findElement(password);
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }

    public ForgotPassword getForgotPassword() {
        driver.findElement(forgotPassword).click();
        return new ForgotPassword(driver);
    }
}