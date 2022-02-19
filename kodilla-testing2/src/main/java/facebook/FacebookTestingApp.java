package facebook;

import config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class FacebookTestingApp {

    public static final String XPATH_ACCEPT_COOKE = "//button[@data-cookiebanner='accept_button']";
    public static final String XPATH_CREATE_ACCOUNT = "//a[contains(@class, \"_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy\")]";

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://pl-pl.facebook.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath(XPATH_ACCEPT_COOKE)).click();
        driver.findElement(By.xpath(XPATH_CREATE_ACCOUNT)).click();

        //fill form
        System.out.println("WAIT");
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.name("firstname")).sendKeys("Grzegorz");
        Select Days =new Select(driver.findElement(By.name("birthday_day")));
        Days.selectByValue("24");
        Select Month =new Select(driver.findElement(By.name("birthday_month")));
        Month.selectByValue("4");
        Select Year =new Select(driver.findElement(By.name("birthday_year")));
        Year.selectByValue("1983");


    }
}
