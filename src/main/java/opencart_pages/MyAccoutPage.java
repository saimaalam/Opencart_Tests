package opencart_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccoutPage {
    private WebDriver driver;
    private By pageHeader = By.xpath("//div[@id='content']/h2");

    public MyAccoutPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getPageHeader(){
        return driver.findElement(pageHeader).getText();
    }
}
