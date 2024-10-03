package opencart_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountSuccessPage {
    private WebDriver driver;
    private By pageHeader = By.xpath("//div[@id='content']/h1");
    private By continueButton = By.linkText("Continue");
    private boolean result;
    public AccountSuccessPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getPageHeader(){
        return driver.findElement(pageHeader).getText();
    }
    public boolean isContinueButtonPresent(){
         return result = driver.findElement(continueButton).isDisplayed();
    }
}
