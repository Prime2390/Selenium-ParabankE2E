package DominikBernas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private By welcome = By.xpath("//h1[@class = 'title']");

    public WebElement getWelcome() {
        return driver.findElement(welcome);
    }
}
