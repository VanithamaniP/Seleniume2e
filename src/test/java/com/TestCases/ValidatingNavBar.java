package com.TestCases;

import com.BasePackage.Base;
import com.PageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class ValidatingNavBar extends Base {
    public WebDriver driver;
    @BeforeTest
    public void beforeTest() throws IOException
    {
        driver=initializeDriver();
        driver.get(prop.getProperty("url"));

    }
    @Test
    public void validatingNavBar() throws IOException {
        driver=initializeDriver();
        driver.get(prop.getProperty("url"));
        HomePage hp=new HomePage(driver);
        Assert.assertTrue(hp.getNavBar().isDisplayed());
    }
    @AfterTest
    public void tearDown()
    {
        driver.close();
    }
}
