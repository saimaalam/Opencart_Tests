package utils;

import com.github.javafaker.Faker;
import org.testng.annotations.*;

public class RegistrationTestDataGenerator {
    Faker faker = new Faker();
    String fname = faker.name().firstName();
    String lname = faker.name().lastName();
    String email = faker.internet().emailAddress(fname + lname);
    String password = "123456";

    @DataProvider(name = "registrationData")
    public Object[][] generateRegistrationData() {
        // Store the generated data in the UserDataStorage class

        DataStorage.registeredFirstName = fname;
        DataStorage.registeredLastName = lname;
        DataStorage.registeredEmail = email;
        DataStorage.registeredPassword = password;

        // Return the data for the registration test
        return new Object[][] {
                {fname, lname, email, password},
        };
    }
}
