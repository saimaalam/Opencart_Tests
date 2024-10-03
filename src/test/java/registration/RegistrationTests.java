package registration;

import base.BaseTests;
import opencart_pages.RegisterAccountPage;
import org.testng.annotations.*;
import utils.TestDataGenerator;

public class RegistrationTests extends BaseTests {
@Test(dataProvider = "registrationData", dataProviderClass = TestDataGenerator.class)
    public void TC_1_Verify_that_a_new_user_can_register(String firstName, String lastName, String email,String password){
    homePage.clickMyAccount();
    RegisterAccountPage registerAccountPage= homePage.clickRegister();
    registerAccountPage.waitForHeader();
    registerAccountPage.setFirstName(firstName);
    registerAccountPage.setLastName(lastName);
    registerAccountPage.setemail(email);
    registerAccountPage.setPassword(password);
    registerAccountPage.clickContinueButton();
}

}
