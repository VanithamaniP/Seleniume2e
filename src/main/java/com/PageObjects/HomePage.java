package com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    private By loginButton= By.cssSelector("[href*='sign_in']");
//    private By centerText=By.cssSelector("[class='text-center'] h2");
    @FindBy(how = How.CSS,using = "[class='text-center'] h2")
    private WebElement centerText;
    private By navBar=By.cssSelector("[class='navbar-collapse collapse']");
    public LoginPage getLoginLink()
    {
         driver.findElement(loginButton).click();
         return new LoginPage(driver);


    }
    public WebElement getCenterText()
    {
        return centerText;
    }
    public WebElement getNavBar()
    {
        return driver.findElement(navBar);
    }
}
