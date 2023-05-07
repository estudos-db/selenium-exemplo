package utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public abstract class BaseTest extends DriverManager {
    private static WebDriver driver;
    private static FileReader filesOperation = new FileReader();

    public static WebDriver getDriver(){
        driver = DriverManager.getDriver();
        return driver;
    }

    @BeforeEach
    public void setUp() throws IOException {
        String URL = filesOperation.getProperties("config").getProperty("url");
        getDriver().get(URL);
    }

    @AfterEach
    public void finish(){
        quitDriver();
    }
}
