package opencart_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Homepage {
    private WebDriver driver;

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickMyAccount(){
        driver.findElement(By.xpath("//span[normalize-space(text())='My Account']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

    }
    public RegisterAccountPage clickRegister(){
        clickMyAccount();
        driver.findElement(By.xpath("//span[normalize-space(text())='My Account']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Register"))));
        driver.findElement(By.linkText("Register")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return new RegisterAccountPage(driver);

    }
    public LoginPage clickLogin(){
        clickMyAccount();
        driver.findElement(By.xpath("//span[normalize-space(text())='My Account']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Login"))));
        driver.findElement(By.linkText("Login")).click();
         wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("form-login"))));
        return new LoginPage(driver);
    }

}
