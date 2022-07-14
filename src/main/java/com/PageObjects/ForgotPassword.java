package com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {
    public WebDriver driver;
    public ForgotPassword(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }
//    private By forgotPassword= By.id("user_email");
    @FindBy(id="user_email")
   WebElement forgotPassword;
    private By resetButton=By.name("commit");
    public WebElement getEmail2Reset()
    {
        return forgotPassword;
    }
    public WebElement getRestButton()
    {
        return driver.findElement(resetButton);
    }
}
