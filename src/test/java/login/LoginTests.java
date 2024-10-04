package login;

import base.BaseTests;
import io.qameta.allure.*;
import opencart_pages.LoginPage;
import opencart_pages.MyAccoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.LoginTestDataGenerator;
import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTests {
    @Test(dataProvider = "LoginData",dataProviderClass =LoginTestDataGenerator.class)
    @Description("Test for user login functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("User Login")
    public void TC_4_Verify_that_user_can_login_with_valid_credentials(String email, String password){
        Allure.step("Step 1: Open login page",() -> {
            LoginPage loginPage= homePage.clickLogin();
        });
        Allure.step("Step 2: Enter email: " + email,()->{});
        Allure.step("Step 3: Enter password");
        Allure.step("Step 4: Click on login button");
        LoginTestDataGenerator loginData= new LoginTestDataGenerator();
        LoginPage loginPage= homePage.clickLogin();
        loginPage.setEmailField("OzzieUpton@yahoo.com");
        loginPage.setPasswordField("123456");
        MyAccoutPage myAccoutPage= loginPage.clickLoginButton();
        Assert.assertEquals(myAccoutPage.getPageHeader(),"My Account","Header didn't match!!!");
    }
    @Test
    public void TC_5_Verify_that_user_can_log_out(){

    }

}
