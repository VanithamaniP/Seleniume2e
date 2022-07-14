package com.TestCases;

import com.BasePackage.Base;
import com.PageObjects.ForgotPassword;
import com.PageObjects.HomePage;
import com.PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class ResetingPassword extends Base {
    public WebDriver driver;

@BeforeTest
    public void beforeTest() throws IOException
    {
        driver=initializeDriver();
        driver.get(prop.getProperty("url"));

    }
    @Test
    public void resetingPassword() throws IOException {

        driver=initializeDriver();
        driver.get(prop.getProperty("url"));
        HomePage hp=new HomePage(driver); //As Homepage returning -> Login Page and LoginPage --> returning Forgot Password Page
        LoginPage lp=hp.getLoginLink();
       ForgotPassword fp= lp.getForgotPassword();
       fp.getEmail2Reset().sendKeys("randomText@gmail.com");
       fp.getRestButton().click();


    }
    @AfterTest
    public void tearDown()
    {
        driver.close();
    }
}
