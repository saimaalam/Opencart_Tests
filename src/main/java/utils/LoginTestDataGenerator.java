package utils;

import org.testng.annotations.DataProvider;

public class LoginTestDataGenerator {
    RegistrationTestDataGenerator data = new RegistrationTestDataGenerator();
       String email= data.getRegisteredEmail();
       String password= data.getRegisteredPassword();

    @DataProvider(name = "LoginData")
    public Object[][] generateLoginData() {

        return new Object[][] {
                {email,password},
        };
    }
}
