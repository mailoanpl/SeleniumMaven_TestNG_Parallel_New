package common;

import Drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class BaseTest {

    @BeforeMethod
    @Parameters({"browser"})
    public void createBrowser(String browsername) {
        WebDriver driver = setBrowser(browsername);
        DriverManager.setDriver(driver); // gan gia tri driver vao trong TheadLocal

    }


    public WebDriver setBrowser(String browsername) {
        WebDriver driver = null;


        if (browsername.trim().toLowerCase().equals("chrome")) {
            driver = new ChromeDriver();
        }
        if (browsername.trim().toLowerCase().equals("edge")) {
            driver = new EdgeDriver();
        }
        if (browsername.trim().toLowerCase().equals("firefox")) {
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().maximize();

        return driver;
    }

    @AfterMethod
    public void endBrowser() {
        DriverManager.quit();
    }


}
