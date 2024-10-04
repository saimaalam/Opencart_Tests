package utils;

import org.testng.annotations.DataProvider;

public class LoginTestDataGenerator {

    @DataProvider(name = "LoginData")
    public Object[][] generateLoginData() {
        // Access the data stored in UserDataStorage class
        String fname = DataStorage.registeredFirstName;
        String lname = DataStorage.registeredLastName;
        String email = DataStorage.registeredEmail;
        String password = DataStorage.registeredPassword;

        // Return the data for the login test
        return new Object[][]{
                {email, password},
        };
    }
}
