package utils;

import com.github.javafaker.Faker;
import org.testng.annotations.*;

public class RegistrationTestDataGenerator {
    Faker faker = new Faker();
    String fname= faker.name().firstName();
    String lname= faker.name().lastName();
    String email= faker.internet().emailAddress(fname+lname);
    String password= "123456";


    @DataProvider(name = "registrationData")
    public Object[][] generateRegistrationData() {
        return new Object[][] {
                {fname,lname,email,password},
        };
    }
    public String getRegisteredEmail(){
        return email;
    }
    public String getRegisteredPassword(){
        return password;
    }
}
