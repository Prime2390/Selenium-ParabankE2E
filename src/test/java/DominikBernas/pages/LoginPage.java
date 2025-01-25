package DominikBernas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By welcome = By.xpath("//b[text()='Welcome']");
    public WebElement getWelcome() {
        return driver.findElement(welcome);
    }

    private By errorMessage = By.xpath("//p[@class= 'error']");
    public WebElement getErrorMessage() {
        return driver.findElement(errorMessage);
    }

    private By logOutButton = By.xpath("//a[text()='Log Out']");
    public HomePage getLogOutButton() {
        driver.findElement(logOutButton).click();
        return new HomePage(driver);
    }






}
