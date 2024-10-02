package registration;

import base.BaseTests;
import com.github.javafaker.Faker;
import opencart_pages.Homepage;
import opencart_pages.RegisterAccountPage;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTests {
    Faker faker = new Faker();
    String fname= faker.name().firstName();
    String lname= faker.name().lastName();
    String email= faker.internet().emailAddress(fname+lname);
    String password= "123456";
@Test
    public void TC_1_Verify_that_a_new_user_can_register(){
    homePage.clickMyAccount();
    RegisterAccountPage registerAccountPage= homePage.clickRegister();
    registerAccountPage.waitForHeader();
    registerAccountPage.setFirstName(fname);
    registerAccountPage.setLastName(lname);
    registerAccountPage.setemail(email);
    registerAccountPage.setPassword(password);
    registerAccountPage.clickContinueButton();
}

}
