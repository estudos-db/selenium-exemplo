package utils;

import java.io.IOException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest extends DriverManager {

    private static final FileReader filesOperation = new FileReader();

    public static WebDriver getDriver(){
        return DriverManager.getDriver();
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
