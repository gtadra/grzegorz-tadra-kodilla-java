package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverConfig {
    public final static String CHROME = "CHROME_DRIVER";
    public static WebDriver getDriver(final String driver) {

        System.setProperty("webdriver.chrome.driver", "D:/DOKUMENTY/09_MATERIALY SZKOLENIA/Java/Selenium-drivers/Chrome/chromedriver_win32/chromedriver.exe");

        if (driver.equals(CHROME)) {
            return new ChromeDriver();
        } else {
            return null;
        }
    }
}