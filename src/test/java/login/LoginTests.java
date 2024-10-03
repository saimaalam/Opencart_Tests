package login;

import base.BaseTests;
import opencart_pages.LoginPage;
import opencart_pages.MyAccoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.LoginTestDataGenerator;
import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTests {
    @Test(dataProvider = "LoginData",dataProviderClass =LoginTestDataGenerator.class)
    public void TC_4_Verify_that_user_can_login_with_valid_credentials(String email, String password){
        LoginTestDataGenerator loginData= new LoginTestDataGenerator();
        LoginPage loginPage= homePage.clickLogin();
        loginPage.setEmailField(email);
        loginPage.setPasswordField(password);
        MyAccoutPage myAccoutPage= loginPage.clickLoginButton();
        Assert.assertEquals(myAccoutPage.getPageHeader(),"My Account","Header didn't match!!!");
    }

}
