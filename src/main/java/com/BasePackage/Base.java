package com.BasePackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {
    public WebDriver driver;
public Properties prop;
    //initialize and invoking the driver obj
    public WebDriver initializeDriver() throws IOException {
         prop=new Properties();
        FileInputStream fis=new FileInputStream("/Users/vanithamanip/Desktop/IntellijiWorkspace/SeleniumE2E/src/main/java/com/BasePackage/data.properties");
        prop.load(fis);
        String browserName=prop.getProperty("browser");
        System.out.println(browserName);
        if(browserName.equalsIgnoreCase("chrome"))
        {
            //Chrome browser initialization will present here
            WebDriverManager.chromedriver().setup();
             driver=new ChromeDriver();
        }
       else if(browserName.equalsIgnoreCase("firefox"))
        {
            //firefox browser initialization will present here
            WebDriverManager.firefoxdriver().setup();
             driver=new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("edge"))
        {
           //IE browser initialization will present here
            WebDriverManager.edgedriver().setup();
             driver=new EdgeDriver();

        }
        return driver;
    }
    public void screenshots(String method,WebDriver driver) throws IOException {
        TakesScreenshot ts= (TakesScreenshot)driver;
       File source= ts.getScreenshotAs(OutputType.FILE);
       String destination = System.getProperty("user.dir")+"/reports/"+method+".png";
        FileUtils.copyFile(source,new File(destination));

    }

}
