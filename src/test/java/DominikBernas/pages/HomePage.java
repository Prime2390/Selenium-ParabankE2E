package DominikBernas.pages;

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
}
