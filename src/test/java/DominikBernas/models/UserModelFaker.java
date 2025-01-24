package DominikBernas.models;

import com.github.javafaker.Faker;

public class UserModelFaker {
    Faker faker = new Faker();

    private String loginFaker = faker.name().username();
    private String passwordFaker = faker.internet().password();

    public Faker getFaker() {
        return faker;
    }

    public String getLoginFaker() {
        return loginFaker;
    }

    public String getPasswordFaker() {
        return passwordFaker;
    }
}
