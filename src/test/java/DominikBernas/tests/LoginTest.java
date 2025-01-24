package DominikBernas.tests;

import DominikBernas.basetest.BaseTest;
import DominikBernas.models.FirstUserModel;
import DominikBernas.models.UserModelFaker;
import DominikBernas.pages.HomePage;
import DominikBernas.pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void testLogin() {
        FirstUserModel firstUserModel = new FirstUserModel();
        new HomePage(driver)
                .loginFirstUser(firstUserModel);
        WebElement welcome = new LoginPage(driver).getWelcome();

        Assert.assertTrue(welcome.isDisplayed());
        Assert.assertEquals(welcome.getText(), "Welcome");
    }

    @Test
    public void testLoginWithWrongData() {
        UserModelFaker faker = new UserModelFaker();
        new HomePage(driver)
                .loginFaker(faker);
        WebElement errorMessage = new LoginPage(driver).getErrorMessage();

        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "The username and password could not be verified.");

    }
}
