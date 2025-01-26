package DominikBernas.models;

import com.github.javafaker.Faker;

public class RegisterModelFaker {

   private Faker faker = new Faker();
   private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String address = faker.address().streetAddress();
    private String city = faker.address().city();
    private String state = faker.address().state();
    private String country = faker.address().country();
    private String zipCode = faker.address().zipCode();
    private String phoneNumber = faker.phoneNumber().phoneNumber();
    private String pesel = faker.idNumber().valid();
    private String login = faker.name().username();
    private String password = faker.internet().password();
    private String confirmPassword = faker.internet().password();

    public Faker getFaker() {
        return faker;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPesel() {
        return pesel;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
