package utils;

import org.testng.annotations.DataProvider;

public class LoginTestDataGenerator {
    RegistrationTestDataGenerator data = new RegistrationTestDataGenerator();
    public String getEmail(){
       return data.email;
   }
    public String getPassword(){
        return data.password;
    }
    @DataProvider(name = "LoginData")
    public Object[][] generateRegistrationData() {
        return new Object[][] {
                {data.email,data.password},
        };
    }
}
