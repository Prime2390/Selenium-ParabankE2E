package DominikBernas.pages;

import DominikBernas.utils.SeleniumWaiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage {
    private WebDriver driver;
    public NewAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private By selector = By.id("type");
    public NewAccountPage selectTypeChecking() {
        Select select = new Select(driver.findElement(selector));
        select.selectByValue("0");
        return this;
    }
    public NewAccountPage selectTypeSaving() {
        Select select = new Select(driver.findElement(selector));
        select.selectByValue("1");
        return this;
    }

    private By NewAccountButton = By.xpath("//input[@class='button']");
    public NewAccountPage NewAccountButton() {
      WebElement button =  driver.findElement(NewAccountButton);
        SeleniumWaiter.waitForClickable(button, driver);
        button.click();
        return this;
    }

    private By accountOpenInformation = By.xpath("//*[@id=\"openAccountResult\"]/p[2]/b");
    public WebElement getAccountOpenInformation() {
        return driver.findElement(accountOpenInformation);
    }


}
