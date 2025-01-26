package DominikBernas.pages;

import DominikBernas.models.RegisterModel;
import DominikBernas.models.RegisterModelFaker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private By firstName = By.id("customer.firstName");
    private By lastName = By.id("customer.lastName");
    private By address = By.id("customer.address.street");
    private By city = By.id("customer.address.city");
    private By state = By.id("customer.address.state");
    private By zip = By.id("customer.address.zipCode");
    private By phone = By.id("customer.phoneNumber");
    private By ssn = By.id("customer.ssn");
    private By username = By.id("customer.username");
    private By password = By.id("customer.password");
    private By compfirmPassword = By.id("repeatedPassword");
    private By registerButton = By.xpath("//input[@value = 'Register']");

    public RegisterPage register(RegisterModel registerModel) {
        driver.findElement(firstName).sendKeys(registerModel.getFirstName());
        driver.findElement(lastName).sendKeys(registerModel.getLastName());
        driver.findElement(address).sendKeys(registerModel.getAddress());
        driver.findElement(city).sendKeys(registerModel.getCity());
        driver.findElement(state).sendKeys(registerModel.getState());
        driver.findElement(zip).sendKeys(registerModel.getZip());
        driver.findElement(phone).sendKeys(registerModel.getPhone());
        driver.findElement(ssn).sendKeys(registerModel.getSsn());
        driver.findElement(username).sendKeys(registerModel.getUsername());
        driver.findElement(password).sendKeys(registerModel.getPassword());
        driver.findElement(compfirmPassword).sendKeys(registerModel.getPassword());
        driver.findElement(registerButton).click();
        return this;
    }

    public LoginPage registerWithFaker(RegisterModelFaker registerModelFaker) {
        driver.findElement(firstName).sendKeys(registerModelFaker.getFirstName());
        driver.findElement(lastName).sendKeys(registerModelFaker.getLastName());
        driver.findElement(address).sendKeys(registerModelFaker.getAddress());
        driver.findElement(city).sendKeys(registerModelFaker.getCity());
        driver.findElement(state).sendKeys(registerModelFaker.getState());
        driver.findElement(zip).sendKeys(registerModelFaker.getZipCode());
        driver.findElement(phone).sendKeys(registerModelFaker.getPhoneNumber());
        driver.findElement(ssn).sendKeys(registerModelFaker.getPesel());
        driver.findElement(username).sendKeys(registerModelFaker.getLogin());
        driver.findElement(password).sendKeys(registerModelFaker.getPassword());
        driver.findElement(compfirmPassword).sendKeys(registerModelFaker.getPassword());
        driver.findElement(registerButton).click();
        return new  LoginPage(driver);
    }
    public RegisterPage registerWithFakerConfirm(RegisterModelFaker registerModelFaker) {
        driver.findElement(firstName).sendKeys(registerModelFaker.getFirstName());
        driver.findElement(lastName).sendKeys(registerModelFaker.getLastName());
        driver.findElement(address).sendKeys(registerModelFaker.getAddress());
        driver.findElement(city).sendKeys(registerModelFaker.getCity());
        driver.findElement(state).sendKeys(registerModelFaker.getState());
        driver.findElement(zip).sendKeys(registerModelFaker.getZipCode());
        driver.findElement(phone).sendKeys(registerModelFaker.getPhoneNumber());
        driver.findElement(ssn).sendKeys(registerModelFaker.getPesel());
        driver.findElement(username).sendKeys(registerModelFaker.getLogin());
        driver.findElement(password).sendKeys(registerModelFaker.getPassword());
        driver.findElement(compfirmPassword).sendKeys(registerModelFaker.getConfirmPassword());
        driver.findElement(registerButton).click();
        return this;
    }

    private By errorUsernameExists = By.id("customer.username.errors");

    public WebElement getErrorUsernameExists() {
        return driver.findElement(errorUsernameExists);
    }

    private List<By> errorLocators = Arrays.asList(
            By.id("customer.firstName.errors"),
            By.id("customer.lastName.errors"),
            By.id("customer.address.street.errors"),
            By.id("customer.address.city.errors"),
            By.id("customer.address.state.errors"),
            By.id("customer.address.zipCode.errors"),
            By.id("customer.ssn.errors"),
            By.id("customer.username.errors"),
            By.id("customer.password.errors"),
            By.id("repeatedPassword.errors")
    );
    public List<WebElement> errorsRequired(WebDriver driver) {
        return errorLocators.stream()
                .map(driver::findElement)
                .collect(Collectors.toList());
    }

    private By errorRepeatedPassword = By.xpath("//*[@id=\"repeatedPassword.errors\"]");
    public WebElement getErrorRepeatedPassword() {
        return driver.findElement(errorRepeatedPassword);
    }

}










