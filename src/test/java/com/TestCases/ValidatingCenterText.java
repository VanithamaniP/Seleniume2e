package com.TestCases;

import com.BasePackage.Base;
import com.PageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class ValidatingCenterText extends Base {
    public WebDriver driver;
    @BeforeTest
    public void beforeTest() throws IOException
    {
        driver=initializeDriver();
        driver.get(prop.getProperty("url"));

    }
    @Test
    public void validatingHomePage() throws IOException {
        driver=initializeDriver();
        driver.get(prop.getProperty("url"));
        HomePage hp=new HomePage(driver);
        Assert.assertEquals(hp.getCenterText().getText(),"FEATURED COURSES1");
    }
    @AfterTest
    public void tearDown()
    {
        driver.close();
    }
}
