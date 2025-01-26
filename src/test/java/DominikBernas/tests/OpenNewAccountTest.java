package DominikBernas.tests;

import DominikBernas.basetest.BaseTest;
import DominikBernas.models.FirstUserModel;
import DominikBernas.pages.HomePage;
import DominikBernas.pages.LoginPage;
import DominikBernas.pages.NewAccountPage;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenNewAccountTest extends BaseTest {
    @Test
    public void openNewAccount() {
        FirstUserModel firstUserModel = new FirstUserModel();

     WebElement title =   new HomePage(driver)
                .loginFirstUser(firstUserModel)
                .OpenNewAccountClick()
                .selectTypeChecking()
                .NewAccountButton()
                .getAccountOpenInformation();

    }
    @Test
    public void openNewAccountPage() {

        LogStep("");
        FirstUserModel firstUserModel = new FirstUserModel();
    WebElement title =  new HomePage(driver)
                .loginFirstUser(firstUserModel)
                .OpenNewAccountClick()
                .selectTypeSaving()
                .NewAccountButton()
                .getAccountOpenInformation();

    }
}

