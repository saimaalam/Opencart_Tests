package opencart_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {
    private WebDriver driver;

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickElement(String xpath){
        driver.findElement(By.xpath(xpath)).click();

    }
    public void clickMyAccount(){
        clickElement("//span[normalize-space(text())='My Account']");
    }
    public RegisterAccountPage clickRegister(){
        clickMyAccount();
        driver.findElement(By.linkText("Register")).click();
        return new RegisterAccountPage(driver);
    }

}
