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


        WebElement logout = new HomePage(driver)
                .loginFirstUser(user)
                .getLogOutButton()
                .customerLoginForm();

       Assert.assertTrue(logout.isDisplayed());
       Assert.assertEquals(logout.getText(), "Customer Login");

    }
}
