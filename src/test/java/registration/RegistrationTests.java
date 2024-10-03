package registration;

import base.BaseTests;
import opencart_pages.AccountSuccessPage;
import opencart_pages.RegisterAccountPage;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
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
    registerAccountPage.scrollToPrivacyPolicy();
    registerAccountPage.checkPrivacyPolicyCheckbox();
    registerAccountPage.scrollToContinueButton();
    AccountSuccessPage accountSuccessPage= registerAccountPage.clickContinueButton();
    SoftAssert softAssert= new SoftAssert();
    softAssert.assertEquals(accountSuccessPage.getPageHeader(),"Your Account Has Been Created!","Test Failed!!! Message not displayed");
    softAssert.assertTrue(accountSuccessPage.isContinueButtonPresent(),"Test failed!!! Button doesn't Displayed");
}

}
