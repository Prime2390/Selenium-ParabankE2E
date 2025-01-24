package DominikBernas.tests;

import DominikBernas.basetest.BaseTest;
import DominikBernas.models.RegisterModel;
import DominikBernas.models.RegisterModelFaker;
import DominikBernas.pages.HomePage;
import DominikBernas.pages.LoginPage;
import DominikBernas.pages.RegisterPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class RegisterTest extends BaseTest {

        @Test
        public void registrationWithFaker() {
    RegisterModelFaker registerModelFaker = new RegisterModelFaker();

    LogStep("Opening Register Page");
           new HomePage(driver).
    registerButtonClick();
    LogStep("Provides Data with Faker");
           new RegisterPage(driver)
                   .registerWithFaker(registerModelFaker);
           LogStep("Account login");
           WebElement alert = new LoginPage(driver).getWelcome();

            LogStep("Test account has been created");
            Assert.assertTrue(alert.isDisplayed());
            Assert.assertTrue(alert.getText().contains("Welcome"));
}

        @Test
        public void registrationWithUsedUsername() {
        RegisterModel registerModel = new RegisterModel();
        registerModel.setFirstName("Dominik");
        registerModel.setLastName("Bernas");
        registerModel.setAddress("Adama Mickiewicz 14/10");
        registerModel.setCity("Warszawa");
        registerModel.setState("Wielkopolski");
        registerModel.setZip("42-400");
        registerModel.setPhone("696596965");
        registerModel.setSsn("415262514536");
        registerModel.setUsername("Tester2390");
        registerModel.setPassword("Testerpass2390");


        LogStep("Opening Register Page");
        new HomePage(driver).
                registerButtonClick();
        LogStep("Provides Data");
        new RegisterPage(driver)
                .register(registerModel);
        WebElement Error = new RegisterPage(driver).getErrorUsernameExists();

        Assert.assertTrue(Error.isDisplayed());
        Assert.assertTrue(Error.getText().contains("This username already exists."));
        LogStep("Error Message: " + Error.getText());
    }

    @Test
    public void registrationWithoutData() {
        RegisterModel registerModel = new RegisterModel();
        registerModel.setFirstName("");
        registerModel.setLastName("");
        registerModel.setAddress("");
        registerModel.setCity("");
        registerModel.setState("");
        registerModel.setZip("");
        registerModel.setPhone("");
        registerModel.setSsn("");
        registerModel.setUsername("");
        registerModel.setPassword("");


        LogStep("Opening Register Page");
        new HomePage(driver).
                registerButtonClick();
        LogStep("Provides Data");
        new RegisterPage(driver)
                .register(registerModel);
        LogStep("Assert");
        List<WebElement> errorRequired = new RegisterPage(driver)
                .errorsRequired(driver).stream().toList();

        LogStep("Error Message: " + errorRequired.get(0).getText());
        Assert.assertTrue(errorRequired.get(0).getText().contains("First name is required."));
        LogStep("Error Message: " + errorRequired.get(1).getText());
        Assert.assertTrue(errorRequired.get(1).getText().contains("Last name is required."));
        LogStep("Error Message: " + errorRequired.get(2).getText());
        Assert.assertTrue(errorRequired.get(2).getText().contains("Address is required."));
        LogStep("Error Message: " + errorRequired.get(3).getText());
        Assert.assertTrue(errorRequired.get(3).getText().contains("City is required."));
        LogStep("Error Message: " + errorRequired.get(4).getText());
        Assert.assertTrue(errorRequired.get(4).getText().contains("State is required."));
        LogStep("Error Message: " + errorRequired.get(5).getText());
        Assert.assertTrue(errorRequired.get(5).getText().contains("Zip Code is required."));
        LogStep("Error Message: " + errorRequired.get(6).getText());
        Assert.assertTrue(errorRequired.get(6).getText().contains("Social Security Number is required."));
        LogStep("Error Message: " + errorRequired.get(7).getText());
        Assert.assertTrue(errorRequired.get(7).getText().contains("Username is required."));
        LogStep("Error Message: " + errorRequired.get(8).getText());
        Assert.assertTrue(errorRequired.get(8).getText().contains("Password is required."));
        LogStep("Error Message: " + errorRequired.get(9).getText());
        Assert.assertTrue(errorRequired.get(9).getText().contains("Password confirmation is required."));

    }
}
