package opencart_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterAccountPage {
    private WebDriver driver;
    private By pageHeader = By.xpath("//div[@id='content']/h1");
    private By firstNameField= By.id("input-firstname");
    private By lastNameField= By.id("input-lastname");
    private By emailField= By.id("input-email");
    private By passwordField= By.id("input-password");
    private By continueButton= By.xpath("//button[@type='submit']");
    private By privacyPolicyCheckbox= By.xpath("//input[@name='agree']");

    public RegisterAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForHeader(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.presenceOfElementLocated(pageHeader));
    }
    private void scrollToElement(WebElement element){
        String script= "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script,element);

    }
    public void scrollToPrivacyPolicy(){
        WebElement element= driver.findElement(privacyPolicyCheckbox);
        Actions a = new Actions(driver);
        a.moveToElement(element).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void scrollToContinueButton(){
       WebElement element= driver.findElement(continueButton);
        Actions a = new Actions(driver);
        a.moveToElement(element).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void setFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void setLastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void setemail(String email){
        driver.findElement(emailField).sendKeys(email);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void checkPrivacyPolicyCheckbox(){
        driver.findElement(privacyPolicyCheckbox).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    public AccountSuccessPage clickContinueButton(){
        driver.findElement(continueButton).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return new AccountSuccessPage(driver);
    }
}
