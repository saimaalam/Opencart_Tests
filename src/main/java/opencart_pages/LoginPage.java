package opencart_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LoginTestDataGenerator;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private By emailField= By.id("input-email");
    private By passwordField= By.id("input-password");
    private By loginButton= By.xpath("//button[@type='submit']");
    WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(60));

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmailField(String email) {
       driver.findElement(emailField).sendKeys(email);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public MyAccoutPage clickLoginButton(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(loginButton)));
        Actions action= new Actions(driver);
        action.moveToElement(driver.findElement(loginButton)).click().perform();
        return new MyAccoutPage(driver);

    }
}
