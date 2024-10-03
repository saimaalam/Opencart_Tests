package utils;

import org.testng.annotations.DataProvider;

public class LoginTestDataGenerator {
    @DataProvider(name = "LoginData")
    public Object[][] generateRegistrationData() {
        RegistrationTestDataGenerator data = new RegistrationTestDataGenerator();
        return new Object[][] {
                {data.email,data.password},
        };
    }
}
