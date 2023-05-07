package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
//             options.addArguments("--window-size=1440,768");
            options.addArguments("--incognito");
//             options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }

        return driver;
    }
    public static void quitDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
