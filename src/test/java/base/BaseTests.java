package base;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import opencart_pages.Homepage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class BaseTests {
    protected Homepage homePage;
    private WebDriver driver;
    private TakesScreenshot capture;

    @BeforeClass
    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    /*switch (browserName){
        case "chrome":
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            break;
        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            break;
        case "edge":
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            break;
        case "ie":
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
            break;
        default:
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
    }*/
    }

    @BeforeMethod
    public void navigateToUrl() {
        driver.get("https://demo.opencart.com");
        homePage = new Homepage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            capture = (TakesScreenshot) driver;
            File screenshot = capture.getScreenshotAs(OutputType.FILE);
            File destination = new File("screenshots/"+ result.getName()+ ".png");
            try {
                Files.move(screenshot,destination);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    @AfterClass
    public void quitBrowser() {
        driver.quit();
    }

}
