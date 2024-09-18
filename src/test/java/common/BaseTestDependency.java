package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTestDependency {
    public WebDriver driver;

    @BeforeClass
    public void createBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }


    public void createBrowser(String browsername) {

        if (browsername.equals("chrome")) {
            driver = new ChromeDriver();
        }
        if (browsername.equals("edge")) {
            driver = new EdgeDriver();
        }
        if (browsername.equals("FireFox")) {
            driver = new FirefoxDriver();
        }
        //2 Ham cho doi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        // 2 ham maximine cua so trinh duyet
        driver.manage().window().maximize();
    }

    @AfterClass
    public void endBrowser() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }


    public void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
