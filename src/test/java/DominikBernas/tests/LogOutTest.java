package DominikBernas.tests;

import DominikBernas.basetest.BaseTest;
import DominikBernas.models.FirstUserModel;
import DominikBernas.pages.HomePage;
import DominikBernas.pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest {
    @Test
    public void LogOutFirstCustomer() {
        FirstUserModel user = new FirstUserModel();

        LogStep("Open page and enter data");
        new HomePage(driver)
                .loginFirstUser(user);
        LogStep("Click logout button");
        new LoginPage(driver).getLogOutButton();
        LogStep("Back to home page");
       WebElement CustomerLoginForm = new HomePage(driver).customerLoginForm();
        LogStep("Assert");
       Assert.assertTrue(CustomerLoginForm.isDisplayed());
       Assert.assertEquals(CustomerLoginForm.getText(), "Customer Login");

    }
}
