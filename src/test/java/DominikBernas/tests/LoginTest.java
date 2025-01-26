package DominikBernas.tests;

import DominikBernas.basetest.BaseTest;
import DominikBernas.models.FirstUserModel;
import DominikBernas.models.UserModelFaker;
import DominikBernas.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void testLogin() {
        FirstUserModel firstUserModel = new FirstUserModel();
       WebElement welcome = new HomePage(driver)
                .loginFirstUser(firstUserModel)
                .getWelcome();

        Assert.assertTrue(welcome.isDisplayed());
        Assert.assertEquals(welcome.getText(), "Welcome");
    }

    @Test
    public void testLoginWithWrongData() {
        UserModelFaker faker = new UserModelFaker();

        WebElement errorMessage =  new HomePage(driver)
                .loginFaker(faker)
                .getErrorMessage();

        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "The username and password could not be verified.");

    }
}
