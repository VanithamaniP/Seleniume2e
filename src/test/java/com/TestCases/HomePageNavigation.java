package com.TestCases;

import com.BasePackage.Base;
import com.PageObjects.HomePage;
import com.PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageNavigation extends Base {
    LoginPage lp;
    public WebDriver driver;
    @BeforeTest
    public void beforeTest() throws IOException
    {
        driver=initializeDriver();
        driver.get(prop.getProperty("url"));

    }
    @Test(dataProvider = "getLoginData")
    public void homePage(String email,String password) {


        HomePage hp=new HomePage(driver);
        LoginPage lp= hp.getLoginLink();  //Login Link get clicked
        lp.getEmail().sendKeys(email);
        lp.getPassword().sendKeys(password);
        lp.getLoginButton().click();
    }

    @DataProvider
    public Object[][] getLoginData()
    {
        Object[][] data=new Object[1][2];
        //Row --> no.of iteration and Columns --> How many values for each iteration
        //1st Iteration
        data[0][0]="test1@gmail.com";
        data[0][1]="test1";

        //2nd Iteration
//        data[1][0]="test2@gmail.com";
//        data[1][1]="test2";
        return data;
    }
    @AfterTest
    public void tearDown()
    {
        driver.close();
    }
}
