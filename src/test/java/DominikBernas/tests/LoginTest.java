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
        LogStep("Open page and enter data");
        new HomePage(driver)
                .loginFirstUser(firstUserModel);
        LogStep("Assert that user is logged in");
        WebElement welcome = new LoginPage(driver).getWelcome();

        Assert.assertTrue(welcome.isDisplayed());
        Assert.assertEquals(welcome.getText(), "Welcome");
    }

    @Test
    public void testLoginWithWrongData() {
        UserModelFaker faker = new UserModelFaker();
        LogStep("Open page and enter data");
        new HomePage(driver)
                .loginFaker(faker);
        LogStep("Assert wrong data");
        WebElement errorMessage = new LoginPage(driver).getErrorMessage();

        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "The username and password could not be verified.");

    }
}
