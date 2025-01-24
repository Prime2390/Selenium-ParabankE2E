package DominikBernas.pages;

import DominikBernas.models.FirstUserModel;
import DominikBernas.models.UserModelFaker;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    private By registerButton = By.xpath("//a[text()='Register']");
    public RegisterPage registerButtonClick(){
        driver.findElement(registerButton).click();
        return new RegisterPage(driver);
    }

    private By loginUsername = By.name("username");
    private By loginPassword = By.name("password");
    private By loginButton = By.xpath("//input[@class='button']");

    public LoginPage loginFirstUser(FirstUserModel firstUser){
        driver.findElement(loginUsername).sendKeys(firstUser.getUsername());
        driver.findElement(loginPassword).sendKeys(firstUser.getPassword());
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }
    public LoginPage loginFaker(UserModelFaker faker){
        driver.findElement(loginUsername).sendKeys(faker.getLoginFaker());
        driver.findElement(loginPassword).sendKeys(faker.getPasswordFaker());
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }
}
