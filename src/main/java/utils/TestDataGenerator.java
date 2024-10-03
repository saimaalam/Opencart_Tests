package utils;

import com.github.javafaker.Faker;
import org.testng.annotations.*;

public class TestDataGenerator {
    @DataProvider(name = "registrationData")
    public Object[][] generateRegistrationData() {
        Faker faker = new Faker();
        String fname= faker.name().firstName();
        String lname= faker.name().lastName();
        String email= faker.internet().emailAddress(fname+lname);
        String password= "123456";

        return new Object[][] {
                {fname,lname,email,password},
        };
    }
}
