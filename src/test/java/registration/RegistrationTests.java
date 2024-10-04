package registration;

import base.BaseTests;
import io.qameta.allure.Allure;
import io.qameta.allure.*;
import opencart_pages.AccountSuccessPage;
import opencart_pages.RegisterAccountPage;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utils.RegistrationTestDataGenerator;

public class RegistrationTests extends BaseTests {
@Test(dataProvider = "registrationData", dataProviderClass = RegistrationTestDataGenerator.class)
@Description("Test for user registration functionality")
@Severity(SeverityLevel.BLOCKER)
@Feature("User Registration")
    public void TC_1_Verify_that_a_new_user_can_register(String firstName, String lastName, String email,String password){

    Allure.step("Step 1: Open registration page");
    Allure.step("Step 2: Enter first name: " + firstName);
    Allure.step("Step 3: Enter last name: " + lastName);
    Allure.step("Step 4: Enter email: " + email);
    Allure.step("Step 5: Enter password");
    Allure.step("Step 6: Submit the registration form");

    RegisterAccountPage registerAccountPage= homePage.clickRegister();
    registerAccountPage.waitForHeader();
    registerAccountPage.setFirstName(firstName);
    registerAccountPage.setLastName(lastName);
    registerAccountPage.setemail(email);
    registerAccountPage.setPassword(password);
    registerAccountPage.scrollToPrivacyPolicy();
    registerAccountPage.checkPrivacyPolicyCheckbox();
    registerAccountPage.scrollToContinueButton();
    AccountSuccessPage accountSuccessPage= registerAccountPage.clickContinueButton();
    SoftAssert softAssert= new SoftAssert();
    softAssert.assertEquals(accountSuccessPage.getPageHeader(),"Your Account Has Been Created!","Test Failed!!! Message not displayed");
    softAssert.assertTrue(accountSuccessPage.isContinueButtonPresent(),"Test failed!!! Button doesn't Displayed");
}

}
